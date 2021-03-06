package cn.techflower.authorization.presistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "role")
public class RoleDO implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
