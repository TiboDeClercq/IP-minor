package be.tibo.taskmanager;

import be.tibo.taskmanager.domain.SubTask;
import be.tibo.taskmanager.domain.Task;
import be.tibo.taskmanager.dto.SubTaskDTO;
import be.tibo.taskmanager.dto.TaskDTO;
import be.tibo.taskmanager.service.TaskService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskTest {
    private Validator validator;
    @Autowired
    private TaskService ts;

    @BeforeEach
    public void reset() {
        ts.removeAllTasks();
    }

    @Test
    public void nieuweTaak() {
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(1);
        dto.setTitle("Eerste taak");
        dto.setDescription("Beschrijving eerste taak");
        dto.setDateAndTimeOfTask(LocalDateTime.now());
        ts.addTask(dto);

        List<Task> taken = ts.getTasks();
        Task t = ts.getTask(1);

        assertNotNull(t);
        assertNotNull(taken);
        assertFalse(taken.isEmpty());
        assertEquals(1, dto.getTaskId());
        assertEquals("Eerste taak", dto.getTitle());
        assertEquals("Beschrijving eerste taak", dto.getDescription());
    }


    @Test
    public void verwijderTaak() {
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(1);
        dto.setTitle("Eerste taak");
        dto.setDescription("Beschrijving eerste taak");
        dto.setDateAndTimeOfTask(LocalDateTime.now());
        ts.addTask(dto);

        List<Task> taken = ts.getTasks();
        Task t = ts.getTask(1);

        ts.removeAllTasks();
        assertTrue(ts.getTasks().isEmpty());
    }

    @Test
    public void getters_Test() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Titel vd Taak");
        taskDTO.setDescription("EEN super lange title wqqqqqqqqqqqqqqqqq");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertTrue(violations.isEmpty());
        assertEquals("Titel vd Taak", taskDTO.getTitle());
        assertEquals("EEN super lange title wqqqqqqqqqqqqqqqqq", taskDTO.getDescription());
        assertEquals(LocalDateTime.MIN, taskDTO.getDateAndTimeOfTask());
    }

    @Test
    public void getTask() {
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(1);
        dto.setTitle("Eerste taak");
        dto.setDescription("Beschrijving eerste taak");
        dto.setDateAndTimeOfTask(LocalDateTime.now());

        ts.addTask(dto);

    }
    @Test
    public void legeLijstTaken() {
        List<Task> taken = ts.getTasks();
        assertTrue(taken.isEmpty());
    }
    @Test
    public void zonder_Date() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Titel vd TAak");
        taskDTO.setDescription("EEN super lange title wqqqqqqqqqqqqqqqqq");
        taskDTO.setDateAndTimeOfTask(null);
        Set<ConstraintViolation<TaskDTO>> errors = validator.validate(taskDTO);
        assertFalse(errors.isEmpty());
        assertEquals(1, errors.size());
    }

    @Test
    public void Geen_Beschrijving() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);
        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void Geen_Titel() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("");
        taskDTO.setDescription("EEN super lange title wqqqqqqqqqqqqqqqqq");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);
        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void Geen_Title_Geen_Beschijving_Geen_Datum() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("");
        taskDTO.setDescription("");
        taskDTO.setDateAndTimeOfTask(null);
        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(3, violations.size());
    }







}

