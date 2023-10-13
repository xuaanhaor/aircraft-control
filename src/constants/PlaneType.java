package constants;

public enum PlaneType {
    CAR("Cargo"),
    LRG("Long Range"),
    PRV("Private");

    private String value;
    PlaneType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
