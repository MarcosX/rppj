package factory;

import java.util.List;

public class Busca {

    private ServicoDeBusca servicoDeBusca;

    public Busca(ServicoDeBusca servicoDeBusca) {
        this.servicoDeBusca = servicoDeBusca;
    }

    public void por(ParametrosDeBusca parametros) {
        CriterioDeBusca criterio = criarCriterio(parametros);
        List<String> idsDeResultado = servicoDeBusca.realizarBuscaCom(criterio);
        encontrarProdutosPorIds(idsDeResultado);
    }

    CriterioDeBusca criarCriterio(ParametrosDeBusca parametros) {
        CriterioDeBusca criterio = new CriterioDeBusca();
        criterio.setPaginacao(parametros.getResultadosPorPagina());
        criterio.setCategoria(parametros.getCategoria());

        if (parametros.getTipoDeBusca().equals(TipoDeBusca.PROMOCIONAL)) {

        } else if (parametros.getTipoDeBusca().equals(TipoDeBusca.POR_CATEGORIA)) {

        } else { //Busca normal
            criterio.setOrdernarPor(parametros.getOrdernarPor());
        }

        return criterio;
    }

    private void encontrarProdutosPorIds(List<String> idsDeResultado) {
        // Implementação não importa
    }
}
