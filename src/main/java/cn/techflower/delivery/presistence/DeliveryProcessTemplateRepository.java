package cn.techflower.delivery.presistence;


import cn.techflower.delivery.domain.entity.DeliveryProcessTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryProcessTemplateRepository extends JpaRepository<DeliveryProcessTemplateEntity, Long>, JpaSpecificationExecutor<DeliveryProcessTemplateEntity> {
    List<DeliveryProcessTemplateEntity> findAllByCreatedBy(String createdBy);
}
