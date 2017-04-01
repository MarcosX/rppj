package strategy;

public class Login {
    static int METODO_INVALIDO = 0;
    static int FACE_NOTE_SUCESSO = 200;
    static int FACE_NOTE_REVOCADO = 403;
    static int FACE_NOTE_BLOQUEADO = 408;

    static int ZUITER_SUCESSO = 202;
    static int ZUITER_PENDENTE = 400;

    private ServicoFaceNoteLogin servicoFaceNote;
    private ServicoZuiterLogin servicoZuiter;

    public Login(ServicoFaceNoteLogin servicoFaceNote, ServicoZuiterLogin servicoZuiter) {
        this.servicoFaceNote = servicoFaceNote;
        this.servicoZuiter = servicoZuiter;
    }

    public RespostaLogin com(DadosDeLogin dadosDeLogin) {
        int resposta = METODO_INVALIDO;
        if (dadosDeLogin.getMetodo().equals(Autenticacao.VIA_FACENOTE)) {
            resposta = servicoFaceNote.autenticar(dadosDeLogin.getUsuario());
        } else if (dadosDeLogin.getMetodo().equals(Autenticacao.VIA_ZUITER)) {
            resposta = servicoZuiter.autenticar(dadosDeLogin.getUsuario());
        }

        String mensagem = "não foi possível autenticar";
        boolean status = false;

        if (resposta == FACE_NOTE_SUCESSO || resposta == ZUITER_SUCESSO) {
            status = true;
            mensagem = "login com sucesso";
        } else if (resposta == FACE_NOTE_REVOCADO) {
            mensagem = "acesso revocado";
        } else if (resposta == FACE_NOTE_BLOQUEADO) {
            mensagem = "acesso bloqueado";
        } else if (resposta == ZUITER_PENDENTE) {
            mensagem = "acesso pendente";
        }

        return new RespostaLogin(mensagem, status);
    }
}
