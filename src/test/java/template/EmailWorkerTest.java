package template;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmailWorkerTest {

    @Test
    public void mandaEmailParaDestinatarios() throws Exception {
        int idUsuario = 1;
        List<String> destinatarios = Arrays.asList("email@email.com", "outro@email.com", "qualquer@email.com");
        String assunto = "Convite enviado por Usuario1";

        EmailWorker emailWorker = new EmailWorker();
        EmailEnviado email = emailWorker.enviar(idUsuario, destinatarios, Email.CONVITE);

        assertEquals(destinatarios, email.getDestinatarios());
        assertEquals(assunto, email.getAssunto());
        assertEquals(3, email.getEmailsEnviados());
    }
}