package decorator;

public class Adaga implements Arma {
    @Override
    public int getDano() {
        return 10;
    }

    @Override
    public int getBonusVelocidade() {
        return 3;
    }
}
