package learn.legacy;

public class BirthdayGreetingService {

    private final MessageSender messageSender;

    public BirthdayGreetingService() {
        messageSender = new EmailMessageSender();
    }

    public void greet(final Employee employee) {
        messageSender.send(employee.getAddress(), "Greetings on your birthday");
    }

}
