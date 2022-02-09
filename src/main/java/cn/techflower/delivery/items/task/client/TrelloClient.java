package cn.techflower.delivery.items.task.client;

import cn.techflower.delivery.items.task.domian.dto.BoardDto;
import cn.techflower.delivery.items.task.domian.dto.CardDto;
import cn.techflower.foundation.error.BusinessException;
import cn.techflower.settings.domain.entity.TrelloSettingEntity;
import cn.techflower.settings.service.TrelloSettingService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static cn.techflower.foundation.error.BusinessErrorEnums.TRELLO_AUTH_CONFIG_NOT_FOUND;

@Component
@Slf4j
@Data
public class TrelloClient {
    private final ClientHttpRequestFactory clientHttpRequestFactory;
    private final TrelloSettingService trelloSettingService;

    public List<BoardDto> getBoardList() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String resourceUrl = "https://api.trello.com/1/members/me/boards";

        HttpHeaders headers = buildTrelloAuthHeaser();

        HttpEntity<?> request = new HttpEntity<>(headers);


        ResponseEntity<List<BoardDto>> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, request, new ParameterizedTypeReference<>() {
        });

        log.debug("{}", response);

        return response.getBody();
    }

    public List<CardDto> getCardList(String boardId) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String resourceUrl = String.format("https://api.trello.com/1/boards/%s/cards", boardId);

        HttpHeaders headers = buildTrelloAuthHeaser();
        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<List<CardDto>> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, request, new ParameterizedTypeReference<>() {
        });

        log.debug("{}", response);
        return response.getBody();
    }

    private HttpHeaders buildTrelloAuthHeaser() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", buildAuthHeader());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String buildAuthHeader() {
        TrelloSettingEntity currentTrelloConfig = trelloSettingService.getTrelloSetting();
        if (StringUtils.isBlank(currentTrelloConfig.getOauthConsumerKey()) || StringUtils.isBlank(currentTrelloConfig.getOauthToken())) {
            throw new BusinessException(TRELLO_AUTH_CONFIG_NOT_FOUND);
        }
        return String.format("OAuth oauth_consumer_key=\"%s\", oauth_token=\"%s\"", currentTrelloConfig.getOauthConsumerKey(), currentTrelloConfig.getOauthToken());
    }
}
