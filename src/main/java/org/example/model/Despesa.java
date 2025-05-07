//CRIADO E COMENTADO POR MATHEUS DE OLIVEIRA MEDEIROS
package org.example.model;

import java.time.LocalDate;

    //Criar uma classe Despesa com os seguintes atributos: id, descrição, data, valor e categoria

public class Despesa {
    private long id;
    private String descricao;
    private LocalDate data;
    private Double valor;
    private Categoria categoria;

    //construtor

    public Despesa(long id, String descricao, LocalDate data, Double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
