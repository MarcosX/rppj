package state;

public class MariaPequena implements Estado {
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
        return new MariaMorta();
    }

    @Override
    public Estado pegarFlorDeFogo() {
        return new MariaFlorDeFogo();
    }

    @Override
    public EstadoMaria getEstado() {
        return EstadoMaria.PEQUENA;
    }
}
