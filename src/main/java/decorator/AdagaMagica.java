package decorator;

public class AdagaMagica implements Arma {
    @Override
    public int getDano() {
        return 15;
    }

    @Override
    public int getBonusVelocidade() {
        return 7;
    }
}
