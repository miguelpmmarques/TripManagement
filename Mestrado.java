/**
 * 
 * Esta classe que herda tudo da Classe Utilizador
 * Permite diferenciar os utilizador que vai ter um hot ou um evita
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Mestrado que é uma Classe derivada de Utilizador
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Mestrado extends Utilizador implements Serializable{
    private Local evita;
    /**
     * 
     * @param avoid Local a evitar pelo utilizador
     * @param name Nome do utilizador
     * @param num_estudante Numero de estudante do utilizador
     * @param mont_max Quantia maxima de dinheiro que o utilizador está disposto a gastar
     * @param dist Matriz de distancias
     * @param viagem Viagem selecionada pelo utilizador
     */
    public Mestrado(Local avoid,String name, long num_estudante,double mont_max,int [][] dist,Viagem viagem){
        super(name, num_estudante, mont_max, dist, viagem);
        this.evita=avoid;
    }
    /**
     * Construtor da classe
     * 
     * @param nome Nome do utilizador
     * @param num Numero de estudante do utilizador
     */
    public Mestrado(String nome, long num){
        super(nome,num);
    }
    /**
     * Permite alterar o Local a evitar
     * @param avoid Local a evitar
     */
    public void setEvita(Local avoid){
        this.evita=avoid;
    }
}
