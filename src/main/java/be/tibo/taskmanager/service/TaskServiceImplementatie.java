package be.tibo.taskmanager.service;

import be.tibo.taskmanager.domain.SubTask;
import be.tibo.taskmanager.domain.Task;
import be.tibo.taskmanager.dto.SubTaskDTO;
import be.tibo.taskmanager.dto.TaskDTO;
import be.tibo.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementatie implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImplementatie(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getTaskId(), taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDateAndTimeOfTask(), taskDTO.getSubTasks());
        taskRepository.saveAndFlush(task);
    }

    @Override
    public Task getTask(long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        Task task = getTask(taskDTO.getTaskId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDateAndTimeOfTask(taskDTO.getDateAndTimeOfTask());
        taskRepository.saveAndFlush(task);
    }

    @Override
    public void removeTask(long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void removeAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public List<SubTask> getSubTasks(long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            return null;
        } else {
            return task.getSubTasks();
        }
    }

    @Override
    public void addSubTask(SubTaskDTO subTaskDTO, long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task != null) {
            task.AddSubTask(subTaskDTO);
            taskRepository.saveAndFlush(task);
        }
    }



}
