package cn.techflower.delivery.service;

import cn.techflower.delivery.domain.dto.ProcessDetailDto;
import cn.techflower.delivery.domain.entity.DeliveryProcessTemplateEntity;
import cn.techflower.delivery.presistence.DeliveryProcessTemplateRepository;
import cn.techflower.foundation.error.BusinessException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static cn.techflower.foundation.error.BusinessErrorEnums.DELIVERY_PROCESS_TEMPLATE_ALREADY_EXIST;
import static cn.techflower.foundation.error.BusinessErrorEnums.DELIVERY_PROCESS_TEMPLATE_NOT_FOUND;

@Service
@Slf4j
@Data
public class DeliveryProcessTemplateService {
    private final DeliveryProcessTemplateRepository deliveryProcessTemplateRepository;

    public void createDeliveryProcessTemplate(String name, List<ProcessDetailDto> processTypeList) {
        String authName = SecurityContextHolder.getContext().getAuthentication().getName();

        List<DeliveryProcessTemplateEntity> allByCreatedBy = deliveryProcessTemplateRepository.findAllByCreatedByOrderByCreatedDesc(authName);

        boolean alreadyExist = allByCreatedBy.stream().anyMatch(a -> a.getProcessDetailList().equals(processTypeList));
        if (alreadyExist) {
            throw new BusinessException(DELIVERY_PROCESS_TEMPLATE_ALREADY_EXIST);
        }

        deliveryProcessTemplateRepository.save(new DeliveryProcessTemplateEntity().setName(name).setProcessDetailList(processTypeList));
    }

    public List<DeliveryProcessTemplateEntity> getTemplateList() {
        String authName = SecurityContextHolder.getContext().getAuthentication().getName();
        return deliveryProcessTemplateRepository.findAllByCreatedByOrderByCreatedDesc(authName);
    }


    public DeliveryProcessTemplateEntity getDeliveryProcessTemplate(Long templateId) {
        Optional<DeliveryProcessTemplateEntity> processTemplateEntityOptional = deliveryProcessTemplateRepository.findById(templateId);
        return processTemplateEntityOptional.orElseThrow(() -> new BusinessException(DELIVERY_PROCESS_TEMPLATE_NOT_FOUND));
    }

}
