
package projetopoo2018;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe Ficheiro, utilizada para a leitura e escrita em ficheiros de texto e ficheiros objeto
 * 
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class Ficheiros {
    /**
     * Unico construtor desta classe, serve unicamente para incializar o objeto
     */
    public Ficheiros(){}
    /**
     * 
     * @param locs Arraylist de Locais a serem carregados para o programa
     * @param dists matriz irregular que contem as distancias entre locais
     * @param users Arraylist com os utilizadores que ja se registaram no programa
     * @throws IOException -
     * @throws ClassNotFoundException -
     */
    void carrega_ficheiros(ArrayList<Local> locs,int [][] dists,ArrayList<Utilizador> users) throws IOException, ClassNotFoundException{
     
        
        String linha;
        int for_helper_local,for_helper_pi;
        File f = new File("fichObjeto.tmp");
        File ftxt = new File("fichTxt.txt");
        try {
            /**
             * Tenta ler o ficheiros objeto relativo às informações de locais e pontos de interesse, caso nao existam vai ler o ficheiro de texto
             * Uma vez lido o ficheiro de objetos ignora por completo o ficheiro de texto
             * Vamos deixar o ficheiro de texto pois caso os dados sejam corrompidos ou queimamos fazer um reset às pontuações sempre temos o ficheiro original
             */
            FileInputStream fis = new FileInputStream(f); 
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Local>  aux =  new ArrayList<>();
            aux = (ArrayList)ois.readObject();
            for (Iterator<Local> iterator = aux.iterator(); iterator.hasNext();) 
            {
                    Local next = iterator.next();
                    locs.add(next);
            }
            ois.close();
            fis.close();
            System.out.println("Ficheiro de Objetos lido--->"+locs.size());
        } catch (FileNotFoundException ex) 
        { 
            if (ftxt.exists() && ftxt.isFile())
            {
                System.out.println("Ficheiro de Texto lido");
                try 
                {
                    FileReader fr = new FileReader(ftxt);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    line = br.readLine();
                    line = br.readLine();
                    int n_locais = Integer.parseInt(line);
                    for(int n=0;n<n_locais;n++)
                    {
                        line = br.readLine();
                        String localString[] = line.split("\\s+");
                        for_helper_local = Integer.parseInt(localString[1]);
                        ArrayList<PontoInteresse> pi = new ArrayList<>();
                        for (int i = 0; i < for_helper_local; i++) 
                        {
                            line = br.readLine();
                            String piString[] = line.split("\\.");
                            char letra = piString[0].charAt(0);
                            line = br.readLine();
                            String piElem[] = line.split("\\|");
                            Hora abre = new Hora(Integer.parseInt(piElem[0]), Integer.parseInt(piElem[1]));
                            Hora fecha = new Hora(Integer.parseInt(piElem[2]), Integer.parseInt(piElem[3]));
                            String dia_folga_string[] = piElem[4].split("\\s+");
                            int[] dia_folga_int = new int[dia_folga_string.length];
                            int move = 0;
                            for (String j : dia_folga_string) 
                            {
                                dia_folga_int[move] = Integer.parseInt(j);
                                move++;
                            }
                            Horario h = new Horario(dia_folga_int, abre, fecha);
                            float custo_medio = Float.parseFloat(piElem[5]);
                            float custo_entrada = Float.parseFloat(piElem[6]);
                            int rating = Integer.parseInt(piElem[7]);
                            switch(letra)
                            {
                                case 'M':
                                    String tematica = piElem[8];
                                    Museu museu = new Museu(localString[0],piString[1], h, custo_medio, custo_entrada, rating, tematica);
                                    pi.add(museu);
                                    break;
                                case 'B':
                                    
                                    float consumo_min = Float.parseFloat(piElem[8]);
                                    Bar bar = new Bar(localString[0],piString[1], h, custo_medio, custo_entrada, rating, consumo_min);
                                    pi.add(bar);
                                    break;
                                case 'U':
                                    String[] cursos = piElem[8].split("\\s+");
                                    ArrayList<String> c = new ArrayList<>();
                                    for (String curso : cursos)
                                    {
                                        curso = curso.replace("_"," ");
                                        c.add(curso);
                                    }
                                    Universidade universidade = new Universidade(localString[0],piString[1], h, custo_medio, custo_entrada, rating,c);
                                    pi.add(universidade);
                                    break;
                                case 'C':
                                    int nr_wc = Integer.parseInt(piElem[8]);
                                    ArrayList<Espetaculo> espetaculos = new ArrayList<>();
                                    if(piElem[9].compareTo("Sem espetaculos")!=0)
                                    {
                                        String[] espetaculosStrings = piElem[9].split("\\?");
                                        Hora abreEspetaculo = new Hora(Integer.parseInt(espetaculosStrings[2]), Integer.parseInt(espetaculosStrings[3]));
                                        Hora fechaEspetaculo = new Hora(Integer.parseInt(espetaculosStrings[4]), Integer.parseInt(espetaculosStrings[5]));
                                        String dia_folga_stringEspetaculo[] = espetaculosStrings[6].split("\\s+");
                                        int[] dia_folga_intEspetaculo = new int[dia_folga_stringEspetaculo.length];
                                        int moveEspetaculo = 0;
                                        for (String j : dia_folga_stringEspetaculo) 
                                        {
                                            dia_folga_intEspetaculo[moveEspetaculo] = Integer.parseInt(j);
                                            moveEspetaculo++;
                                        }
                                        Horario hEspetaculo = new Horario(dia_folga_intEspetaculo, abreEspetaculo, fechaEspetaculo);
                                        Espetaculo espetaculoObjeto = new Espetaculo(espetaculosStrings[0], espetaculosStrings[1], hEspetaculo, Float.parseFloat(espetaculosStrings[7]));
                                        espetaculos.add(espetaculoObjeto);
                                    }
                                    
                                    String[] atividades = piElem[10].split("\\s+");
                                    ArrayList<String> act = new ArrayList<>();
                                    for (String atividade : atividades) 
                                    {
                                        atividade = atividade.replace("_", " ");
                                        act.add(atividade);
                                    }
                                    Cultural cultural = new Cultural(localString[0],piString[1], h, custo_medio, custo_entrada, rating, nr_wc, espetaculos, act, piElem[11],piElem[12]);
                                    pi.add(cultural);
                                    break;
                                case 'D':
                                    int nr_wcD = Integer.parseInt(piElem[8]);
                                    ArrayList<Espetaculo> espetaculosD = new ArrayList<>();
                                    if(piElem[9].compareTo("Sem espetaculos")!=0)
                                    {
                                        String[] espetaculosStrings = piElem[9].split("\\?");
                                        Hora abreEspetaculo = new Hora(Integer.parseInt(espetaculosStrings[2]), Integer.parseInt(espetaculosStrings[3]));
                                        Hora fechaEspetaculo = new Hora(Integer.parseInt(espetaculosStrings[4]), Integer.parseInt(espetaculosStrings[5]));
                                        String dia_folga_stringEspetaculo[] = espetaculosStrings[6].split("\\s+");
                                        int[] dia_folga_intEspetaculo = new int[dia_folga_stringEspetaculo.length];
                                        int moveEspetaculo = 0;
                                        for (String j : dia_folga_stringEspetaculo) 
                                        {
                                            dia_folga_intEspetaculo[moveEspetaculo] = Integer.parseInt(j);
                                            moveEspetaculo++;
                                        }
                                        Horario hEspetaculo = new Horario(dia_folga_intEspetaculo, abreEspetaculo, fechaEspetaculo);
                                        Espetaculo espetaculoObjeto = new Espetaculo(espetaculosStrings[0], espetaculosStrings[1], hEspetaculo, Float.parseFloat(espetaculosStrings[7]));
                                        espetaculosD.add(espetaculoObjeto);
                                    }
                                    ArrayList<String> atracoes = new ArrayList<>();
                                    String[] atracoesStrings = piElem[10].split("\\_");
                                    for (String j : atracoesStrings) 
                                    {
                                        atracoes.add(j);
                                    }
                                    ArrayList<String> equipamentos = new ArrayList<String>();
                                    String[] equipamentosStrings = piElem[11].split("\\_");
                                    for (String j : equipamentosStrings) 
                                    {
                                        equipamentos.add(j);
                                    }

                                    String mes_disponiveis_string[] = piElem[12].split("\\s+");
                                    int[]mes_disponiveis = new int[mes_disponiveis_string.length];
                                    int movemes = 0;
                                    for (String j : mes_disponiveis_string) 
                                    {
                                        mes_disponiveis[movemes] = Integer.parseInt(j);
                                        movemes++;
                                    }
                                    String piscinas_lines[] = piElem[13].split("\\_");
                                    ArrayList<Piscinas> lista_piscinas = new ArrayList<>();
                                    for (String piscinas_line : piscinas_lines) {
                                        String piscinas_lin[] = piscinas_line.split("\\s+");
                                        int[] int_pis = new int[3];
                                        int_pis[0]=Integer.parseInt(piscinas_lin[0]);
                                        int_pis[1]=Integer.parseInt(piscinas_lin[1]);
                                        int_pis[2]=Integer.parseInt(piscinas_lin[2]);
                                        Piscinas pools = new Piscinas(int_pis[0],int_pis[1],int_pis[2]);
                                        lista_piscinas.add(pools);
                                    }
                                    P_aquatico parque_aquatico = new P_aquatico(localString[0],mes_disponiveis,lista_piscinas,espetaculosD, equipamentos, atracoes, piString[1],0, h, custo_medio, custo_entrada, rating, nr_wcD);
                                    pi.add(parque_aquatico);
                                    break;
                                  }
                                }
                                Local local = new Local(localString[0], pi, 0,n);
                                locs.add(local);

                            }
                        br.close();
                    } catch (IOException e) {
                    System.out.println("ERRO");
                }
            }
            else
            System.out.println("Nao existem ficheiros para ser lidos");
        } catch (IOException ex) { 
            System.out.println("Erro a ler ficheiro."); 
        } catch (ClassNotFoundException ex) { 
            System.out.println("Erro a converter objeto."); 
        }
        File fut = new File("fichObjetoUsers.tmp");
        ArrayList<Utilizador>  aux_users =  new ArrayList<>();
        try { 
                FileInputStream fis_ut = new FileInputStream(fut); 
                ObjectInputStream ois_ut = new ObjectInputStream(fis_ut);
                
                aux_users = (ArrayList)ois_ut.readObject();
                
                for (Utilizador next : aux_users) {
                    users.add(next);
                }
            System.out.println("Ficheiro de Objetos lido--->"+users.size());
            ois_ut.close();
            fis_ut.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro não exite");
        }
       
        
        File fdobj = new File("fichDistObjeto.tmp");
        File fdtxt = new File("fichDistTxt.txt");
        try {
            int [][] dist_aux;
            FileInputStream fisd = new FileInputStream(fdobj); 
            ObjectInputStream oisd;
            oisd = new ObjectInputStream(fisd);
            dist_aux = (int[][])oisd.readObject();
           for (int i = 0; i < 20; i++) {
                dists[i] = dist_aux[i].clone();
            }
            oisd.close();
            fisd.close();
            System.out.println("Ficheiro de Objetos lido--->"+locs.size());
        } catch (FileNotFoundException ex) 
        { 
            if (fdtxt.exists() && fdtxt.isFile())
            {
                try 
                {
                    FileReader frd = new FileReader(fdtxt);
                    BufferedReader brd = new BufferedReader(frd);

                    String line;
                    for (int i = 0; i < 20; i++) {
                        line = brd.readLine();
                        String[] dis_str = line.split("\\s+");
                        dists[i] = new int[dis_str.length];
                        for (int j = 0; j < dis_str.length; j++) {
                            dists[i][j] = Integer.parseInt(dis_str[j]);
                        }

                    }
                }
                catch (IOException e) { 
                    System.out.println("Erro a ler ficheiro."); 
                }
            }   
        }
        catch (IOException ex) {
            Logger.getLogger(Ficheiros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ficheiros.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * 
     * @param locs Arraylist de locais 
     * @param dists Matriz irregular com as distancias entre locais
     * @param users Arraylist com os utilizadores que ja se registaram no programa
     */
    public void guarda_em_ficheiros_obj(ArrayList<Local> locs,int [][] dists,ArrayList<Utilizador> users){
        try 
        { 
            FileOutputStream fosd = new FileOutputStream("fichDistObjeto.tmp");
            FileOutputStream fos = new FileOutputStream("fichObjeto.tmp"); 
            FileOutputStream fut= new FileOutputStream("fichObjetoUsers.tmp");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) 
            {
                oos.writeObject(locs);
                System.out.println("GUARDADO EM FICHEIROS OBJETOS COM SUCESSO -> Locais");
                oos.close();
            } 
            try (ObjectOutputStream oosd = new ObjectOutputStream(fosd)) 
            {
                oosd.writeObject(dists);
                System.out.println("GUARDADO EM FICHEIROS OBJETOS COM SUCESSO -> Distancias");
                oosd.close();
            } 
            try (ObjectOutputStream oosut = new ObjectOutputStream(fut)) 
            {
                oosut.writeObject(users);
                System.out.println("GUARDADO EM FICHEIROS OBJETOS COM SUCESSO -> Utilizadores");
                oosut.close();
            } 
            
        } catch (FileNotFoundException ex) 
        { 
            System.out.println("Ficheiro nao encontrado"); 
        } catch (IOException ex) 
        { 
            System.out.println("Erro a escrever para o ficheiro."); 
            ex.printStackTrace();
        }
        
    }
}

    
  
