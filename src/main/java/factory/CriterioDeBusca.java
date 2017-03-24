package factory;

public class CriterioDeBusca {
    private int paginacao;
    private Categoria categoria;
    private OrdenarPor ordernarPor;

    public int getPaginacao() {
        return paginacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public OrdenarPor getOrdernarPor() {
        return ordernarPor;
    }

    public void setPaginacao(int paginacao) {
        this.paginacao = paginacao;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setOrdernarPor(OrdenarPor ordernarPor) {
        this.ordernarPor = ordernarPor;
    }
}
