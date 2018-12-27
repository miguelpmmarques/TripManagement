/**
 * Classe com informação relativa ao horario, muito importante para o projeto visto que é um caracteristica de cada Ponto de Interesse
 */
package projetopoo2018;

import java.io.Serializable;

/**
 * Bastate util para os pontos de interesse
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Horario implements Serializable
{
    
    private int [] diaFolga;
    private String diaFolga_string = "";
    private Hora abre;
    private Hora fecha;
    /**
     * 
     * @param dia_folga Representa os dias de folga de 2 (Segunda Feira) a 8 (Domingo)
     * @param open Representa a hora de abertura
     * @param close Representa a hora de fecho 
     */
    public Horario(int [] dia_folga, Hora open, Hora close)
    {
        this.diaFolga=dia_folga;
        this.abre=open;
        this.fecha=close;
        int move = 0;
        for (int i : dia_folga) {
            switch(i)
            {
                case(2):
                    diaFolga_string = this.diaFolga_string.concat(" Segunda-feira");
                    move++;
                    break;
                case(3):
                    diaFolga_string = this.diaFolga_string.concat(" Terça-feira");
                    move++;
                    break;
                case(4):
                    diaFolga_string = this.diaFolga_string.concat(" Quarta-feira");
                    move++;
                    break;
                case(5):
                    diaFolga_string = this.diaFolga_string.concat(" Quinta-feira");
                    move++;
                    break;
                case(6):
                    diaFolga_string = this.diaFolga_string.concat(" Sexta-feira");
                    move++;
                    break;
                case(7):
                    diaFolga_string = this.diaFolga_string.concat(" Sabado");
                    move++;
                    break;
                case(8):
                    diaFolga_string = this.diaFolga_string.concat(" Domingo");
                    move++;
                    break;
            }
            
        }
        if (move == 0) 
        {
            diaFolga_string = this.diaFolga_string.concat(" Sempre Aberto");
        }
    }
    /**
     * 
     * @return Retorna a hora de abertura
     */
    public Hora getAbre()
    {
        return this.abre;
    }
    /**
     * 
     * @return Retorna a hora de fecho
     */
    public Hora getFecha()
    {
        return this.fecha;
    }
    /**
     * 
     * @return Retorna os dias de folga de 2 (Segunda Feira) a 8 (Domingo)
     */
    public int [] getDiaFolga()
    {
        return this.diaFolga;
    }
    /**
     * 
     * @return Coloca toda a informação essencial numa String
     */
    @Override
    public String toString()
    {
        if (abre.getHoras()==0 && abre.getMinutos()==0 && fecha.getHoras()==0 && fecha.getMinutos()==0) {
            return " | Está sempre aberto |";
        }
        return " | Abertura "+abre.getHoras()+":"+abre.getMinutos()+" Fecho "+fecha.getHoras()+":"+fecha.getMinutos()+" | Dias folga -"+this.diaFolga_string+" |";
    }
    
}
