package be.tibo.taskmanager.service;

import be.tibo.taskmanager.domain.SubTask;
import be.tibo.taskmanager.domain.Task;
import be.tibo.taskmanager.dto.SubTaskDTO;
import be.tibo.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    public void addTask(TaskDTO taskDTO);

    public Task getTask(long taskId);

    public void editTask(TaskDTO taskDTO);

    public void removeTask(long taskId);

    public void removeAllTasks();

    public List<SubTask> getSubTasks(long taskId);

    public void addSubTask(SubTaskDTO subTaskDTO, long taskId);

    public List<Task> getTasks();

}
