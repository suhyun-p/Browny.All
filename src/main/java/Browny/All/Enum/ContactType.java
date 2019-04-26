package Browny.All.Enum;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ContactType {
    P("PhoneNo"),
    K("KakaoTalk"),
    F("Facebook"),
    I("Instagram"),
    Y("Youtube"),
    DC("DaumCafe"),
    NC("NaverCafe"),
    NB("NaverBand");
    // Key("Value");

    private String value;

    ContactType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
