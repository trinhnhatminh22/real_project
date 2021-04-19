package com.ptt.mvc.repository;

import com.ptt.mvc.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    Set<Task> findAllByProjectId(int id);

    Set<Task> findAllByEmployeeId(int id);
}
