package Jogo.Peca;

import Jogo.Tabuleiro.Tabuleiro;

import java.util.ArrayList;

/*
* Esquema de coloração de peças:
* False (0): Brancas
* True (1): Pretas
* */
public class Peca {
    private boolean cor;
    private int linha,coluna;
    private boolean dama;
    private int frente;


    public Peca(boolean cor, int linha, int coluna){
        this.coluna=coluna;
        this.linha=linha;
        this.cor=cor;
        this.frente = this.cor ? -1 : 1;
    }

    @Override
    public String toString(){return this.cor ? "P" : "B";}

    public boolean getCor() {
        return cor;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean posicaoValida(int linha, int coluna){
        return ((linha%2) == (coluna%2));
    }

    public void setLinha(int linha){this.linha=linha;}

    public void setColuna(int coluna){this.coluna=coluna;}

    public boolean isDama() {
        return dama;
    }

    public void setDama(boolean dama) {
        this.dama = dama;
    }

    public int getFrente() {
        return frente;
    }
}
