package pl.edu.agh.student.danielkurosz.Email;

import java.util.LinkedList;

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    //Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null)
    protected EmailMessage( String from,
                         LinkedList<String> to,
                         String subject,
                         String content,
                         String mimeType,
                         LinkedList<String> cc,
                         LinkedList<String> bcc){
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
        public EmailMessage build(){
            return new EmailMessage(this);
        }
    }
}

