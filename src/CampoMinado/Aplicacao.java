package CampoMinado;

import CampoMinado.Modelo.Tabuleiro;
import CampoMinado.Visao.TabuleiroConsole;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        new TabuleiroConsole(tabuleiro);

    }
}
