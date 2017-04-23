package decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonagemTest {

    @Test
    public void equiparAdagaAumentaForcaDeAtaqueEm10() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new Adaga());

        assertEquals(15, personagem.getForcaDeAtaque());
    }

    @Test
    public void equiparAdagaAumentaVelocidadeEm3() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new Adaga());

        assertEquals(13, personagem.getVelocidade());
    }

    @Test
    public void equiparAdagaMagicaAumentaForcaDeAtaqueEm15() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new ArmaMagica(new Adaga()));

        assertEquals(20, personagem.getForcaDeAtaque());
    }

    @Test
    public void equiparAdagaMagicaAumentaVelocidadeEm7() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new ArmaMagica(new Adaga()));

        assertEquals(17, personagem.getVelocidade());
    }

    @Test
    public void equiparEspadaLongaAumentaForcaDeAtaqueEm20() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new EspadaLonga());

        assertEquals(25, personagem.getForcaDeAtaque());
    }

    @Test
    public void equiparEspadaLongaReduzirVelocidadeEm2() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new EspadaLonga());

        assertEquals(8, personagem.getVelocidade());
    }

    @Test
    public void equiparEspadaLongaMagicaAumentaForcaDeAtaqueEm25() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new ArmaMagica(new EspadaLonga()));

        assertEquals(30, personagem.getForcaDeAtaque());
    }

    @Test
    public void equiparEspadaLongaMagicaAumentaVelocidadeEm2() throws Exception {
        Personagem personagem = new Personagem(5, 10);
        personagem.equiparArma(new ArmaMagica(new EspadaLonga()));

        assertEquals(12, personagem.getVelocidade());
    }
}