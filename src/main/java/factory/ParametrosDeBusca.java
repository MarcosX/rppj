package factory;

public class ParametrosDeBusca {
    private int resultadosPorPagina = 15;
    private Categoria categoria = Categoria.TUDO;
    private TipoDeBusca tipoDeBusca = TipoDeBusca.NORMAL;
    private OrdenarPor ordernarPor = OrdenarPor.RELEVANCIA;

    public int getResultadosPorPagina() {
        return resultadosPorPagina;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public TipoDeBusca getTipoDeBusca() {
        return tipoDeBusca;
    }

    public OrdenarPor getOrdernarPor() {
        return ordernarPor;
    }

    public void setResultadosPorPagina(int resultadosPorPagina) {
        this.resultadosPorPagina = resultadosPorPagina;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setTipoDeBusca(TipoDeBusca tipoDeBusca) {
        this.tipoDeBusca = tipoDeBusca;
    }

    public void setOrdernarPor(OrdenarPor ordernarPor) {
        this.ordernarPor = ordernarPor;
    }
}
