package be.tibo.taskmanager.repository;

import be.tibo.taskmanager.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
