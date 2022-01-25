package cn.techflower.delivery.items.task.client;

import cn.techflower.CangjieDeliveryApplicationTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class TrelloClientTest extends CangjieDeliveryApplicationTests {
    @Autowired
    private TrelloClient trelloClient;

    @Disabled
    @Test
    public void getTrelloBoard() {
        trelloClient.getBoardList();
    }

    @Test
    @Disabled
    public void getTrelloCardList(){
        trelloClient.getCardList("61d8ffea7a477334757805a5");
    }

}
