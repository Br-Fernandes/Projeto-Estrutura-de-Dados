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

        Object[] menu = {"Inserir novo aluno", "Remover aluno", "Buscar aluno", "Imprimir lista", "Sair"};

        int menu2 = -1;

        do {
             menu2 = JOptionPane.showOptionDialog(null,"",
                    "Escola",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menu, menu[0]);

            if (menu2 == 0) {

                Object[] opcoesNota = {"0","1","2","3","4","5","6","7","8","9","10"};

                JTextField nome = new JTextField();
                JTextField idade = new JTextField();
                JComboBox<Object> nota1 = new JComboBox<>(opcoesNota);
                JComboBox<Object> nota2 = new JComboBox<>(opcoesNota);
                JComboBox<Object> nota3 = new JComboBox<>(opcoesNota);
                JComboBox<Object> nota4 = new JComboBox<>(opcoesNota);

                Object[] campos = {
                        "Nome do Aluno" , nome,
                        "Idade do Aluno", idade,
                        "Nota 1", nota1,
                        "Nota 2", nota2,
                        "Nota 3", nota3,
                        "Nota 4", nota4,
                };

                JOptionPane.showConfirmDialog(null, campos);

                Aluno aluno = new Aluno(nome.getText(),
                        idade.getText(),
                        (String) nota1.getSelectedItem(),
                        (String) nota2.getSelectedItem(),
                        (String) nota3.getSelectedItem(),
                        (String) nota4.getSelectedItem());
                ab.inserir2((aluno));

            } else if (menu2 == 1) {
                String nome = JOptionPane.showInputDialog("Insira o nome do aluno que deseja remover do sistema");

                Aluno alunoRemover = new Aluno(nome);

                if (ab.contem(alunoRemover)) {
                    ab.remover(alunoRemover);
                    JOptionPane.showMessageDialog(null, "Aluno removido do sistema com sucesso","Escola", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não está cadastrado para ser removido do sistema","Escola", JOptionPane.ERROR_MESSAGE);
                }

            } else if (menu2 == 2) {
                String nome = JOptionPane.showInputDialog("Insira o nome do aluno que deseja buscar");

                Aluno alunoBusca = new Aluno(nome);

                if (ab.contem(alunoBusca)) {
                    JOptionPane.showMessageDialog(null, ab.buscar(ab.getRaiz(), alunoBusca),
                            "Informações do Aluno", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não cadastrado",
                            "Escola", JOptionPane.ERROR_MESSAGE);
                }

            } else if (menu2 == 3) {
                JOptionPane.showMessageDialog(null, ab.inOrdem());

            }

        } while (menu2 != 4);

    }
}
