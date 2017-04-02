package template;

import java.util.List;

public class EmailEnviado {

    private List<String> destinatarios;
    private String assunto;

    public EmailEnviado(String assunto, List<String> destinatarios) {
        this.assunto = assunto;
        this.destinatarios = destinatarios;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public String getAssunto() {
        return assunto;
    }

    public int getEmailsEnviados() {
        return destinatarios.size();
    }
}
