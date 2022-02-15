package cn.techflower.delivery.service;

import cn.techflower.delivery.controller.vo.CreateProcessVo;
import cn.techflower.delivery.controller.vo.DeliveryProcessVo;
import cn.techflower.delivery.domain.dto.ProcessDetailDto;
import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.domain.entity.DeliveryProcessTemplateEntity;
import cn.techflower.delivery.enums.ProcessNodeEnums;
import cn.techflower.delivery.enums.ProcessToolEnums;
import cn.techflower.delivery.items.task.service.TaskService;
import cn.techflower.delivery.presistence.DeliveryProcessRepository;
import cn.techflower.foundation.error.BusinessException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static cn.techflower.foundation.error.BusinessErrorEnums.DELIVERY_PROCESS_NOT_FOUND;

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


    public DeliveryProcessVo getDeliveryProcessDetail(Long processId) {
        Optional<DeliveryProcessEntity> deliveryProcessEntityOptional = deliveryProcessRepository.findById(processId);
        DeliveryProcessEntity deliveryProcessEntity = deliveryProcessEntityOptional.orElseThrow(() -> new BusinessException(DELIVERY_PROCESS_NOT_FOUND));

        DeliveryProcessTemplateEntity deliveryProcessTemplate = deliveryProcessEntity.getDeliveryProcessTemplate();

        DeliveryProcessVo deliveryProcessVo = new DeliveryProcessVo();
        deliveryProcessVo.setTemplate(deliveryProcessTemplate);
        deliveryProcessVo.setDeliveryProcess(deliveryProcessEntity);

        List<List<DeliveryProcessVo.ItemVo>> items = getDeliveryItemsDetail(deliveryProcessEntity, deliveryProcessTemplate.getProcessDetailList());
        deliveryProcessVo.setItems(items);

        return deliveryProcessVo;
    }

    private List<List<DeliveryProcessVo.ItemVo>> getDeliveryItemsDetail(DeliveryProcessEntity deliveryProcessEntity, List<ProcessDetailDto> processDetailList) {
        Optional<Integer> max = processDetailList.stream()
            .map(m -> m.getProcessTools().size())
            .max(Comparator.naturalOrder());

        List<List<DeliveryProcessVo.ItemVo>> items = new ArrayList<>();

        IntStream.range(0, max.orElse(0)).forEach(index -> {
            List<DeliveryProcessVo.ItemVo> itemVoList = new ArrayList<>();
            for (ProcessDetailDto processDetailDto : processDetailList) {
                if (index < processDetailDto.getProcessTools().size()) {
                    ProcessToolEnums processToolEnums = processDetailDto.getProcessTools().get(index);
                    itemVoList.add(new DeliveryProcessVo.ItemVo()
                        .setProcessDetail(getProcessItemDetail(processDetailDto.getProcessNode(), processToolEnums, deliveryProcessEntity))
                        .setProcessNodeEnums(processDetailDto.getProcessNode()));
                } else {
                    itemVoList.add(null);
                }
            }
            items.add(itemVoList);
        });

        return items;
    }

    private Object getProcessItemDetail(ProcessNodeEnums processNodeEnums, ProcessToolEnums processToolEnums, DeliveryProcessEntity deliveryProcess) {
        if (processNodeEnums.equals(ProcessNodeEnums.TASK)) {
            return taskService.getTaskDto(processToolEnums, deliveryProcess);
        }
        return null;
    }
}
