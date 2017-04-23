package decorator;

public class ArmaMagica implements Arma {

    private Arma arma;

    public ArmaMagica(Arma arma) {
        this.arma = arma;
    }

    @Override
    public int getDano() {
        return arma.getDano() + 5;
    }

    @Override
    public int getBonusVelocidade() {
        return arma.getBonusVelocidade() + 4;
    }
}
