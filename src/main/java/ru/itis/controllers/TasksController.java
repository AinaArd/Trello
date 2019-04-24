//package ru.itis.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import ru.itis.models.Card;
//import ru.itis.models.Task;
//import ru.itis.services.TaskService;
//
//import java.util.List;
//
//@Controller
//public class TasksController {
//
//    @Autowired
//    private TaskService taskService;
//
//    @GetMapping("/tasks")
//    public String getCardTasks(ModelMap model){
//        Card card =
//        List<Task> tasks = taskService.findCardTasks(card);
//        model.addAttribute("tasks", tasks);
//        return "tasks";
//    }
//}
