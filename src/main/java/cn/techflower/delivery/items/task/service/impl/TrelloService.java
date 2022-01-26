package cn.techflower.delivery.items.task.service.impl;

import cn.techflower.delivery.items.task.client.TrelloClient;
import cn.techflower.delivery.items.task.domian.dto.BoardDto;
import cn.techflower.delivery.items.task.domian.dto.TaskDto;
import cn.techflower.delivery.items.task.service.TaskService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Data
public class TrelloService implements TaskService {
    private final TrelloClient trelloClient;

    public List<BoardDto> getBoardList() {
        return trelloClient.getBoardList();
    }

    @Override
    public void selectTask(TaskDto taskDto) {

    }

    @Override
    public List<TaskDto> findAllTask() {

        return null;
    }
}
