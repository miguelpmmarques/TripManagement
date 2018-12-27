/**
 * Classe Universidade, vai ser uma classe derivada da classe PontoInteresse, herdando assim todos os seus metodos e atributos
 */
package projetopoo2018;

import java.util.*;

/**
 * Classe Universidade que é uma Classe derivada de PontoInteresse
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Universidade extends PontoInteresse{
   private ArrayList<String> curso;
    /**
     * 
     * @param mylocal Nome do Local 
     * @param name Nome da Universidade
     * @param horario Horario da Universidade
     * @param custo_medio Custo medio da Universidade
     * @param custo_entrada Custo de entrada da Universidade
     * @param rat Rating da Universidade
     * @param cursos Cursos Relacionados com Engenharia Informatica presentes na Universidade
     */
    public Universidade(String mylocal,String name, Horario horario, float custo_medio,float custo_entrada,int rat, ArrayList<String> cursos)
    {
        super(mylocal,name, 0, horario, custo_medio, custo_entrada, rat);
        this.curso=cursos;
    }
   /**
    * 
    * @return Retorna uma String com todos os Cursos Relacionados com Engenharia Informatica presentes na Universidade
    */
    public String getCursos(){
        String cursos_todos_numa_string = "";
        Iterator <String> it = curso.iterator();
        while (it.hasNext()) {
            cursos_todos_numa_string = cursos_todos_numa_string.concat("  ");
            cursos_todos_numa_string = cursos_todos_numa_string.concat(it.next());
       }
        return cursos_todos_numa_string;

    }
   
}
