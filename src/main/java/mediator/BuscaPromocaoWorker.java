package mediator;

import java.util.List;
import java.util.stream.Collectors;

public class BuscaPromocaoWorker {

    private NotificadorMediator notificador;

    public BuscaPromocaoWorker(NotificadorMediator notificador) {
        this.notificador = notificador;
    }

    public void executar(Usuario usuario, List<Produto> produtosPromocionais) {
        List<Produto> produtosDeInteresse = usuario.getProdutosDeInteresse();

        List<Produto> produtos = produtosDeInteresse.stream()
                .filter(produtosPromocionais::contains)
                .collect(Collectors.toList());

        notificador.produtosEmPromocao(usuario, produtos);
        atualizarNotificacaoDeUsuario();
    }

    private void atualizarNotificacaoDeUsuario() { }
}
