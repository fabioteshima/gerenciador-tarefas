package Servicos;

import entities.ListaDeTarefas;
import entities.Tarefa;
import enums.StatusTarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Scanner;

public class ServicoDeTarefas {

    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Tarefa Cadastrar(Scanner scanner){
        String titulo;
        String descricao;
        String entradaDataLimite;
        LocalDate dataLimite;

        while (true) {
            System.out.print("Título: ");
            titulo = scanner.nextLine().trim();
            if (titulo.isBlank() || titulo.length() < 5) {
                System.out.println("Título inválido! O Título dever possuir pelo menos 5 caracteres.");
            } else {
                break; // sai do loop quando o título for válido
            }
        }
        while (true) {
            System.out.print("Descrição:  ");
            descricao = scanner.nextLine().trim();
            if (descricao.isBlank() || descricao.length() < 6) {
                System.out.println("Descrição inválida! A Descrição dever possuir pelo menos 5 caracteres.");
            } else {
                break; // sai do loop quando o título for válido
            }
        }
        while(true){
            System.out.print("Data limite (DD/MM/AAAA): ");
            entradaDataLimite = scanner.nextLine().trim();
            // verifica se só tem números e barras
            if (!entradaDataLimite.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Formato inválido! Use apenas números no padrão DD/MM/AAAA.");
                continue;
            }
            // tenta converter para LocalDate
            try {
                dataLimite = LocalDate.parse(entradaDataLimite, dtf);
                if(dataLimite.isBefore(LocalDate.now())){
                    System.out.println("Data inválida! A Data Limite deve ser posterior à data atual.");
                    continue;
                }
                break; // sai do loop quando a data for válida
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Essa data não existe.");
            }
        }
        System.out.println("Tarefa cadastrada com sucesso!");
        return new Tarefa(titulo, descricao, dataLimite);
    }

    public static void Listar(ListaDeTarefas listaDeTarefas){
        listaDeTarefas.getListaDeTarefas().stream()
                .sorted(Comparator.comparing(t -> t.getDataLimite()))
                .forEach(t -> {
                    System.out.print("Data limite: " + t.getDataLimite().format(dtf));
                    System.out.print(", Título: " + t.getTitulo());
                    System.out.print(", Descrição: " + t.getDescricao());
                    System.out.println(", Status: " + t.getStatus());
                });
    }

    public static void Filtrar( ListaDeTarefas listaDeTarefas, Scanner scanner) {
        int opcao = 0;
        boolean validado = false;
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

        StatusTarefa status = StatusTarefa.ConverteOpcaoParaStatus(opcao);

        if(opcao != 4){
            System.out.println();
            System.out.println("RESULTADO:");
            boolean resultado = listaDeTarefas.getListaDeTarefas().stream()
                    .anyMatch(tarefa -> tarefa.getStatus().equals(status));
            if (!resultado) {
                System.out.println("Nenhuma ocorrência encontrada.");
            } else {
                listaDeTarefas.getListaDeTarefas().stream()
                        .filter(tarefa -> tarefa.getStatus().equals(status))
                        .sorted(Comparator.comparing(t -> t.getDataLimite()))
                        .forEach(tarefa -> {
                            System.out.print("Status: " + tarefa.getStatus());
                            System.out.print(", Título: " + tarefa.getTitulo());
                            System.out.print(", Descrição: " + tarefa.getDescricao());
                            System.out.println(", Data limite: " + tarefa.getDataLimite().format(dtf));
                        });
            }
        }
    }

}
