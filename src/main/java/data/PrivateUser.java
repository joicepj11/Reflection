package data;

public class PrivateUser {

    private String name;

    public PrivateUser(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}