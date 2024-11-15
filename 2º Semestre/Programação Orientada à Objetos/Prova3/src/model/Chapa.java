/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author eduar
 */
public class Chapa {
    private String nome;
    private String presidente;
    private String cursoPresidente;
    private String vicePresidente;
    private String cursoVicePresidente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getCursoPresidente() {
        return cursoPresidente;
    }

    public void setCursoPresidente(String cursoPresidente) {
        this.cursoPresidente = cursoPresidente;
    }

    public String getVicePresidente() {
        return vicePresidente;
    }

    public void setVicePresidente(String vicePresidente) {
        this.vicePresidente = vicePresidente;
    }

    public String getCursoVicePresidente() {
        return cursoVicePresidente;
    }

    public void setCursoVicePresidente(String cursoVicePresidente) {
        this.cursoVicePresidente = cursoVicePresidente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.presidente);
        hash = 89 * hash + Objects.hashCode(this.cursoPresidente);
        hash = 89 * hash + Objects.hashCode(this.vicePresidente);
        hash = 89 * hash + Objects.hashCode(this.cursoVicePresidente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chapa other = (Chapa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.presidente, other.presidente)) {
            return false;
        }
        if (!Objects.equals(this.cursoPresidente, other.cursoPresidente)) {
            return false;
        }
        if (!Objects.equals(this.vicePresidente, other.vicePresidente)) {
            return false;
        }
        return Objects.equals(this.cursoVicePresidente, other.cursoVicePresidente);
    }
}
