package cn.techflower.delivery.items.task.presistence;


import cn.techflower.delivery.items.task.domian.entity.TrelloConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrelloConfigRepository extends JpaRepository<TrelloConfigEntity, Long>, JpaSpecificationExecutor<TrelloConfigEntity> {
    Optional<TrelloConfigEntity> findFirstByOwner(String owner);
}
