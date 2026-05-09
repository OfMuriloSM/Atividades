package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/")
    public String inicio() {
        return "Aplicação Spring Boot funcionando!";
    }

    @GetMapping("/aluno")
    public String aluno() {
        return "Aluno: Murilo Soares Maciel";
    }

    @GetMapping("/curso")
    public String curso() {
        return "Curso: Análise e Desenvolvimento de Sistemas";
    }

    @GetMapping("/mensagem")
    public String mensagem() {
        return "Este é meu primeiro projeto usando Spring Boot.";
    }

    @GetMapping("/saudacao")
    public String saudacao(@RequestParam(value = "nome", defaultValue = "visitante") String nome) {
        return "Bem-vindo, " + nome + "! Projeto executado com sucesso.";
    }
}