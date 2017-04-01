package strategy;

public class DadosDeLogin {
    private String usuario;
    private Autenticacao metodo;

    public DadosDeLogin(String usuario, Autenticacao metodo) {
        this.usuario = usuario;
        this.metodo = metodo;
    }

    public String getUsuario() {
        return usuario;
    }

    public Autenticacao getMetodo() {
        return metodo;
    }
}
