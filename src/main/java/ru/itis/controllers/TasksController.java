package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.TaskEditForm;
import ru.itis.models.Task;
import ru.itis.services.TaskService;

@Controller
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{task-id}")
    public String getCardTasks(ModelMap model, @PathVariable(name = "task-id") Long taskId){
        if(taskService.findTaskById(taskId).isPresent()) {
            Task task = taskService.findTaskById(taskId).get();
            if(task.getText() == null) {
                model.addAttribute("noText", true);
            }
            model.addAttribute("task", task);
        }
        return "tasks";
    }

    @PostMapping("/tasks/{task-id}")
    public String editTaskInfo(@PathVariable(name = "task-id") Long taskId, TaskEditForm taskEditForm){
        System.out.println(taskEditForm.getName());
        if(taskService.findTaskById(taskId).isPresent()) {
            Task task = taskService.findTaskById(taskId).get();

            taskService.edit(taskEditForm, task);
        }
        return "redirect:{task-id}";
    }
}
