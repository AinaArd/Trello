package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.services.CardService;
import ru.itis.services.TaskService;

@RestController
public class AjaxController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CardService cardService;

    @PostMapping("/ajax/addtask")
    public ResponseEntity<Object> addTask(@RequestParam(name = "id") Long cardId, @RequestParam(name = "name") String taskName){
        Card card = cardService.findById(cardId).orElseThrow(IllegalAccessError::new);
        Task task = Task.builder()
                .name(taskName)
                .card(card)
                .build();
        Task newTask = taskService.addTask(task);
        return ResponseEntity.ok(newTask.getId());
    }
}
