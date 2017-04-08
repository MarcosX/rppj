package strategy;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginTest {

    @Test
    public void fazLoginViaFaceNote() throws Exception {
        LoginViaFaceNote loginViaFaceNote = mock(LoginViaFaceNote.class);
        LoginViaZuiter loginViaZuiter = mock(LoginViaZuiter.class);

        Login login = new Login(loginViaFaceNote, loginViaZuiter);

        String usuario = "Paula";
        DadosDeLogin dadosDeLogin = new DadosDeLogin(usuario, Autenticacao.VIA_FACENOTE);
        login.com(dadosDeLogin);

        verify(loginViaFaceNote).autenticar(usuario);
    }

    @Test
    public void fazLoginViaZuiter() throws Exception {
        LoginViaFaceNote loginViaFaceNote = mock(LoginViaFaceNote.class);
        LoginViaZuiter loginViaZuiter = mock(LoginViaZuiter.class);

        Login login = new Login(loginViaFaceNote, loginViaZuiter);

        String usuario = "Paula";
        DadosDeLogin dadosDeLogin = new DadosDeLogin(usuario, Autenticacao.VIA_ZUITER);
        login.com(dadosDeLogin);

        verify(loginViaZuiter).autenticar(usuario);
    }
}