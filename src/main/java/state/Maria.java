package state;

public class Maria {

    private EstadoMaria estadoAtual;

    public Maria() {
        this.estadoAtual = EstadoMaria.PEQUENA;
    }

    public void pegarFlorDeGelo() {
        if (estadoAtual.equals(EstadoMaria.ESTRELA)) {
            return;
        }
        estadoAtual = EstadoMaria.FLOR_DE_GELO;
    }

    public void pegarEstrela() {
        estadoAtual = EstadoMaria.ESTRELA;
    }

    public void levarDano() {
        if (estadoAtual.equals(EstadoMaria.ESTRELA)) {
            return;
        }
        if (estadoAtual.equals(EstadoMaria.PEQUENA)) {
            estadoAtual = EstadoMaria.MORTA;
        } else {
            estadoAtual = EstadoMaria.PEQUENA;
        }
    }

    public EstadoMaria getEstadoAtual() {
        return estadoAtual;
    }
}
