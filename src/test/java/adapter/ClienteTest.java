package adapter;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClienteTest {

    @Test
    public void retornaListaDeEmailsDoCliente() throws Exception {
        String idUniversal = "FG123";
        String emails = "cliente@cliente.com,cliente@email.com";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        when(clienteSoap.obterPreferenciasEmail(idUniversal)).thenReturn(emails);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(2, preferencias.getEmails().size());
        assertEquals("cliente@cliente.com", preferencias.getEmails().get(0));
        assertEquals("cliente@email.com", preferencias.getEmails().get(1));
    }

    @Test
    public void retornaListaVaziaQuandoClienteNaoTemEmails() throws Exception {
        String idUniversal = "FG123";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(0, preferencias.getEmails().size());
    }

    @Test
    public void retornaListaDeTelefonesDoCliente() throws Exception {
        String idUniversal = "FG123";
        String telefones = "+1234567890,+0987654321";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        when(clienteSoap.obterPreferenciasTelefone(idUniversal)).thenReturn(telefones);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(2, preferencias.getTelefones().size());
        assertEquals("+1234567890", preferencias.getTelefones().get(0));
        assertEquals("+0987654321", preferencias.getTelefones().get(1));
    }

    @Test
    public void retornaListaVaziaQuandoClienteNaoTemTelefone() throws Exception {
        String idUniversal = "FG123";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(0, preferencias.getTelefones().size());
    }

    @Test
    public void retornaEnderecoDoCliente() throws Exception {
        String idUniversal = "FG123";
        String endereco = "Rua ABC n 123, Cidade, Estado";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        when(clienteSoap.obterPreferenciasEndereco(idUniversal)).thenReturn(endereco);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(endereco, preferencias.getEndereco());
    }

    @Test
    public void retornaVazioQuandoClienteNaoTemEndereco() throws Exception {
        String idUniversal = "FG123";
        String endereco = "";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(endereco, preferencias.getEndereco());
    }


    @Test
    public void retornaCartaoPagamentoDoCliente() throws Exception {
        String idUniversal = "FG123";
        String cartao = "1234 5678";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        when(clienteSoap.obterPreferenciasCartao(idUniversal)).thenReturn(cartao);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(cartao, preferencias.getCartaoPagamento());
    }

    @Test
    public void retornaVazioQuandoClienteNaoTemCartao() throws Exception {
        String idUniversal = "FG123";
        String cartao = "";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        Cliente cliente = new Cliente(idUniversal, clienteSoap);

        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(cartao, preferencias.getCartaoPagamento());
    }
}