/**
 * Classe com informação relativa à hora, e serve de auxilio à Classe Horario
 */
package projetopoo2018;

import java.io.Serializable;

/**
 * Bastate util para os pontos de interesse
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Hora implements Serializable{
    private int horas;
    private int minutos;
    /**
     * 
     * @param h Hora
     * @param min Minuto
     */
    public Hora(int h,int min){
        this.horas=h;
        this.minutos=min;
    }
    /**
     * 
     * @return Retorna Minutos
     */
    public int getMinutos(){
        return this.minutos;
    }
    /**
     * 
     * @return Retorna Horas
     */
    public int getHoras(){
        return this.horas;
    }
    /**
     * 
     * @return Poe na string o formato da hora Horas:Minutos
     */
    @Override
    public String toString(){
        return this.horas+":"+this.minutos;
    }
    
    
}
