package be.tibo.taskmanager;

import be.tibo.taskmanager.domain.Task;
import be.tibo.taskmanager.dto.SubTaskDTO;
import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubTask {
    private Validator validator;
    @Test
    public void Juiste_Taak_Zonder_Fouten() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("Titel van de subtaks");
        subTaskDTO.setDescription("Beschrijving subtask ");
        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void Lege_SubTask() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("");
        subTaskDTO.setDescription("");
        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertEquals(2, violations.size());

    }

    @Test
    public void SubTask_Getter_Test() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Task task = new Task();
        task.setTitle("task title");
        task.setDescription("a task description");
        task.setDateAndTimeOfTask(LocalDateTime.MIN);
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("Titel van de subtaks");
        subTaskDTO.setDescription("Beschrijving subtask ");
        subTaskDTO.setTask(task);

        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertTrue(violations.isEmpty());
        assertEquals("Titel van de subtaks", subTaskDTO.getTitle());
        assertEquals("Beschrijving subtask ", subTaskDTO.getDescription());
        assertEquals(task, subTaskDTO.getTask());
    }

}
