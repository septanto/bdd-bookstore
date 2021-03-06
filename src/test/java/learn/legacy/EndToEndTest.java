package learn.legacy;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class EndToEndTest {

    @Test
    public void emailAndEmployee() {
        final StringBuilder systemOutput = injectSystemOutput();
        final Employee john = new Employee(new Email("john@example.com"));

        new BirthdayGreetingService(new EmailMessageSender()).greet(john);

        assertThat(systemOutput.toString(), equalTo("Sent email to '"
                + "john@example.com"
                + "' with the body '"
                + "Greetings on your birthday"
                + "'\n"));
    }

    @Test
    public void theServiceShouldAskTheMessageSender() {
        final Email address = new Email("john@example.com");
        final Employee john = new Employee(address);
        final MessageSender messageSender = mock(MessageSender.class);

        new BirthdayGreetingService(messageSender).greet(john);

        verify(messageSender).send(address, "Greetings on your birthday");
    }

    // This code has been used with permission from
    //GMaur's LegacyUtils:
    // https://github.com/GMaur/legacyutils
    private StringBuilder injectSystemOutput() {
        final StringBuilder stringBuilder =
                new StringBuilder();
        final PrintStream outputPrintStream =
                new PrintStream(
                        new OutputStream() {
                            @Override
                            public void write(final int b)
                                    throws IOException {
                                stringBuilder.append((char) b);
                            }
                        });
        System.setOut(outputPrintStream);
        return stringBuilder;
    }

}
