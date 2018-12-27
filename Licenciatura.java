/**
 * 
 * Esta classe que herda tudo da Classe Utilizador
 * Permite diferenciar os utilizador que vai ter um hot ou um evita
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Licenciatura que é uma Classe derivada de Utilizador
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Licenciatura extends Utilizador implements Serializable{
    PontoInteresse hot;
    
    /**
     * Construtor da classe
     * @param quente Parametro correspondente ao ponto de interesse hot escolhido
     * @param name Nome do utilizador
     * @param num_estudante Numero de estudante do utilizador
     * @param mont_max Quantia maxima de dinheiro que o utilizador está disposto a gastar
     * @param dist Matriz de distancias
     * @param viagem Viagem selecionada pelo utilizador
     */
    public Licenciatura(PontoInteresse quente,String name, long num_estudante,double mont_max,int [][] dist,Viagem viagem){
        super(name, num_estudante, mont_max, dist, viagem);
        this.hot=quente;
    }
    /**
     * Construtor da classe
     * 
     * @param nome Nome do utilizador
     * @param num Numero de estudante do utilizador
     */
    public Licenciatura(String nome,long num){
        super(nome,num);
    }
    /**
     * Permite alterar o ponto de interesse hot
     * @param quente Ponto de interesse hot
     */
    public void setHot(PontoInteresse quente){
        this.hot=quente;
    }
}
