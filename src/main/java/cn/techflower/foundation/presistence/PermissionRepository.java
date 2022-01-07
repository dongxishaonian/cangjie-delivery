package cn.techflower.foundation.presistence;

import cn.techflower.foundation.presistence.entity.PermissionDO;
import cn.techflower.foundation.presistence.entity.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionDO, Long>, JpaSpecificationExecutor<PermissionDO> {
    Optional<PermissionDO> findFirstByUsername(String userName);

    List<PermissionDO> findAllByAuthoritiesContains(RoleDO roleDO);
}
