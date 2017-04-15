package state;

public class MariaFlorDeFogo implements Estado {
    @Override
    public Estado pegarFlorDeGelo() {
        return new MariaFlorDeGelo();
    }

    @Override
    public Estado pegarEstrela() {
        return new MariaEstrela();
    }

    @Override
    public Estado levarDano() {
        return new MariaPequena();
    }

    @Override
    public Estado pegarFlorDeFogo() {
        return this;
    }

    @Override
    public EstadoMaria getEstado() {
        return EstadoMaria.FLOR_DE_FOGO;
    }
}
