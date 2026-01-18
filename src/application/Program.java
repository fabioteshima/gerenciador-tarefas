package application;

import Servicos.ServicoDeTarefas;
import entities.ListaDeTarefas;
import entities.Tarefa;

import javax.swing.plaf.BorderUIResource;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true; // inicializa para evitar problemas

        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();

        System.out.println("***---------- GERENCIADOR DE TAREFAS ----------***\n");

        do {
            int opcao = 0;
            // validação da opção
            do {
                System.out.println("Digite a opção desejada");
                System.out.println("1 - CADASTRAR \n2 - LISTAR \n3 - FILTRAR \n4 - SAIR");
                System.out.print("Opção: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Digite apenas números 1, 2, 3 ou 4.");
                    scanner.next(); // descarta entrada inválida
                }
                opcao = scanner.nextInt();
                scanner.nextLine(); // consome o ENTER
                System.out.println();
                if(opcao < 1 || opcao > 4 ){
                    System.out.println("Entrada inválida.");
                    System.out.println();
                }
            } while (opcao < 1 || opcao > 4);

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
                    // implementar filtro
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