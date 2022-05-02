package Jogo.Tabuleiro;

import Jogo.Peca.Peca;

import java.util.ArrayList;

/* visão do tabuleiro
X | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
-----------------------------------
A | B |   | B |   | B |   | B |   |
B |   | B |   | B |   | B |   | B |
C | B |   | B |   | B |   | B |   |
D |   |   |   |   |   |   |   |   |
E |   |   |   |   |   |   |   |   |
F |   | P |   | P |   | P |   | P |
G | P |   | P |   | P |   | P |   |
H |   | P |   | P |   | P |   | P |
*/
public class Tabuleiro {
    private Peca[] pecasBrancas = new Peca[12];
    private Peca[] pecasPretas = new Peca[12];

    public Tabuleiro(){
        iniciarTabuleiro();
    }

    // retorna a lista de instancias de pecas brancas
    public Peca[] getPecasBrancas() {
        return pecasBrancas;
    }

    // retorna a lista de instancias de pecas pretas
    public Peca[] getPecasPretas() {
        return pecasPretas;
    }

    /*
    * Direção: Especificar se a pessa irá no sentido Direita(1) ou Esquerda(-1)
    * */
    public boolean comePeca(Peca peca, Peca[][] tabuleiro, int direcao) {
        // verifica se a direção e sentido é valido
        if (
                peca.getCor()

        ){
            return false;
        }
        // movimentação pelas extremidades do tabuleiro
        if (
                ((0 == peca.getColuna()+direcao) || (7 == peca.getColuna()+direcao)) // direção no batente

        ) {
            return false;
        } else {
            // movimentação pelo centro do tabuleiro
            // não existe peça na próxima posição a frente
            if (null == tabuleiro[peca.getLinha() + peca.getFrente()][peca.getColuna() + direcao])
                return false;
            // caso exista uma peça na posição a frente
            // seja de cor diferente
            // e após essa peça a próxima posição é vazia
            return (peca.getCor() != tabuleiro[peca.getLinha() + peca.getFrente()][peca.getColuna() + direcao].getCor()) // se for uma peca adversária
                    && (null != tabuleiro[peca.getLinha() + (peca.getFrente() * 2)][peca.getColuna() + (direcao * 2)]);
        }
    }

    // retorna a lista de movimentos possiveis de uma
    // determinada peca no tabuleiro
    public ArrayList<String> getMovimentos(Peca peca){
        // tabuleiro atual
        Peca[][] tabuleiro = getTabuleiro();
        // lista de movimentos possiveis
        ArrayList<String> movimentos = new ArrayList<>();

        // movimento obrigatorio
        // come esquerda
        if (comePeca(peca,tabuleiro, -1)){
            movimentos.add("Posição: ("+(peca.getLinha()+(peca.getFrente()*2))+";"+(peca.getColuna()-2)+")");
        }
        if (comePeca(peca, tabuleiro, 1)){
            movimentos.add("Posicao: ("+(peca.getLinha()+(peca.getFrente()*2))+";"+(peca.getColuna()+2)+")");
        }
        //------
        // movimentos para frente
        // frente+esquerda
        if(null == tabuleiro[peca.getLinha()+peca.getFrente()][peca.getColuna()-1]){
            movimentos.add("Posição: ("+(peca.getLinha()+peca.getFrente())+";"+(peca.getColuna()-1)+")");
        }
        // frente+direita
        if(null == tabuleiro[peca.getLinha()+peca.getFrente()][peca.getColuna()+1]){
            movimentos.add("Posição: ("+(peca.getLinha()-1)+";"+(peca.getColuna()-1)+")");
        }
        //------
        // movimentos para tras
        // tras+esquerda
        if (peca.isDama()){
            if(null == tabuleiro[peca.getLinha()-peca.getFrente()][peca.getColuna()-1]){
                movimentos.add("Posição: ("+(peca.getLinha()-peca.getFrente())+";"+(peca.getColuna()-1)+")");
            }
        // tras+frente
            if(null == tabuleiro[peca.getLinha()-peca.getFrente()][peca.getColuna()+1]){
                movimentos.add("Posição: ("+(peca.getLinha()-peca.getFrente())+";"+(peca.getColuna()-1)+")");
            }
            // !!! verifica movimentação diagonal desta peça
        }
        return movimentos;
    }

    // método para imprimir o estado atual do tabuleiro
    @Override
    public String toString(){
        // monta matrizes de instancias
        Peca[][] tabuleiro = getTabuleiro();
        String s="";
        for(byte i = 0; i < 8; i++) {
            s+="-----|-----|-----|-----|-----|-----|-----|-----\n";
            for (byte j = 0; j < 8; j++) {
                s+="  "+ ((null != tabuleiro[i][j]) ? tabuleiro[i][j].toString() : " ") +"  "+((7==j) ? " " : "|");
            }
            s+="\n";
        }
        s+="-----|-----|-----|-----|-----|-----|-----|-----\n";
        return s;
    }

    // retorna o estado de instancias atual do tabuleiro
    public Peca[][] getTabuleiro(){
        Peca[][] tabuleiro = new Peca[8][8];
        for (byte i=0;i<12;i++){
            tabuleiro[pecasBrancas[i].getLinha()][pecasBrancas[i].getColuna()]=pecasBrancas[i];
            tabuleiro[pecasPretas[i].getLinha()][pecasPretas[i].getColuna()]=pecasPretas[i];
        }
        return tabuleiro;
    }

    // cria os arrays com as instancias iniciais
    private void iniciarTabuleiro(){
        int brancas = 0;
        int pretas = 0;
        /* gabarito para colocar as peças no tabuleiro */
        char[][] tab=new char[][]{
                {'B',' ','B',' ','B',' ','B',' '},
                {' ','B',' ','B',' ','B',' ','B'},
                {'B',' ','B',' ','B',' ','B',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ','P',' ','P',' ','P',' ','P'},
                {'P',' ','P',' ','P',' ','P',' '},
                {' ','P',' ','P',' ','P',' ','P'}
        };
        for(byte i=0;i<8;i++){
            for (byte j=0;j<8;j++){
                switch (tab[i][j]){
                    case 'B':
                        this.pecasBrancas[brancas] = new Peca(false,i,j);
                        brancas++;
                        break;
                    case 'P':
                        this.pecasPretas[pretas] = new Peca(true,i,j);
                        pretas++;
                        break;
                }
            }
        }
    }
}
