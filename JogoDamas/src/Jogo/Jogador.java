package Jogo;

import Jogo.Peca.Peca;
import Jogo.Tabuleiro.Tabuleiro;

import java.util.ArrayList;

public class Jogador {
    // jogador
    private Peca[] pecas;
    private boolean cor;
    private Tabuleiro tabuleiro;

    public Jogador(boolean cor, Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        this.cor=cor;
        this.pecas = cor ? this.tabuleiro.getPecasBrancas() : this.tabuleiro.getPecasPretas();
    }

    // retorna a lista de movimentos possiveis que este jogador pode realizar
    public ArrayList<String> movimentosPossiveis(){
        ArrayList<String> movimentos = new ArrayList<>();
        for (Peca peca : this.pecas){
            for (String mov : this.tabuleiro.getMovimentos(peca)) {
                movimentos.add(mov);
            }
        }
        return movimentos;
    }

    // movimenta a peça indicada para a posição informada
    public void movimentarPeca(int peca, int linDes, int colDest){
        movimentarPeca(this.pecas[peca],linDes,colDest);
    }
    // movimenta a peça passada por parâmetro para a posição informada
    public void movimentarPeca(Peca peca, int linDes, int colDest){
        peca.setLinha(linDes);
        peca.setColuna(colDest);
    }

    public void setPecas(Peca[] pecas) {this.pecas = pecas;}
}
