package strategy;

public class Login {

    private LoginViaFaceNote loginViaFaceNote;
    private LoginViaZuiter loginViaZuiter;

    public Login(LoginViaFaceNote loginViaFaceNote, LoginViaZuiter loginViaZuiter) {
        this.loginViaFaceNote = loginViaFaceNote;
        this.loginViaZuiter = loginViaZuiter;
    }

    public RespostaLogin com(DadosDeLogin dadosDeLogin) {
        if (dadosDeLogin.getMetodo().equals(Autenticacao.VIA_FACENOTE)) {
            return loginViaFaceNote.autenticar(dadosDeLogin.getUsuario());
        } else if (dadosDeLogin.getMetodo().equals(Autenticacao.VIA_ZUITER)) {
            return loginViaZuiter.autenticar(dadosDeLogin.getUsuario());
        }

        String mensagem = "método de autenticação não especificado";
        boolean status = false;

        return new RespostaLogin(mensagem, status);
    }
}
