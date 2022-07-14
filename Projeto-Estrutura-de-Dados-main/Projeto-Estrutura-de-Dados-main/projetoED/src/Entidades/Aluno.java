package Entidades;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {

    public Aluno() {

    }

    private String nome;
    private String idade;
    private String nota1;
    private String nota2;
    private String nota3;
    private String nota4;

    public Aluno(String nome) {
        this.nome = nome;
        this.idade = null;
        this.nota1 = null;
        this.nota2 = null;
        this.nota3 = null;
        this.nota4 = null;
    }

    public Aluno(String nome, String idade, String nota1, String nota2, String nota3, String nota4) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }

    public String getNota3() {
        return nota3;
    }

    public void setNota3(String nota3) {
        this.nota3 = nota3;
    }

    public String getNota4() {
        return nota4;
    }

    public void setNota4(String nota4) {
        this.nota4 = nota4;
    }

    @Override
    public String toString() {
        return "Nome do Aluno: " + getNome()+
                ", Idade: " + getIdade()+
                ", Nota 1: " + getNota1()+
                ", Nota 2: " + getNota2()+
                ", Nota 3: " + getNota3()+
                ", Nota 4 : " + getNota4() + "\n";
    }

    @Override
    public int compareTo(Aluno o) {
        return this.nome.compareTo(o.nome);
    }

    @Override
    public boolean equals(Object o) {
        return this.nome.equals(((Aluno) o).nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, nota1, nota2, nota3, nota4);
    }
}
