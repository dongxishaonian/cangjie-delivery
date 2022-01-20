package cn.techflower.delivery.items.task.service;

import cn.techflower.delivery.items.task.domian.dto.TaskDto;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Data
public class TaskAdaptorService implements TaskService {
    private final Map<TaskSourceType, TaskService> taskServiceMap;


    @Override
    public void selectTask(TaskDto taskDto) {

    }

    @Override
    public List<TaskDto> findAllTask() {

        return null;
    }
}
