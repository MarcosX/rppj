package builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CarroTest {

    @Test
    public void validaAnoModeloNaoPodeSerAnteriorAoAnoFabicacao() throws Exception {
        int anoFabricacao = 2000;
        int anoModelo = 1999;

        Carro carroInvalido = new Carro("modelo a", "fabricante a", anoFabricacao, "abc1234", null, 0l, anoModelo, 0l, 0l);

        String mensagemDeErro = "ano do modelo nao pode ser anterior ao ano de fabricacao";
        assertFalse(carroInvalido.validar());
        assertEquals(1, carroInvalido.getErros().size());
        assertEquals(mensagemDeErro, carroInvalido.getErros().get(0));
    }

    @Test
    public void validaPlacaExiste() throws Exception {
        CarroValidoBuilder builder = new CarroValidoBuilder().comPlaca(null);

        Carro carroInvalido = builder.build();

        String mensagemDeErro = "placa nao pode ser nulo";
        assertFalse(carroInvalido.validar());
        assertEquals(1, carroInvalido.getErros().size());
        assertEquals(mensagemDeErro, carroInvalido.getErros().get(0));
    }

    @Test
    public void validaModeloExiste() throws Exception {
        Carro carroInvalido = new Carro(null, "fabricante a", 2000, "ABC1234", null, 0l, 2000, 0l, 0l);

        String mensagemDeErro = "modelo nao pode ser nulo";
        assertFalse(carroInvalido.validar());
        assertEquals(1, carroInvalido.getErros().size());
        assertEquals(mensagemDeErro, carroInvalido.getErros().get(0));
    }

    @Test
    public void validaFabricanteExiste() throws Exception {
        Carro carroInvalido = new Carro("modelo a", null, 2000, "ABC1234", null, 0l, 2000, 0l, 0l);

        String mensagemDeErro = "fabricante nao pode ser nulo";
        assertFalse(carroInvalido.validar());
        assertEquals(1, carroInvalido.getErros().size());
        assertEquals(mensagemDeErro, carroInvalido.getErros().get(0));
    }
}