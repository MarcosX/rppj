package factory;

import java.util.List;

public class Busca {

    private ServicoDeBusca servicoDeBusca;

    public Busca(ServicoDeBusca servicoDeBusca) {
        this.servicoDeBusca = servicoDeBusca;
    }

    public void por(ParametrosDeBusca parametros) {
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();
        List<String> idsDeResultado = servicoDeBusca.realizarBuscaCom(criterio);
        encontrarProdutosPorIds(idsDeResultado);
    }

    private void encontrarProdutosPorIds(List<String> idsDeResultado) {
        // Implementação não importa
    }
}
