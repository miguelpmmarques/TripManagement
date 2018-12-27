/*
 * Classe Museu que herda tudo da Classe ponto de interesse
 *
 */
package projetopoo2018;

import java.io.Serializable;

/**
 * Classe Museu que é uma Classe derivada de PontoInteresse
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Museu extends PontoInteresse implements Serializable{
    
    private String tematica;
    /**
     * 
     * @param mylocal Nome do Local onde de encontra o Museu
     * @param name Nome do Museu
     * @param hor Hoario do Museu
     * @param cust_med Custo medio do Museu
     * @param cust_entrada Custo da entrada do Museu
     * @param rating Rating do Museu
     * @param tema Tema do Museu
     */
    public Museu(String mylocal,String name, Horario hor, float cust_med, float cust_entrada, int rating,String tema){
        super(mylocal,name,0,hor,cust_med,cust_entrada,rating);
        this.tematica=tema;
    }
    /**
     * 
     * @return Retorna o custo total do Museu
     */
    @Override
    public float getCusto()
    {
        return this.cust_entrada+this.cust_med;
    }
    /**
     * 
     * @return Retorna o tema do Museu
     */
    public String getTematica()
    {
        return this.tematica;
    }
}
