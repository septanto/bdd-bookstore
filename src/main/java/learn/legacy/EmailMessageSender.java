package learn.legacy;

public class EmailMessageSender extends MessageSender {

    public void send(String address, String msg) {
        System.out.println("Sent email to '" + address + "' with the body '" + msg + "'");
    }
}
