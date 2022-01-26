package cn.techflower.delivery.items.task.service;

import cn.techflower.delivery.items.task.domian.dto.TrelloConfigDto;
import cn.techflower.delivery.items.task.domian.entity.TrelloConfigEntity;
import cn.techflower.delivery.items.task.presistence.TrelloConfigRepository;
import cn.techflower.foundation.error.BusinessException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static cn.techflower.foundation.error.BusinessErrorEnums.USER_NOT_FOUND;

@Service
@Slf4j
@Data
public class TrelloConfigService {
    private final TrelloConfigRepository trelloConfigRepository;

    public void setTrelloConfig(TrelloConfigDto trelloConfig) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        TrelloConfigEntity trelloConfigEntity = new TrelloConfigEntity()
                .setTrelloKey(trelloConfig.getTrelloKey())
                .setTrelloToken(trelloConfig.getTrelloToken())
                .setOwner(authentication.getName());

        trelloConfigRepository.save(trelloConfigEntity);
    }

    public TrelloConfigEntity getCurrentTrelloConfig() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            throw new BusinessException(USER_NOT_FOUND);
        }

        String name = authentication.getName();
        Optional<TrelloConfigEntity> firstByOwner = trelloConfigRepository.findFirstByOwner(name);
        return firstByOwner.orElse(new TrelloConfigEntity());
    }
}
