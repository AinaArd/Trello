package ru.itis.controllers;

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
import ru.itis.utils.FileDownloader;

import java.util.List;

@RestController
public class AjaxController {

    @Autowired
    private FileDownloader fileDownloader;

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
        Task newTask = taskService.addTask(task);
//        TODO: state isn't printed immediately
        return ResponseEntity.ok(newTask.getId());
    }

    @PostMapping("/ajax/adduser")
    public ResponseEntity<Object> addUser(@RequestParam(name = "search") String search) {
        List<User> userCandidates = userService.findByNameOrLogin(search);
        List<String> userNames = userService.getNames(userCandidates);
        return ResponseEntity.ok(userNames);
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
}
