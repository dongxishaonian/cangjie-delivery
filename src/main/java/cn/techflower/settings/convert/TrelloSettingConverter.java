package cn.techflower.settings.convert;

import cn.techflower.settings.controller.vo.TrelloSettingVo;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.IGNORE,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrelloSettingConverter {
    TrelloSettingEntity toTrelloSettingEntity(TrelloSettingVo trelloSettingVo);
}
