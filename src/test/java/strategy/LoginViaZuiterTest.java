package strategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginViaZuiterTest {
    @Test
    public void autenticaViaZuiter() throws Exception {
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        LoginViaZuiter login = new LoginViaZuiter(servicoZuiter);

        String usuario = "Gil";

        RespostaLogin respostaLogin = login.autenticar(usuario);

        assertEquals(true, respostaLogin.getStatus());
        assertEquals("login com sucesso", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaZuiterFalhaComAcessoPendente() throws Exception {
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        LoginViaZuiter login = new LoginViaZuiter(servicoZuiter);

        String usuario = "Ana";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_ZUITER);

        RespostaLogin respostaLogin = login.autenticar(usuario);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso pendente", respostaLogin.getMessage());
    }
}