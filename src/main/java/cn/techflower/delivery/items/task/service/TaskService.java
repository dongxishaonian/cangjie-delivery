package cn.techflower.delivery.items.task.service;

import cn.techflower.delivery.items.task.domian.dto.TaskDto;

import java.util.List;

public interface TaskService {
    void selectTask(TaskDto taskDto);

    List<TaskDto> findAllTask();
}
