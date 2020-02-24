package org.emygdio.CalculadoraHoras;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculadoraChronus {

    public static Duration somaDuracaoTempo(ArrayList<Duration> tempos) {

        Duration primeiroHorario = tempos.remove(0);

        return tempos.stream()
                .reduce(primeiroHorario, Duration::plus);
    }

    public static Duration somaDuracaoDeUmaRepresentacaoDeCaracteres(ArrayList<String> tempos) {

        ArrayList<Duration> tempoDuration = (ArrayList<Duration>) tempos.stream()

                .map(CalculadoraChronus::getMatcherParaRepresentacaoTempo)
                .filter(Matcher::find)
                .map(CalculadoraChronus::transformaRepresentacaoPorcaoTempoParaDuration)
                .collect(Collectors.toList());

        return somaDuracaoTempo(tempoDuration);
    }


    public static LocalTime subtraiHoraDeUmaDuracao(LocalTime horaDoDia, Duration duracaoTempo) {
        return horaDoDia.minus(duracaoTempo);
    }

    public static Duration subtraiPorcoesTempo(Duration tempo1, Duration tempo2) {
        if (tempo1.compareTo(tempo2) < 0) {
            return tempo2.minus(tempo1);
        }
        return tempo1.minus(tempo2);
    }

    private static Duration transformaRepresentacaoPorcaoTempoParaDuration(Matcher matcher) {
        StringBuilder pardraDuration = new StringBuilder("PT");

        if (matcher.group(1) != null) {
            pardraDuration.append(String.format("%sH", matcher.group(1).replace(":", "")));
        }
        if (matcher.group(2) != null) {
            pardraDuration.append(String.format("%sM", matcher.group(2).replace(":", "")));
        }
        if (matcher.group(3) != null) {
            pardraDuration.append(String.format("%sS", matcher.group(3).replace(":", "")));
        }

        return Duration.parse(pardraDuration.toString());
    }

    private static Matcher getMatcherParaRepresentacaoTempo(String tempo) {
        Pattern padraoTempo = Pattern.compile("(^[0-9]{1,2}:)([0-9]{1,2}:)([0-9]{1,2})");
        return padraoTempo.matcher(tempo);
    }
}
