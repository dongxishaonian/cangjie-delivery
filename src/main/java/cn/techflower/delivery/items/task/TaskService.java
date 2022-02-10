package cn.techflower.delivery.items.task;

import cn.techflower.delivery.items.task.client.TrelloClient;
import cn.techflower.delivery.items.task.controller.vo.TaskSearchVo;
import cn.techflower.delivery.items.task.domian.dto.BoardDto;
import cn.techflower.delivery.items.task.domian.dto.CardDto;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import cn.techflower.delivery.items.task.presistence.TaskRepository;
import cn.techflower.delivery.presistence.DeliveryProcessRepository;
import cn.techflower.foundation.error.BusinessException;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import cn.techflower.settings.service.TrelloSettingService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

import static cn.techflower.foundation.error.BusinessErrorEnums.TASK_SOURCE_NOT_FOUND;

@Data
@Slf4j
@Service
public class TaskService {
    private final TrelloSettingService trelloSettingService;
    private final TrelloClient trelloClient;
    private final TaskRepository taskRepository;
    private final DeliveryProcessRepository deliveryProcessRepository;
    private final ApplicationContext applicationContext;

    public List<BoardDto> getTrelloBoards() {
        return trelloClient.getBoardList();
    }

    public List<CardDto> getTaskList(TaskSearchVo taskSearchVo) {
        if (Objects.isNull(taskSearchVo) || Objects.isNull(taskSearchVo.getTaskSource())) {
            throw new BusinessException(TASK_SOURCE_NOT_FOUND);
        }
        if (taskSearchVo.getTaskSource().equals(TaskSourceType.TRELLO)) {
            return getTrelloCardDtos(taskSearchVo);
        }
        return new ArrayList<>();
    }

    private List<CardDto> getTrelloCardDtos(TaskSearchVo taskSearchVo) {
        if (StringUtils.isBlank(taskSearchVo.getTrelloBoard())) {
            throw new BusinessException(TASK_SOURCE_NOT_FOUND);
        }
        return trelloClient.getCardList(taskSearchVo.getTrelloBoard());
    }

    public List<TaskSourceType> getUsefulTaskSources() {
        List<TaskSourceType> taskSourceTypes = new ArrayList<>();

        Arrays.stream(TaskSourceType.values()).forEach(source -> {
            if (source.equals(TaskSourceType.TRELLO) && trelloSettingExist()) {
                taskSourceTypes.add(source);
            }
        });

        return taskSourceTypes;
    }

    private Boolean trelloSettingExist() {
        Optional<TrelloSettingEntity> trelloSettingEntityOptional = trelloSettingService.getTrelloSetting();
        return trelloSettingEntityOptional.isPresent();
    }

}
