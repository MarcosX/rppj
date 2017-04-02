package template;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmailWorkerTest {

    @Test
    public void mandaEmailParaDestinatarios() throws Exception {
        int idUsuario = 1;
        List<String> destinatarios = Arrays.asList("email@email.com", "outro@email.com", "qualquer@email.com");
        String assunto = "Convite enviado por Usuario1";

        ServicoEmail servicoEmail = new ServicoEmail();
        EmailWorker emailWorker = new EmailWorker(servicoEmail);
        EmailEnviado email = emailWorker.enviar(idUsuario, destinatarios, Email.CONVITE);

        assertEquals(destinatarios, email.getDestinatarios());
        assertEquals(assunto, email.getAssunto());
        assertEquals(3, email.getEmailsEnviados());
    }

    @Test
    public void trataTimeouts() throws Exception {
        int idUsuario = 1;
        List<String> destinatarios = Arrays.asList("email@email.com", "outro@email.com", "qualquer@email.com");
        String assunto = "Convite enviado por Usuario1";
        String corpoEmail = "Corpo do email Convite de Usuario1";

        ServicoEmail servicoEmail = mock(ServicoEmail.class);
        when(servicoEmail.enviarEmail(assunto, corpoEmail, destinatarios)).thenThrow(new TimeoutException("Erro de test"));
        EmailWorker emailWorker = new EmailWorker(servicoEmail);
        EmailEnviado email = emailWorker.enviar(idUsuario, destinatarios, Email.CONVITE);

        assertEquals(Collections.emptyList(), email.getDestinatarios());
        assertEquals("", email.getAssunto());
        assertEquals(0, email.getEmailsEnviados());
    }

    @Test
    public void enviaEmailMesmoApos4Falhas() throws Exception {
        int idUsuario = 1;
        List<String> destinatarios = Arrays.asList("email@email.com", "outro@email.com", "qualquer@email.com");
        String assunto = "Convite enviado por Usuario1";
        String corpoEmail = "Corpo do email Convite de Usuario1";

        ServicoEmail servicoEmail = mock(ServicoEmail.class);
        EmailEnviado emailEnviado = new EmailEnviado(assunto, destinatarios);
        when(servicoEmail.enviarEmail(assunto, corpoEmail, destinatarios))
                .thenThrow(new TimeoutException("Erro de test"))
                .thenThrow(new TimeoutException("Erro de test"))
                .thenThrow(new TimeoutException("Erro de test"))
                .thenThrow(new TimeoutException("Erro de test"))
                .thenReturn(emailEnviado);
        EmailWorker emailWorker = new EmailWorker(servicoEmail);
        EmailEnviado email = emailWorker.enviar(idUsuario, destinatarios, Email.CONVITE);

        assertEquals(destinatarios, email.getDestinatarios());
        assertEquals(assunto, email.getAssunto());
        assertEquals(3, email.getEmailsEnviados());
    }
}