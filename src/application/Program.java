package application;
import entities.GerenciadorDeTarefas;
import entities.Tarefa;
import java.time.LocalDate;

public class Program {

    public static void main (String[] args){

        Tarefa tarefa1 = new Tarefa("Tarefa 1", "Fazer Tarefa 1", LocalDate.now());
        Tarefa tarefa2 = new Tarefa("Tarefa 2", "Fazer Tarefa 2", LocalDate.now().plusDays(1));

        GerenciadorDeTarefas gt = new GerenciadorDeTarefas();
        gt.adicionarTarefa(tarefa1);
        gt.adicionarTarefa(tarefa2);

        for(Tarefa t : gt.getListaDeTarefas()){
            System.out.println(t.toString());
        }
    }

}

