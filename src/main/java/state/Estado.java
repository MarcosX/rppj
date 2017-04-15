package state;

public interface Estado {

    Estado pegarFlorDeGelo();

    Estado pegarEstrela();

    Estado levarDano();

    Estado pegarFlorDeFogo();

    EstadoMaria getEstado();
}
