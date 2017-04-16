package builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarroValidoBuilderTest {

    @Test
    public void criaCarroValido() throws Exception {
        CarroValidoBuilder builder = new CarroValidoBuilder();
        Carro carroValido = builder.build();

        assertTrue(carroValido.validar());
    }

    @Test
    public void criaCarroComCorEKmRodados() throws Exception {
        CarroValidoBuilder builder = new CarroValidoBuilder().comCor("azul").comKmRodados(1234l);
        Carro carroValido = builder.build();

        assertTrue(carroValido.validar());
        assertEquals("azul", carroValido.getCor());
        assertEquals(1234l, carroValido.getKmRodados());
    }
}