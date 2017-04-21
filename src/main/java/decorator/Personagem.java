package decorator;

public class Personagem {

    private final int danoBase;
    private final int velocidade;
    private Arma armaEquipada;

    public Personagem(int danoBase, int velocidade) {
        this.danoBase = danoBase;
        this.velocidade = velocidade;
    }

    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
    }

    public int getForcaDeAtaque() {
        return danoBase + armaEquipada.getDano();
    }

    public int getVelocidade() {
        return velocidade + armaEquipada.getBonusVelocidade();
    }
}
