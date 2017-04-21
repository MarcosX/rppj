package decorator;

public class EspadaLonga implements Arma {
    @Override
    public int getDano() {
        return 20;
    }

    @Override
    public int getBonusVelocidade() {
        return -2;
    }
}
