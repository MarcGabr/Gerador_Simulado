package Logica;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EnviarMail {

    /*
	 *Servidor SMTP do GMAIL e a porta usada por ele configurados automaticamente
     */
    private static String servidorMailSmtp = "smtp.gmail.com";
    private static String portaSMTPMail = "587";
    private static String usuario = "gjjmproducoesoficial@gmail.com";
    private static String senha = "gjjm123456";
    private static Session session;
    private static Properties props;

    /*
	 * Caso queira mudar o servidor e a porta
     */
    public static void mudarServidor(String servidorMailSmtpMuda, String portaSMTPMailMuda) {
        servidorMailSmtp = servidorMailSmtpMuda;
        portaSMTPMail = portaSMTPMailMuda;
    }

    private static void initialize() {
        props = new Properties();
        props.setProperty("mail.smtp. quit wait", "false");
        props.put("mail.transport.protocol", "smtp"); //Protocolo de envio como SMTP
        props.put("mail.smtp.ssl.trust", servidorMailSmtp);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", servidorMailSmtp);
        props.put("mail.smtp.port", portaSMTPMail);
        session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, senha);
            }
        });
    }

    public static boolean sendMail(String[] to, String assunto, String file) {
        initialize();
        Message msg = new MimeMessage(session);
        session.setDebug(true);
        try {
            InternetAddress[] emails = new InternetAddress[to.length];
            int i = 0;
            for (String toAddr : to) {
                emails[i] = new InternetAddress(toAddr);
                i++;
            }
            //Setando o destinatário
            msg.setRecipients(Message.RecipientType.TO, emails);
            //Setando a origem do email
            msg.setFrom(new InternetAddress(usuario));
            //Setando o assunto
            msg.setSubject(assunto);
            //Setando o conteúdo/corpo do email
            MimeBodyPart mbp = new MimeBodyPart();
            DataSource fds = new FileDataSource(file);
            mbp.setDisposition(Part.ATTACHMENT);
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(fds.getName());
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);
            msg.setContent(mp);
        } catch (MessagingException e) {
            return false;
        }
        //Utilizados para enviar os dados para o email
        Transport enviarDados;
        try {
            enviarDados = session.getTransport("smtp");
            enviarDados.connect(servidorMailSmtp, usuario, senha);
            msg.saveChanges();
            enviarDados.sendMessage(msg, msg.getAllRecipients());
            enviarDados.close();
        } catch (MessagingException e) {
            return false;
        }
        return true;
    }
}
