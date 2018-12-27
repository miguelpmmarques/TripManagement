/*
 * Classe Parque Aquatico, vai herdar tudo da Classe Diversoes
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.*;

/**
 * Classe P_aquatico que é uma Classe derivada de Diversoes
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class P_aquatico extends Diversoes implements Serializable{
    private int [] mesesAberto;
    private ArrayList<Piscinas> piscinas;
    private String mesesAbertoString="";
    /**
     * 
     * @param mylocal Nome do Local onde se encontra o Parque aquatico
     * @param meses_aberto Meses em que o Parque aquatico está aberto, de 1 (Janeiro) a 12 (Dezembro)
     * @param pisc Piscina que o Parque Aquatico contem
     * @param espet Espetaculo presentes no Parque Aquatico
     * @param equipamentos Equipamentos que o Parque Aquatico possui
     * @param atracoes Atrações que consistem no Parque Aquatico
     * @param name Nome do Parque Aquatico
     * @param pontos Pontos do Parque Aquatico
     * @param hor Horario do Parque Aquatico
     * @param cust_med Custo medio do Parque Aquatico
     * @param cust_entrada Custo da entrada Parque Aquatico
     * @param rating Rating Parque Aquatico
     * @param num_wc Numero de Casa de banho Parque Aquatico
     * 
     */
    public P_aquatico(String mylocal,int[] meses_aberto,ArrayList<Piscinas> pisc, ArrayList<Espetaculo> espet,ArrayList<String> equipamentos, 
            ArrayList<String> atracoes, String name, int pontos, Horario hor, float cust_med, float cust_entrada, int rating, int num_wc) {
        super(mylocal,espet,equipamentos, atracoes, name, pontos, hor, cust_med, cust_entrada, rating, num_wc);
        this.mesesAberto=meses_aberto;
        this.piscinas=pisc;
        for (int mes : this.mesesAberto) {
            switch(mes){
                case 1: mesesAbertoString = mesesAbertoString.concat("Janeiro ");
                        break;
                case 2: mesesAbertoString = mesesAbertoString.concat("Fevereiro ");
                        break;
                case 3: mesesAbertoString = mesesAbertoString.concat("Março ");
                        break;
                case 4: mesesAbertoString = mesesAbertoString.concat("Abril ");
                        break;
                case 5: mesesAbertoString = mesesAbertoString.concat("Maio ");
                        break;
                case 6: mesesAbertoString = mesesAbertoString.concat("Junho ");
                        break;
                case 7: mesesAbertoString = mesesAbertoString.concat("Julho ");
                        break;
                case 8: mesesAbertoString = mesesAbertoString.concat("Agosto ");
                        break;
                case 9: mesesAbertoString = mesesAbertoString.concat("Setembro ");
                        break;
                case 10: mesesAbertoString = mesesAbertoString.concat("Outubro ");
                        break;
                case 11: mesesAbertoString = mesesAbertoString.concat("Novembro ");
                        break;
                case 12: mesesAbertoString = mesesAbertoString.concat("Dezembro ");
                        break;
                
            } 
        }
    }
    /**
     * 
     * @return Retorna roda a informacao essencial das piscinas
     */
    public String getPiscinasInfo()
    {
        String aux= "";
        for (Iterator<Piscinas> iterator = piscinas.iterator(); iterator.hasNext();) {
            Piscinas next = iterator.next();
            aux = aux.concat(next.toString());
            
        }
        return aux;
    }
    /**
     * 
     * @return Retorna uma String com o nome dos meses em que o Parque aquatico está aberto
     */
    public String getMesesAberto()
    {
        return this.mesesAbertoString;
    }
    /**
     * 
     * @return Retorna o Custo total do Parque Aquatico
     */
    @Override
    public float getCusto()
    {
        return this.cust_entrada+this.cust_med;
    }
    /**
     * 
     * @return Retorna toda a informação essencia dos espetaculos do Parque Aquatico
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
}
