package builder;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String placa;
    private String cor;
    private long kmRodados;
    private int anoModelo;
    private long precoMinimo;
    private long precoAnunciado;

    private List<String> erros;

    public Carro(String modelo, String fabricante, int anoFabricacao, String placa, String cor, long kmRodados, int anoModelo, long precoMinimo, long precoAnunciado) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.placa = placa;
        this.cor = cor;
        this.kmRodados = kmRodados;
        this.anoModelo = anoModelo;
        this.precoMinimo = precoMinimo;
        this.precoAnunciado = precoAnunciado;
        this.erros = new ArrayList<>();
    }

    public boolean validar() {
        if (anoFabricacao > anoModelo) {
            erros.add("ano do modelo nao pode ser anterior ao ano de fabricacao");
        }
        if (placa == null || placa.isEmpty()) {
            erros.add("placa nao pode ser nulo");
        }
        if (modelo== null || modelo.isEmpty()) {
            erros.add("modelo nao pode ser nulo");
        }
        if (fabricante== null || fabricante.isEmpty()) {
            erros.add("fabricante nao pode ser nulo");
        }
        return erros.isEmpty();
    }

    public List<String> getErros() {
        return erros;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public long getKmRodados() {
        return kmRodados;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public long getPrecoMinimo() {
        return precoMinimo;
    }

    public long getPrecoAnunciado() {
        return precoAnunciado;
    }
}
