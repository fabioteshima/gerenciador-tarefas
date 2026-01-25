package entities;

import enums.StatusTarefa;

import java.time.LocalDate;

public class Tarefa {

    private static int numeradorId;

    private int id;
    private String titulo;
    private String descricao;
    private LocalDate dataLimite;
    private StatusTarefa status;

    public Tarefa(String titulo, String descricao, LocalDate dataLimite) {
        this.id = ++numeradorId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.status = StatusTarefa.PENDENTE;
    }

    public int getId(){
        return id;
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

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa statusTarefa) {
        this.status = statusTarefa;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", TÍTULO: "+ titulo
                + ", DESCRIÇÃO: " + descricao
                + ", DEADLINE: " + dataLimite
                + ", STATUS: " + status;
    }
}
