package cn.techflower.settings.service;

import cn.techflower.settings.controller.vo.TrelloSettingVo;
import cn.techflower.settings.convert.TrelloSettingConverter;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import cn.techflower.settings.presistence.TrelloSettingRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@Data
@Transactional
public class TrelloSettingService {
    private final TrelloSettingRepository trelloSettingRepository;
    private final TrelloSettingConverter trelloSettingConverter;

    public void createTrelloSetting(TrelloSettingVo trelloSettingVo) {
        Optional<TrelloSettingEntity> trelloSettingOptional = getTrelloSetting();
        if (trelloSettingOptional.isPresent()) {
            TrelloSettingEntity trelloSettingEntity = trelloSettingOptional.get();
            trelloSettingEntity.setOauthConsumerKey(trelloSettingVo.getOauthConsumerKey());
            trelloSettingEntity.setOauthToken(trelloSettingVo.getOauthToken());
            return;
        }

        TrelloSettingEntity trelloSettingEntity = trelloSettingConverter.toTrelloSettingEntity(trelloSettingVo);
        trelloSettingEntity.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        trelloSettingRepository.save(trelloSettingEntity);
    }

    public Optional<TrelloSettingEntity> getTrelloSetting() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return  trelloSettingRepository.findByOwner(name);
    }
}
