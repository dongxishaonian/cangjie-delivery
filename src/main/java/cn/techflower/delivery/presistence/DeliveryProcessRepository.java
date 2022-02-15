package cn.techflower.delivery.presistence;


import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryProcessRepository extends JpaRepository<DeliveryProcessEntity, Long>, JpaSpecificationExecutor<DeliveryProcessEntity> {
}
