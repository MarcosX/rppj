package mediator;

public class Produto {
    private final String nomeProduto;

    public Produto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return nomeProduto.equals(produto.nomeProduto);
    }

    @Override
    public int hashCode() {
        return nomeProduto.hashCode();
    }
}
