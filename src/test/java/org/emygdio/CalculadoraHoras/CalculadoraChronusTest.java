package org.emygdio.CalculadoraHoras;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CalculadoraChronusTest {

    @Test
    public void devera_somar_horas_informadas() {

        Duration hora1 = Duration.parse("PT28M");
        Duration hora2 = Duration.parse("PT36M");

        Duration resultadoEsperado = Duration.parse("PT1H4M");
        Duration resultado = CalculadoraChronus.somaDuracaoTempo(new ArrayList(Arrays.asList(hora1, hora2)));


        assertThat(resultado.compareTo(resultadoEsperado), is(equalTo(0)));
    }

    @Test
    public void devera_somar_a_partir_de_uma_colecao_horas_representadas_por_strings() {
        String tempo1 = "00:27:00";
        String tempo2 = "00:28:36";

        Duration retornoEsperado = Duration.parse("PT55M36S");
        Duration ressultado = CalculadoraChronus.somaDuracaoDeUmaRepresentacaoDeCaracteres(new ArrayList<String>(Arrays.asList(tempo1, tempo2)));
        assertThat(ressultado.compareTo(retornoEsperado), is(equalTo(0)));
    }

    @Test
    public void devera_receber_um_hora_do_dia_e_subtrair_de_uma_duracao_de_tempo() {
        LocalTime horaDoDia = LocalTime.of(17, 43);
        Duration duracaoTempo = Duration.parse("PT1H32M");

        LocalTime horaEsperadaDoDia = LocalTime.of(16, 11);
        LocalTime horaRetornada = CalculadoraChronus.subtraiHoraDeUmaDuracao(horaDoDia, duracaoTempo);

        assertThat(horaRetornada.compareTo(horaEsperadaDoDia), is(equalTo(0)));
    }

    @Test
    public void devera_subtrair_duracoes_de_tempo() {

        Duration tempo1 = Duration.of(8, ChronoUnit.HOURS);
        Duration tempo2 = Duration.parse("PT9H32M");

        Duration retornoEsperado = Duration.parse("PT1H32M");
        Duration retorno = CalculadoraChronus.subtraiPorcoesTempo(tempo1, tempo2);

        assertThat(retorno.compareTo(retornoEsperado), is(equalTo(0)));
    }

}