package strategy;

public class ServicoZuiterLoginFake extends ServicoZuiterLogin {
    public int autenticar(String idUsuario) {
        if (idUsuario.equals("Gil")) {
            return 202;
        }
        return 400;
    }
}
