package cn.techflower.delivery.items.task.service.impl;

import cn.techflower.delivery.items.task.domian.dto.TaskDto;
import cn.techflower.delivery.items.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrelloService implements TaskService {
    @Override
    public void selectTask(TaskDto taskDto) {

    }

    @Override
    public List<TaskDto> findAllTask() {
        return null;
    }
}
