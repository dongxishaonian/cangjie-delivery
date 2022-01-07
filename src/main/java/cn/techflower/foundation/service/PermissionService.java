package cn.techflower.foundation.service;

import cn.techflower.foundation.presistence.PermissionRepository;
import cn.techflower.foundation.presistence.PermissionRoleRepository;
import cn.techflower.foundation.presistence.RoleRepository;
import cn.techflower.foundation.presistence.entity.PermissionDO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.security.config.Elements.ANONYMOUS;

@Service
@Slf4j
public class PermissionService implements UserDetailsService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRoleRepository permissionRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void startUp() throws JsonProcessingException {
        permissionRepository.save(new PermissionDO().setCreated(LocalDateTime.now())
            .setPassword(passwordEncoder.encode("123456"))
            .setEffective(true)
            .setUpdated(LocalDateTime.now())
            .setUsername("chengang"));
        System.out.println(new Jackson2ObjectMapperBuilder().build().writeValueAsString(permissionRepository.findAll()));
    }

    public Boolean isPermission(String username) {
        Optional<PermissionDO> permissionDOOptional = permissionRepository.findFirstByUsername(username);
        if (!permissionDOOptional.isPresent()) {
            return false;
        }
        return permissionDOOptional.get().getEffective();
    }

    public Boolean permissionHasRole(String userName, String roleName) {
        UserDetails userDetails = loadUserByUsername(userName);
        return userDetails.getAuthorities().stream().anyMatch(a -> roleName.equals(a.getAuthority()));
    }

    public Boolean currentPermissionHasRole(String roleName) {
        UserDetails currentUserDetails = getCurrentUserDetails();
        return currentUserDetails.getAuthorities().stream().anyMatch(a -> roleName.equals(a.getAuthority()));
    }

    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            return ANONYMOUS;
        }
        return authentication.getName();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<PermissionDO> permissionDOOptional = permissionRepository.findFirstByUsername(s);
        return permissionDOOptional.orElse(new PermissionDO()
            .setUsername(ANONYMOUS)
            .setEffective(true)
            .setAuthorities(new ArrayList<>()));
    }

    public UserDetails getCurrentUserDetails() {
        return loadUserByUsername(this.getCurrentUserName());
    }
}
