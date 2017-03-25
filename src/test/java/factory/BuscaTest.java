package factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BuscaTest {

    @Test
    public void criaCriterioDeBuscaNormal() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RELEVANCIA);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }

    @Test
    public void criaCriterioDeBuscaNormalComPaginacao() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 20);
    }

    @Test
    public void criaCriterioDeBuscaNormalComOrdem() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setOrdernarPor(OrdenarPor.RECENTE);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
    }

    @Test
    public void criaCriterioDeBuscaPromocional() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.PROMOCIONAL);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalComResultadoPorPagina() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 20);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalOrdenadoPorMaisRecenteSempre() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setOrdernarPor(OrdenarPor.RELEVANCIA);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalNaCategoriaEmPromocaoSempre() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setCategoria(Categoria.TUDO);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoria() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RELEVANCIA);
        assertEquals(criterio.getCategoria(), Categoria.ELETRONICOS);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoriaComResultadosPorPagina() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 20);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoriaComOrdenacao() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        parametros.setOrdernarPor(OrdenarPor.PRECO);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.PRECO);
    }

    @Test
    public void criaCriterioDeBuscaNormalQuandoCategoriaNaoEspecificada() {
        ServicoDeBusca servico = mock(ServicoDeBusca.class);

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca();
        parametros.setTipoDeBusca(TipoDeBusca.POR_CATEGORIA);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RELEVANCIA);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }
}