
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        /**
         * colocar dentro do while - ok
         * saber a vez de cada jogador - ok
         * fazer joagada - ok
         * ver se a jogada é valida - ok
         * por posição exitente - ok
         * posição vazia - ok
         * ver se o jogo acabou - ok
         * ver se deu velha - ok
         * ver se alguem ganhou - ok
         *      ver na linhas - ok
         *      ver nas colunas - ok
         *      ver nas diagonais - ok
         * */

        /**
         *             __|__|__
         *             __|__|__
         *             __|__|__
         */

        Character[][] tab = new Character[3][3];

        Jogo jogo = new Jogo();

        Character jogadorAtual = jogo.getJogadorAtual();


        Scanner scanner = new Scanner(System.in);

        int linha = 0;
        int coluna = 0;

        int numeroJogadas = 0;

        while (numeroJogadas < 10) {

            imprimirTabuleiro(tab);
            System.out.println("O jogador da vez é:" + jogadorAtual);

            System.out.println("Digite a linha:");
            linha = scanner.nextInt();
            System.out.println("Digite a coluna:");
            coluna = scanner.nextInt();

            if (fazerJogada(tab, linha, coluna, jogadorAtual) == true) {
                if (checarLinhas(tab, jogadorAtual) == true || checarColunas(tab, jogadorAtual) == true || checarDiagonais(tab, jogadorAtual)) {
                    imprimirTabuleiro(tab);
                    System.out.printf("O jogador %c ganhou o jogo\n", jogadorAtual);
                    break;
                }
                numeroJogadas++;
                jogo.mudarJogador();
                jogadorAtual = jogo.getJogadorAtual();
                System.out.println("Numero de jogadas: " + numeroJogadas);
                if (numeroJogadas == 9) {
                    System.out.println("Tabuleiro completo.");
                    break;
                }
            } else {
                System.out.println("Jogada inválida! Jogue novamente");
            }
        }
    }


    public static void imprimirTabuleiro(Character[][] tab) {
        System.out.println();

        for (int indiceLinha = 0; indiceLinha < 3; indiceLinha++) {
            Character[] linha = tab[indiceLinha];

            for (int indiceColuna = 0; indiceColuna < 3; indiceColuna++) {
                Character elemento = tab[indiceLinha][indiceColuna];

                if (elemento == null) {
                    System.out.print("__");
                } else {
                    System.out.print(elemento);
                }

                if (indiceColuna != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }


    public static boolean fazerJogada(Character[][] tab, int linha, int coluna, Character jogadorAtual) {
        if (verificarPosicaoVazia(tab, linha, coluna) == true) {
            tab[linha][coluna] = jogadorAtual;
            return true;
        }
        return false;
    }

    public static boolean verificarPosicaoVazia(Character[][] tab, int linha, int coluna) {

        if (linha >= 0 && linha < 3) {
            if (coluna >= 0 && coluna < 3) {
                if (tab[linha][coluna] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    // opcional
//    public static boolean tabuleiroCompleto(Character[][] tab, int linha, int coluna) {
//        int posicoesCompletas = 0;
//        for (linha = 0; linha < 3; linha++) {
//            for (coluna = 0; coluna < 3; coluna++) {
//                if (tab[linha][coluna] != null) {
//                    posicoesCompletas++;
//                }
//            }
//        }
//        if (posicoesCompletas == 9) {
//            System.out.println("Tabuleiro completo. Jogo empatado");
//            return true;
//        }
//        return false;
//    }

    public static boolean checarLinhas(Character[][] tab, Character jogadorAtual) {
        int contDoSimbolo = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tab[linha][coluna] != jogadorAtual) {
                    contDoSimbolo = 0;
                    break;
                } else {
                    contDoSimbolo++;
                }
            }
            if (contDoSimbolo == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean checarColunas(Character[][] tab, Character jogadorAtual) {
        int contDoSimbolo = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tab[coluna][linha] != jogadorAtual) {
                    contDoSimbolo = 0;
                    break;
                } else {
                    contDoSimbolo++;
                }
            }
            if (contDoSimbolo == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean checarDiagonais(Character[][] tab, Character jogadorAtual) {
        if((tab[0][0] == jogadorAtual) && (tab[1][1] == jogadorAtual) && (tab[2][2] == jogadorAtual)){
            return true;
        }
        if((tab[0][2] == jogadorAtual) && (tab[1][1] == jogadorAtual) && (tab[2][0] == jogadorAtual)){
            return true;
        }
        return false;
    }
}


class Jogo {
    char jogador1 = 'X';
    char jogador2 = 'O';

    Character jogadorAtual = jogador1;

    private Teste tabuleiro;

    public Jogo(){
        tabuleiro = new Teste();
    }

    public void mudarJogador() {
        if(jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }

    public Character getJogadorAtual() {
        return jogadorAtual;
    }


}
