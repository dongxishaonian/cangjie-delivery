package cn.techflower.delivery.service;

import cn.techflower.delivery.controller.vo.CreateProcessVo;
import cn.techflower.delivery.domain.dto.ProcessDetailDto;
import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.domain.entity.DeliveryProcessTemplateEntity;
import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.items.task.service.TaskService;
import cn.techflower.delivery.presistence.DeliveryProcessRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Data
@Slf4j
@Service
@Transactional
public class DeliveryService {
    private final DeliveryProcessRepository deliveryProcessRepository;
    private final DeliveryProcessTemplateService deliveryProcessTemplateService;
    private final TaskService taskService;

    public void createDeliveryProcess(CreateProcessVo createProcessVo) {
        DeliveryProcessTemplateEntity deliveryProcessTemplate = deliveryProcessTemplateService.getDeliveryProcessTemplate(createProcessVo.getTemplateId());

        DeliveryProcessEntity deliveryProcessEntity = new DeliveryProcessEntity();
        deliveryProcessEntity.setDeliveryProcessTemplate(deliveryProcessTemplate);
        deliveryProcessRepository.save(deliveryProcessEntity);

        List<ProcessDetailDto> processDetailList = deliveryProcessTemplate.getProcessDetailList();
        for (ProcessDetailDto processDetailDto : processDetailList) {
            ProcessNodeEnums processNode = processDetailDto.getProcessNode();
            for (ProcessToolEnums processToolEnums : processDetailDto.getProcessTools()) {
                if (processNode.equals(ProcessNodeEnums.TASK)) {
                    taskService.createTaskProcessNode(processToolEnums, createProcessVo.getTaskKey(), createProcessVo.getTaskUrl(), deliveryProcessEntity);
                }
            }
        }
    }
}
