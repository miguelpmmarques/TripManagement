/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo2018;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Super Classe das classes Mestrado e Licenciatura
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
abstract class Utilizador implements Serializable{
    protected String nome;
    protected long numEstudante;
    protected double montanteMaximo;
    protected int [][] distancia;
    private Viagem trip = null;
    
    /**
     * 
     * @param name Nome do utilizador
     * @param num_estudante Numero de estudante do utilizador
     * @param mont_max Quantia maxima de dinheiro que o utilizador está disposto a gastar
     * @param dist Matriz de distancias
     * @param viagem Viagem selecionada pelo utilizador
     */
    public Utilizador(String name, long num_estudante,double mont_max,int [][] dist,Viagem viagem){
        this.nome=name;
        this.numEstudante=num_estudante;
        this.montanteMaximo=mont_max;
        this.distancia=dist;
        this.trip=viagem;
    }
    /**
     * 
     * @param mont_max Vlaor maximo que o utilizador está disposto a dar pela viagem
     */
    public void setMontante(double mont_max){
        this.montanteMaximo=mont_max;
    }
    /**
     * Construtor da classe
     * 
     * @param name Nome do utilizador
     * @param num_estudante Numero de estudante do utilizador
     */
    public Utilizador (String name, long num_estudante){
        this.nome=name;
        this.numEstudante=num_estudante;
    }
    /**
     * 
     * @return Retorna o nome do utilizador
     */
    public String getNome(){
        return this.nome;
    }
    /**
     * 
     * @return retorna o numero de estudante do utilizador
     */
    public long getNumEstudante(){
        return this.numEstudante;
    }
    /**
     * Permite alterara viagem selecionada
     * @param v Viagem selecionada pelo utilizador
     */
    public void setViagem(Viagem v){
        this.trip = v;
    }
    /**
     * 
     * @return Retorna a viagem selecionada pelo utilizador
     */
    public Viagem getViagem(){
        return this.trip;
    }

    
}
