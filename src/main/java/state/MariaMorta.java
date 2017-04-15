package state;

public class MariaMorta implements Estado {
    @Override
    public Estado pegarFlorDeGelo() {
        return this;
    }

    @Override
    public Estado pegarEstrela() {
        return this;
    }

    @Override
    public Estado levarDano() {
        return this;
    }

    @Override
    public Estado pegarFlorDeFogo() {
        return this;
    }

    @Override
    public EstadoMaria getEstado() {
        return EstadoMaria.MORTA;
    }
}
