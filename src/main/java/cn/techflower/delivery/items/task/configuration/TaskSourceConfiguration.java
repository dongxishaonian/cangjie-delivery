package cn.techflower.delivery.items.task.configuration;

import cn.techflower.delivery.items.task.enums.TaskSourceType;
import cn.techflower.delivery.items.task.service.TaskService;
import cn.techflower.delivery.items.task.service.impl.TrelloService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
@AllArgsConstructor
public class TaskSourceConfiguration {
    private final TrelloService trelloService;

    @Bean
    public Map<TaskSourceType, TaskService> taskServiceMap() {
        Map<TaskSourceType, TaskService> map = new HashMap<>();
        map.put(TaskSourceType.TRELLO, trelloService);
        return map;
    }
}
