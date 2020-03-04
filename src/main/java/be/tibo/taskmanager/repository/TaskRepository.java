package be.tibo.taskmanager.repository;

import be.tibo.taskmanager.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> taken;

    public TaskRepository() {
        taken = new ArrayList<>();
        taken.add(new Task("taak1 ", " Da was tegen vandaag gast"));
    }

    public List<Task> getTaken() {
        return taken;
    }
    public void addTask(Task t){
        taken.add(t);
    }
}
