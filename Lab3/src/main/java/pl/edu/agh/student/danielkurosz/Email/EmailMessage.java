package pl.edu.agh.student.danielkurosz.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;

public class EmailMessage {
    private final String from; //required (must be e-mail)
    private final LinkedList<String> to; //required at least one (must be e-mail)
    private final String subject; //optional
    private final String content; //optional
    private final String mimeType;  // optional
    private final LinkedList<String> cc; //optional
    private final LinkedList<String> bcc; // optional


    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }





    private EmailMessage(Builder builder){
        this.from=builder.from;
        this.to=builder.to;
        this.subject=builder.subject;
        this.content=builder.content;
        this.mimeType=builder.mimeType;
        this.cc=builder.cc;
        this.bcc=builder.bcc;
    }

    public static class Builder{
        private String from;
        private LinkedList<String> to;
        private String subject=null;
        private String content=null;
        private String mimeType=null;
        private LinkedList<String> cc=null;
        private LinkedList<String> bcc=null;

        public Builder(String from,LinkedList<String>to){
            this.from=from;
            this.to=to;
        }
        public Builder subject(String subject){
            this.subject=subject;
            return this;
        }
        public Builder content(String content){
            this.content=content;
            return this;
        }
        public Builder mimeType(String mimeType){
            this.mimeType=mimeType;
            return this;
        }
        public Builder cc(LinkedList<String>cc){
            this.cc=cc;
            return this;
        }
        public Builder bcc(LinkedList<String>bcc){
            this.bcc=bcc;
            return this;
        }
        public EmailMessage build(){
            return new EmailMessage(this);
        }

    }
    public void send(String _password) {
        final String username=from;
        final String password=_password;

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session=Session.getInstance(props,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for(String receiver: to){
                message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(receiver));
            }
            message.setSubject(subject);
            message.setText(content);
            if(cc!=null) {
                InternetAddress[] ccAddress = new InternetAddress[cc.size()];
                for (InternetAddress cc : ccAddress) {
                    message.addRecipient(Message.RecipientType.CC, cc);

                }
            }
            if(bcc!=null) {
                InternetAddress[] bccAddress = new InternetAddress[bcc.size()];
                for (InternetAddress bcc : bccAddress) {
                    message.addRecipient(Message.RecipientType.BCC, bcc);
                }
            }

            Transport.send(message);

            System.out.printf("Wyslano wiadmosc :D ");

        }catch (MessagingException ex){
            System.out.println(ex.getMessage());
        }

    }
}

