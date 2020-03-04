package be.tibo.taskmanager.service;

import be.tibo.taskmanager.domain.Task;
import be.tibo.taskmanager.dto.TaskDTO;
import be.tibo.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Task> getTasksList() {
        return repository.getTaken();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task taak = new Task(taskDTO.getNaam(), taskDTO.getDatum());
        repository.addTask(taak);
    }
}
