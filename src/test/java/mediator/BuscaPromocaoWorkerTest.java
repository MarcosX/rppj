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

        NotificadorMediator notificador = mock(NotificadorMediator.class);
        BuscaPromocaoWorker worker = new BuscaPromocaoWorker(notificador);
        worker.executar(usuario, produtos);

        verify(notificador).produtosEmPromocao(usuario, produtos);
    }

    @Test
    public void deveNotificarApenasProdutosEmPromocao() throws Exception {
        List<Produto> produtosDeInteresse = Arrays.asList(
                new Produto("Super Maria Sisters"), new Produto("USB Controller"));
        Usuario usuario = new Usuario();
        usuario.setProdutosDeInteresse(produtosDeInteresse);

        NotificadorMediator notificador = mock(NotificadorMediator.class);
        BuscaPromocaoWorker worker = new BuscaPromocaoWorker(notificador);
        List<Produto> produtosEmPromoção = Arrays.asList(
                new Produto("Super Maria Sisters"), new Produto("Gamer Keyboard"));
        worker.executar(usuario, produtosEmPromoção);

        List<Produto> produtosNotificados = Arrays.asList(new Produto("Super Maria Sisters"));
        verify(notificador).produtosEmPromocao(usuario, produtosNotificados);
    }
}