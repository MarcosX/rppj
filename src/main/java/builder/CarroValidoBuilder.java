package builder;

public class CarroValidoBuilder {
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String placa;
    private String cor;
    private long kmRodados;
    private int anoModelo;
    private long precoMinimo;
    private long precoAnunciado;

    public CarroValidoBuilder() {
        this.modelo = "Modelo A";
        this.fabricante = "Fabricante A";
        this.anoFabricacao = 2000;
        this.anoModelo = 2001;
        this.placa = "ABC1234";
    }

    public Carro build() {
        Carro carro = new Carro(modelo, fabricante, anoFabricacao, placa, cor, kmRodados, anoModelo, precoMinimo, precoAnunciado);
        return carro;
    }

    public CarroValidoBuilder comCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CarroValidoBuilder comKmRodados(long kmRodados) {
        this.kmRodados = kmRodados;
        return this;
    }

    public CarroValidoBuilder comPlaca(String placa) {
        this.placa = placa;
        return this;
    }
}
