package application;
import entities.Tarefa;
import java.time.LocalDate;

public class Program {

    public static void main (String[] args){

        Tarefa tarefa = new Tarefa("Tarefa1", "FazerTarefa1", LocalDate.now());

         System.out.println(tarefa);
    }

}

