package template;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class ServicoEmail {
    public EmailEnviado enviarEmail(String assunto, String corpoEmail, List<String> destinatarios) throws TimeoutException {
        // implementação não importa
        return new EmailEnviado(assunto, destinatarios);
    }
}
