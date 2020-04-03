package be.tibo.taskmanager.dto;


import be.tibo.taskmanager.domain.SubTask;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    private long taskId;

    @NotEmpty(message = "Title mag niet leeg zijn")
    private String title;
    @NotEmpty(message = "Description mag niet leeg zijn")
    private String description;
    @NotNull(message = "Datum mag niet leeg zijn")
    private LocalDateTime dateAndTimeOfTask;

    private List<SubTask> subTasks;


    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
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

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void AddSubTask(@Valid SubTaskDTO subTaskDTO) {
        SubTask subTask = new SubTask(subTaskDTO.getTitle(), subTaskDTO.getDescription());
        subTasks.add(subTask);
    }
}
