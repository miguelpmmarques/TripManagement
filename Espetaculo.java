/**
 * Esta Classe possui todos os metodos e variaveis que correspondem às caracateristicas dos Espetaculos
 * 
 */
package projetopoo2018;

import java.io.Serializable;

/**
 * Auxiliar às Classe derivadas de Parque
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Espetaculo implements Serializable{
    private String tipo;
    private String elementos;
    private Horario hor;
    private float precoEspetaculo;
    /**
     * Unico construtor desta classe
     * 
     * @param type Tipo de Espetaculo
     * @param elems Elementos que fazem parte do espetaculos
     * @param horario Horario do Espetaculo
     * @param preco_espetaculos Precos do Espetaculo
     */
    public Espetaculo(String type,String elems,Horario horario,float preco_espetaculos){
        this.tipo=type;
        this.elementos=elems;
        this.hor=horario;
        this.precoEspetaculo=preco_espetaculos;
        
    }
    /**
     * Util para a visualização
     * @return Retorna toda a informação relativa a um parque de diversoes 
     */
    @Override
    public String toString(){
        return "Tipo: "+this.tipo+" | Elementos: "+this.elementos+" Horario: "+this.hor.toString()+" Custo de entrada: "+this.precoEspetaculo+" euros |";

    }
    
}
