package cn.techflower.authorization;

import cn.techflower.authorization.controller.dto.RegisterDto;
import cn.techflower.authorization.presistence.PermissionRepository;
import cn.techflower.authorization.presistence.entity.PermissionDO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.security.config.Elements.ANONYMOUS;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class PermissionService implements UserDetailsService {
    private final PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PermissionDO> permissionDOOptional = permissionRepository.findFirstByUsername(username);
        return permissionDOOptional.orElse(new PermissionDO()
            .setUsername(ANONYMOUS)
            .setEffective(true)
            .setAuthorities(new ArrayList<>()));
    }

    public void createNewUser(RegisterDto registerDto) {
        PermissionDO permissionDO = new PermissionDO().setUsername(registerDto.getUsername())
            .setPassword(new BCryptPasswordEncoder().encode(registerDto.getPassword()));
        permissionRepository.save(permissionDO);
    }
}
