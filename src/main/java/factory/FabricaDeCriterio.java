package factory;

class FabricaDeCriterio {
    private final ParametrosDeBusca parametros;

    FabricaDeCriterio(ParametrosDeBusca parametros) {
        this.parametros = parametros;
    }

    CriterioDeBusca criarCriterio() {
        CriterioDeBusca criterio;
        if (parametros.getTipoDeBusca().equals(TipoDeBusca.PROMOCIONAL)) {
            criterio = new FabricaDeCriterio(parametros).criterioPromocional();
        } else if (parametros.getTipoDeBusca().equals(TipoDeBusca.POR_CATEGORIA)) {
            criterio = new FabricaDeCriterio(parametros).criterioPorCategoria();
        } else {
            criterio = new FabricaDeCriterio(parametros).criterioNormal();
        }

        return criterio;
    }

    private CriterioDeBusca criterioNormal() {
        CriterioDeBusca criterio = new CriterioDeBusca();
        criterio.setPaginacao(parametros.getResultadosPorPagina());
        criterio.setCategoria(parametros.getCategoria());
        criterio.setOrdernarPor(parametros.getOrdernarPor());
        return criterio;
    }

    private CriterioDeBusca criterioPromocional() {
        CriterioDeBusca criterio = new CriterioDeBusca();
        criterio.setPaginacao(parametros.getResultadosPorPagina());
        criterio.setCategoria(Categoria.EM_PROMOCAO);
        criterio.setOrdernarPor(OrdenarPor.RECENTE);
        return criterio;
    }

    private CriterioDeBusca criterioPorCategoria() {
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
