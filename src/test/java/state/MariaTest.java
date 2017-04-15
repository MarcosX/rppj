package state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MariaTest {

    @Test
    public void mariaPequenaPegaFlorDeGelo() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeGelo();
        assertEquals(EstadoMaria.FLOR_DE_GELO, maria.getEstadoAtual());
    }

    @Test
    public void mariaPequenaPegaFlorDeFogo() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeFogo();
        assertEquals(EstadoMaria.FLOR_DE_FOGO, maria.getEstadoAtual());
    }

    @Test
    public void mariaPequenaPegaEstrela() throws Exception {
        Maria maria = new Maria();
        maria.pegarEstrela();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaPequenaLevaDano() throws Exception {
        Maria maria = new Maria();
        maria.levarDano();
        assertEquals(EstadoMaria.MORTA, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeGeloPegaFlorDeGelo() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeGelo();
        maria.pegarFlorDeGelo();
        assertEquals(EstadoMaria.FLOR_DE_GELO, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeGeloPegaFlorDeFogo() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeGelo();
        maria.pegarFlorDeFogo();
        assertEquals(EstadoMaria.FLOR_DE_FOGO, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeGeloPegaEstrela() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeGelo();
        maria.pegarEstrela();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeGeloLevaDano() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeGelo();
        maria.levarDano();
        assertEquals(EstadoMaria.PEQUENA, maria.getEstadoAtual());
    }

    @Test
    public void mariaEstrelaPegaFlorDeGelo() throws Exception {
        Maria maria = new Maria();
        maria.pegarEstrela();
        maria.pegarFlorDeGelo();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaEstrelaPegaFlorDeFogo() throws Exception {
        Maria maria = new Maria();
        maria.pegarEstrela();
        maria.pegarFlorDeFogo();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaEstrelaPegaEstrela() throws Exception {
        Maria maria = new Maria();
        maria.pegarEstrela();
        maria.pegarEstrela();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaEstrelaLevaDano() throws Exception {
        Maria maria = new Maria();
        maria.pegarEstrela();
        maria.levarDano();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeFogoPegaFlorDeGelo() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeFogo();
        maria.pegarFlorDeGelo();
        assertEquals(EstadoMaria.FLOR_DE_GELO, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeFogoPegaFlorDeFogo() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeFogo();
        maria.pegarFlorDeFogo();
        assertEquals(EstadoMaria.FLOR_DE_FOGO, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeFogoPegaEstrela() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeFogo();
        maria.pegarEstrela();
        assertEquals(EstadoMaria.ESTRELA, maria.getEstadoAtual());
    }

    @Test
    public void mariaFlorDeFogoLevaDano() throws Exception {
        Maria maria = new Maria();
        maria.pegarFlorDeFogo();
        maria.levarDano();
        assertEquals(EstadoMaria.PEQUENA, maria.getEstadoAtual());
    }
}