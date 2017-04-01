package strategy;

public class LoginViaFaceNote {

    static int FACE_NOTE_SUCESSO = 200;
    static int FACE_NOTE_REVOCADO = 403;
    static int FACE_NOTE_BLOQUEADO = 408;

    private ServicoFaceNoteLogin servicoFaceNote;

    public LoginViaFaceNote(ServicoFaceNoteLogin servicoFaceNote) {
        this.servicoFaceNote = servicoFaceNote;
    }

    public RespostaLogin autenticar(String idUsuario) {
        int resposta = servicoFaceNote.autenticar(idUsuario);
        String mensagem = "não foi possível autenticar";
        boolean status = false;

        if (resposta == FACE_NOTE_SUCESSO) {
            status = true;
            mensagem = "login com sucesso";
        } else if (resposta == FACE_NOTE_REVOCADO) {
            mensagem = "acesso revocado";
        } else if (resposta == FACE_NOTE_BLOQUEADO) {
            mensagem = "acesso bloqueado";
        }

        return new RespostaLogin(mensagem, status);
    }
}
