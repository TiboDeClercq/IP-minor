package be.tibo.taskmanager.dto;

import be.tibo.taskmanager.domain.Task;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SubTaskDTO {
    private long subtaskId;

    @NotEmpty(message = "Beschrijving mag niet leeg zijn")
    private String description;
    @NotEmpty(message = "Title mag niet leeg zijn")
    private String title;

    private Task task;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(long subtaskId) {
        this.subtaskId = subtaskId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
