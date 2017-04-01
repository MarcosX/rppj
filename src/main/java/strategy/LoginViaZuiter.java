package strategy;

public class LoginViaZuiter {

    static int ZUITER_SUCESSO = 202;
    static int ZUITER_PENDENTE = 400;

    private ServicoZuiterLogin servicoZuiter;

    public LoginViaZuiter(ServicoZuiterLogin servicoZuiter) {
        this.servicoZuiter = servicoZuiter;
    }

    public RespostaLogin autenticar(String idUsuario) {
        int resposta = servicoZuiter.autenticar(idUsuario);
        String mensagem = "não foi possível autenticar";
        boolean status = false;

        if (resposta == ZUITER_SUCESSO) {
            status = true;
            mensagem = "login com sucesso";
        } else if (resposta == ZUITER_PENDENTE) {
            mensagem = "acesso pendente";
        }

        return new RespostaLogin(mensagem, status);
    }
}
