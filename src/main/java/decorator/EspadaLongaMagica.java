package decorator;

public class EspadaLongaMagica implements Arma {
    @Override
    public int getDano() {
        return 25;
    }

    @Override
    public int getBonusVelocidade() {
        return 2;
    }
}
