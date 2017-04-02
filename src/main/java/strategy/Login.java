package strategy;

public class Login {

    private LoginViaFaceNote loginViaFaceNote;
    private LoginViaZuiter loginViaZuiter;

    public Login(LoginViaFaceNote loginViaFaceNote, LoginViaZuiter loginViaZuiter) {
        this.loginViaFaceNote = loginViaFaceNote;
        this.loginViaZuiter = loginViaZuiter;
    }

    public RespostaLogin com(DadosDeLogin dadosDeLogin) {
        String mensagem = "método de autenticação não especificado";
        boolean status = false;
        RespostaLogin respostaLogin = new RespostaLogin(mensagem, status);

        if (dadosDeLogin.getMetodo().equals(Autenticacao.VIA_FACENOTE)) {
            respostaLogin = loginViaFaceNote.autenticar(dadosDeLogin.getUsuario());
        } else if (dadosDeLogin.getMetodo().equals(Autenticacao.VIA_ZUITER)) {
            respostaLogin = loginViaZuiter.autenticar(dadosDeLogin.getUsuario());
        }
        return respostaLogin;
    }
}
