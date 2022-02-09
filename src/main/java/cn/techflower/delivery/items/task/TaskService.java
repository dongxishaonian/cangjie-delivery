package cn.techflower.delivery.items.task;

import cn.techflower.delivery.items.task.enums.TaskSourceType;
import cn.techflower.delivery.items.task.presistence.TaskRepository;
import cn.techflower.delivery.presistence.DeliveryProcessRepository;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import cn.techflower.settings.service.TrelloSettingService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
@Slf4j
@Service
public class TaskService {
    private final TrelloSettingService trelloSettingService;
    private final TaskRepository taskRepository;
    private final DeliveryProcessRepository deliveryProcessRepository;
    private final ApplicationContext applicationContext;

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
