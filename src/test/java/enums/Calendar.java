package enums;

public enum Calendar {
    DAY("DAY"),
    MONTH("MONTH"),
    YEAR("YEAR");

    private final String text;


    Calendar(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
