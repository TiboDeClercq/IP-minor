package be.tibo.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private long subtaskId;
    @NotEmpty(message = "Beschrijving mag niet leeg zijn")
    private String description;
    @NotEmpty(message = "Title mag niet leeg zijn")
    private String title;

    @ManyToOne
    private Task task;

    public SubTask() {
    }

    public SubTask(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    //Getters and setters
    public long getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(long subtaskId) {
        this.subtaskId = subtaskId;
    }

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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
