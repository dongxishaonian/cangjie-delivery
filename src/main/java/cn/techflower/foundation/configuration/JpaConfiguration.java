package cn.techflower.foundation.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.springframework.security.config.Elements.ANONYMOUS;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfiguration {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            if (StringUtils.isNotBlank(name)) {
                return Optional.of(name);
            }
            return Optional.of(ANONYMOUS);
        };
    }
}
