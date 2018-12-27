/**
 * É um tipo de Ponto de interesse, este caso Abstrato, podendo ser Cultural ou de Diversões. Vai herdar tudo que os Pontos de interesse possuem.
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Super classe abstrata das classes Cultural e Diversoes
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
abstract class Parque extends PontoInteresse implements Serializable{
    protected int numerowc;
    protected ArrayList<Espetaculo> espetaculos = new ArrayList<>(); 
    /**
     * 
     * @param mylocal Nome do local onde se encontra o Parque
     * @param espet Nome dos Espetaculos do Parque
     * @param name Nome do Parque
     * @param pontos Pontos do Parque
     * @param hor Horario do Parque
     * @param cust_med Custo medio do Parque
     * @param cust_entrada Custo de entrada no Parque
     * @param rating Rating do Parque
     * @param num_wc Numero de casas de banho do Parque
     */
    public Parque(String mylocal,ArrayList<Espetaculo> espet,String name, int pontos, Horario hor, float cust_med, float cust_entrada, int rating,int num_wc){
        super(mylocal,name, pontos, hor, cust_med, cust_entrada, rating);
        this.espetaculos=espet;
        this.numerowc=num_wc;
    }
    /**
     * 
     * @return Nada, util para o Polimorfismo
     */
    @Override
    public String getEspetaculoInfo()
    {
        return "";
    }
    /**
     * 
     * @return Nada, util para o Polimorfismo
     */
    public String getAtividadeInfo()
    {
        return "";
    }
    /**
     * 
     * @return Nada, util para o Polimorfismo
     */
    public String getTipo()
    {
        return "";
    }
    /**
     * 
     * @return Nada, util para o Polimorfismo
     */
    public String getAreaEstudo()
    {
        return "";
    }
    
}
