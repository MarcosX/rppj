package adapter;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private String idUniversal;

    private ClienteSoap clienteSoap;

    public Cliente(String idUniversal, ClienteSoap clienteSoap) {
        this.idUniversal = idUniversal;
        this.clienteSoap = clienteSoap;
    }

    public String getPreferencias() {
        String emailsXml = clienteSoap.obterPreferenciasEmail(idUniversal);
        List<String> emails = emailsXml == null ? Collections.emptyList() : Arrays.asList(emailsXml.split(","));

        String cartao = clienteSoap.obterPreferenciasCartao(idUniversal);
        cartao = cartao == null ? "" : cartao;

        String telefonesXml = clienteSoap.obterPreferenciasTelefone(idUniversal);
        List<String> telefones = telefonesXml == null ? Collections.emptyList() : Arrays.asList(telefonesXml.split(","));

        String endereco = clienteSoap.obterPreferenciasEndereco(idUniversal);
        endereco = endereco == null ? "" : endereco;

        PreferenciasCliente preferenciasCliente = new PreferenciasCliente(emails, endereco, telefones, cartao);
        return new Gson().toJson(preferenciasCliente);
    }
}
