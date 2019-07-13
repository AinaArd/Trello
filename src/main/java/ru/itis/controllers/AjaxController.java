package ru.itis.controllers;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.glassfish.jersey.server.monitoring.ResponseMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.forms.TaskForm;
import ru.itis.models.*;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.*;
import ru.itis.transfer.*;

import java.time.LocalDate;
import java.util.List;

import static ru.itis.transfer.UserCommentDto.from;

@RestController
public class AjaxController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CardService cardService;

    @Autowired
    private DeskService deskService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CheckListService checkListService;

    @Autowired
    private ElemService elemService;

    @PostMapping("/ajax/addTask")
    public ResponseEntity<Object> addTask(@RequestParam(name = "id") Long cardId, TaskForm taskForm) {
        Card card = cardService.findById(cardId).orElseThrow(IllegalArgumentException::new);
        Desk desk = deskService.findDeskByCard(card.getId()).orElseThrow(IllegalArgumentException::new);
        LocalDate term = LocalDate.parse(taskForm.getDate());
        Task task = Task.builder()
                .name(taskForm.getName())
                .card(card)
                .desk(desk)
                .term(term)
                .state(card.getName())
                .flag(false)
                .build();
        TaskDto newTask = taskService.addTask(task);
        return ResponseEntity.ok(newTask);
    }

    @PostMapping("/ajax/addUserToDesk")
    public ResponseEntity<Object> addUserToDesk(@RequestParam(name = "userName") String userName, @RequestParam(name = "deskId") Long deskId) {
        User user = userService.findByName(userName).orElseThrow(IllegalArgumentException::new);
        Desk desk = deskService.findOneDesk(deskId).orElseThrow(IllegalArgumentException::new);
        desk.getUsers().add(user);
        user.getDesks().add(desk);
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/ajax/addUserToTask")
    public ResponseEntity<Object> addUserToTask(@RequestParam(name = "userName") String userName, @RequestParam(name = "taskId") Long taskId) {
        User user = userService.findByName(userName).orElseThrow(IllegalArgumentException::new);
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        task.getUsers().add(user);
        user.getTasks().add(task);
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/ajax/addComment")
    public ResponseEntity<Object> addComment(@RequestParam(name = "id") Long taskId, @RequestParam(name = "comment") String message,
                                             Authentication authentication) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
//        store in postgres
        Comment comment = Comment.builder()
                .task(task)
                .content(message)
                .author(currentUser)
                .build();
        Comment savedComment = taskService.addComment(comment);
//        store in mongoDB
//        CommentMongo newCommentMongo = CommentMongo.builder()
//                .content(message)
//                .author(currentUser.getId())
//                .taskId(task.getId())
//                .build();
//        CommentMongo savedComment = commentService.add(newCommentMongo);

        UserCommentDto dto = from(currentUser, savedComment);
        System.out.println(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/ajax/returnTask")
    public ResponseEntity<Object> returnTask(@RequestParam(name = "id") Long taskId) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        taskService.changeFlag(task);
        return ResponseEntity.ok(task.getId());
    }

    @PostMapping("/ajax/inviteUsersToDesk")
    public ResponseEntity<Object> inviteUsers(@RequestParam(name = "search") String search, Authentication authentication) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        List<UserDto> userCandidates = userService.findByNameOrLogin(search, currentUser);
        return ResponseEntity.ok(userCandidates);
    }

    @PostMapping("/ajax/inviteUsersToTask")
    public ResponseEntity<Object> inviteUsers(@RequestParam(name = "search") String search) {
        List<UserDto> userCandidates = userService.findByNameOrLogin(search);
        return ResponseEntity.ok(userCandidates);
    }

    @PostMapping("/ajax/deleteUserFromDesk")
    public ResponseEntity<Object> deleteUserFromDesk(@RequestParam(name = "id") Long userId,
                                                     @RequestParam(name = "desk-id") Long deskId) {
        User user = userService.findById(userId).orElseThrow(IllegalArgumentException::new);
        Desk desk = deskService.findOneDesk(deskId).orElseThrow(IllegalArgumentException::new);
        desk.getUsers().remove(user);
        user.getDesks().remove(desk);
        userService.removeFromDesk(user, desk);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ajax/deleteUserFromTask")
    public ResponseEntity<Object> deleteUserFromTask(@RequestParam(name = "id") Long userId,
                                                     @RequestParam(name = "task-id") Long taskId) {
        User user = userService.findById(userId).orElseThrow(IllegalArgumentException::new);
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        task.getUsers().remove(user);
        user.getTasks().remove(task);
        userService.removeFromTask(user, task);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ajax/checkUser")
    public ResponseEntity<Object> mentionUser(@RequestParam(name = "name") String userName) {
        if (userService.findByLogin(userName).isPresent()) {
            User foundUser = userService.findByLogin(userName).orElseThrow(IllegalArgumentException::new);
            return ResponseEntity.ok(foundUser);
        }
        return ResponseEntity.ok("invalid name");
    }

    @PostMapping("/ajax/editCard")
    public ResponseEntity<Object> editCardName(@RequestParam("id") Long cardId, @RequestParam("name") String newName) {
        Card card = cardService.findById(cardId).orElseThrow(IllegalArgumentException::new);
        card.setName(newName);
        CardDto updatedCard = cardService.editCardName(card);
        return ResponseEntity.ok(updatedCard);
    }

    @PostMapping("/ajax/deleteDesk")
    public ResponseEntity<Object> deleteDesk(@RequestParam("id") Long deskId) {
        Desk desk = deskService.findOneDesk(deskId).orElseThrow(IllegalArgumentException::new);
        User userOwner = desk.getOwner();
        userOwner.getOwnDesks().remove(desk);
        deskService.deleteDesk(desk);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ajax/editTaskState")
    public ResponseEntity<Object> changeState(@RequestParam(name = "name") String taskName, @RequestParam(name = "cardName") String cardState) {
        Task task = taskService.findTaskByName(taskName).orElseThrow(IllegalArgumentException::new);
        task.setState(cardState);
        TaskDto updatedTask = taskService.addTask(task);
        return ResponseEntity.ok(updatedTask);
    }


    @PostMapping("/ajax/addElem")
    public ResponseEntity<Object> addElem(@RequestParam(name = "list-id") Long listId, @RequestParam(name = "elem-name") String name) {
        CheckList checkList = checkListService.findCheckListById(listId).orElseThrow(IllegalArgumentException::new);
        Elem elem = Elem.builder()
                .content(name)
                .state(false)
                .checkList(checkList)
                .build();
        Elem newElem = elemService.addElem(elem);
        return ResponseEntity.ok(newElem);
    }

    @PostMapping("/ajax/deleteCheckList")
    public ResponseEntity<Object> deleteCheckList(@RequestParam(name = "id") Long id){
        CheckList checkList = checkListService.findCheckListById(id).orElseThrow(IllegalArgumentException::new);
        checkListService.delete(checkList);
        return ResponseEntity.ok().build();
    }
}
