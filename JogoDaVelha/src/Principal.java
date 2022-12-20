import Tabuleiro.Tabuleiro;

public class Principal {
    private final static Tabuleiro tabuleiro = new Tabuleiro();
    public static void main(String[] args) {
        Jogo();
    }

    private static void Jogo(){
        while(!tabuleiro.validaFimJogo()){
            tabuleiro.printaTabuleiro();
        }
    }
}
