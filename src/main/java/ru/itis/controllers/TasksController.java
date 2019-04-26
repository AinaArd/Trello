package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.models.Card;
import ru.itis.models.Task;
import ru.itis.services.TaskService;

import java.util.List;

@Controller
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{task-id}")
    public String getCardTasks(ModelMap model, @PathVariable(name = "task-id") Long taskId){
        if(taskService.findTaskById(taskId).isPresent()) {
            Task task = taskService.findTaskById(taskId).get();
            model.addAttribute("task", task);
        }
        return "tasks";
    }
}
