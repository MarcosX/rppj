package strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTest {
    @Test
    public void autenticaViaFaceNote() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = mock(ServicoFaceNoteLogin.class);
        ServicoZuiterLogin servicoZuiter = mock(ServicoZuiterLogin.class);
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        when(servicoFaceNote.autenticar(usuario)).thenReturn(Login.FACE_NOTE_SUCESSO);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(true, respostaLogin.getStatus());
        assertEquals("login com sucesso", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaFaceNoteFalhaComAcessoRevocado() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = mock(ServicoFaceNoteLogin.class);
        ServicoZuiterLogin servicoZuiter = mock(ServicoZuiterLogin.class);
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        when(servicoFaceNote.autenticar(usuario)).thenReturn(Login.FACE_NOTE_REVOCADO);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso revocado", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaFaceNoteFalhaComAcessoBloqueado() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = mock(ServicoFaceNoteLogin.class);
        ServicoZuiterLogin servicoZuiter = mock(ServicoZuiterLogin.class);
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);

        when(servicoFaceNote.autenticar(usuario)).thenReturn(Login.FACE_NOTE_BLOQUEADO);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso bloqueado", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaZuiter() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = mock(ServicoFaceNoteLogin.class);
        ServicoZuiterLogin servicoZuiter = mock(ServicoZuiterLogin.class);
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_ZUITER);

        when(servicoZuiter.autenticar(usuario)).thenReturn(Login.ZUITER_SUCESSO);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(true, respostaLogin.getStatus());
        assertEquals("login com sucesso", respostaLogin.getMessage());
    }

    @Test
    public void autenticaViaZuiterFalhaComAcessoPendente() throws Exception {
        ServicoFaceNoteLogin servicoFaceNote = mock(ServicoFaceNoteLogin.class);
        ServicoZuiterLogin servicoZuiter = mock(ServicoZuiterLogin.class);
        Login login = new Login(servicoFaceNote, servicoZuiter);

        String usuario = "Gil";
        DadosDeLogin dados = new DadosDeLogin(usuario, Autenticacao.VIA_ZUITER);

        when(servicoZuiter.autenticar(usuario)).thenReturn(Login.ZUITER_PENDENTE);

        RespostaLogin respostaLogin = login.com(dados);

        assertEquals(false, respostaLogin.getStatus());
        assertEquals("acesso pendente", respostaLogin.getMessage());
    }
}