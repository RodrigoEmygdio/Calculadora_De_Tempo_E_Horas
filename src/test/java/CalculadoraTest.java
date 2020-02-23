import org.emygdio.CalculadoraHoras.CalculadoraHoras;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculadoraTest {
    @Test
    public void devera_somar_horas_informadas(){

        Duration hora1 = Duration.parse("PT28M");
        Duration hora2 = Duration.parse("PT36M");

        Duration resultadoEsperado = Duration.parse("PT1H4M");
        Duration resultado = CalculadoraHoras.soma(new ArrayList(Arrays.asList(hora1, hora2)));


       assertThat(resultado.compareTo(resultadoEsperado),is(equalTo(0)));
    }
}
