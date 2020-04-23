package be.tibo.taskmanager;

import be.tibo.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @BeforeEach
    public void setup(){ taskService.removeAllTasks();}

    @Test
    public void testGetTasksMetEenTask(){

    }
}
