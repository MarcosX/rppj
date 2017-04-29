package mediator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotificadorMediatorTest {

    @Test
    public void notificaProdutosEmPromocao() throws Exception {
        List<Produto> produtos = Arrays.asList(
                new Produto("Super Maria Sisters"), new Produto("USB Controller"));
        Usuario usuario = new Usuario();
        usuario.setProdutosDeInteresse(produtos);

        NotificadorCliente notificadorCliente = mock(NotificadorCliente.class);
        NotificadorFornecedor notificadorFornecedor = mock(NotificadorFornecedor.class);
        NotificadorMediator mediator = new NotificadorMediator(notificadorCliente, notificadorFornecedor);

        mediator.produtosEmPromocao(usuario, produtos);

        verify(notificadorCliente).produtosEmPromocao(usuario, produtos);
        verify(notificadorFornecedor).produtosEmPromocao(produtos);
    }
}