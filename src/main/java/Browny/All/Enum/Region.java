package Browny.All.Enum;

public enum Region {
    HD("홍대"),
    GN("강남"),
    BD("분당"),
    GD("건대");
    // Key("Value");

    private String value;

    Region(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
