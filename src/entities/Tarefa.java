package entities;

import enums.StatusTarefa;

import java.time.LocalDate;

public class Tarefa {

    private String titulo;
    private String descricao;
    private LocalDate deadline;
    private StatusTarefa status;

    public Tarefa(String titulo, String descricao, LocalDate deadline) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.deadline = deadline;
        this.status = StatusTarefa.PENDENTE;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa statusTarefa) {
        this.status = statusTarefa;
    }

//    @Override
//    public String toString() {
//        return "TÍTULO: "+ titulo
//                + ", DESCRIÇÃO: " + descricao
//                + ", DEADLINE: " + deadline
//                + ", STATUS: " + status;
//    }
}
