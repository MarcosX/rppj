package mediator;

import java.util.List;

public class NotificadorMediator {
    private NotificadorCliente notificadorCliente;
    private NotificadorFornecedor notificadorFornecedor;

    public NotificadorMediator(NotificadorCliente notificadorCliente, NotificadorFornecedor notificadorFornecedor) {
        this.notificadorCliente = notificadorCliente;
        this.notificadorFornecedor = notificadorFornecedor;
    }

    public void produtosEmPromocao(Usuario usuario, List<Produto> produtos) {
        notificadorCliente.produtosEmPromocao(usuario, produtos);
        notificadorFornecedor.produtosEmPromocao(produtos);
    }
}
