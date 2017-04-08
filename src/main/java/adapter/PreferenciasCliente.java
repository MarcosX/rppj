package adapter;

import java.util.List;

public class PreferenciasCliente {
    private List<String> emails;

    private String endereco;

    private List<String> telefones;

    private String cartaoPagamento;

    public PreferenciasCliente(List<String> emails, String endereco, List<String> telefones, String cartaoPagamento) {
        this.emails = emails;
        this.endereco = endereco;
        this.telefones = telefones;
        this.cartaoPagamento = cartaoPagamento;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCartaoPagamento() {
        return cartaoPagamento;
    }
}
