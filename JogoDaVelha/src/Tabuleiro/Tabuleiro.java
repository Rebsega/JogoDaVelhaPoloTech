package Tabuleiro;

import Jogador.Jogador;

import java.util.Scanner;

public class Tabuleiro extends Jogador {

    private final String[][] matrizTabuleiro = new String[3][3];
    Scanner scanner = new Scanner(System.in);
    Jogador jogador1;
    Jogador jogador2;
    Jogador jogadorAtual;
    int linha;
    int coluna;
    public Tabuleiro() {
        super();
        jogador1 = new Jogador();
        jogador2 = new Jogador();
        jogadorAtual = new Jogador();
        jogador1.setSimbolo("X");
        jogadorAtual.setSimbolo("X");
        jogador2.setSimbolo("O");
        linha=0;
        coluna=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizTabuleiro[i][j] = "";
            }

        }
    }

    public void printaTabuleiro(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!matrizTabuleiro[i][j].equals("")) {
                    System.out.print(matrizTabuleiro[i][j]);
                }
                else{
                    System.out.print("_");
                }
                if(j<2){
                    System.out.print("|");
                }

            }
            System.out.println("");
        }
        System.out.println("==================================================");
        System.out.println("Jogada do jogador:" +this.jogadorAtual.getSimbolo());
        System.out.println("Digite a linha:");
        linha = scanner.nextInt();
        while(linha<0 || linha>2){
            System.out.println("Linha inválida. Digite novamente:");
            linha = scanner.nextInt();
        }
        System.out.println("Digite a coluna:");
        coluna = scanner.nextInt();
        while(coluna<0 || coluna>2){
            System.out.println("Coluna inválida. Digite novamente:");
            coluna = scanner.nextInt();
        }
        jogada(linha,coluna,jogadorAtual);
        validaFimJogo();
    }

    public boolean validaFimJogo(){
        if(matrizTabuleiro[0][0].equals(matrizTabuleiro[0][1]) && matrizTabuleiro[0][1].equals(matrizTabuleiro[0][2]) && !matrizTabuleiro[0][0].equals("")){
            System.out.println("Jogador "+jogadorAtual.getSimbolo()+" venceu!");
            return true;
        }
        else if(matrizTabuleiro[1][0].equals(matrizTabuleiro[1][1]) && matrizTabuleiro[1][1].equals(matrizTabuleiro[1][2]) && !matrizTabuleiro[1][0].equals("")){
            System.out.println("Jogador "+jogadorAtual.getSimbolo()+" venceu!");
            return true;
        }
        else if(matrizTabuleiro[2][0].equals(matrizTabuleiro[2][1]) && matrizTabuleiro[2][1].equals(matrizTabuleiro[2][2]) && !matrizTabuleiro[2][0].equals("")){
            System.out.println("Jogador "+jogadorAtual.getSimbolo()+" venceu!");
            return true;
        }
        else if(matrizTabuleiro[0][0].equals(matrizTabuleiro[1][0]) && matrizTabuleiro[1][0].equals(matrizTabuleiro[2][0]) && !matrizTabuleiro[0][0].equals("")){
            System.out.println("Jogador "+jogadorAtual.getSimbolo()+" venceu!");
            return true;
        }
        else if(matrizTabuleiro[0][1].equals(matrizTabuleiro[1][1]) && matrizTabuleiro[1][1].equals(matrizTabuleiro[2][1]) && !matrizTabuleiro[0][1].equals("")){
            System.out.println("Jogador "+jogadorAtual.getSimbolo()+" venceu!");
            return true;
        }
        return false;
        //else if(matrizTabuleiro[0][2].equals(matrizTabuleiro[1][2]) && matrizTabuleiro[1][2].equals(matrizTabuleiro[2][2]) && !matrizTabuleiro[0][2].equals(""))
    }

    public void setPosicao(int linha, int coluna) {
        this.matrizTabuleiro[linha][coluna] = jogadorAtual.getSimbolo();
    }

    public String getPosicao(int linha, int coluna) {
        return this.matrizTabuleiro[linha][coluna];
    }

    public void jogada(int linha, int coluna, Jogador jogadorAtual){
        if(matrizTabuleiro[linha][coluna].equals("")) {
            this.setPosicao(linha, coluna);
            if (this.jogadorAtual.getSimbolo().equals("X")) {
                this.jogadorAtual = jogador2;
            } else {
                this.jogadorAtual = jogador1;
            }
        }else{
            System.out.println("Jogada inválida");
        }
    }
}
