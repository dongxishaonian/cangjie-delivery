package cn.techflower.delivery.items.task;

import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.items.task.domian.dto.TaskDto;
import cn.techflower.delivery.items.task.domian.entity.TaskEntity;
import cn.techflower.delivery.items.task.presistence.TaskRepository;
import cn.techflower.delivery.presistence.DeliveryProcessRepository;
import cn.techflower.foundation.error.BusinessException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static cn.techflower.foundation.error.BusinessErrorEnums.DELIVERY_PROCESS_NOT_FOUND;

@Data
@Slf4j
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final DeliveryProcessRepository deliveryProcessRepository;

    public void bindTaskInProcess(TaskDto taskDto) {
        TaskEntity task = new TaskEntity();
        BeanUtils.copyProperties(taskDto, task);

        Optional<DeliveryProcessEntity> processEntityOptional = deliveryProcessRepository.findById(taskDto.getDeliveryProcessId());
        DeliveryProcessEntity deliveryProcessEntity = processEntityOptional.orElseThrow(() -> new BusinessException(DELIVERY_PROCESS_NOT_FOUND));
        task.setDeliveryProcess(deliveryProcessEntity);

        taskRepository.save(task);
    }


}
