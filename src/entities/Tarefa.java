package entities;

import java.time.LocalDate;

public class Tarefa {

    private String titulo;
    private String descricao;
    private LocalDate deadline;
    private Status status;

    public Tarefa(String titulo, String descricao, LocalDate deadline) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.deadline = deadline;
        this.status = Status.PENDENTE;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "entities.Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", deadline=" + deadline +
                ", status=" + status +
                '}';
    }
}
