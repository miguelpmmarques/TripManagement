/**
 * Esta classe que herda tudo da Classe Ponto de Interesse
 * Representa os pontos de interesse que correspondem à categoria Bar
 */
package projetopoo2018;

import java.io.Serializable;

/**
 * Classe Bar que é uma Classe derivada de PontoInteresse
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Bar extends PontoInteresse implements Serializable{
    private float consumoMinimo;
    
    
    /**
     * Unico construtor desta classe
     * 
     * @param mylocal Local onde se encontra o bar
     * @param name Nome do bar
     * @param hor Horario do bar
     * @param cust_med Custo medio do bar
     * @param cust_entrada Custo da entrada do bar
     * @param rating Rating do bar
     * @param cons_min Consumo minimo no bar
     */
    public Bar(String mylocal,String name, Horario hor, float cust_med, float cust_entrada, int rating, float cons_min){
        super(mylocal,name,0,hor,cust_med,cust_entrada,rating);
        this.consumoMinimo=cons_min;
    }
    /**
     * Util para a visualização
     * @return Retorna o consumo minimo do bar 
     */
    public float getConsumo()
    {
        return this.consumoMinimo;
    }
    /**
     * Util para o custo total da viagem
     * @return Retorna o custo total do bar
     */
    @Override
    public float getCusto()
    {
        return this.cust_entrada+this.cust_med+this.consumoMinimo;
    }
}
