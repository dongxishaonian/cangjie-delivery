package cn.techflower.delivery.items.task.controller;


import cn.techflower.delivery.items.task.TaskService;
import cn.techflower.delivery.items.task.controller.vo.TaskSearchVo;
import cn.techflower.delivery.items.task.domian.dto.BoardDto;
import cn.techflower.delivery.items.task.enums.TaskSourceType;
import cn.techflower.foundation.vo.SelectOptionsVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@Data
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping(value = "/taskSourceList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SelectOptionsVo>> getTaskSourceList() {
        List<TaskSourceType> usefulTaskSources = taskService.getUsefulTaskSources();
        List<SelectOptionsVo> selectOptionsVos = usefulTaskSources.stream()
            .map(m -> new SelectOptionsVo().setName(m.getDesc()).setValue(m.name()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(selectOptionsVos);
    }

    @GetMapping(value = "/trelloBoards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SelectOptionsVo>> getTrelloBoards() {
        List<BoardDto> trelloBoards = taskService.getTrelloBoards();
        List<SelectOptionsVo> selectOptionsVos = trelloBoards.stream()
            .map(m -> new SelectOptionsVo().setName(m.getName()).setValue(m.getId()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(selectOptionsVos);
    }

    @GetMapping(value = "/taskList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<?>> getTaskList(@ModelAttribute TaskSearchVo taskSearchVo) {
        log.info("receive search body:{}", taskSearchVo);
        return ResponseEntity.ok(taskService.getTaskList(taskSearchVo));
    }

}
