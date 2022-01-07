package cn.techflower.foundation.presistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "permission")
public class PermissionDO implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean effective;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {@JoinColumn(name = "permission_id")}
        , inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<RoleDO> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return effective;
    }
}
