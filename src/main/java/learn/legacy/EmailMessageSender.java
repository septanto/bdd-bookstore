package learn.legacy;

public class EmailMessageSender extends MessageSender {

    public void send(Email address, String msg) {
        System.out.println("Sent email to '" + address.getAddress() + "' with the body '" + msg + "'");
    }
}
