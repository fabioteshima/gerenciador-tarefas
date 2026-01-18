package Servicos;

import entities.ListaDeTarefas;
import entities.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        System.out.println("Tarefa cadastrada com sucesso!");
        return new Tarefa(titulo, descricao, dataLimite);
    }

    public static void Listar(ListaDeTarefas listaDeTarefas){
         listaDeTarefas.getListaDeTarefas().forEach(System.out::println);
    }

}
