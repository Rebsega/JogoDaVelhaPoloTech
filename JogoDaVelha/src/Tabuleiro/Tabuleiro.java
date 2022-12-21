package Tabuleiro;

import Jogador.Jogador;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Tabuleiro extends Jogador {

    private final String[][] matrizTabuleiro = new String[3][3];
    Scanner scanner = new Scanner(System.in);
    Boolean fimJogo = false;
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
        jogadorAtual.setSimbolo("X");
        jogador1.setSimbolo("X");
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
        if(!fimJogo) {
            movimento();
        }
    }

    public void movimento() {
        System.out.println("==================================================");
        System.out.println("Jogada do jogador:" +this.jogadorAtual.getSimbolo());
        System.out.println("Digite a linha:");
        try {
            linha = scanner.nextInt();
            while (linha < 0 || linha > 2) {
                System.err.println("Linha inválida. Digite novamente:");
                linha = scanner.nextInt();
            }
            System.out.println("Digite a coluna:");
            coluna = scanner.nextInt();
            while (coluna < 0 || coluna > 2) {
                System.err.println("Coluna inválida. Digite novamente:");
                coluna = scanner.nextInt();
            }
        }catch (InputMismatchException e){
            System.err.println("Entrada inválida. Digite novamente:");
            scanner.next();
            movimento();
        }
        jogada(linha,coluna);
    }

    public boolean validaFimJogo(){
        /*matrizTabuleiro[0][0].equals(matrizTabuleiro[0][1]) && matrizTabuleiro[0][1].equals(matrizTabuleiro[0][2]) && !matrizTabuleiro[0][0].equals("") ||
                matrizTabuleiro[1][0].equals(matrizTabuleiro[1][1]) && matrizTabuleiro[1][1].equals(matrizTabuleiro[1][2]) && !matrizTabuleiro[1][0].equals("") ||
                matrizTabuleiro[2][0].equals(matrizTabuleiro[2][1]) && matrizTabuleiro[2][1].equals(matrizTabuleiro[2][2]) && !matrizTabuleiro[2][0].equals("") ||
                matrizTabuleiro[0][0].equals(matrizTabuleiro[1][0]) && matrizTabuleiro[1][0].equals(matrizTabuleiro[2][0]) && !matrizTabuleiro[0][0].equals("") ||
                matrizTabuleiro[0][1].equals(matrizTabuleiro[1][1]) && matrizTabuleiro[1][1].equals(matrizTabuleiro[2][1]) && !matrizTabuleiro[0][1].equals("")
        {*/

        if(validaColuna() || validaLinha() || validaDiagonal()){
            System.out.println("Jogador " + jogadorAtual.getSimbolo() + " venceu!");
            fimJogo = true;
            printaTabuleiro();
            return true;
        }
        else if(validaEmpate()){
            System.out.println("Empate!");
            printaTabuleiro();
            return true;
        }
        else{
            trocaJogador();
            return false;

        }
    }

    public boolean validaEmpate(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(matrizTabuleiro[i][j].equals("")){
                    return false;
                }
            }
        }
        fimJogo=true;
        System.out.println("Deu velha!!");
        return true;
    }

    public void trocaJogador(){
        if (this.jogadorAtual.getSimbolo().equals("X")) {
            this.jogadorAtual = jogador2;
        } else {
            this.jogadorAtual = jogador1;
        }
    }

    public boolean validaColuna() {
        int i=0;
        for(int j=0;j<3;j++) {
            if ((Objects.equals(matrizTabuleiro[i][j], matrizTabuleiro[i + 1][j]) &&
                Objects.equals(matrizTabuleiro[i+1][j], matrizTabuleiro[i + 2][j])) &&
                    (!Objects.equals(matrizTabuleiro[i][j], "") && !Objects.equals(matrizTabuleiro[i+1][j], "")&& !Objects.equals(matrizTabuleiro[i+2][j], ""))
            ){
                return true;
            }
        }
        return false;
    }

    public boolean validaLinha() {
        int i=0;
        for(int j=0;j<3;j++) {
            if ((Objects.equals(matrizTabuleiro[j][i], matrizTabuleiro[j][i + 1]) &&
                Objects.equals(matrizTabuleiro[j][i + 1], matrizTabuleiro[j][i + 2])) &&
                (!Objects.equals(matrizTabuleiro[j][i], "")) && (!Objects.equals(matrizTabuleiro[j][i+1], ""))
            ){
                return true;
            }
        }
        return false;
    }

    public boolean validaDiagonal() {
        int i=0,j=0;
        if (((Objects.equals(matrizTabuleiro[0][0], matrizTabuleiro[1][1]) &&
            Objects.equals(matrizTabuleiro[1][1], matrizTabuleiro[2][2])) &&

            (!Objects.equals(matrizTabuleiro[0][0], "") &&
            !Objects.equals(matrizTabuleiro[1][1], "") &&
            !Objects.equals(matrizTabuleiro[2][2], ""))) ||

            ((Objects.equals(matrizTabuleiro[0][2], matrizTabuleiro[1][1]) &&
            Objects.equals(matrizTabuleiro[1][1], matrizTabuleiro[2][0])) &&

            (!Objects.equals(matrizTabuleiro[0][2], "") &&
            !Objects.equals(matrizTabuleiro[1][1], "") &&
            !Objects.equals(matrizTabuleiro[2][0], "")))
        ) {
            return true;
        }
        return false;
    }

    public void setPosicao(int linha, int coluna) {
        this.matrizTabuleiro[linha][coluna] = jogadorAtual.getSimbolo();
    }

    public void jogada(int linha, int coluna){
        if(matrizTabuleiro[linha][coluna].equals("")) {
            this.setPosicao(linha, coluna);
        }else{
            System.err.println("Esta posição já está ocupada. Tente novamente.");
            movimento();
        }
    }
}
