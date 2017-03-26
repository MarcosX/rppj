package factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BuscaTest {

    @Test
    public void criaCriterioDeBuscaNormal() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.NAO_ESPECIFICADO);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }

    @Test
    public void criaCriterioDeBuscaNormalComPaginacao() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 20);
    }

    @Test
    public void criaCriterioDeBuscaNormalComOrdem() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.NORMAL);
        parametros.setOrdernarPor(OrdenarPor.RECENTE);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
    }

    @Test
    public void criaCriterioDeBuscaPromocional() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalComResultadoPorPagina() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 20);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalOrdenadoPorMaisRecenteSempre() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setOrdernarPor(OrdenarPor.RELEVANCIA);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
    }

    @Test
    public void criaCriterioDeBuscaPromocionalNaCategoriaEmPromocaoSempre() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.PROMOCIONAL);
        parametros.setCategoria(Categoria.TUDO);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getCategoria(), Categoria.EM_PROMOCAO);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoria() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RECENTE);
        assertEquals(criterio.getCategoria(), Categoria.ELETRONICOS);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoriaComResultadosPorPagina() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        parametros.setResultadosPorPagina(20);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 20);
    }

    @Test
    public void criaCriterioDeBuscaPorCategoriaComOrdenacao() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        parametros.setCategoria(Categoria.ELETRONICOS);
        parametros.setOrdernarPor(OrdenarPor.PRECO);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getOrdernarPor(), OrdenarPor.PRECO);
    }

    @Test
    public void criaCriterioDeBuscaNormalQuandoCategoriaNaoEspecificada() {
        ServicoDeBusca servico = new ServicoDeBusca();

        Busca busca = new Busca(servico);
        ParametrosDeBusca parametros = new ParametrosDeBusca(TipoDeBusca.POR_CATEGORIA);
        CriterioDeBusca criterio = busca.criarCriterio(parametros);

        assertEquals(criterio.getPaginacao(), 15);
        assertEquals(criterio.getOrdernarPor(), OrdenarPor.RELEVANCIA);
        assertEquals(criterio.getCategoria(), Categoria.TUDO);
    }
}