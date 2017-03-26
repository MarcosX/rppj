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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriterioDeBusca that = (CriterioDeBusca) o;

        if (paginacao != that.paginacao) return false;
        if (categoria != that.categoria) return false;
        return ordernarPor == that.ordernarPor;
    }

    @Override
    public int hashCode() {
        int result = paginacao;
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (ordernarPor != null ? ordernarPor.hashCode() : 0);
        return result;
    }
}
