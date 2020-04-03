package be.tibo.taskmanager.domain;

import be.tibo.taskmanager.dto.SubTaskDTO;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long taskId;
    @NotEmpty(message = "Title mag niet leeg zijn")
    private String title;
    @NotEmpty(message = "Description mag niet leeg zijn")
    private String description;
    @NotNull(message = "Datum mag niet leeg zijn")
    private LocalDateTime dateAndTimeOfTask;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SubTask> subTasks;

    public Task() {
    }

    public Task(long taskId, String title, String description, LocalDateTime dateAndTimeOfTask) {
        setTaskId(taskId);
        setTitle(title);
        setDescription(description);
        setDateAndTimeOfTask(dateAndTimeOfTask);
        subTasks = new ArrayList<>();
    }

    public Task(long taskId, String title, String description, LocalDateTime dateAndTimeOfTask, List<SubTask> subTasks) {
        setTaskId(taskId);
        setTitle(title);
        setDescription(description);
        setDateAndTimeOfTask(dateAndTimeOfTask);
        setSubTasks(subTasks);
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAndTimeOfTask() {
        return dateAndTimeOfTask;
    }

    public long getTaskId() {
        return taskId;
    }

    public List<SubTask> getSubTasks() {
        return this.subTasks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateAndTimeOfTask(LocalDateTime dateAndTimeOfTask) {
        this.dateAndTimeOfTask = dateAndTimeOfTask;
    }

    public void AddSubTask(@Valid SubTaskDTO subTaskDTO) {
        SubTask subTask = new SubTask(subTaskDTO.getTitle(), subTaskDTO.getDescription());
        subTasks.add(subTask);
    }
    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
}
