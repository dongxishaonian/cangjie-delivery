package cn.techflower.delivery.items.task.client;

import cn.techflower.delivery.items.task.domian.dto.BoardDto;
import cn.techflower.delivery.items.task.domian.dto.CardDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
@Data
public class TrelloClient {
    private final ClientHttpRequestFactory clientHttpRequestFactory;
    @Value("${external-system.trello.authStr}")
    private String authStr;


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
        headers.add("Authorization", authStr);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
