package cn.techflower.delivery.items.task.service;

import cn.techflower.delivery.items.task.domian.entity.TrelloConfigEntity;
import cn.techflower.delivery.items.task.presistence.TrelloConfigRepository;
import cn.techflower.foundation.error.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloConfigServiceTest {
    @InjectMocks
    private TrelloConfigService trelloConfigService;
    @Mock
    private TrelloConfigRepository trelloConfigRepository;


    @Test
    public void 无法获取当前用户信息时_获取trello配置_异常() {
        Throwable exception = assertThrows(BusinessException.class, () -> {
            trelloConfigService.getCurrentTrelloConfig();
        });
        assertEquals(exception.getMessage(), "用户信息不存在！");
    }

    @Test
    public void 用户的trello配置不存在_获取trello配置_返回空对象() {
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken("admin", "admin"));
        when(trelloConfigRepository.findFirstByOwner("admin")).thenReturn(Optional.empty());

        TrelloConfigEntity currentTrelloConfig = trelloConfigService.getCurrentTrelloConfig();

        Assertions.assertEquals(currentTrelloConfig, new TrelloConfigEntity());
    }

    @Test
    public void 用户的trello配置存在_获取trello配置_正常返回(){
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken("admin", "admin"));
        when(trelloConfigRepository.findFirstByOwner("admin")).thenReturn(Optional.of(new TrelloConfigEntity().setOwner("admin")));

        TrelloConfigEntity currentTrelloConfig = trelloConfigService.getCurrentTrelloConfig();

        Assertions.assertEquals(currentTrelloConfig, new TrelloConfigEntity().setOwner("admin"));
    }
}
