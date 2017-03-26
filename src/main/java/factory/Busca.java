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
            // Busca promocional ignora parametros de busca
            criterio.setCategoria(Categoria.EM_PROMOCAO);
            criterio.setOrdernarPor(OrdenarPor.RECENTE);
        } else if (parametros.getTipoDeBusca().equals(TipoDeBusca.POR_CATEGORIA)) {
            criterio.setCategoria(parametros.getCategoria());
            if (parametros.getCategoria().equals(Categoria.TUDO)) {
                // Se categoria não for especificada, volta para busca normal
                criterio.setOrdernarPor(OrdenarPor.RELEVANCIA);
            } else {
                // Se tiver categoria, ordena por mais recente
                if (parametros.getOrdernarPor().equals(OrdenarPor.NAO_ESPECIFICADO)) {
                    criterio.setOrdernarPor(OrdenarPor.RECENTE);
                } else {
                    // Se ordenação for especificada, mantém
                    criterio.setOrdernarPor(parametros.getOrdernarPor());
                }
            }
        } else { //Busca normal
            criterio.setOrdernarPor(parametros.getOrdernarPor());
        }

        return criterio;
    }

    private void encontrarProdutosPorIds(List<String> idsDeResultado) {
        // Implementação não importa
    }
}
