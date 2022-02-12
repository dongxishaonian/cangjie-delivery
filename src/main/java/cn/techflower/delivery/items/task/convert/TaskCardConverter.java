package cn.techflower.delivery.items.task.convert;

import cn.techflower.delivery.items.task.controller.vo.TaskListItemVo;
import cn.techflower.delivery.items.task.domian.dto.CardDto;
import cn.techflower.foundation.configuration.MapstructIgnoreConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapstructIgnoreConfig.class, componentModel = "spring")
public interface TaskCardConverter {
    @Mapping(target = "taskUrl", source = "shortUrl")
    @Mapping(target = "taskKey", source = "id")
    @Mapping(target = "title", source = "name")
    TaskListItemVo convertTaskListItemVo(CardDto cardDto);

    List<TaskListItemVo> convertTaskListItemVoList(List<CardDto> cardDtos);
}
