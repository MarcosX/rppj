package template;

import java.util.List;

public class EmailWorker {
    public EmailEnviado enviar(int idUsuario, List<String> destinatarios, Email tipoEmail) {
        Usuario usuario = buscarUsuario(idUsuario);
        String corpoEmail = gerarCorpoEmail(tipoEmail, usuario);
        String assunto = gerarAssunto(tipoEmail, usuario);

        return enviarEmail(assunto, corpoEmail, destinatarios);
    }

    private EmailEnviado enviarEmail(String assunto, String corpoEmail, List<String> destinatarios) {
        // implementação não importa
        return new EmailEnviado(assunto, destinatarios);
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
