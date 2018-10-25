package pl.edu.agh.student.danielkurosz.Email;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList<String> to=new LinkedList<String>();
        to.add("danielkurosz@gmail.com");
        to.add("danioscv@wp.pl");

        EmailMessage message=new EmailMessage.Builder("danielkurosz@gmail.com",to).subject("Hello").content("AGH").build();
        message.send("xd");
    }
}
