package co.com.sofka.util;

public enum LoginKey {

    USER("[email]"),
    PASSWORD("[password]"),
    NAME("[NAME]"),
    JOB("[JOB]");

    private final String value;

    LoginKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
