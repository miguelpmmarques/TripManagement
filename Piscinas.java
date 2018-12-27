/*
 * Classe que integra as caracteristicas das piscinas e seus metodos
 */
package projetopoo2018;

import java.io.Serializable;

/**
 * Classe auxiliar à classe P_aquatico
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Piscinas implements Serializable{
    private float tamanho;
    private int restricao_idade;
    private float profundidade;

    /**
     * 
     * @param tam Tamanho da Piscina
     * @param rest Restricao de idade
     * @param prof Profundidade da piscina
     */
    public Piscinas(float tam,int rest,float prof) {
        this.tamanho=tam;
        this.restricao_idade=rest;
        this.profundidade=prof;
    }
    /**
     * 
     * @return Retorna o tamanho da piscina
     */
    public float getTamanho(){
        return this.tamanho;
    }
    /**
     * 
     * @return Retorna o limite da idade para poder ir para a piscina
     */
    public int getR_idade(){
        return this.restricao_idade;
    }
    /**
     * 
     * @return Retorna a profundidade da Piscina
     */
    public float getProfundidade(){
        return this.profundidade;
    }
    /**
     * 
     * @return String que indica todas as caracteristicas de certa piscina 
     */
    @Override
    public String toString()
    {
        return "Dimensão: "+tamanho+" metros cubicos | Restricao de idade de "+restricao_idade+" | Profundidade: "+profundidade+" |";
    }
    
}
