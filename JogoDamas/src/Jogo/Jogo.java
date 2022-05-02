package Jogo;

import Jogo.Tabuleiro.Tabuleiro;

public class Jogo {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador j1 = new Jogador(false, tabuleiro);
        Jogador j2 = new Jogador(true, tabuleiro);
        System.out.println(tabuleiro.toString());
        System.out.println("\n---------- Movimentos Possiveis J1\n");
/*
        for (String s : j1.movimentosPossiveis()){
            System.out.println("  * "+s);
        }
*/
    }
}
