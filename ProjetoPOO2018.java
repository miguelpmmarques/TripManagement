
package projetopoo2018;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
/**
 * Classe principal do projeto de POO
 * 
 * @author Miguel Marques e Paulo Cardoso
 */
public class ProjetoPOO2018 {
   
    
    /**
     * Este é o metodo principal do programa
     * @param args -
     * @throws IOException -
     * @throws InterruptedException -
     * @throws ClassNotFoundException -
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here   
        GUI gui;
        ArrayList<Local> locais = new ArrayList<>();
        ArrayList<Utilizador> users= new ArrayList<>();
        int[][] distancias = new int[20][];
        Utilizador user;
        Ficheiros fi = new Ficheiros();
        fi.carrega_ficheiros(locais, distancias,users);
        while(true)
        {
        GUI login = new GUI(users);
        login.setTitle("AGENCIAS UerVa");
        login.setUndecorated(true);
        login.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        login.setVisible(true);
        
        
            while(login.isVisible()){
          
            TimeUnit.MILLISECONDS.sleep(200);
            
        }
        user=login.getUtilizadorSeleccionado();
            if (login.getCheck()){
                gui = new GUI(locais,distancias,user);
                gui.setUndecorated(true);
                gui.setTitle("AGENCIAS UerVa");
                gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
                gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gui.setVisible(true);
                while(gui.isVisible())
                    TimeUnit.MILLISECONDS.sleep(100);
                if (!gui.getCheck())
                    break;
            }
            else
                break;
        }
      
        System.out.println("Check--->"+locais.size());
        fi.guarda_em_ficheiros_obj(locais, distancias,users);
        
        System.exit(0);
    }
}
