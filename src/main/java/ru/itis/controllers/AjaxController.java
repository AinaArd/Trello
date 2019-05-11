package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.models.Card;
import ru.itis.models.Comment;
import ru.itis.models.Task;
import ru.itis.models.User;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.CardService;
import ru.itis.services.TaskService;
import ru.itis.services.UserServiceImpl;

import java.util.List;

@RestController
public class AjaxController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CardService cardService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/ajax/addtask")
    public ResponseEntity<Object> addTask(@RequestParam(name = "id") Long cardId, @RequestParam(name = "name") String taskName) {
        Card card = cardService.findById(cardId).orElseThrow(IllegalArgumentException::new);
        Task task = Task.builder()
                .name(taskName)
                .card(card)
//                .state(taskForm.getState())
                .flag(false)
                .build();
        System.out.println(task.getName());
        Task newTask = taskService.addTask(task);
        return ResponseEntity.ok(newTask.getId());
    }

    @PostMapping("/ajax/adduser")
    public ResponseEntity<Object> addUser(@RequestParam(name = "search") String search) {
        List<User> userCandidates = userService.findByNameOrLogin(search);
        System.out.println(userCandidates.get(0).getName());
        return ResponseEntity.ok(userCandidates);
    }

    @PostMapping("/ajax/addcomment")
    public ResponseEntity<Object> addComment(@RequestParam(name = "id") Long taskId, @RequestParam(name = "comment") String text,
                                             Authentication authentication) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        User currentUser = ((UserDetailsImpl)authentication.getPrincipal()).getUser();
        Comment comment = Comment.builder()
                .task(task)
                .content(text)
                .author(currentUser)
                .build();
        Comment newComment = taskService.addComment(comment);
        return ResponseEntity.ok(newComment.getAuthor().getName());
    }
}
