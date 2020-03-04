package be.tibo.taskmanager.service;

import be.tibo.taskmanager.domain.Task;
import be.tibo.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    public List<Task> getTasksList();
    void addTask(TaskDTO taskDTO);
}
