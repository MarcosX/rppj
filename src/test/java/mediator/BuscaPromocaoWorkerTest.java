package mediator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BuscaPromocaoWorkerTest {

    @Test
    public void deveNotificarUsuarioProdutosEmPromocao() throws Exception {
        List<Produto> produtos = Arrays.asList(
                new Produto("Super Maria Sisters"), new Produto("USB Controller"));
        Usuario usuario = new Usuario();
        usuario.setProdutosDeInteresse(produtos);

        NotificadorCliente notificadorCliente = mock(NotificadorCliente.class);
        NotificadorFornecedor notificadorFornecedor = mock(NotificadorFornecedor.class);
        BuscaPromocaoWorker worker = new BuscaPromocaoWorker(notificadorCliente, notificadorFornecedor);
        worker.executar(usuario, produtos);

        verify(notificadorCliente).produtosEmPromocao(usuario, produtos);
        verify(notificadorFornecedor).produtosEmPromocao(produtos);
    }

    @Test
    public void deveNotificarApenasProdutosEmPromocao() throws Exception {
        List<Produto> produtosDeInteresse = Arrays.asList(
                new Produto("Super Maria Sisters"), new Produto("USB Controller"));
        Usuario usuario = new Usuario();
        usuario.setProdutosDeInteresse(produtosDeInteresse);

        NotificadorCliente notificadorCliente = mock(NotificadorCliente.class);
        NotificadorFornecedor notificadorFornecedor = mock(NotificadorFornecedor.class);
        BuscaPromocaoWorker worker = new BuscaPromocaoWorker(notificadorCliente, notificadorFornecedor);
        List<Produto> produtosEmPromoção = Arrays.asList(
                new Produto("Super Maria Sisters"), new Produto("Gamer Keyboard"));
        worker.executar(usuario, produtosEmPromoção);

        List<Produto> produtosNotificados = Arrays.asList(new Produto("Super Maria Sisters"));
        verify(notificadorCliente).produtosEmPromocao(usuario, produtosNotificados);
        verify(notificadorFornecedor).produtosEmPromocao(produtosNotificados);
    }
}