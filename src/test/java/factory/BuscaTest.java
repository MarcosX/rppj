package factory;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BuscaTest {

    @Test
    public void realizarBusca() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        busca.por(parametros);

        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        verify(servico).realizarBuscaCom(criterio);
    }
}