package cn.techflower.authorization.presistence;

import cn.techflower.authorization.presistence.entity.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleDO, Long>, JpaSpecificationExecutor<RoleDO> {
    List<RoleDO> findAllByNameIn(List<String> nameList);

    Optional<RoleDO> findFirstByName(String name);

    @Modifying
    @Query(value = "delete from role where name=?1", nativeQuery = true)
    void deleteRole(String name);
}
