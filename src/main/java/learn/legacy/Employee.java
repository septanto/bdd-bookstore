package learn.legacy;

public class Employee {

    private Email email;

    public Employee(Email emailAddress) {
        this.email = emailAddress;
    }

    public Email getAddress() {
        return this.email;
    }
}
