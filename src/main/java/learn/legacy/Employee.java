package learn.legacy;

public class Employee {

    private Email email;

    public Employee(Email emailAddress) {
        this.email = emailAddress;
    }

    public String getAddress() {
        return this.email.getAddress();
    }
}
