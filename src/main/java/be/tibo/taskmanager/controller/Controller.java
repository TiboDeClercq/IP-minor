package be.tibo.taskmanager.controller;


import be.tibo.taskmanager.dto.TaskDTO;
import be.tibo.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/tasks")
public class Controller {
    private final TaskService taskService;

    @Autowired
    public Controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTask(Model model) {
        model.addAttribute("tasks", taskService.getTasksList());
        return "tasks";
    }

    @PostMapping
    public String addRestaurant(@ModelAttribute TaskDTO taskDTOW) {
        taskService.addTask(taskDTOW);
        return "redirect:/tasks";
    }

}
