package Aplicacao;

import ArvoreBinariaBusca.ArvoreBB;
import ArvoreBinariaBusca.No;
import Entidades.Aluno;
import vizualizacao.InterfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class Main {

    public static void main(String[] args) {

        ArvoreBB<Aluno> ab = new ArvoreBB<>();

        int menu2;

        do {

            menu2 = InterfaceGrafica.telaPrincipal();

            switch (menu2) {
                case 0:
                    ab.inserir(InterfaceGrafica.cadastrarAluno());
                    break;
                case 1:
                    InterfaceGrafica.removerAluno(ab);
                    break;
                case 2:
                    InterfaceGrafica.buscarAluno(ab);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, ab.inOrdem());
                    break;
            }

        } while (menu2 != 4 && menu2 != -1);

    }
}