package template;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailWorker {

    private static Logger logger = Logger.getLogger(EmailWorker.class.getName());

    private ServicoEmail servicoEmail;
    private int limiteTentativas;

    public EmailWorker(ServicoEmail servicoEmail) {
        this.servicoEmail = servicoEmail;
        limiteTentativas = 5;
    }

    public EmailEnviado enviar(int idUsuario, List<String> destinatarios, Email tipoEmail) {
        Usuario usuario = buscarUsuario(idUsuario);
        String corpoEmail = gerarCorpoEmail(tipoEmail, usuario);
        String assunto = gerarAssunto(tipoEmail, usuario);
        EmailEnviado emailEnviado = new EmailEnviado("", Collections.emptyList());

        int contadorTentativas = 0;
        while (contadorTentativas < limiteTentativas) {
            try {
                emailEnviado = servicoEmail.enviarEmail(assunto, corpoEmail, destinatarios);
                contadorTentativas = limiteTentativas;
            } catch (TimeoutException e) {
                logger.log(Level.SEVERE, e.getMessage());
                contadorTentativas++;
            }
        }
        return emailEnviado;
    }

    private String gerarAssunto(Email tipoEmail, Usuario usuario) {
        // implementação não importa
        return String.format("%s enviado por %s", tipoEmail, usuario);
    }

    private String gerarCorpoEmail(Email tipoEmail, Usuario usuario) {
        // implementação não importa
        return String.format("Corpo do email %s de %s", tipoEmail, usuario);
    }

    private Usuario buscarUsuario(int idUsuario) {
        // implementação não importa
        return new Usuario(idUsuario);
    }
}
