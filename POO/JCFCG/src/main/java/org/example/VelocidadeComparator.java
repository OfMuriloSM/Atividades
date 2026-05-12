package org.example;

import java.util.Comparator;

public class VelocidadeComparator implements Comparator<DispositivoRede> {

    @Override
    public int compare(DispositivoRede d1, DispositivoRede d2) {
        return Integer.compare(d2.getVelocidadeMbps(), d1.getVelocidadeMbps());
    }
}