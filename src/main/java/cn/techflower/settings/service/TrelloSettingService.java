package cn.techflower.settings.service;

import cn.techflower.settings.controller.vo.TrelloSettingVo;
import cn.techflower.settings.convert.TrelloSettingConverter;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import cn.techflower.settings.presistence.TrelloSettingRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Data
public class TrelloSettingService {
    private final TrelloSettingRepository trelloSettingRepository;
    private final TrelloSettingConverter trelloSettingConverter;

    public void createTrelloSetting(TrelloSettingVo trelloSettingVo) {
        TrelloSettingEntity trelloSettingEntity = trelloSettingConverter.toTrelloSettingEntity(trelloSettingVo);
        trelloSettingEntity.setOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        trelloSettingRepository.save(trelloSettingEntity);
    }

    public TrelloSettingEntity getTrelloSetting() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<TrelloSettingEntity> trelloSetting = trelloSettingRepository.findByOwner(name);
        return trelloSetting.orElse(null);
    }
}
