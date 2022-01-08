package cn.techflower.authorization.presistence;

import cn.techflower.authorization.presistence.entity.PermissionRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRoleRepository extends JpaRepository<PermissionRoleDO, Long>, JpaSpecificationExecutor<PermissionRoleDO> {

    @Modifying
    @Query(value = "delete from permission_role where permission_id=?1 and role_id=?2", nativeQuery = true)
    void deletePermissionRole(Long permissionId, Long roleId);

    @Modifying
    @Query(value = "delete from permission_role where role_id=?1", nativeQuery = true)
    void deleteAllPermissionByRole(Long roleId);
}
