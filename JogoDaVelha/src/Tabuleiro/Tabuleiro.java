package Tabuleiro;

import Jogador.Jogador;

public class Tabuleiro extends Jogador {

    private final int[][] matrizTabuleiro = new int[3][3];
    public Tabuleiro() {
        super();
        Jogador jogador = new Jogador();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizTabuleiro[i][j] = 0;
            }
        }
    }

    public void mostraTabuleiro(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizTabuleiro[i][j] == 1) {
                    System.out.print("X" + " ");
                } else {
                    System.out.print("O" + " ");
                }
            }
            System.out.println("");
        }
    }

    public void setPosicao(int linha, int coluna, int valor, Jogador jogador) {
        this.matrizTabuleiro[linha][coluna] = valor;
        jogador.setJogada(valor);
    }

    public int getPosicao(int linha, int coluna) {
        return this.matrizTabuleiro[linha][coluna];
    }
}
