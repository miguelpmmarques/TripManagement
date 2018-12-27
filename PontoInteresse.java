/**
 * Uma das classes mais importantes deste projeto, Super classe das Classes: Bar, Parque, Universidade e Museu
 */
package projetopoo2018;

import java.io.Serializable;
/**
 * Super Classe das classes Bar, Universidade, Parque e Museu
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */

abstract class PontoInteresse implements Serializable{
    protected String nome;
    private int pontuacao = 0;
    protected Horario hor;
    protected float cust_med;
    protected float cust_entrada;
    protected int rating;
    protected String mylocal;
    /**
     * Construtor da classe Ponto_Interrsess
     * @param mylocal Local onde está o ponto de interesse
     * @param name Nome do ponto de interesse dado
     * @param pontos Permite escolher mais tarde os pontos de locais favoritos
     * @param horario Horario de funcionamento desse determinado ponto de interesse
     * @param custo_medio Custo medio desse determinado ponto de interesse
     * @param custo_entrada Custo de entrada desse determinado ponto de interesse
     * @param rat Rating desse determinado ponto de interesse
     */
    
    public PontoInteresse(String mylocal,String name, int pontos, Horario horario, float custo_medio,float custo_entrada,int rat){
        this.nome=name;
        this.mylocal = mylocal;
        this.pontuacao= pontos;
        this.hor= horario;
        this.cust_med=custo_medio;
        this.cust_entrada= custo_entrada;
        this.rating= rat;
    }
    /**
     * 
     * @return Retorna o nome do local onde se encontra o Ponto de interesse
     */
    public String getLocal(){
        return this.mylocal;
    }
    /**
     * 
     * @return Retorna o custo do Ponto de interesse
     */
    public float getCusto()
    {
        return this.cust_entrada+this.cust_med;
    }
    /**
     * 
     * @return Retorna o nome do Ponto de interesse
     */
    public String getNome()
    {
        return this.nome;
    }
    /**
     * 
     * @return Retorna a informaçao relativa aos espetaculos de certo ponto de interesse
     */
    public String getEspetaculoInfo()
    {
        return "";
    }
    /**
     * 
     * @return Retorna certa informação no formato String
     */
    @Override
    public String toString(){
        return "";
    }
    /**
     * 
     * @return Retorna o Rating de certo Ponto de interesse
     */
    public String getRating(){
        return Integer.toString(rating);
    }
    /**
     * 
     * @return Retorna a informação relativa ao horario de certo ponto de interesse
     */
    public String toStringHorario(){
        return "Horario\n"+this.hor.toString();
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
