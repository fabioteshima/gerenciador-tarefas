package Servicos;

import entities.ListaDeTarefas;
import entities.Tarefa;
import enums.StatusTarefa;

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
        System.out.println("Tarefa cadastrada com sucesso!");
        return new Tarefa(titulo, descricao, dataLimite);
    }

    public static void Listar(ListaDeTarefas listaDeTarefas){
        listaDeTarefas.getListaDeTarefas()
                .forEach(t -> {
                    System.out.print("Título: " + t.getTitulo());
                    System.out.print(", Descrição: " + t.getDescricao());
                    System.out.print(", Data limite: " + t.getDeadline().format(dtf));
                    System.out.println(", Status: " + t.getStatus());
                });
    }

    public static void Filtrar( ListaDeTarefas listaDeTarefas, Scanner scanner) {
        int opcao = 0;
        boolean validado = false;
        // validação da opção
        do {
            System.out.println("1 - PENDENTE \n2 - EM_ANDAMENTO \n3 - CONCLUÍDO \n4 - VOLTAR");
            System.out.print("Opção: ");
            if(scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
                if(opcao >= 1 && opcao <= 4){
                    validado = true;
                }
                else {
                    System.out.println("Entrada inválida! Opções entre 1 e 4.\n");
                }
            }
            else {
                System.out.println("Entrada inválida. Digite apenas números.\n");
                scanner.nextLine(); // descarta entrada inválida
            }
        } while (!validado);
        System.out.println();

        StatusTarefa status = StatusTarefa.ConverteOpcaoParaStatus(opcao);

        System.out.println("RESULTADO:");
        boolean resultado = listaDeTarefas.getListaDeTarefas().stream()
                .anyMatch(tarefa -> tarefa.getStatus().equals(status));
        if (!resultado) {
            System.out.println("Nenhuma ocorrência encontrada.");
        } else {
            listaDeTarefas.getListaDeTarefas().stream()
                    .filter(tarefa -> tarefa.getStatus().equals(status))
                    .forEach(tarefa -> {
                        System.out.print("Título: " + tarefa.getTitulo());
                        System.out.print(", Descrição: " + tarefa.getDescricao());
                        System.out.print(", Data limite: " + tarefa.getDeadline().format(dtf));
                        System.out.println(", Status: " + tarefa.getStatus());
                    });
        }
    }

}
