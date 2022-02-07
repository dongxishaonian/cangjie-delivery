package cn.techflower.settings.controller.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TrelloSettingVo {
    private String oauthConsumerKey;
    private String oauthToken;
}
