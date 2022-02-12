package cn.techflower.settings.convert;

import cn.techflower.foundation.configuration.MapstructIgnoreConfig;
import cn.techflower.settings.controller.vo.TrelloSettingVo;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import org.mapstruct.Mapper;

@Mapper(config = MapstructIgnoreConfig.class, componentModel = "spring")
public interface TrelloSettingConverter {
    TrelloSettingEntity toTrelloSettingEntity(TrelloSettingVo trelloSettingVo);
}
