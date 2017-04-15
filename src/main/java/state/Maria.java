package state;

public class Maria {

    private Estado estadoAtual;

    public Maria() {
        this.estadoAtual = new MariaPequena();
    }

    public void pegarFlorDeGelo() {
        estadoAtual = estadoAtual.pegarFlorDeGelo();
    }

    public void pegarEstrela() {
        estadoAtual = estadoAtual.pegarEstrela();
    }

    public void levarDano() {
        estadoAtual = estadoAtual.levarDano();
    }

    public EstadoMaria getEstadoAtual() {
        return estadoAtual.getEstado();
    }

    public void pegarFlorDeFogo() {
        estadoAtual = estadoAtual.pegarFlorDeFogo();
    }
}
