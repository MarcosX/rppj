package adapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdaptadorSoap {

    private ClienteSoap clienteSoap;

    public AdaptadorSoap(ClienteSoap clienteSoap) {
        this.clienteSoap = clienteSoap;
    }

    public PreferenciasCliente getPreferenciasCliente(String idUniversal) {
        String emailsXml = clienteSoap.obterPreferenciasEmail(idUniversal);
        List<String> emails = emailsXml == null ? Collections.emptyList() : Arrays.asList(emailsXml.split(","));

        String cartao = clienteSoap.obterPreferenciasCartao(idUniversal);
        cartao = cartao == null ? "" : cartao;

        String telefonesXml = clienteSoap.obterPreferenciasTelefone(idUniversal);
        List<String> telefones = telefonesXml == null ? Collections.emptyList() : Arrays.asList(telefonesXml.split(","));

        String endereco = clienteSoap.obterPreferenciasEndereco(idUniversal);
        endereco = endereco == null ? "" : endereco;

        return new PreferenciasCliente(emails, endereco, telefones, cartao);
    }
}
