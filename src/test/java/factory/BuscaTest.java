package factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BuscaTest {

    @Test
    public void criaCriterioDeBuscaPadrao() throws Exception {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RELEVANCIA);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }
}