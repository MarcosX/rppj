package strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginViaFaceNoteTest {
    @Test
    public void autenticaViaFaceNote() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        LoginViaFaceNote login = new LoginViaFaceNote(servicoFaceNote);

        String usuario = "Gil";

        RespostaLogin respostaLogin = login.autenticar(usuario);

        assertEquals(true, respostaLogin.getStatus());
        assertEquals("login com sucesso", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaFaceNoteFalhaComAcessoRevocado() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        LoginViaFaceNote login = new LoginViaFaceNote(servicoFaceNote);

        String usuario = "Ana";

        RespostaLogin respostaLogin = login.autenticar(usuario);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso revocado", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaFaceNoteFalhaComAcessoBloqueado() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = new ServicoFaceNoteLoginFake();
        LoginViaFaceNote login = new LoginViaFaceNote(servicoFaceNote);

        String usuario = "Celso";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        RespostaLogin respostaLogin = login.autenticar(usuario);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso bloqueado", respostaLogin.getMessage());
    }
}