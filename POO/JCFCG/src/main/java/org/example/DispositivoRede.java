package org.example;

import java.util.Objects;

public class DispositivoRede implements Comparable<DispositivoRede> {

    private String ip;
    private String nome;
    private int velocidadeMbps;

    public DispositivoRede(String ip, String nome, int velocidadeMbps) {
        this.ip = ip;
        this.nome = nome;
        this.velocidadeMbps = velocidadeMbps;
    }

    public String getIp() {
        return ip;
    }

    public String getNome() {
        return nome;
    }

    public int getVelocidadeMbps() {
        return velocidadeMbps;
    }

    @Override
    public int compareTo(DispositivoRede outro) {
        return this.ip.compareTo(outro.ip);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        DispositivoRede outro = (DispositivoRede) obj;
        return Objects.equals(this.ip, outro.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    @Override
    public String toString() {
        return "IP: " + ip +
                " | Nome: " + nome +
                " | Velocidade: " + velocidadeMbps + " Mbps";
    }
}