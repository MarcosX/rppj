package state;

public class MariaFlorDeGelo implements Estado {
    @Override
    public Estado pegarFlorDeGelo() {
        return this;
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
        return new MariaFlorDeFogo();
    }

    @Override
    public EstadoMaria getEstado() {
        return EstadoMaria.FLOR_DE_GELO;
    }
}
