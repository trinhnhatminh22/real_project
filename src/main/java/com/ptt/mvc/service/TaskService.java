package com.ptt.mvc.service;

import com.ptt.mvc.model.Task;

public interface TaskService {
    Task createTask(int projectId, String name, String employeeName);

    Task getTaskById(int id);

    Task updateTask(int id,String name, String employee);

    Task updateTaskStatus(int id);

    void deleteTask(int id);
}
