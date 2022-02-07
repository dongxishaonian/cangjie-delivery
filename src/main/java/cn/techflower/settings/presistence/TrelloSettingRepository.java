package cn.techflower.settings.presistence;

import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrelloSettingRepository extends JpaRepository<TrelloSettingEntity, Long>, JpaSpecificationExecutor<TrelloSettingEntity> {
    Optional<TrelloSettingEntity> findByOwner(String owner);
}
