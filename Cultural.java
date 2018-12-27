/**
 * Esta classe que herda tudo da Classe Parque
 * Representa os pontos de interesse que correspondem à categoria Parque Cultural
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.*;

/**
 * Classe Cultural que é uma Classe derivada de Parque
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Cultural extends Parque implements Serializable{
    private ArrayList<String> atividades = new ArrayList<>();
    private final String areaEstudo;
    private final String tipoParque;
    /**
     * Unico construtor desta classe
     * 
     * @param mylocal Nome do Local onde se encontra o Ponto de interesse
     * @param name Nome do Parque Cultural
     * @param hor Horario do Parque Cultural
     * @param cust_med Custo medio do Parque Cultural
     * @param cust_entrada Custo da entrada do Parque Cultural
     * @param rating Rating do Parque Cultural
     * @param num_wc Numero de casas de banho do Parque Cultural
     * @param espet Espetaculos do Parque Cultural
     * @param ativs Atividades do Parque Cultural
     * @param area_estudo Area de estudo do Parque Cultural
     * @param tipo_parque Tipo do Parque Cultural
     */
    public Cultural(String mylocal,String name, Horario hor, float cust_med, float cust_entrada, int rating,int num_wc,ArrayList<Espetaculo> espet,ArrayList<String> ativs, String area_estudo, String tipo_parque){
        super(mylocal,espet,name, 0, hor, cust_med, cust_entrada, rating, num_wc);
        this.atividades=ativs;
        this.areaEstudo=area_estudo;
        this.tipoParque=tipo_parque;
    }
    /**
     * 
     * @return Retorna o custo total do Parque Cultural
     */
    @Override
    public float getCusto()
    {
        return this.cust_entrada+this.cust_med;
    }
    /**
     * Util para a visualização
     * Diz se o Parque é do tipo natural, urbano, etc...
     * @return Retorna o tipo do Parque Cultural
     */
    @Override
    public String getTipo()
    {
        return this.tipoParque;
    }
    /**
     * Util para a visualização
     * @return Retorna a area de estudo do Parque Cultural
     */
    @Override
    public String getAreaEstudo()
    {
        return this.areaEstudo;
    }
    /**
     * Util para a visualização
     * @return Retorna a informacao dos espetaculos
     */
    @Override
    public String getEspetaculoInfo()
    {
        String todos_espetaculos_numa_string="";
        if (super.espetaculos.isEmpty())
            todos_espetaculos_numa_string ="Sem espetaculos";
        else
        {
            Iterator <Espetaculo> it = super.espetaculos.iterator();
            while (it.hasNext()) 
            {
                todos_espetaculos_numa_string = todos_espetaculos_numa_string.concat(it.next().toString());
                todos_espetaculos_numa_string = todos_espetaculos_numa_string.concat(" ");
            }
        }
        return todos_espetaculos_numa_string;
    }
    /**
     * Util para a visualização
     * @return Retorna a informacao das atividades
     */
    @Override
    public String getAtividadeInfo(){
        String todas_actividades_numa_string="| ";
        
        if (this.atividades.isEmpty())
            todas_actividades_numa_string ="Nao ha atividades |";
        else
        {
            Iterator <String> it = this.atividades.iterator();
            while (it.hasNext()) 
            {
                todas_actividades_numa_string = todas_actividades_numa_string.concat(it.next());
                todas_actividades_numa_string = todas_actividades_numa_string.concat(" |");
            }
        }
        return todas_actividades_numa_string;
    }
    
    
}
