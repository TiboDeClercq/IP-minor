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

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskTest {
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
    /*@Test
    public void addSubtask() {
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(1);
        dto.setTitle("Eerste taak");
        dto.setDescription("Beschrijving eerste taak");
        dto.setDateAndTimeOfTask(LocalDateTime.now());

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("Test");
        subTaskDTO.setDescription("beschrijving");
        subTaskDTO.setSubtaskId(1);


        ts.addTask(dto);

        ts.addSubTask(subTaskDTO, 1);

        System.out.println(ts.getTasks().size());
        System.out.println(ts.getSubTasks(1).size());

    }*/
    
}
