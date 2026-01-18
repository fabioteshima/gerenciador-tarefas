package Servicos;

import entities.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ServicoDeTarefas {

    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Tarefa Cadastrar(Scanner scanner){
        System.out.print("Título: ");
        var titulo = scanner.nextLine();
        System.out.print("Descrição:  ");
        var descricao = scanner.nextLine();
        System.out.print("Data limite: ");
        var dataLimite = LocalDate.parse(scanner.nextLine(), dtf);
        System.out.println("Tarefa cadastrada");
        return new Tarefa(titulo, descricao, dataLimite);
    }

}
