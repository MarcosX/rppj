package adapter;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClienteTest {

    @Test
    public void retornaPreferenciasDoCliente() throws Exception {
        String idUniversal = "FG123";
        String email = "cliente@cliente.com";
        String telefone = "+1234567890";
        String endereco = "Rua ABC n 123, Cidade, Estado";
        String cartao = "1234 5678";

        ClienteSoap clienteSoap = mock(ClienteSoap.class);
        when(clienteSoap.obterPreferenciasEmail(idUniversal)).thenReturn(email);
        when(clienteSoap.obterPreferenciasTelefone(idUniversal)).thenReturn(telefone);
        when(clienteSoap.obterPreferenciasEndereco(idUniversal)).thenReturn(endereco);
        when(clienteSoap.obterPreferenciasCartao(idUniversal)).thenReturn(cartao);
        AdaptadorSoap adaptadorSoap = new AdaptadorSoap(clienteSoap);

        Cliente cliente = new Cliente(idUniversal, adaptadorSoap);
        String preferenciasJson = cliente.getPreferencias();
        PreferenciasCliente preferencias = new Gson().fromJson(preferenciasJson, PreferenciasCliente.class);

        assertEquals(telefone, preferencias.getTelefones().get(0));
        assertEquals(email, preferencias.getEmails().get(0));
        assertEquals(cartao, preferencias.getCartaoPagamento());
        assertEquals(endereco, preferencias.getEndereco());
    }
}