package cn.techflower.delivery.presistence;

import cn.techflower.delivery.domain.entity.DeliveryProcessToolConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryProcessToolConfigRepository extends JpaRepository<DeliveryProcessToolConfigEntity, Long>, JpaSpecificationExecutor<DeliveryProcessToolConfigEntity> {
}
