package application;

import Servicos.ServicoDeTarefas;
import entities.ListaDeTarefas;
import entities.Tarefa;
import enums.StatusTarefa;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();

        Tarefa tarefaTeste0 = new Tarefa("Tarefa Teste 0", "Fazer tarefa Teste 0", LocalDate.now().plusDays(1));
        tarefaTeste0.setStatus(StatusTarefa.EM_ANDAMENTO);
        listaDeTarefas.adicionarTarefa(tarefaTeste0);

        Tarefa tarefaTeste1 = new Tarefa("Tarefa Teste 1", "Fazer tarefa Teste 1", LocalDate.now().plusDays(2));
        tarefaTeste1.setStatus(StatusTarefa.PENDENTE);
        listaDeTarefas.adicionarTarefa(tarefaTeste1);

        Tarefa tarefaTeste2 = new Tarefa("Tarefa Teste 2", "Fazer tarefa Teste 2", LocalDate.now().plusDays(3));
        tarefaTeste2.setStatus(StatusTarefa.EM_ANDAMENTO);
        listaDeTarefas.adicionarTarefa(tarefaTeste2);

        Tarefa tarefaTeste3 = new Tarefa("Tarefa Teste 3", "Fazer tarefa Teste 3", LocalDate.now().plusDays(4));
        tarefaTeste3.setStatus(StatusTarefa.CONCLUIDO);
        listaDeTarefas.adicionarTarefa(tarefaTeste3);

        System.out.println("***---------- GERENCIADOR DE TAREFAS ----------***\n");

        boolean continuar = true;
        do {
            int opcao = 0;
            boolean validado = false;
            // validação da opção
            do {
                System.out.println("Digite a opção desejada");
                System.out.println("1 - CADASTRAR \n2 - LISTAR \n3 - FILTRAR \n4 - SAIR");
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
            switch (opcao) {
                case 1:
                    System.out.println("CADASTRAR TAREFA");
                    listaDeTarefas.adicionarTarefa(ServicoDeTarefas.Cadastrar(scanner));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("LISTA DE TAREFA(S)");
                    ServicoDeTarefas.Listar(listaDeTarefas);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("FILTRAR TAREFA(S)");
                    ServicoDeTarefas.Filtrar(listaDeTarefas);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("PROGRAMA ENCERRADO");
                    continuar = false; // força saída do loop
                    break;
            }
        } while (continuar);

        // imprime todas as tarefas cadastradas antes de encerrar
        for (Tarefa t : listaDeTarefas.getListaDeTarefas()) {
            System.out.println(t.toString());
        }

        scanner.close();
    }
}