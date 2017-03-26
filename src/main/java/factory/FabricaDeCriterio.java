package factory;

public class FabricaDeCriterio {
    private final ParametrosDeBusca parametros;

    public FabricaDeCriterio(ParametrosDeBusca parametros) {
        this.parametros = parametros;
    }

    public CriterioDeBusca criterioNormal() {
        CriterioDeBusca criterio = new CriterioDeBusca();
        criterio.setPaginacao(parametros.getResultadosPorPagina());
        criterio.setCategoria(parametros.getCategoria());
        criterio.setOrdernarPor(parametros.getOrdernarPor());
        return criterio;
    }

    public CriterioDeBusca criterioPromocional() {
        CriterioDeBusca criterio = new CriterioDeBusca();
        criterio.setPaginacao(parametros.getResultadosPorPagina());
        criterio.setCategoria(Categoria.EM_PROMOCAO);
        criterio.setOrdernarPor(OrdenarPor.RECENTE);
        return criterio;
    }

    public CriterioDeBusca criterioPorCategoria() {
        if (parametros.getCategoria().equals(Categoria.TUDO)) {
            return criterioNormal();
        }
        CriterioDeBusca criterio = new CriterioDeBusca();
        criterio.setPaginacao(parametros.getResultadosPorPagina());
        criterio.setCategoria(parametros.getCategoria());
        if (parametros.getOrdernarPor().equals(OrdenarPor.NAO_ESPECIFICADO)) {
            criterio.setOrdernarPor(OrdenarPor.RECENTE);
        } else {
            criterio.setOrdernarPor(parametros.getOrdernarPor());
        }
        return criterio;
    }
}
