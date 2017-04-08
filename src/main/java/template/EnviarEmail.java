package template;

import java.util.List;

public class EnviarEmail {
    private int idUsuario;
    private Email tipoEmail;
    private List<String> destinatarios;

    public EnviarEmail(int idUsuario, Email tipoEmail, List<String> destinatarios) {
        this.idUsuario = idUsuario;
        this.tipoEmail = tipoEmail;
        this.destinatarios = destinatarios;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Email getTipoEmail() {
        return tipoEmail;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }
}
