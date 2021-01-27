package br.com.springproject.entities;

import java.io.Serializable;

public class Cliente implements Serializable, Comparable<Cliente> {

    private static final long serialVersionUID = -3977659307748755288L;

    private Integer idCliente;
    private String nome;
    private String email;

    public Cliente(){

    }

    public Cliente(Integer idCliente, String nome, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.idCliente.compareTo(o.getIdCliente());
    }
}
