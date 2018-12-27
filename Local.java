/*
 * Classe que guarda toda a informação de cada local que se encontra no ficheiro de configuração
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.*;

/**
 * Classe Local, retem toda a informação inerente nos ficheiros de texto
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Local implements Serializable {
    protected String nome;
    protected ArrayList<PontoInteresse> ponto_interesse;
    private int pontuacao = 0,id;
    /**
     * 
     * @param name Nome do local
     * @param P_I Lista dos Pontos de interesse de certo local
     * @param pont Pontucação desse mesmo local
     * @param id  ID sequencia do ponto de interesse
     */
    public Local(String name, ArrayList<PontoInteresse> P_I, int pont,int id){
        this.nome=name;
        this.ponto_interesse=P_I;
        this.pontuacao=pont;
        this.id = id;
    }
    /**
     * 
     * @return Retorna o ID sequencial do Local
     */
    public int getId()
    {
        return this.id;
    }
    /**
     * 
     * @return Retorna a lista de Pontos de interresse de certo Local
     */
    public ArrayList<PontoInteresse> getPontosInteresse(){
        return ponto_interesse;
    }
    
    /**
     * 
     * @return Retorna os nomes de todos os Pontos de interesse de certo local num vetor de Strings 
     */
    public String[] nomePontosInteresse(){
        String[] pi = new String[ponto_interesse.size()];
        int move=0;
        for (Iterator<PontoInteresse> iterator = ponto_interesse.iterator(); iterator.hasNext();) {
            PontoInteresse next = iterator.next();
            pi[move] = next.getNome();
            move++;
        }
        return pi;
    }
    /**
     * 
     * @param indice Recebe o indice da lista de pontos de interesse
     * @return Retorna o ponto de interesse que se encontra nesse mesmo indice
     */
    public PontoInteresse getPont_Int(int indice){
        PontoInteresse p_i= this.ponto_interesse.get(indice);
        return p_i;
    }
   /**
    * 
    * @return Retorna o nome do Local
    */
    public String getNome()
    {
        return this.nome;
    }
    public void incrementaPontuacao(){
        this.pontuacao++;
    }
    public void desincrementaPontuacao(){
        this.pontuacao--;
    }
    public int getPontuacao(){
        return this.pontuacao;
    }
}
