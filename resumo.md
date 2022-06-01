# Resumo

resumo para prova 2

## Teoria dos Jogos

* Utiliza como base os métodos de busca para resolver problemas.
* Baseado em estados
* Normalmente utiliza-se mecânicas de jogos por turnos, onde o adversário pode tomar ações que atrapalham a solução do problema, ou seja tem que haver replanejamento a cada jogada
* heurística é uma função que retorna se uma decisão é boa ou ruim com base nos estados/fatores 

### Algoritmos de Decisão

#### Minimax

```
ROTINA minimax(nó, profundidade)
    SE nó é um nó terminal OU profundidade = 0 ENTÃO
        RETORNE o valor da heurística do nó
    SENÃO SE o nó representa a jogada de algum adversário ENTÃO
        α ← +∞
        PARA CADA filho DE nó
            α ← min(α, minimax(filho, profundidade-1))
        FIM PARA
        RETORNE α
    SENÃO
        α ← -∞
        PARA CADA filho DE nó
            α ← max(α, minimax (filho, profundidade-1))
        FIM PARA
        RETORNE α
    FIM SE
FIM ROTINA
```

#### Alfa-beta

é uma variação do algoritmo **Minimax**

A poda alfa-beta (ou poda α-β) é uma variação do algoritmo minimax que visa reduzir o número de nós que são avaliados na árvore de busca. É uma busca adversarista comumente utilizada na implementação de jogadores automáticos em jogos com dois jogadores (Jogo da Velha, Xadrez, Go, etc.). Ele para completamente de avaliar um movimento quando ele encontra, de maneira comprovada, um movimento cujo valor associado seja pior que um movimento previamente examinado. Sendo assim, os movimentos posteriores não necessitam ser avaliados.

A poda alfa beta não altera o resultado da avaliação de uma sub-árvore e a sua vantagem está no fato de que, em árvores de busca com um fator de ramificação muito grande, a utilização de memória será significativamente reduzida. 

O algoritmo mantém dois valores, alpha e beta, os quais representam a pontuação máxima que é garantida ao jogador maximizador (max) e a pontuação mínima que é garantida ao jogador minimizador (min), respectivamente. Inicialmente, alpha recebe o valor "infinito negativo" e beta, "infinito positivo". Portanto, ambos os jogadores iniciam com a suas piores pontuações possíveis.

Pode acontecer que, ao selecionar um ramo de um certo nó, a pontuação mínima que é garantida ao jogador minimizador se torne menor do que a pontuação máxima que é garantida ao jogador maximizador (beta <= alpha). Se isso ocorrer, o "nó pai" não deve selecionar esse nó, pois isso fará com que a pontuação para o node pai seja pior. Por fim, os outros ramos do nó não precisarão ser explorados. 

## Sistemas Especialistas

São sistemas que possuem conhecimentos empíricos e teóricos de um especialista (humano) desta determinada área para solucionar determinado problema.

Utiliza o motor de inferência para aplicar as regras sobre os conhecimentos.

Conhecimento deve estar armazenado em um local diferente da lógica e do(s) códigos principais. (base de conhecimento)

Deve ser capaz de realizar a prova real de uma resposta, ou seja, explicar a tomada de decisão para determinada resposta.

Deve ser capaz de explicar o por que uma certa informação é critia

* representação de conhecimentos 
* representação de regras 
* Respostas (nós finais) 
* utiliza do motor de inferência para chegar a respostas, tanto por meio de dados quanto por meio de respostas de regras ou conjunto de regras
* **DEVE TER MOTOR DE INFERÊNCIA** 

*otimização META-CONHECIMENTO (divisão de um conhecimento em pequenos conhecimentos que são utilizados com base em certas regras)*

### Representação de conecimento

* Regras (expressões lógicas)
* Frames (conceito similar a classes descritivas)
  * Facetas: características descritas
  * Conceitos Derivados: Outro objeto que possui seu próprio conjunto de características e ou outros conceitos
* Redes Semânticas
  * Grafos

## Técnicas de Planejamento
