package template;

public class Usuario {
    private final int id;

    public Usuario(int idUsuario) {
        this.id = idUsuario;
    }

    @Override
    public String toString() {
        return "Usuario" + id;
    }
}
