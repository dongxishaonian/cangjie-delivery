package cn.techflower.delivery.items.task.presistence;


import cn.techflower.delivery.domain.entity.DeliveryProcessEntity;
import cn.techflower.delivery.items.task.domian.entity.TaskEntity;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>, JpaSpecificationExecutor<TaskEntity> {
    Optional<TaskEntity> findFirstByDeliveryProcess(DeliveryProcessEntity deliveryProcess);

    Optional<TaskEntity> findFirstByTaskKeyAndSourceType(String taskKey, TaskSourceType taskSourceType);
}
