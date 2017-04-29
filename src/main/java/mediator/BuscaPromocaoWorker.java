package mediator;

import java.util.List;
import java.util.stream.Collectors;

public class BuscaPromocaoWorker {

    private NotificadorCliente notificadorCliente;
    private NotificadorFornecedor notificadorFornecedor;

    public BuscaPromocaoWorker(NotificadorCliente notificadorCliente, NotificadorFornecedor notificadorFornecedor) {
        this.notificadorCliente = notificadorCliente;
        this.notificadorFornecedor = notificadorFornecedor;
    }

    public void executar(Usuario usuario, List<Produto> produtosPromocionais) {
        List<Produto> produtosDeInteresse = usuario.getProdutosDeInteresse();

        List<Produto> produtos = produtosDeInteresse.stream()
                .filter(produtosPromocionais::contains)
                .collect(Collectors.toList());

        notificadorCliente.produtosEmPromocao(usuario, produtos);
        notificadorFornecedor.produtosEmPromocao(produtos);
        atualizarNotificacaoDeUsuario();
    }

    private void atualizarNotificacaoDeUsuario() { }
}
