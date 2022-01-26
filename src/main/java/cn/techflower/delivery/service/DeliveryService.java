package cn.techflower.delivery.service;

import cn.techflower.delivery.domain.dto.CreateDeliveryDto;
import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.presistence.DeliveryProcessRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class DeliveryService {
    private final DeliveryProcessRepository deliveryProcessRepository;

    public void createDeliveryProcess(CreateDeliveryDto deliveryDto) {
        DeliveryProcessEntity deliveryProcessEntity = new DeliveryProcessEntity()
                .setName(deliveryDto.getName());

        deliveryProcessRepository.save(deliveryProcessEntity);
    }


}
