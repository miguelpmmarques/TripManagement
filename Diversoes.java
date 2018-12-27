/**
 * Esta classe é abstrata e herda tudo da Classe Parque
 * 
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe abstrata Diversoes que é uma Classe derivada de Parque
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
abstract class Diversoes extends Parque implements Serializable{
    protected ArrayList<String> equipamentos;
    protected ArrayList<String> atracoes;
    /**
     * Unico construtor desta classe abstrata
     * 
     * @param mylocal Nome do local onde se encontra o ponto de interesse
     * @param espet Espetaculos do Parque de Diversoes
     * @param equipamentos Equipamentos que fazem parte do Parque de Diversoes
     * @param atracoes Atraçoes que fazem parte do Parque de Diversoes
     * @param name Nome do Parque de Diversoes
     * @param pontos Pontuacao do Parque de Diversoes
     * @param hor Horario do Parque de Diversoes
     * @param cust_med Custo medio do Parque de Diversoes
     * @param cust_entrada Custo da entrada do Parque de Diversoes
     * @param rating Rating do Parque de Diversoes
     * @param num_wc Numero de Casas de banho do Parque de Diversoes
     */
    public Diversoes(String mylocal,ArrayList<Espetaculo> espet,ArrayList<String> equipamentos, ArrayList<String> atracoes, String name, int pontos, Horario hor, float cust_med, float cust_entrada, int rating, int num_wc) {
        super(mylocal,espet,name, pontos, hor, cust_med, cust_entrada, rating, num_wc);
        this.equipamentos = equipamentos;
        this.atracoes = atracoes;
    }
    /**
     * Util para a visualização
     * @return Retorna a informação relativa ao equipamentos do Parque de Diversoes
     */
    public String getEquipamentosInfo()
    {
        String todos_equipamentos_numa_string="";
        if (this.equipamentos.isEmpty())
            todos_equipamentos_numa_string ="Sem equipamentos";
        else
        {
            Iterator <String> it = this.equipamentos.iterator();
            while (it.hasNext()) 
            {
                todos_equipamentos_numa_string = todos_equipamentos_numa_string.concat(it.next());
                todos_equipamentos_numa_string = todos_equipamentos_numa_string.concat(" ");
            }
        }
        return todos_equipamentos_numa_string;
    }
    /**
     * Util para a visualização
     * @return Retorna a informação relativa ao equipamentos do Parque de Diversoes
     */
    public String getAtracoesInfo()
    {
        String todas_atracoes_numa_string="|";
        if (this.atracoes.isEmpty())
            todas_atracoes_numa_string ="Sem atracoes";
        else
        {
            Iterator <String> it = this.atracoes.iterator();
            while (it.hasNext()) 
            {
                todas_atracoes_numa_string = todas_atracoes_numa_string.concat(it.next());
                todas_atracoes_numa_string = todas_atracoes_numa_string.concat("| ");
            }
        }
        return todas_atracoes_numa_string;
    }
    /**
     * Util para a visualização
     * @return Retorna o Custo Total do Parque de Diversoes
     */
    @Override
    public float getCusto()
    {
        return this.cust_entrada+this.cust_med;
    }
}
