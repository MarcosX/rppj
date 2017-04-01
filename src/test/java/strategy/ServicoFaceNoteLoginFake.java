package strategy;

public class ServicoFaceNoteLoginFake extends ServicoFaceNoteLogin {
    public int autenticar(String idUsuario) {
        if (idUsuario.equals("Gil")) {
            return 200;
        } else if(idUsuario.equals("Ana")) {
            return 403;
        }
        return 408;
    }
}
