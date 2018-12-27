/**
 * Classe muito importante para o bom funcionamento do programa, deste modo é possivel guardar todas das viagens geradas e selecoandas pelo utilizador.
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Classe Viagem que possiu informação relativa a uma viagem com 3 locais, varios pontos de interesse e um ponto hot ou um local a evitar
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Viagem implements Serializable{
    private float custoTotal;
    private Local[] locais;
    private ArrayList<PontoInteresse> todosPontos = new ArrayList<PontoInteresse>();
    private PontoInteresse hot;
    private Local evita;
    /**
     * 
     * @param custo_total Custo total da Viagem
     * @param locs Vetor de Locais que fazem parte da viagem
     * @param todosPontos Lista de todos os Pontos de interesse que fazem parte da viagem
     */
    public Viagem(float custo_total,Local[] locs,ArrayList<PontoInteresse> todosPontos){
        this.custoTotal=custo_total;
        this.locais=locs;
        this.todosPontos=todosPontos;
        
    }
    /**
     * 
     * @return Retorna o ponto de interesse hot
     */
    public PontoInteresse getHot()
    {
        return this.hot;
    }
    /**
     * 
     * @return Retorna o local a evitar
     */
    public Local getEvita()
    {
        return this.evita;
    }
    /**
     * Construtor
     * @param v Viagem
     */
    public Viagem(Viagem v)
    {
        this.custoTotal=v.custoTotal;
        this.locais = Arrays.<Local>copyOf(v.locais, v.locais.length);
        this.todosPontos=v.todosPontos;
    }
    /**
     * 
     * @param v Viagem
     * @param evita Local a evitar
     */
    public Viagem(Viagem v,Local evita)
    {
        this.custoTotal=v.custoTotal;
        this.locais = Arrays.<Local>copyOf(v.locais, v.locais.length);
        this.todosPontos=v.todosPontos;
        this.evita = evita;
    }
    /**
     * 
     * @param v Viagem
     * @param hot Ponto de interesse hot
     */
    public Viagem(Viagem v,PontoInteresse hot)
    {
        this.custoTotal=v.custoTotal;
        this.locais = Arrays.<Local>copyOf(v.locais, v.locais.length);
        this.todosPontos=v.todosPontos;
        this.hot = hot;
    }
    
    /**
     * 
     * @param custo_total Custo total da viagem
     * @param locs Vetor com os locais selecionados
     * @param todosPontos Arraylist com todos os Pontos de interesse selecionados
     * @param eviLocal Local a evitar
     */
    public Viagem(float custo_total,Local[] locs,ArrayList<PontoInteresse> todosPontos,Local eviLocal)
    {
        this.custoTotal=custo_total;
        this.locais=locs;
        this.todosPontos=todosPontos;
        this.evita = eviLocal;
    }
    
    /**
     * 
     * @param custo_total Custo total da viagem
     * @param locs Vetor com os locais selecionados
     * @param todosPontos Arraylist com todos os Pontos de interesse selecionados
     * @param hot Ponto de interesse hot
     */
    public Viagem(float custo_total,Local[] locs,ArrayList<PontoInteresse> todosPontos,PontoInteresse hot)
    {
        this.custoTotal=custo_total;
        this.locais=locs;
        this.todosPontos=todosPontos;
        this.hot = hot;
    }
    /**
     * 
     * @param index Recebe o index de certo local
     * @return Retorna o custo do local desse index
     */
    public float getPrecoLocal(int index)
    {
        float custo = 0;
        for (Iterator<PontoInteresse> iterator = locais[index].getPontosInteresse().iterator(); iterator.hasNext();) {
            PontoInteresse next = iterator.next();
            if(todosPontos.contains(next))
                custo+=next.getCusto();
        }
        return custo;
    }
    /**
     * 
     * @param index Recebe o index do Ponto de interesse
     * @return Retorna o Array
     */
    public ArrayList<PontoInteresse> getPontosInteresseEscolhidosDeCertoLocal(int index)
    {
        float custo = 0;
        ArrayList<PontoInteresse> escolhidos = new ArrayList<>();
        for (Iterator<PontoInteresse> iterator = locais[index].getPontosInteresse().iterator(); iterator.hasNext();) {
            PontoInteresse next = iterator.next();
            if(todosPontos.contains(next))
                escolhidos.add(next);
        }
        return escolhidos;
    }
    /**
     * 
     * @return Retorna o Vetor de Pontos de Interesse
     */
    public Local[] getLocais(){
        return this.locais;
    }
    /**
     * 
     * @return Retorna uma lista com todos os Pontos de Interesse presentes na Viagem
     */
    public ArrayList<PontoInteresse> getPI(){
        return this.todosPontos;
    }
    
    /**
     * 
     * @return Retorna o Custo da Viagem
     */
    public float getCusto() {
        return this.custoTotal;
    }
   /**
    * Ordena os locais por ordem crescente de custo
    */
    public void crescenteSort()
    {
        Local move;
        boolean flag = true;
        do{
            flag = true;
            for (int i = 0; i<2;i++) {
                if(this.getPrecoLocal(i) > this.getPrecoLocal(i+1))
                {
                    move = locais[i];
                    locais[i] = locais[i+1];
                    locais[i+1] = move;
                    flag = false;
                }
            }
        }while(flag == false);
    }
    /**
    * Ordena os locais por ordem decrescente de custo
    */
    public void decrescenteSort()
    {
        Local move;
        boolean flag = true;
        do
        {
            flag = true;
            for (int i = 0; i<2;i++) {
                if(this.getPrecoLocal(i) < this.getPrecoLocal(i+1))
                {
                    move = locais[i];
                    locais[i] = locais[i+1];
                    locais[i+1] = move;
                    flag = false;
                }
            }
        }while(flag == false);
    }
    
}

