package br.com.springproject.entities;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable, Comparable<Cliente> {

    private static final long serialVersionUID = -6473902029327085888L;

    private Integer idCliente;
    private String nome;
    private String email;

    public Cliente() {
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
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (idCliente == null) {
            if (other.idCliente != null)
                return false;
        } else if (!idCliente.equals(other.idCliente))
            return false;
        return true;
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.idCliente.compareTo(cliente.getIdCliente());
    }
}
