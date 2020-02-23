package org.emygdio.CalculadoraHoras;

import java.time.Duration;
import java.util.ArrayList;

public class CalculadoraHoras {
    public static Duration soma(ArrayList<Duration> asList) {

        Duration primeiroHorario = asList.remove(0);

        return asList.stream()
                .reduce(primeiroHorario, Duration::plus);
    }
}
