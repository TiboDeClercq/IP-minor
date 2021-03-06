package be.tibo.taskmanager.controller;

import org.springframework.ui.Model;
import be.tibo.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import be.tibo.taskmanager.dto.SubTaskDTO;
import be.tibo.taskmanager.dto.TaskDTO;

@org.springframework.stereotype.Controller
@RequestMapping("/tasks")
public class Controller {
    private final TaskService taskService;

    @Autowired
    public Controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "overview";
    }

    @GetMapping("overview")
    public String getTaskOverview(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "overview";
    }
    //adding a task
    @GetMapping("new")
    public String getTaskForm(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "newTask";
    }

    @PostMapping("new")
    public String PostNewTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "newTask";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }
    //Edit a task
    @GetMapping("edit/{taskId}")
    public String getEditTaskForm(@PathVariable int taskId, Model model){
        model.addAttribute("taskDTO", taskService.getTask(taskId));
        return "editTask";
    }

    @PostMapping("edit")
    public String updateTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult, Model model, @RequestParam(value = "taskId") Integer taskId){
        if(bindingResult.hasErrors()){
            return "editTask";
        }
        taskService.editTask(taskDTO);
        return "redirect:/tasks/" + taskId;
    }

    @GetMapping("{taskId}")
    public String getTaskDetail(@PathVariable int taskId, Model model){
        model.addAttribute("task", taskService.getTask(taskId));
        if(taskService.getTask(taskId) != null && !taskService.getSubTasks(taskId).isEmpty()) {
                model.addAttribute("subtaskList", taskService.getSubTasks(taskId));
        }
        return "details";
    }


    @GetMapping("/delete/{taskId}")
    public String getDeleteTaskPage(@PathVariable int taskId, Model model){
        model.addAttribute("taskToDelete", taskService.getTask(taskId));
        return "deletepage";
    }

    @PostMapping("/delete")
    public String postDeleteTask(@RequestParam(value = "confirmation") String confirmation, @RequestParam(value = "taskId") Integer taskId){
        if(confirmation.equals("yes")){
            taskService.removeTask(taskId);
        }
        return "redirect:/tasks";
    }


    @GetMapping("/deleteall")
    public String getDeleteAllTaskPage(Model model){
        model.addAttribute("amounttasktodelete", taskService.getTasks().size());
        return "deleteAll";
    }

    @PostMapping("/deleteallconfirmed")
    public String postDeleteAllTask(@RequestParam(value = "confirmation") String confirmation){
        if(confirmation.equals("yes")){
            taskService.removeAllTasks();
        }
        return "redirect:/tasks";
    }

    @GetMapping("{taskId}/sub/create")
    public String getSubTaskForm(@PathVariable int taskId, Model model){
        model.addAttribute("masterTask", taskService.getTask(taskId));
        model.addAttribute("subTaskDTO", new SubTaskDTO());
        return "newSubtask";
    }

    @PostMapping("sub/newTask")
    public String PostNewSubTask(@ModelAttribute @Valid SubTaskDTO subTaskDTO, BindingResult bindingResult, Model model, @RequestParam(value = "taskId") Integer taskId){
        if(bindingResult.hasErrors()){
            model.addAttribute("masterTask", taskService.getTask(taskId));
            return "newSubtask";
        }
        taskService.addSubTask(subTaskDTO, taskId);
        return "redirect:/tasks/" + taskId;
    }

}
