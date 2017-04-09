package adapter;

import com.google.gson.Gson;

public class Cliente {

    private String idUniversal;

    private AdaptadorSoap adaptadorSoap;

    public Cliente(String idUniversal, AdaptadorSoap adaptadorSoap) {
        this.idUniversal = idUniversal;
        this.adaptadorSoap = adaptadorSoap;
    }

    public String getPreferencias() {
        PreferenciasCliente preferenciasCliente = adaptadorSoap.getPreferenciasCliente(idUniversal);
        return new Gson().toJson(preferenciasCliente);
    }
}
