package learn.legacy;

public class BirthdayGreetingService {

    private final MessageSender messageSender;

    public BirthdayGreetingService(final MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    protected MessageSender getMessageSender() {
        return new EmailMessageSender();
    }

    public void greet(final Employee employee) {
        messageSender.send(employee.getAddress(), "Greetings on your birthday");
    }

}
