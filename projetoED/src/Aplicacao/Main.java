package Aplicacao;

import ArvoreBinariaBusca.ArvoreBB;
import Entidades.Aluno;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class Main {

    public static void main(String[] args) {
        programa();

    }

    public static void programa() {

        ArvoreBB<Aluno> ab = new ArvoreBB();

        Object[] menu = {"Inserir novo aluno", "Inserir notas", "Remover aluno", "Buscar aluno", "Imprimir lista", "Sair"};

        int menu2 = -1;

        do {
             menu2 = JOptionPane.showOptionDialog(null,"",
                    "Escola",JOptionPane.DEFAULT_OPTION, JOptionPane.CLOSED_OPTION, null, menu, menu[0]);

            if (menu2 == 0) {

                JTextField nome = new JTextField();
                JTextField idade = new JTextField();
                JTextField nota1 = new JTextField();
                JTextField nota2 = new JTextField();
                JTextField nota3 = new JTextField();
                JTextField nota4 = new JTextField();


                Object[] campos = {
                    "Nome do Aluno" , nome,
                    "Idade do Aluno", idade,
                    "Nota 1", nota1,
                    "Nota 2", nota2,
                    "Nota 3", nota3,
                    "Nota 4", nota4,
                };

                JOptionPane.showConfirmDialog(null, campos);

                Aluno aluno = new Aluno(nome.getText(), idade.getText(), nota1.getText(), nota2.getText(), nota3.getText(), nota4.getText());
                ab.inserir((aluno));





            } else if (menu2 == 1) {
                JOptionPane.showMessageDialog(null, ab.preOrdem());

            } else if (menu2 == 2) {


            } else if (menu2 == 3) {
                String a = JOptionPane.showInputDialog("Insira o nome do aluno que deseja buscar");

                Aluno alunoBusca = new Aluno(a);

                if (ab.buscar(alunoBusca) == true) {
                    JOptionPane.showMessageDialog(null, ab.toString());

                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não cadastrado");

                }

            } else if (menu2 == 4){


            }

        } while (menu2 != 5);

    }

}
