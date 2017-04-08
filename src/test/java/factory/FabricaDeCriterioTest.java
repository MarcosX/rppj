package factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FabricaDeCriterioTest {

    @Test
    public void criaCriterioDeBuscaNormal() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.NAO_ESPECIFICADO);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }

    @Test
    public void criaCriterioDeBuscaNormalComPaginacao() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 20);
    }

    @Test
    public void criaCriterioDeBuscaNormalComOrdem() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        parametros.setOrdernarPor(OrdenarPor.RECENTE);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
    }

    @Test
    public void criaCriterioDeBuscaPromocional() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalComResultadoPorPagina() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio =  new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 20);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalOrdenadoPorMaisRecenteSempre() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setOrdernarPor(OrdenarPor.RELEVANCIA);
        CriterioDeBusca criterio =  new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalNaCategoriaEmPromocaoSempre() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setCategoria(Categoria.TUDO);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoria() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.ELETRONICOS);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoriaComResultadosPorPagina() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 20);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoriaComOrdenacao() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        parametros.setOrdernarPor(OrdenarPor.PRECO);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.PRECO);
    }

    @Test
    public void criaCriterioDeBuscaNormalQuandoCategoriaNaoEspecificada() {
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        CriterioDeBusca criterio = new FabricaDeCriterio(parametros).criarCriterio();

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.NAO_ESPECIFICADO);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }
}