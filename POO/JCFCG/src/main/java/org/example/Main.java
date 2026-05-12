package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        DispositivoRede d1 = new DispositivoRede("192.168.0.10", "Roteador Principal", 1000);
        DispositivoRede d2 = new DispositivoRede("192.168.0.20", "Switch Datacenter", 10000);
        DispositivoRede d3 = new DispositivoRede("192.168.0.30", "Servidor Web", 2500);

        DispositivoRede d4 = new DispositivoRede("192.168.0.10", "Roteador Backup", 500);

        HashSet<DispositivoRede> conjunto = new HashSet<>();

        conjunto.add(d1);
        conjunto.add(d2);
        conjunto.add(d3);
        conjunto.add(d4);

        System.out.println("Tamanho do HashSet: " + conjunto.size());
        System.out.println("A duplicata foi barrada porque dois dispositivos possuem o mesmo IP.");
        System.out.println();

        ArrayList<DispositivoRede> lista = new ArrayList<>();

        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);

        Collections.sort(lista);

        System.out.println("Lista ordenada pela ordem natural, ou seja, pelo IP:");
        for (DispositivoRede dispositivo : lista) {
            System.out.println(dispositivo);
        }

        System.out.println();

        Collections.sort(lista, new VelocidadeComparator());

        System.out.println("Lista ordenada por velocidade, do mais rápido para o mais lento:");
        for (DispositivoRede dispositivo : lista) {
            System.out.println(dispositivo);
        }
    }
}