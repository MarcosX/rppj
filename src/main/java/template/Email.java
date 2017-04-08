package template;

public enum Email {
    CONVITE("Convite");

    private String descricao;


    Email(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
