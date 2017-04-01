package strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void autenticaViaFaceNote() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(true, respostaLogin.getStatus());
        assertEquals("login com sucesso", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaFaceNoteFalhaComAcessoRevocado() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Ana";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso revocado", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaFaceNoteFalhaComAcessoBloqueado() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Celso";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso bloqueado", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaZuiter() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_ZUITER);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(true, respostaLogin.getStatus());
        assertEquals("login com sucesso", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaZuiterFalhaComAcessoPendente() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        ServicoZuiterLogin servicoZuiter = new ServicoZuiterLoginFake();
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Ana";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_ZUITER);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso pendente", respostaLogin.getMessage());
    }
}