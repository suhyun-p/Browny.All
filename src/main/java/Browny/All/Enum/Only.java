package Browny.All.Enum;

public enum Only {
    M("Gentleman Only"),
    F("Lady Only");
    // Key("Value");

    private String value;

    Only(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
