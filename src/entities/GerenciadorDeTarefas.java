package entities;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    private List< Tarefa> listaDeTarefas;

    public GerenciadorDeTarefas() {
        this.listaDeTarefas = new ArrayList<>();
    }

    public List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }

    public void adicionarTarefa(Tarefa tarefa){
        this.listaDeTarefas.add(tarefa);
    }

    @Override
    public String toString() {
        return "GerenciadorDeTarefas{" +
                "listaDeTarefas=" + listaDeTarefas +
                '}';
    }
}
