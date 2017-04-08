package template;

import java.util.Collections;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailWorker extends TemplateWorker{

    private static Logger logger = Logger.getLogger(EmailWorker.class.getName());

    private ServicoEmail servicoEmail;
    private int limiteTentativas;
    private int contadorTentativas;

    public EmailWorker(ServicoEmail servicoEmail) {
        this.servicoEmail = servicoEmail;
    }

    @Override
    protected <T> T trabalhar(Object parametros) throws TimeoutException {
        EnviarEmail enviarEmail = (EnviarEmail) parametros;
        Usuario usuario = buscarUsuario(enviarEmail.getIdUsuario());
        String corpoEmail = gerarCorpoEmail(enviarEmail.getTipoEmail(), usuario);
        String assunto = gerarAssunto(enviarEmail.getTipoEmail(), usuario);
        EmailEnviado emailEnviado = servicoEmail.enviarEmail(assunto, corpoEmail, enviarEmail.getDestinatarios());
        contadorTentativas = limiteTentativas;
        return (T) emailEnviado;
    }

    @Override
    protected <T> T valorPadraoDeRetorno() {
        return (T) new EmailEnviado("", Collections.emptyList());
    }

    @Override
    protected void trataExcecao(TimeoutException e) {
        logger.log(Level.SEVERE, e.getMessage());
        contadorTentativas++;
    }

    @Override
    protected boolean deveContinuarTentando() {
        return limiteTentativas > contadorTentativas;
    }

    @Override
    protected void antesExecucao(Object parametros) {
        limiteTentativas = 5;
        contadorTentativas = 0;
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
