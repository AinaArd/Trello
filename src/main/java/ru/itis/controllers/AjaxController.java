package ru.itis.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.forms.TaskForm;
import ru.itis.models.*;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CardService;
import ru.itis.services.DeskService;
import ru.itis.services.TaskService;
import ru.itis.services.UserServiceImpl;
import ru.itis.transfer.TaskDto;
import ru.itis.transfer.UserDto;
import ru.itis.utils.FileDownloader;

import java.util.HashMap;
import java.util.List;

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

    @PostMapping("/ajax/addtask")
    public ResponseEntity<Object> addTask(@RequestParam(name = "id") Long cardId, TaskForm taskForm) {
        Card card = cardService.findById(cardId).orElseThrow(IllegalArgumentException::new);
        Desk desk = deskService.findDeskByCard(card.getId()).orElseThrow(IllegalArgumentException::new);
        Task task = Task.builder()
                .name(taskForm.getName())
                .card(card)
                .desk(desk)
                .state(TaskState.valueOf(taskForm.getState()))
                .flag(false)
                .build();
        TaskDto newTask = taskService.addTask(task);
        return ResponseEntity.ok(newTask);
    }

    @PostMapping("/ajax/addusertodesk")
    public ResponseEntity<Object> addUserToDesk(@RequestParam(name = "userName") String userName, @RequestParam(name = "deskId") Long deskId) {
        User user = userService.findByName(userName).orElseThrow(IllegalArgumentException::new);
        Desk desk = deskService.findOneDesk(deskId).orElseThrow(IllegalArgumentException::new);
        desk.getUsers().add(user);
        user.getDesks().add(desk);
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/ajax/addusertotask")
    public ResponseEntity<Object> addUserToTask(@RequestParam(name = "userName") String userName, @RequestParam(name = "taskId") Long taskId) {
        User user = userService.findByName(userName).orElseThrow(IllegalArgumentException::new);
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        task.getUsers().add(user);
        user.getTasks().add(task);
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/ajax/addcomment")
    public ResponseEntity<Object> addComment(@RequestParam(name = "id") Long taskId, @RequestParam(name = "comment") String text,
                                             Authentication authentication) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        Comment comment = Comment.builder()
                .task(task)
                .content(text)
                .author(currentUser)
                .build();
        Comment newComment = taskService.addComment(comment);
        return ResponseEntity.ok(newComment.getAuthor().getName());
    }

    @PostMapping("/ajax/returntask")
    public ResponseEntity<Object> returnTask(@RequestParam(name = "id") Long taskId) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        taskService.changeFlag(task);
        return ResponseEntity.ok(task.getId());
    }

    @PostMapping("/ajax/inviteuserstodesk")
    public ResponseEntity<Object> inviteUsers(@RequestParam(name = "search") String search, Authentication authentication) {
        User currentUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        List<UserDto> userCandidates = userService.findByNameOrLogin(search, currentUser);
        return ResponseEntity.ok(userCandidates);
    }

    @PostMapping("/ajax/inviteuserstotask")
    public ResponseEntity<Object> inviteUsers(@RequestParam(name = "search") String search) {
        List<UserDto> userCandidates = userService.findByNameOrLogin(search);
        return ResponseEntity.ok(userCandidates);
    }

    @PostMapping("/ajax/deleteuser")
    public ResponseEntity<Object> deleteUserFromDesk(@RequestParam(name = "userName") String name, @RequestParam(name = "desk-id") Long deskId){
        User user = userService.findByName(name).orElseThrow(IllegalArgumentException::new);
        Desk desk = deskService.findOneDesk(deskId).orElseThrow(IllegalArgumentException::new);
        userService.removeFromDesk(user, desk);
        desk.getUsers().remove(user);
        user.getDesks().remove(desk);
        return ResponseEntity.ok().build();

    }
}
