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

    private TaskService taskService;

    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/{task-id}")
    public String getSingleTask(ModelMap model, @PathVariable(name = "task-id") Long taskId) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
        String picture = task.getPicturePath();
        if (taskService.findTaskById(taskId).isPresent()) {
            if (task.getText() == null) {
                model.addAttribute("noText", true);
            }
            model.addAttribute("task", task);
        }
        model.addAttribute("picture", picture);
        return "task";
    }

    @PostMapping("/tasks/{task-id}")
    public String editTaskInfo(@PathVariable(name = "task-id") Long taskId, TaskEditForm taskEditForm) {
        if (taskService.findTaskById(taskId).isPresent()) {
            Task task = taskService.findTaskById(taskId).orElseThrow(IllegalArgumentException::new);
            if (task.getText() == null || task.getText().equals("")) {
                taskService.addText(taskEditForm, task);
            } else
                taskService.edit(taskEditForm, task);
        }
        return "redirect:{task-id}";
    }

    @PostMapping(value = "/tasks/{task-id}", params = "archive")
    public String archiveTask(@PathVariable(name = "task-id") Long taskId) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalAccessError::new);
        Long deskId = task.getDesk().getId();
        taskService.archive(task);
        return "redirect:/desks/" + deskId;
    }

    @PostMapping(value = "/tasks/{task-id}", params = "delete")
    public String deleteTask(@PathVariable(name = "task-id") Long taskId) {
        Task task = taskService.findTaskById(taskId).orElseThrow(IllegalAccessError::new);
        Long deskId = task.getDesk().getId();
        taskService.deleteTask(task);
        return "redirect:/desks/" + deskId;
    }
}
