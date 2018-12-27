/**
 * Classe mais complexa e mais extensa deste programa
 */
package projetopoo2018;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Arrays;
//import java.lang.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Classe GUI que monotoriza toda a interface do nosso programa
 * @author Miguel Marques 2017266263 Paulo Cardoso 2017249716
 */
class GUI extends JFrame
{
    private JPanel panelPrincipal;
    private JPanel panel_user;
    
    private JTextField name_user,num_user;
    private JLabel label_name, sec_label_name, num_label, sec_num_label, label_ciclo,sec_label_ciclo,title,sec_title,image, label_user_combo,trd_title,sec_label_user;
    private ImageIcon imagem_user;
    private JComboBox ciclo,user_combo;
    private ArrayList<String> text_ciclo=new ArrayList<>(Arrays.asList("Escolha a sua opcao","Licenciatura","Mestrado"));
    private ArrayList<String> nomes_users=new ArrayList<>(Arrays.asList("ADD USER+++"));
    private ComboListener escuta_combo;
    private UserComboListener escuta_user_combo;
    private TextListener escuta_texto,escuta_num;
    private String combo_seleccionado=text_ciclo.get(0), nome_seleccionado="";
    private String texto_user_seleccionado;
    private ArrayList<Utilizador> users_cpy=new ArrayList<>();
    private boolean check=true;
    int conta=0;
    private long numero_seleccionado=0;
    private JDialog warning_num=new JDialog();
    private Utilizador user_seleccionado;
    

    //construtor segunda janela;
    private int montante_int=100;
    private float custoViagem=0;
    private float custoPontoI=0;
    private ArrayList<Viagem> viagemGeradas = new ArrayList<>();
    private int [][] matriz_distancias;
    private DecimalFormat df = new DecimalFormat("#.##");
    private ArrayList<Local> locais;
    private JTextField textodoCusto;
    private EscutaKey cusco1; 
    private doisEscutaTeclas cusco2,cusco3,cusco4;
    //45
    
    
    //LABELS
    private JLabel welcome,montante,hotouevita,background,viagens_possiveis,euros;
    private JLabel custoZero,custoPrimeiro,custoSegundo,custoTerceiro,custoFinal;
    private JLabel distanciaZero,distanciaPrimeiro,distanciaSegundo,distanciaTerceiro,distanciaFinal;
    private JLabel primeiroLocal,segundoLocal,terceiroLocal;
    private JLabel tituloViagem,tituloViagemaux;
    private JLabel primeiroLocalPI,segundoLocalPI,terceiroLocalPI,primeiroLocalPIaux,segundoLocalPIaux,terceiroLocalPIaux,todosPi;
    private JLabel custoTotal,avisoSeleciona,avisoSelecionaaux,hotEvitaLabel,hotEvitaLabelaux;
    private JComboBox hot_evita,primeiroLocalCombo,segundoLocalCombo,terceiroLocalCombo;
    
    // BOTOES
    private JButton lets_go,but_sair,but_remove;
    private ButtonListener escuta_butao;
    private ButtonListenerSair escuta_sair;
    private ButtonlistenerRemove escuta_remove;
    private JButton gerar_viagens,pum,pdois,ptres,premove,verViagem,exiButton,selectButton,voltarButton,favButton;
    private ButtonVerViagemListeer verViagemListeer ;
    private umButtonListener listenum;
    private doisButtonListener listendois;
    private tresButtonListener listentres;
    private removeButtonListener listenremove;
    private selectButtonListener listenselect;
    private JButton limpaViagem,retiraViagem;
    private ButtonGeraViagensListener geraViagensListener;
    private ButtonListenerSair  escuta_exit,escuta_voltar;
    private ButtonLimpaViagemListeer limpaViagemListeer;
    private ButtonRetiraViagemListeer retiraViagemListeer;
  
    // IMAGENS
    private ImageIcon bg;
    private ImageIcon img1;
    private ImageIcon img2;
    private ImageIcon img3;
    private ImageIcon img4;
    private ImageIcon nada;
    private ImageIcon black;
    private ImageIcon pin;
    private ImageIcon contour2;
    private JLabel img1L;
    private JLabel img2L;
    private JLabel img3L;
    private JLabel img4L;
    private JLabel contour,contour2L;
    private JLabel pinumL,pindoisL,pintresL,pinquatroL;
    
    private JScrollPane informacaoViagemscrollPane;
    private SpinnerModel escreve_montante= new SpinnerNumberModel(100, 20, 99999, 1); ;
    private JSpinner spinner = new JSpinner(escreve_montante);
    private String localum = "";
    private String localdois = "";
    private String localtres = "";
    private Local loc1=null,loc2=null,loc3=null;
    private ArrayList<PontoInteresse> piPrimeiroLocal = new ArrayList<>();
    private ArrayList<PontoInteresse> piSegundoLocal = new ArrayList<>();
    private ArrayList<PontoInteresse> piTerceiroLocal = new ArrayList<>();
    private ArrayList<PontoInteresse> pitotal = new ArrayList<>();
    private String[] viagemEmString;
    private String[] piLocalum={"Nenhum"};
    private String[] piLocaldois={"Nenhum"};
    private String[] piLocaltres={"Nenhum"};
    private ArrayList<String> piLocaltodos = new ArrayList<>();
    private ArrayList<String> combo_opcoesLocal= new ArrayList<>(),aux_opcoesPontos= new ArrayList<>();
    private ArrayList<String> viagens = new ArrayList<String>();
    private String[] piLocaltodos_string  ={""};
    private JList lista_viagens;
    private JList primeiroLocalPiList,segundoLocalPiList,terceiroLocalPiList,todosPiList;
    private JList informacaoViagem;
    private String[] informacaoViagemString ={""};
    private ArrayList<String> informacaoViagemArrayList = new ArrayList<>();
    private ArrayList<String> combo_opcoes_hot_evita=new ArrayList<>();
    private ArrayList<PontoInteresse> todos_pontos_interesse= new ArrayList<>();
    private Viagem novaViagemaux;
    private Viagem novaViagem;
    private Viagem viagemVisualiza = null;
    private Viagem viagemSelecionada = null;
    private int indice_hot_evita=0;
    private String auxiliar_evita = "";
    private PontoInteresse helper;
    private Local helperEvita;
    private boolean hot_evita_bool=true;
    /**
     *
     * @param locs Arraylist de Locais a serem carregados para o programa
     * @param dists matriz irregular que contem as distancias entre locais
     * @param user Arraylist com os utilizadores que ja se registaram no programa
     */
    public GUI(ArrayList<Local> locs,int [][] dists,Utilizador user){
        super("Fullscreen");
        String nome_user=user.getNome();
        user_seleccionado=user;
        locais = locs;
        matriz_distancias = dists;
        combo_opcoesLocal.add("Selecione o local");
        aux_opcoesPontos.add("Selecione o Ponto de Interesse");
        todos_pontos_interesse.addAll(getsTodosPontoInteresses());
        //todos_locais
        aux_opcoesPontos.addAll(getSTRTodosPontosInteresse());
        combo_opcoesLocal.addAll(getSTRTodosLocais());
        
        if (user instanceof Licenciatura){
            combo_opcoes_hot_evita=aux_opcoesPontos;
        }
        else if(user instanceof Mestrado){
            combo_opcoes_hot_evita=combo_opcoesLocal;
        }
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        
        welcome = new JLabel("Bem Vindo "+nome_user);
        welcome.setBounds(25, 5, 1500, 100);
        welcome.setFont(new Font("abadi", Font.BOLD, 45));
        welcome.setForeground(Color.WHITE);

        panelPrincipal.add(welcome);
        
        exiButton=new JButton("SAIR");
        exiButton.setBounds(20,960,250,50);
        exiButton.setFont(new Font("abadi", Font.BOLD, 25));
        
        voltarButton=new JButton("NOVO LOGIN");
        voltarButton.setBounds(20,900,250,50);
        voltarButton.setFont(new Font("abadi", Font.BOLD, 25));
        escuta_voltar=new ButtonListenerSair();
        voltarButton.addActionListener(escuta_voltar);
        panelPrincipal.add(voltarButton);
        
        escuta_exit=new ButtonListenerSair();
        exiButton.addActionListener(escuta_exit);
        panelPrincipal.add(exiButton);
        
        montante = new JLabel("Indique a quatia:");
        montante.setBounds(25, 70, 250, 100);
        montante.setFont(new Font("abadi", Font.BOLD, 30));
        montante.setForeground(Color.WHITE);
        panelPrincipal.add(montante);
        
        euros = new JLabel("Euros");
        euros.setBounds(148, 113, 250, 100);
        euros.setFont(new Font("abadi", Font.BOLD, 30));
        euros.setForeground(Color.WHITE);
        panelPrincipal.add(euros);
        
        if (user instanceof Licenciatura)
            hotouevita = new JLabel("Hot");
        else
            hotouevita = new JLabel("Evita");
        hotouevita.setBounds(25, 170, 350, 100);
        hotouevita.setFont(new Font("abadi", Font.BOLD, 30));
        hotouevita.setForeground(Color.WHITE);
        panelPrincipal.add(hotouevita);
        
        spinner.setFont(new Font("abadi", Font.BOLD, 30));
        spinner.setBounds(40, 150, 100, 30);
        spinner.addChangeListener(new SliderListener());
        panelPrincipal.add(spinner);
        
        
        hot_evita = new JComboBox(combo_opcoes_hot_evita.toArray(new String[combo_opcoes_hot_evita.size()])); 
        hot_evita.setBounds(25, 250, 340, 40);
        hot_evita.setFont(new Font("abadi", Font.BOLD, 17));
        hot_evita.addActionListener(new ComboListenerHotEvita());
        
        panelPrincipal.add(hot_evita);
        
        
        viagens_possiveis = new JLabel("Viagens Geradas:");
        viagens_possiveis.setBounds(380, 20, 400, 200);
        viagens_possiveis.setFont(new Font("abadi", Font.BOLD, 30));
        viagens_possiveis.setForeground(Color.WHITE);
        panelPrincipal.add(viagens_possiveis);
        viagemEmString = viagens.toArray(new String[viagens.size()]);
        lista_viagens = new JList(viagemEmString);
        lista_viagens.setSelectedIndex(0);
        lista_viagens.setFont(new Font("abadi", Font.BOLD, 22));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(lista_viagens);
        scrollPane.setBounds(380, 140, 420, 150);
        panelPrincipal.add(scrollPane);
        
        
        if (user_seleccionado.getViagem() != null) {
           
            writeTripSelected(user_seleccionado.getViagem());
        }
        
        
        primeiroLocal = new JLabel("Primeiro local:");
        primeiroLocal.setBounds(25, 310, 250, 40);
        primeiroLocal.setFont(new Font("abadi", Font.BOLD, 30));
        primeiroLocal.setForeground(Color.WHITE);
        panelPrincipal.add(primeiroLocal);
        
        primeiroLocalCombo = new JComboBox(combo_opcoesLocal.toArray(new String[combo_opcoesLocal.size()])); 
        primeiroLocalCombo.addActionListener(new ComboListenerum());
        primeiroLocalCombo.setBounds(25, 360, 250, 40);
        primeiroLocalCombo.setFont(new Font("abadi", Font.BOLD, 20));
        panelPrincipal.add(primeiroLocalCombo);
        
        
        primeiroLocalPI = new JLabel("Pontos de Interesse:");
        primeiroLocalPI.setBounds(380, 290, 300, 40);
        primeiroLocalPI.setFont(new Font("abadi", Font.BOLD, 30));
        primeiroLocalPI.setForeground(Color.WHITE);
        panelPrincipal.add(primeiroLocalPI);        
        primeiroLocalPIaux = new JLabel("Pontos de Interesse:");
        primeiroLocalPIaux.setBounds(377, 293, 300, 40);
        primeiroLocalPIaux.setFont(new Font("abadi", Font.BOLD, 31));
        primeiroLocalPIaux.setForeground(Color.BLACK);
        panelPrincipal.add(primeiroLocalPIaux);
        
        
        primeiroLocalPiList = new JList(piLocalum);
        primeiroLocalPiList.setSelectedIndex(0);
        primeiroLocalPiList.setFont(new Font("abadi", Font.BOLD, 20));
        JScrollPane primeiroLocalPiListscrollPane = new JScrollPane();
        primeiroLocalPiListscrollPane.setViewportView(primeiroLocalPiList);
        primeiroLocalPiListscrollPane.setBounds(380, 340, 500, 100);
        panelPrincipal.add(primeiroLocalPiListscrollPane);
                
        segundoLocal = new JLabel("Segundo local:");
        segundoLocal.setBounds(25, 450, 250, 40);
        segundoLocal.setFont(new Font("Serif", Font.BOLD, 30));
        segundoLocal.setForeground(Color.WHITE);
        panelPrincipal.add(segundoLocal);
        
        segundoLocalCombo = new JComboBox(combo_opcoesLocal.toArray(new String[combo_opcoesLocal.size()])); 
        segundoLocalCombo.addActionListener(new ComboListenerdois());
        segundoLocalCombo.setBounds(25, 500, 250, 40);
        segundoLocalCombo.setFont(new Font("abadi", Font.BOLD, 20));
        panelPrincipal.add(segundoLocalCombo);
        
        segundoLocalPI = new JLabel("Pontos de Interesse:");
        segundoLocalPI.setBounds(380, 440, 300, 40);
        segundoLocalPI.setFont(new Font("abadi", Font.BOLD, 30));
        segundoLocalPI.setForeground(Color.WHITE);
        panelPrincipal.add(segundoLocalPI);        
        segundoLocalPIaux = new JLabel("Pontos de Interesse:");
        segundoLocalPIaux.setBounds(377, 443, 300, 40);
        segundoLocalPIaux.setFont(new Font("abadi", Font.BOLD, 31));
        segundoLocalPIaux.setForeground(Color.BLACK);
        panelPrincipal.add(segundoLocalPIaux);
        
        
        segundoLocalPiList = new JList(piLocaldois);
        segundoLocalPiList.setSelectedIndex(0);
        segundoLocalPiList.setFont(new Font("abadi", Font.BOLD, 20));
        JScrollPane segundoLocalPiListscrollPane = new JScrollPane();
        segundoLocalPiListscrollPane.setViewportView(segundoLocalPiList);
        segundoLocalPiListscrollPane.setBounds(380, 490, 500, 100);
        panelPrincipal.add(segundoLocalPiListscrollPane);
        
        
        terceiroLocal = new JLabel("Terceiro local:");
        terceiroLocal.setBounds(25, 590, 250, 40);
        terceiroLocal.setFont(new Font("abadi", Font.BOLD, 30));
        terceiroLocal.setForeground(Color.WHITE);
        panelPrincipal.add(terceiroLocal);
        
        terceiroLocalCombo = new JComboBox(combo_opcoesLocal.toArray(new String[combo_opcoesLocal.size()])); 
        terceiroLocalCombo.addActionListener(new ComboListenertres());
        terceiroLocalCombo.setBounds(25, 640, 250, 40);
        terceiroLocalCombo.setFont(new Font("abadi", Font.BOLD, 20));
        panelPrincipal.add(terceiroLocalCombo);
        
        terceiroLocalPI = new JLabel("Pontos de Interesse:");
        terceiroLocalPI.setBounds(380, 590, 300, 40);
        terceiroLocalPI.setFont(new Font("abadi", Font.BOLD, 30));
        terceiroLocalPI.setForeground(Color.WHITE);
        panelPrincipal.add(terceiroLocalPI);      
        terceiroLocalPIaux = new JLabel("Pontos de Interesse:");
        terceiroLocalPIaux.setBounds(377, 593, 300, 40);
        terceiroLocalPIaux.setFont(new Font("abadi", Font.BOLD, 31));
        terceiroLocalPIaux.setForeground(Color.BLACK);
        panelPrincipal.add(terceiroLocalPIaux);
        
        terceiroLocalPiList = new JList(piLocaltres);
        terceiroLocalPiList.setSelectedIndex(0);
        terceiroLocalPiList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        terceiroLocalPiList.setSelectedIndices(terceiroLocalPiList.getSelectedIndices());
        terceiroLocalPiList.setFont(new Font("abadi", Font.BOLD, 20));
        JScrollPane terceiroLocalPiListscrollPane = new JScrollPane();
        terceiroLocalPiListscrollPane.setViewportView(terceiroLocalPiList);
        terceiroLocalPiListscrollPane.setBounds(380, 640, 500, 100);
        panelPrincipal.add(terceiroLocalPiListscrollPane);
        
        
        favButton=new JButton("FAVORITOS");
        favButton.setBounds(20,840,250,50);
        favButton.setFont(new Font("abadi", Font.BOLD, 25));
        favButton.addActionListener(new favListener() ); 
        panelPrincipal.add(favButton);
        
        pum = new JButton("ADD");
        pum.setBounds(900, 375, 70, 40);
        listenum = new umButtonListener(); 
        pum.setFont(new Font("abadi", Font.BOLD, 15));
        pum.addActionListener(listenum); 
        panelPrincipal.add(pum);
        
        pdois = new JButton("ADD");
        pdois.setBounds(900, 520, 70, 40);
        listendois = new doisButtonListener(); 
        pdois.setFont(new Font("abadi", Font.BOLD, 15));
        pdois.addActionListener(listendois); 
        panelPrincipal.add(pdois);
        
        ptres = new JButton("ADD");
        ptres.setBounds(900, 665, 70, 40);
        listentres = new tresButtonListener(); 
        ptres.setFont(new Font("abadi", Font.BOLD, 15));
        ptres.addActionListener(listentres); 
        panelPrincipal.add(ptres);
        
        premove = new JButton("POP");
        premove.setBounds(900, 865, 70, 40);
        listenremove = new removeButtonListener(); 
        premove.setFont(new Font("abadi", Font.BOLD, 15));
        premove.addActionListener(listenremove); 
        panelPrincipal.add(premove);
                
        gerar_viagens = new JButton("GERAR VIAGENS");
        gerar_viagens.setBounds(20, 780, 250, 50);
        geraViagensListener = new ButtonGeraViagensListener(); 
        gerar_viagens.setFont(new Font("abadi", Font.BOLD, 25));
        gerar_viagens.addActionListener(geraViagensListener); 
        panelPrincipal.add(gerar_viagens);
        
        verViagem = new JButton("VER");
        verViagem.setBounds(825, 145, 70, 40);
        verViagemListeer = new ButtonVerViagemListeer(); 
        verViagem.setFont(new Font("abadi", Font.BOLD, 15));
        verViagem.addActionListener(verViagemListeer); 
        panelPrincipal.add(verViagem);
        
        limpaViagem = new JButton("LIMPA");
        limpaViagem.setBounds(1800, 1000, 100, 40);
        limpaViagemListeer = new ButtonLimpaViagemListeer();
        limpaViagem.setFont(new Font("abadi", Font.BOLD, 15));
        limpaViagem.addActionListener(limpaViagemListeer);
        panelPrincipal.add(limpaViagem);
        
        retiraViagem = new JButton("POP");
        retiraViagem.setBounds(825, 195, 70, 40);
        retiraViagemListeer = new ButtonRetiraViagemListeer();
        retiraViagem.setFont(new Font("abadi", Font.BOLD, 15));
        retiraViagem.addActionListener(retiraViagemListeer);
        panelPrincipal.add(retiraViagem);
        
        selectButton = new JButton("SELECT");
        selectButton.setBounds(810, 245, 100, 40);
        listenselect = new selectButtonListener(); 
        selectButton.setFont(new Font("abadi", Font.BOLD, 15));
        selectButton.addActionListener(listenselect); 
        panelPrincipal.add(selectButton);
        
        todosPi = new JLabel("     Todos os Pontos de Interesse:");
        todosPi.setBounds(380, 745, 500, 40);
        todosPi.setFont(new Font("abadi", Font.BOLD, 30));
        todosPi.setForeground(Color.WHITE);
        todosPi.setBackground(Color.BLACK);
        todosPi.setOpaque(true);
        panelPrincipal.add(todosPi);        
        
        custoTotal = new JLabel("Custo Total");
        custoTotal.setBounds(25, 685, 250, 40);
        custoTotal.setFont(new Font("abadi", Font.BOLD, 30));
        custoTotal.setForeground(Color.WHITE);
        panelPrincipal.add(custoTotal);
        
        textodoCusto = new JTextField(10);
        textodoCusto.setEditable(false);
        textodoCusto.setBounds(25, 725, 250, 40);
        textodoCusto.setFont(new Font("abadi", Font.BOLD, 30));
        textodoCusto.setForeground(Color.GREEN);
        textodoCusto.setOpaque(false);
        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
        textodoCusto.setHorizontalAlignment(JTextField.CENTER);
        panelPrincipal.add(textodoCusto);
        
        todosPiList = new JList(piLocaltodos_string);
        todosPiList.setSelectedIndex(0);
        todosPiList.setSelectedIndices(todosPiList.getSelectedIndices());
        todosPiList.setFont(new Font("abadi", Font.BOLD, 20));
        JScrollPane todosLocalPiListscrollPane = new JScrollPane();
        todosLocalPiListscrollPane.setViewportView(todosPiList);
        todosLocalPiListscrollPane.setBounds(380, 790, 500, 200);
        panelPrincipal.add(todosLocalPiListscrollPane);
        
        //DISTANCIAS E CUSTOS
        custoZero = new JLabel("");
        custoZero.setBounds(1070,210,180,180);
        custoZero.setFont(new Font("Serif", Font.BOLD, 23));
        custoZero.setForeground(Color.GREEN);
        panelPrincipal.add(custoZero);
        
        custoPrimeiro = new JLabel("");
        custoPrimeiro.setBounds(1180,210,180,180);
        custoPrimeiro.setHorizontalAlignment(JLabel.CENTER);
        custoPrimeiro.setFont(new Font("Serif", Font.BOLD, 23));
        custoPrimeiro.setForeground(Color.GREEN);
        panelPrincipal.add(custoPrimeiro);
        
        custoSegundo = new JLabel("");
        custoSegundo.setBounds(1380,210,180,180);
        custoSegundo.setHorizontalAlignment(JLabel.CENTER);
        custoSegundo.setFont(new Font("Serif", Font.BOLD, 23));
        custoSegundo.setForeground(Color.GREEN);
        panelPrincipal.add(custoSegundo);
        
        
        custoTerceiro = new JLabel("");
        custoTerceiro.setBounds(1580,210,180,180);
        custoTerceiro.setHorizontalAlignment(JLabel.CENTER);
        custoTerceiro.setFont(new Font("Serif", Font.BOLD, 23));
        custoTerceiro.setForeground(Color.GREEN);
        panelPrincipal.add(custoTerceiro);
        
        custoFinal = new JLabel("");
        custoFinal.setBounds(1700,210,180,180);
        custoFinal.setHorizontalAlignment(JLabel.RIGHT);
        custoFinal.setFont(new Font("Serif", Font.BOLD, 23));
        custoFinal.setForeground(Color.GREEN);
        panelPrincipal.add(custoFinal);
        
        distanciaZero = new JLabel("");
        distanciaZero.setBounds(1070,250,180,180);
        distanciaZero.setFont(new Font("Serif", Font.BOLD, 23));
        distanciaZero.setForeground(Color.YELLOW);
        panelPrincipal.add(distanciaZero);
        
        distanciaPrimeiro = new JLabel("");
        distanciaPrimeiro.setBounds(1180,250,180,180);
        distanciaPrimeiro.setHorizontalAlignment(JLabel.CENTER);
        distanciaPrimeiro.setFont(new Font("Serif", Font.BOLD, 23));
        distanciaPrimeiro.setForeground(Color.YELLOW);
        panelPrincipal.add(distanciaPrimeiro);
        
        
        distanciaSegundo = new JLabel("");
        distanciaSegundo.setBounds(1380,250,180,180);
        distanciaSegundo.setHorizontalAlignment(JLabel.CENTER);
        distanciaSegundo.setFont(new Font("Serif", Font.BOLD, 23));
        distanciaSegundo.setForeground(Color.YELLOW);
        panelPrincipal.add(distanciaSegundo);
        
        
        
        distanciaTerceiro = new JLabel("");
        distanciaTerceiro.setBounds(1580,250,180,180);
        distanciaTerceiro.setHorizontalAlignment(JLabel.CENTER);
        distanciaTerceiro.setFont(new Font("Serif", Font.BOLD, 23));
        distanciaTerceiro.setForeground(Color.YELLOW);
        panelPrincipal.add(distanciaTerceiro);
        
        
        
        distanciaFinal = new JLabel("");
        distanciaFinal.setBounds(1700,250,180,180);
        distanciaFinal.setHorizontalAlignment(JLabel.RIGHT);
        distanciaFinal.setFont(new Font("Serif", Font.BOLD, 23));
        distanciaFinal.setForeground(Color.YELLOW);
        panelPrincipal.add(distanciaFinal);
        
        
        tituloViagem = new JLabel("");
        tituloViagem.setBounds(1100,20,800,40);
        tituloViagem.setHorizontalAlignment(JLabel.CENTER);
        tituloViagem.setFont(new Font("abadi", Font.BOLD, 40));
        tituloViagem.setForeground(Color.WHITE);
        panelPrincipal.add(tituloViagem);
        
        
        avisoSeleciona = new JLabel("");
        avisoSeleciona.setBounds(1100,390,800,40);
        avisoSeleciona.setHorizontalAlignment(JLabel.CENTER);
        avisoSeleciona.setFont(new Font("abadi", Font.BOLD, 40));
        avisoSeleciona.setForeground(Color.GREEN);
        panelPrincipal.add(avisoSeleciona);
        
        avisoSelecionaaux = new JLabel("");
        avisoSelecionaaux.setBounds(1103,393,800,40);
        avisoSelecionaaux.setHorizontalAlignment(JLabel.CENTER);
        avisoSelecionaaux.setFont(new Font("abadi", Font.BOLD, 40));
        avisoSelecionaaux.setForeground(Color.BLACK);
        panelPrincipal.add(avisoSelecionaaux);
        
        hotEvitaLabel = new JLabel("");
        hotEvitaLabel.setBounds(1060,1000,800,40);
        hotEvitaLabel.setHorizontalAlignment(JLabel.CENTER);
        hotEvitaLabel.setFont(new Font("abadi", Font.BOLD, 30));
        hotEvitaLabel.setForeground(Color.BLACK);
        panelPrincipal.add(hotEvitaLabel);
        
        hotEvitaLabelaux = new JLabel("");
        hotEvitaLabelaux.setBounds(1063,1003,800,40);
        hotEvitaLabelaux.setHorizontalAlignment(JLabel.CENTER);
        hotEvitaLabelaux.setFont(new Font("abadi", Font.BOLD, 30));
        hotEvitaLabelaux.setForeground(Color.ORANGE);
        panelPrincipal.add(hotEvitaLabelaux);
        
        tituloViagemaux = new JLabel("");
        tituloViagemaux.setBounds(1103,23,800,40);
        tituloViagemaux.setHorizontalAlignment(JLabel.CENTER);
        tituloViagemaux.setFont(new Font("abadi", Font.BOLD, 40));
        tituloViagemaux.setForeground(Color.BLACK);
        panelPrincipal.add(tituloViagemaux);
        
        
        informacaoViagem = new JList(informacaoViagemString);
        informacaoViagem.setFont(new Font("abadi", Font.BOLD, 17));
        informacaoViagemscrollPane = new JScrollPane();
        informacaoViagemscrollPane.setViewportView(informacaoViagem);
        informacaoViagemscrollPane.setBounds(1050,450,850,530);
        informacaoViagemscrollPane.setVisible(false);
        panelPrincipal.add(informacaoViagemscrollPane);
        
        
        
        
        //IMAGENS
        
        
        try{
            
           
            
            pinumL = new JLabel(nada);
            pinumL.setBounds(1710,40,100,100);
            panelPrincipal.add(pinumL);
            
            pindoisL = new JLabel(nada);
            pindoisL.setBounds(1510,40,100,100);
            panelPrincipal.add(pindoisL);
            
            pintresL = new JLabel(nada);
            pintresL.setBounds(1310,40,100,100);
            panelPrincipal.add(pintresL);
            
            pinquatroL = new JLabel(nada);
            pinquatroL.setBounds(1110,40,100,100);
            panelPrincipal.add(pinquatroL);
            
            
            nada = new ImageIcon(ImageIO.read(new File("nada.png")));
            nada = new ImageIcon(nada.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH));
            img1L = new JLabel(nada);
            img1L.setBounds(1080,100,180,180);
            panelPrincipal.add(img1L);
            
            
            img2L = new JLabel(nada);
            img2L.setBounds(1280,100,180,180);
            img2L.setBackground(Color.BLACK);
            panelPrincipal.add(img2L);
            
            
            img3L = new JLabel(nada);
            img3L.setBounds(1480,100,180,180);
            panelPrincipal.add(img3L);
            
            
            img4L = new JLabel(nada);
            img4L.setBounds(1680,100,180,180);
            panelPrincipal.add(img4L);
            
            
           
            contour = new JLabel(nada);
            contour.setBounds(1050,80,850,290);
            panelPrincipal.add(contour);
            
            contour2 = new ImageIcon(ImageIO.read(new File("efeito.jpg")));
            contour2 = new ImageIcon(contour2.getImage().getScaledInstance(1470,500, Image.SCALE_SMOOTH));
            
            contour2L = new JLabel(nada);
            contour2L.setBounds(1040,70,870,310);
            panelPrincipal.add(contour2L);
            
            bg = new ImageIcon(ImageIO.read(new File("background.jpeg")));
            bg = new ImageIcon(bg.getImage().getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_SMOOTH));
            background = new JLabel(bg);
            background.setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
            panelPrincipal.add(background);
        }catch (Exception exe) {
        }
        
        this.add(panelPrincipal);

    }
    
    /**
     * 
     * @param users Arraylist com os utilizadores que ja se registaram no programa
     * @throws IOException -
     */
    public GUI(ArrayList<Utilizador> users) throws IOException{
        super("Fullscreen");
        texto_user_seleccionado="ADD USER+++"; 
        users_cpy=users;
        if (!users.isEmpty()){
            
            for (Iterator<Utilizador> iterator = users_cpy.iterator(); iterator.hasNext();) {
                Utilizador next = iterator.next();
                nomes_users.add(next.getNome());
                
            }
        }

        
        
        Font titleFont = new Font("bauhaus 93", Font.BOLD, 80);
        Font labels_font = new Font("abadi", Font.BOLD,30);
        Font buttonFont = new Font("abadi", Font.BOLD, 30);
        //panel
        panel_user= new JPanel();
        panel_user.setLayout(null);
        
        //labels
        
        label_name=new JLabel("NOME:");
        label_ciclo=new JLabel("CICLO:");
        title=new JLabel("AGENCIAS UERBA");
        label_user_combo= new JLabel("USER:");
        sec_label_name=new JLabel("NOME:");
        sec_label_ciclo=new JLabel("CICLO:");
        sec_title=new JLabel("AGENCIAS UERBA");
        trd_title=new JLabel("AGENCIAS UERBA");
        sec_label_user=new JLabel("USER:");
        num_label=new JLabel("NUM:");
        sec_num_label=new JLabel("NUM:");
        
        
        
        title.setBounds(600,100,800,100);
        label_name.setBounds(650,450,400,100);
        label_ciclo.setBounds(650,750,270,100);
        num_label.setBounds(650,600,270,100);
        sec_num_label.setBounds(651,599,270,100);
        label_user_combo.setBounds(650,300,400,100);
        sec_label_user.setBounds(651,299,400,100);
        sec_title.setBounds(604,96,800,100);
        sec_label_name.setBounds(651,449,400,100);
        sec_label_ciclo.setBounds(651,749,270,100);
        trd_title.setBounds(602,98,800,100);
        
        title.setFont(titleFont);
        sec_title.setFont(titleFont);
        sec_title.setForeground(new Color(255,255,255));
        sec_label_ciclo.setForeground(new Color(255,255,255));
        sec_label_user.setForeground(new Color(255,255,255));
        sec_label_name.setForeground(new Color(255,255,255));
        sec_num_label.setForeground(new Color(255,255,255));
        trd_title.setFont(titleFont);
        trd_title.setForeground(new Color(253,163,26));
        label_name.setFont(labels_font);
        num_label.setFont(labels_font);
        label_user_combo.setFont(labels_font);
        label_user_combo.enableInputMethods(true);
        label_ciclo.enableInputMethods(true);
        label_ciclo.setFocusable(false);
        label_ciclo.setFont(labels_font);
        sec_label_user.setFont(labels_font);
        sec_label_name.setFont(labels_font);
        sec_label_ciclo.setFont(labels_font);
        sec_num_label.setFont(labels_font);
        
        //text field
        name_user= new JTextField(30);
        name_user.setBounds(755,480,550,50);
        name_user.setFont(buttonFont);
        name_user.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e){
                    String aux="";
                    
                    aux=name_user.getText();
                    verifica_nome_estudante(aux);
                }
            });
        if (texto_user_seleccionado.equals("ADD USER+++"))
            name_user.setEditable(true);
        else
            name_user.setEditable(false);
        num_user= new JTextField(30);
        num_user.setBounds(755,630,550,50);
        num_user.setFont(buttonFont);
        cusco1=new EscutaKey();
        num_user.addKeyListener(cusco1);
        if (texto_user_seleccionado.equals("ADD USER+++"))
            num_user.setEditable(true);
        else
            num_user.setEditable(false);
        
        
  
        ciclo=new JComboBox(text_ciclo.toArray());
        ciclo.setBounds(755,780,550,50);
        user_combo=new JComboBox(nomes_users.toArray());
        user_combo.setBounds(755,330,550,50);
        
        //button
        
        lets_go=new JButton("LET'SA GO!!");
        lets_go.setBounds(825,920,300,80);
        lets_go.setEnabled(false);
        lets_go.setFont(buttonFont);
        cusco2=new doisEscutaTeclas();
        lets_go.addKeyListener(cusco2);
        but_sair=new JButton("SAIR");
        but_sair.setBounds(1125,920,300,80);
        but_sair.setEnabled(true);
        cusco3=new doisEscutaTeclas();
        but_sair.addKeyListener(cusco3);
        but_sair.setFont(buttonFont);
        
        but_remove=new JButton("REMOVER");
        but_remove.setBounds(525,920,300,80);
        but_remove.setFont(buttonFont);
        escuta_remove= new ButtonlistenerRemove();
        but_sair.addKeyListener(cusco4);
        but_remove.addActionListener(escuta_remove);
        but_remove.setEnabled(false);
        
        // IMAGE
        
        try{
        
        imagem_user = new ImageIcon(ImageIO.read(new File("sunset.jpg")));
        imagem_user = new ImageIcon(imagem_user.getImage().getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_SMOOTH));
        image = new JLabel(imagem_user);
        image.setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        }catch (Exception exe) {
        }
        
        //listeners
        escuta_butao = new ButtonListener();
        lets_go.addActionListener(escuta_butao);
        
        escuta_combo=new ComboListener();
        ciclo.addActionListener(escuta_combo);
        ciclo.setFont(buttonFont);
        
        escuta_user_combo=new UserComboListener();
        user_combo.addActionListener(escuta_user_combo);
        user_combo.setFont(buttonFont);
        
        escuta_sair=new ButtonListenerSair();
        but_sair.addActionListener(escuta_sair);
        
        /*escuta_add=new ButtonListenerAdd();
        but_add.addActionListener(escuta_add);*/
        
        escuta_texto=new TextListener();
        name_user.addActionListener(escuta_texto);
        escuta_num=new TextListener();
        num_user.addActionListener(escuta_num);
        // name_user.addKeyListener(l);
        warning_num.setBackground(new Color(0,0,0));
        warning_num.setVisible(true);

        panel_user.add(but_remove);
        panel_user.add(num_user);
        panel_user.add(num_label);
        panel_user.add(sec_num_label);
        panel_user.add(label_ciclo);
        panel_user.add(label_name);
        panel_user.add(sec_label_ciclo);
        panel_user.add(sec_label_name);
        panel_user.add(title);
        panel_user.add(name_user);
        panel_user.add(ciclo);
        panel_user.add(lets_go);
        panel_user.add(trd_title);
        panel_user.add(sec_title);
        panel_user.add(label_user_combo);
        panel_user.add(sec_label_user);
        panel_user.add(user_combo);
        panel_user.add(but_sair);
        panel_user.add(image);
        
        this.add(panel_user);

    }
    
    /**
     * Listener da combobox que se encontra por baixo da label Evita caso seja um aluno de Mestrado ou Hot caso seja de licenciatura
     */
    private class ComboListenerHotEvita implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String combo = (String)cb.getSelectedItem();
            int ind = (int)cb.getSelectedIndex();
            indice_hot_evita=ind;
            
            
            
            if (user_seleccionado instanceof Licenciatura){
                helper = todos_pontos_interesse.get(ind-1);
                


            }
            if(user_seleccionado instanceof Mestrado){
                helperEvita = locais.get(ind-1);
                
                if(ind==primeiroLocalCombo.getSelectedIndex() || ind==segundoLocalCombo.getSelectedIndex() ||ind==terceiroLocalCombo.getSelectedIndex()){
                    cb.setSelectedIndex(0);
                //....
                }
                

            }
               
            
        }
    }
    
    /**
     * Listener do botao responsavel oor eliminar utilizadores
     */
    private class ButtonlistenerRemove implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int variavel=-1;
            do{
                String[] opcoes = new String[] {"SIM","NAO"};
                variavel = JOptionPane.showOptionDialog( null, "Tem a certeza que pretende remover o Utilizador?","Message",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opcoes, opcoes[0]);
                }while (variavel == JOptionPane.CLOSED_OPTION);
    
 
                if (variavel == 0) {
                    
                    users_cpy.remove(user_seleccionado);
                    nomes_users.remove(nomes_users.get(user_combo.getSelectedIndex()));
                    user_combo.removeItemAt(user_combo.getSelectedIndex());
                    user_combo.setSelectedIndex(0);
                }
                else
                    return;
        }
        
    }
    
    /**
     * Listener da tecla enter para os butoes da interface do login
     */
    private class doisEscutaTeclas implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                if (e.getSource()==but_sair)
                    but_sair.doClick(100);
                if(e.getSource()==lets_go)
                    lets_go.doClick(100);
                if(e.getSource()==but_remove)
                    lets_go.doClick(100);
            }
            }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
        
    }
    
    /**
     * Listener da combobox que possiu os locais do primeiro local a escolher
     */
    private class ComboListenerum implements ActionListener  { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            if(user_seleccionado instanceof Mestrado){
                if(hot_evita.getSelectedIndex()==primeiroLocalCombo.getSelectedIndex() ){
                    primeiroLocalCombo.setSelectedIndex(0);
                //....
            }
            }
            set_combo_um();
        }
    }
    
    /**
     * Listener da combobox que possiu os locais do segundo local a escolher
     */
    private class ComboListenerdois implements ActionListener  { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if(user_seleccionado instanceof Mestrado){
                if(hot_evita.getSelectedIndex() ==segundoLocalCombo.getSelectedIndex() ){
                    segundoLocalCombo.setSelectedIndex(0);
                //....
            }
            }
            set_combo_dois();
          
        }
    }
    
    /**
     * Listener da combobox que possiu os locais do terceiro local a escolher
     */
    private class ComboListenertres implements ActionListener  { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            if(user_seleccionado instanceof Mestrado){
                if(hot_evita.getSelectedIndex()==terceiroLocalCombo.getSelectedIndex()){
                    terceiroLocalCombo.setSelectedIndex(0);
                //....
            }
            }
            set_combo_tres();
        }
    }
    
    /**
     * Listener o slider que controla a quantidade de dinheiro que o utilizador esta disposto a paga pela viagem
     */
    private class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            
            montante_int = (int) spinner.getValue();
            if (custoViagem > montante_int)
                textodoCusto.setForeground(Color.RED);
            else
                textodoCusto.setForeground(Color.GREEN);
        }
    }
    
    /**
     * Listener do botao que nos mostra todos os detalhes de certa viagem
     */
    private class ButtonVerViagemListeer implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent e) { 
            int opcao=-1;
            try {
                String aux = lista_viagens.getSelectedValue().toString();
                int ind = viagens.indexOf(aux);
                viagemVisualiza = viagemGeradas.get(ind);
            
                do{
                String[] opcoes = new String[] {"Crescente","Descrecente"};
                opcao = JOptionPane.showOptionDialog( null, "Ordem de precos por local","Message",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opcoes, opcoes[0]);
                }while (opcao == JOptionPane.CLOSED_OPTION);
            } catch (Exception exxx) {
                JOptionPane.showMessageDialog(null, "Selecione uma viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            // VIZUALIZACAO DAS IMAGENS
            limpa_esquerda();
            try{
            String nomeimagemUm = "Coimbra";
            nomeimagemUm = nomeimagemUm.concat(viagemVisualiza.getLocais()[0].getNome());
            nomeimagemUm = nomeimagemUm.concat(".png");

            img1 = new ImageIcon(ImageIO.read(new File(nomeimagemUm)));
            img1 = new ImageIcon(img1.getImage().getScaledInstance(180,180, Image.SCALE_SMOOTH));
            float total_custo=0;
            float total_distancia=0;
            custoZero.setText("0 euros");
            distanciaZero.setText("0km");
            informacaoViagemscrollPane.setVisible(true);
            pin = new ImageIcon(ImageIO.read(new File("pin.png")));
            pin = new ImageIcon(pin.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
            contour2 = new ImageIcon(ImageIO.read(new File("efeito.jpg")));
            contour2 = new ImageIcon(contour2.getImage().getScaledInstance(1470,500, Image.SCALE_SMOOTH));
            total_custo += matriz_distancias[viagemVisualiza.getLocais()[0].getId()][0]*0.05;
            total_distancia += matriz_distancias[viagemVisualiza.getLocais()[0].getId()][0];
            custoPrimeiro.setText((df.format(total_custo)+" euros"));
            distanciaPrimeiro.setText((df.format(total_distancia)+"km"));
            String nomeimagemdois = "";
            if (viagemVisualiza.getLocais()[0].getId() < viagemVisualiza.getLocais()[1].getId())
            {
                nomeimagemdois = nomeimagemdois.concat(viagemVisualiza.getLocais()[0].getNome());
                nomeimagemdois = nomeimagemdois.concat(viagemVisualiza.getLocais()[1].getNome());
                total_custo += matriz_distancias[viagemVisualiza.getLocais()[1].getId()][viagemVisualiza.getLocais()[0].getId()]*0.05;
                total_distancia += matriz_distancias[viagemVisualiza.getLocais()[1].getId()][viagemVisualiza.getLocais()[0].getId()];
            }
            else 
            {
                nomeimagemdois = nomeimagemdois.concat(viagemVisualiza.getLocais()[1].getNome());
                nomeimagemdois = nomeimagemdois.concat(viagemVisualiza.getLocais()[0].getNome());
                total_custo += matriz_distancias[viagemVisualiza.getLocais()[0].getId()][viagemVisualiza.getLocais()[1].getId()]*0.05;
                total_distancia += matriz_distancias[viagemVisualiza.getLocais()[0].getId()][viagemVisualiza.getLocais()[1].getId()];
            }
            custoSegundo.setText((df.format(total_custo)+" euros"));
            distanciaSegundo.setText((df.format(total_distancia)+"km"));
            nomeimagemdois = nomeimagemdois.concat(".png");

            img2 = new ImageIcon(ImageIO.read(new File(nomeimagemdois)));
            img2 = new ImageIcon(img2.getImage().getScaledInstance(180,180, Image.SCALE_SMOOTH));
            
            
            String nomeimagemtres = "";
            if (viagemVisualiza.getLocais()[1].getId() < viagemVisualiza.getLocais()[2].getId())
            {
                total_custo += matriz_distancias[viagemVisualiza.getLocais()[2].getId()][viagemVisualiza.getLocais()[1].getId()]*0.05;
                total_distancia += matriz_distancias[viagemVisualiza.getLocais()[2].getId()][viagemVisualiza.getLocais()[1].getId()];
                nomeimagemtres = nomeimagemtres.concat(viagemVisualiza.getLocais()[1].getNome());
                nomeimagemtres = nomeimagemtres.concat(viagemVisualiza.getLocais()[2].getNome());
            }
            else
            {
                total_custo += matriz_distancias[viagemVisualiza.getLocais()[1].getId()][viagemVisualiza.getLocais()[2].getId()]*0.05;
                total_distancia += matriz_distancias[viagemVisualiza.getLocais()[1].getId()][viagemVisualiza.getLocais()[2].getId()];
                nomeimagemtres = nomeimagemtres.concat(viagemVisualiza.getLocais()[2].getNome());
                nomeimagemtres = nomeimagemtres.concat(viagemVisualiza.getLocais()[1].getNome());
            }
            custoTerceiro.setText((df.format(total_custo)+" euros"));
            distanciaTerceiro.setText((df.format(total_distancia)+"km"));
            nomeimagemtres = nomeimagemtres.concat(".png");

            img3 = new ImageIcon(ImageIO.read(new File(nomeimagemtres)));
            img3 = new ImageIcon(img3.getImage().getScaledInstance(180,180, Image.SCALE_SMOOTH));
   
            
            total_custo += matriz_distancias[viagemVisualiza.getLocais()[2].getId()][0]*0.05;
            total_distancia += matriz_distancias[viagemVisualiza.getLocais()[2].getId()][0];
            
            String nomeimagemdquatro = "Coimbra";
            nomeimagemdquatro = nomeimagemdquatro.concat(viagemVisualiza.getLocais()[2].getNome());
            nomeimagemdquatro = nomeimagemdquatro.concat(".png");

            img4 = new ImageIcon(ImageIO.read(new File(nomeimagemdquatro)));
            img4 = new ImageIcon(img4.getImage().getScaledInstance(180,180, Image.SCALE_SMOOTH));
            custoFinal.setText((df.format(total_custo)+" euros"));
            distanciaFinal.setText((df.format(total_distancia)+"km"));
            
            black = new ImageIcon(ImageIO.read(new File("black2.jpg")));
            black = new ImageIcon(black.getImage().getScaledInstance(1470,500, Image.SCALE_SMOOTH));
            
            
            tituloViagem.setText(viagemVisualiza.getLocais()[0].getNome()+" - "+viagemVisualiza.getLocais()[1].getNome()+" - "+viagemVisualiza.getLocais()[2].getNome());
            tituloViagemaux.setText(viagemVisualiza.getLocais()[0].getNome()+" - "+viagemVisualiza.getLocais()[1].getNome()+" - "+viagemVisualiza.getLocais()[2].getNome());
            if(viagemSelecionada != null)
            {
                

                if(viagemVisualiza == viagemSelecionada)
                {
                    avisoSeleciona.setText("VIAGEM SELECIONADA");
                    avisoSelecionaaux.setText("VIAGEM SELECIONADA");

                }
            }
            
                  
            panelPrincipal.add(informacaoViagemscrollPane);
            
            Viagem auxiliar = new Viagem(viagemVisualiza);
            
            if (opcao == 0) 
                auxiliar.crescenteSort();
            else
                auxiliar.decrescenteSort();
            
            for(int i =0;i<3;i++)
            {
                ArrayList<PontoInteresse> auxliarParaPrints =  auxiliar.getPontosInteresseEscolhidosDeCertoLocal(i);
                String info = "                                                                     Local - " + auxiliar.getLocais()[i].getNome();
                informacaoViagemArrayList.add(info);
                info = "                                                   O custo total deste local e de "+df.format(auxiliar.getPrecoLocal(i))+" euros.";
                informacaoViagemArrayList.add(info);
                if (auxliarParaPrints.isEmpty()) {
                    info = "Nao foram escolhidos pontos de interesse neste local.";
                    informacaoViagemArrayList.add(info);
                    
                }
                else
                {
                    info = " ";
                    informacaoViagemArrayList.add(info);
                    info = "                                        -- Com os seguintes pontos de interesses escolhidos --";
                    informacaoViagemArrayList.add(info);
                    info = " ";
                    informacaoViagemArrayList.add(info);
                    Integer contador = 0;
                    for (Iterator<PontoInteresse> iterator = auxliarParaPrints.iterator(); iterator.hasNext();) {
                        contador++;
                        PontoInteresse next = iterator.next();
                        info = contador.toString()+"- "+next.nome + " - "+df.format(next.getCusto())+" euros.";
                        informacaoViagemArrayList.add(info);
                        info = "    "+next.toStringHorario();
                        informacaoViagemArrayList.add(info);
                        if(next instanceof Cultural)
                        {
                            info = "    Informacao Espetaculo:";
                            informacaoViagemArrayList.add(info);
                            
                            info = "    "+next.getEspetaculoInfo();
                            informacaoViagemArrayList.add(info);
                            info = "    Informacao Atividade:";
                            informacaoViagemArrayList.add(info);
                            
                            info = "    "+((Parque) next).getAtividadeInfo();
                            informacaoViagemArrayList.add(info);
                            info = "    Parque do tipo: "+ ((Parque) next).getTipo();
                            informacaoViagemArrayList.add(info);
                            info = "    Area de estudo "+((Parque) next).getAreaEstudo();
                            informacaoViagemArrayList.add(info);
                        }
                        if(next instanceof P_aquatico)
                        {
                            info = "    Informacao Espetaculo:";
                            informacaoViagemArrayList.add(info);
                            info = "    "+next.getEspetaculoInfo();
                            informacaoViagemArrayList.add(info);
                            
                            info = "    Informacao Equipamentos:";
                            informacaoViagemArrayList.add(info);
                            info = "    "+((P_aquatico) next).getEquipamentosInfo();
                            informacaoViagemArrayList.add(info);
                            
                            info = "    Informacao Atracoes:";
                            informacaoViagemArrayList.add(info);
                            info = "    "+((P_aquatico) next).getAtracoesInfo();
                            informacaoViagemArrayList.add(info);
                            info = "    Meses Aberto:";
                            informacaoViagemArrayList.add(info);
                            info = "    "+((P_aquatico) next).getMesesAberto();
                            informacaoViagemArrayList.add(info);
                            info = "    Com as Piscinas:";
                            informacaoViagemArrayList.add(info);
                            info = "    "+((P_aquatico) next).getPiscinasInfo();
                            informacaoViagemArrayList.add(info);
                        }
                        
                        if(next instanceof Museu)
                        {
                            info = "    Tema do Museu: "+ ((Museu) next).getTematica();
                            informacaoViagemArrayList.add(info);
                        }
                        if(next instanceof Universidade)
                        {
                            info = "    Cursos: "+ ((Universidade) next).getCursos();
                            informacaoViagemArrayList.add(info);
                        }
                        if(next instanceof Bar)
                        {
                            info = "    Consumo minimo Obrigatorio: "+ df.format(((Bar) next).getConsumo());
                            informacaoViagemArrayList.add(info);
                        }
                        
                        info = "    Com o rating "+next.getRating();
                        informacaoViagemArrayList.add(info); 
                        info = " ";
                        informacaoViagemArrayList.add(info);
                    }
                }
                info = " ------------------------------------------------------------------------------------------------------------------";
                informacaoViagemArrayList.add(info);
                info = " ";
                informacaoViagemArrayList.add(info);
                
                
                
                informacaoViagem.setListData(informacaoViagemArrayList.toArray(new String[informacaoViagemArrayList.size()]));
            }
            if(user_seleccionado instanceof Licenciatura)
            {
              
                hotEvitaLabel.setText("Hot: "+ viagemVisualiza.getHot().getNome());
                hotEvitaLabelaux.setText("Hot: "+ viagemVisualiza.getHot().getNome());
            }
            if(user_seleccionado instanceof Mestrado)
            {

                hotEvitaLabel.setText("Evita: "+viagemVisualiza.getEvita().getNome());
                hotEvitaLabelaux.setText("Evita: "+viagemVisualiza.getEvita().getNome());
            }

            
           
            img1L.setIcon(img1);
            img2L.setIcon(img2);
            img3L.setIcon(img3);
            img4L.setIcon(img4);
            contour.setIcon(black);
            contour2L.setIcon(contour2);
            pinumL.setIcon(pin);
            pindoisL.setIcon(pin);
            pintresL.setIcon(pin);
            pinquatroL.setIcon(pin);
            panelPrincipal.add(background);
            
            }catch (Exception exe) {

            }
        }
    }    
    
    /**
     * Listener do botao que nos permite adicionar uma viagem as viagens geradas
     */
    private class ButtonGeraViagensListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent e) {
            if(user_seleccionado instanceof Mestrado){
                if(indice_hot_evita==0){
                    JOptionPane.showMessageDialog(null, "Esqueceu-se do seu Local a evitar! Seleccione-o para gerar a viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
            if(user_seleccionado instanceof Licenciatura){
                if(!pitotal.contains(helper))
                    hot_evita_bool=false;
                else 
                    hot_evita_bool=true;
                if (hot_evita_bool==false){
                    JOptionPane.showMessageDialog(null, "Esqueceu-se do seu ponto hot! Seleccione-o para gerar a viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    return;
                    }
                }
            try{
                spinner.commitEdit();
            }
            catch (java.text.ParseException ex) {
            }
            montante_int = (Integer)(spinner.getValue());
            int contaMuseus = 0;
            for (Iterator<PontoInteresse> iterator = pitotal.iterator(); iterator.hasNext();) {
                PontoInteresse next = iterator.next();
                if(next instanceof Museu)
                    contaMuseus++;
            }
  
            if (custoViagem +custoPontoI > montante_int)
                textodoCusto.setForeground(Color.RED);
            else
                textodoCusto.setForeground(Color.GREEN);
            textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
            if(custoViagem +custoPontoI > montante_int)
                JOptionPane.showMessageDialog(null, "O seu capital não permite pagar a viagem na totalidade", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            else if (loc2 == null || loc1 == null || loc3 == null)
                JOptionPane.showMessageDialog(null, "Precisa de selecionar os 3 locais para gerar a viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            else if(contaMuseus == 0)
            {
                JOptionPane.showMessageDialog(null, "Precisa de selecionar pelo menos um museu para gerar a viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            }        
            else     
            {
                Local[] osTresSelecionados = new Local[3];
                osTresSelecionados[0] = loc1;
                osTresSelecionados[1] = loc2;
                osTresSelecionados[2] = loc3;
                ArrayList<PontoInteresse> copia = new ArrayList<PontoInteresse>(pitotal);
                
                if(user_seleccionado instanceof Mestrado)
                    novaViagem = new Viagem(custoViagem+custoPontoI,osTresSelecionados,copia,helperEvita);
                else
                {
                    novaViagem = new Viagem(custoViagem+custoPontoI,osTresSelecionados,copia,helper);
                }
                String detalhes = "";
                int i=0;
                for (Local osTresSelecionado : osTresSelecionados) {
                    detalhes = detalhes.concat(osTresSelecionado.getNome());
                    if (i<2) {
                        detalhes = detalhes.concat(">>");
                    }
                    i++;
                }
                detalhes = detalhes.concat(" - "+df.format(custoViagem+custoPontoI)+"€");
                int flag = 0;

                for (Viagem n:viagemGeradas) {
                    if(n.getLocais()[0] == novaViagem.getLocais()[0] && n.getLocais()[1] == novaViagem.getLocais()[1] && n.getLocais()[2] == novaViagem.getLocais()[2])
                    {
                        if((n.getPI().containsAll(novaViagem.getPI()) && novaViagem.getPI().containsAll(n.getPI())))
                        {
                            flag=1;
                        }
                    }
                }
                int inseriuFlag = 0;
                if(flag == 0 )
                {
                    for (int j = 0; j < viagemGeradas.size(); j++) {
                        
                        if (viagemGeradas.get(j).getCusto() < novaViagem.getCusto()) {
                            viagemGeradas.add(j,novaViagem);
                            viagens.add(j,detalhes);
                            
                            inseriuFlag = 1;
                            break;
                        }
                    }
                    if(viagemGeradas.isEmpty())
                    {
                        viagemGeradas.add(novaViagem);
                        viagens.add(detalhes);
                    }
                    else if (inseriuFlag == 0) {
                        viagemGeradas.add(viagemGeradas.size(),novaViagem);
                        viagens.add(viagens.size(),detalhes);
                    }
                    viagemEmString = viagens.toArray(new String[viagens.size()]);
                    lista_viagens.setListData(viagemEmString);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Essa viagem já se encontra nas viagens geradas", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                }
            }
                
        }
    }
    
    /**
     * Caso um utlizador ja registado previamente queira ver a sua viagem ou alterá-la, adiciona a sua viagem escolhida previamente à Arraylist de viagens geradas
     * @param v Viagem selecionada previamente pelo utilicador
     */
    private void writeTripSelected(Viagem v){
        Local[] osTresSelecionados = new Local[3];
        osTresSelecionados[0] = v.getLocais()[0];
        osTresSelecionados[1] = v.getLocais()[1];
        osTresSelecionados[2] = v.getLocais()[2];
      
        if(user_seleccionado instanceof Mestrado)
            novaViagemaux = new Viagem(v,v.getEvita());
        else
            novaViagemaux = new Viagem(v,v.getHot());
        String detalhes = "";
        int i=0;
        for (Local osTresSelecionado : osTresSelecionados) {
            detalhes = detalhes.concat(osTresSelecionado.getNome());
            if (i<2) {
                detalhes = detalhes.concat(">>");
            }
            i++;
        }
        detalhes = detalhes.concat(" - "+df.format(v.getCusto())+"€");
        viagemSelecionada = novaViagemaux;

        viagemGeradas.add(novaViagemaux);
        viagens.add(detalhes);
        viagemEmString = viagens.toArray(new String[viagens.size()]);
        lista_viagens.setListData(viagemEmString);
    }
    
    /**
     * Listener do botao que nos permite retirar pontos de interesse dos selecionados previamente
     */
    private class removeButtonListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent e) {
            try {
                String aux = todosPiList.getSelectedValue().toString();
                for (String g : piLocaltodos) {
                    if (g.equals(aux)) {
                        piLocaltodos.remove(g);
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                        break;
                    }
                }
                String[] particoes = aux.split("\\|");
                ArrayList<PontoInteresse> copia = new ArrayList<>(pitotal);
                for (Iterator<PontoInteresse> iterator = copia.iterator(); iterator.hasNext();) {
                    PontoInteresse next = iterator.next();
                    if (next.getLocal().compareTo(particoes[1])==0 && next.getNome().compareTo(particoes[0])==0) {
                        custoPontoI -= next.getCusto();
                        pitotal.remove(next);
                        if (custoViagem+custoPontoI > montante_int)
                        textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                    }

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto de interesse", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    /**
     * Listener do botao que permite adicionar pontos de interesse correspondestes ao primeiro local selecionado
     */
    private class umButtonListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent e) {
            //try {
            try {
                
                String aux = primeiroLocalPiList.getSelectedValue().toString();

                String pontoi = primeiroLocalPiList.getSelectedValue().toString();
                String aux_local = "|";
                //todos_pontos_interesse
                for (int i = 0; i < combo_opcoesLocal.size(); i++) {
                    if(primeiroLocalCombo.getSelectedIndex() == i){
                        aux_local =  aux_local.concat(combo_opcoesLocal.get(i));
                    }
                }
                if(aux.compareTo("Nenhum")!=0)
                {
                    aux = aux.concat(aux_local);
                    boolean contains = piLocaltodos.contains(aux);
                    if (contains == false) {
                        for (Iterator<PontoInteresse> iterator = piPrimeiroLocal.iterator(); iterator.hasNext();) {
                            PontoInteresse next = iterator.next();
                            if(next.getNome().compareTo(pontoi) == 0)
                            {
                                pitotal.add(next);
                                custoPontoI+=next.getCusto();
                                break;
                            }
                        }
                        if (custoViagem+custoPontoI > montante_int)
                            textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                        piLocaltodos.add(aux);
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                        piLocaltodos_string = piLocaltodos.toArray(new String[piLocaltodos.size()]);

                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto de inetresse", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }
    
    /**
     * Listener do botao que permite adicionar pontos de interesse correspondestes ao segundo local selecionado
     */
    private class doisButtonListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent e) { 
            try {
                String aux = segundoLocalPiList.getSelectedValue().toString();
                String aux_local = "|";
                String pontoi = segundoLocalPiList.getSelectedValue().toString();
                for (int i = 0; i < combo_opcoesLocal.size(); i++) {
                    if(segundoLocalCombo.getSelectedIndex() == i){
                        aux_local =  aux_local.concat(combo_opcoesLocal.get(i));

                    }
                }
                if(aux.compareTo("Nenhum")!=0)
                {
                    aux = aux.concat(aux_local);
                    boolean contains = piLocaltodos.contains(aux);
                    if (contains == false) {
                        for (Iterator<PontoInteresse> iterator = piSegundoLocal.iterator(); iterator.hasNext();) {
                            PontoInteresse next = iterator.next();
                            if(next.getNome().compareTo(pontoi) == 0)
                            {
                                pitotal.add(next);
                                custoPontoI+=next.getCusto();
                                break;
                            }

                        }
                        if (custoViagem+custoPontoI > montante_int)
                            textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                        piLocaltodos.add(aux);
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));

                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto de interesse", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }
    
    /**
     * Listener do botao que permite adicionar pontos de interesse correspondestes ao terceiro local selecionado
     */
    private class tresButtonListener implements ActionListener { 
        @Override 
        public void actionPerformed(ActionEvent e) { 
            
            try {
                String aux = terceiroLocalPiList.getSelectedValue().toString();
                String aux_local = "|";
                String pontoi = terceiroLocalPiList.getSelectedValue().toString();
                for (int i = 0; i < combo_opcoesLocal.size(); i++) {
                    if(terceiroLocalCombo.getSelectedIndex() == i){
                        aux_local =  aux_local.concat(combo_opcoesLocal.get(i));
                    }
                }
                if(aux.compareTo("Nenhum")!=0)
                {
                    aux = aux.concat(aux_local);
                    boolean contains = piLocaltodos.contains(aux);
                    if (contains == false) {
                        for (Iterator<PontoInteresse> iterator = piTerceiroLocal.iterator(); iterator.hasNext();) {
                            PontoInteresse next = iterator.next();
                            if(next.getNome().compareTo(pontoi) == 0)
                            {
                                pitotal.add(next);
                                custoPontoI+=next.getCusto();

                                break;
                            }
                        }
                        if (custoViagem+custoPontoI > montante_int)
                            textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                        piLocaltodos.add(aux);
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                        piLocaltodos_string = piLocaltodos.toArray(new String[piLocaltodos.size()]);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selecione ponto de interesse", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    }
    
    /**
     * Listener do botao que permite limpar a visualização dos detalhes de certa viagem
     */
    private class ButtonLimpaViagemListeer implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent e) { 
            limpa_esquerda();
        
        }
    }
    
    /**
     * Listener da combobox que o utilizador usa para indicar se é de licenciatura ou mestrado
     */
    private class ComboListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox cb = (JComboBox)e.getSource();
                String combo = (String)cb.getSelectedItem();
                combo_seleccionado=combo;

                if ((combo_seleccionado.equals(text_ciclo.get(0))==false) && (nome_seleccionado.equals("")==false) && conta ==10)
                 {
                    lets_go.setEnabled(true);

                 }
                else{
                    lets_go.setEnabled(false);

                }
                    
                    
        }
    }
    
    /**
     * Listener da combobox com os utilizadores que se registaram anteriormente
     */
    private class UserComboListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int ind;
            JComboBox cb = (JComboBox)e.getSource();
            String combo = (String)cb.getSelectedItem();
            String aux_num;
            if (cb.getSelectedIndex()==0){
                but_remove.setEnabled(false);
                
            }
            else{
                but_remove.setEnabled(true);
                num_user.setEditable(false);
            }
            texto_user_seleccionado=combo;
                if ((texto_user_seleccionado.equals(nomes_users.get(0))))
                 {
                    nome_seleccionado=combo;
                    ciclo.setSelectedIndex(0);
                    name_user.setText("");
                    num_user.setText("");
                    name_user.setEditable(true);
                    num_user.setEditable(true);
                    ciclo.setEnabled(true);
                    lets_go.setEnabled(false);
                    //but_add.setEnabled(true);
                     
                 }
                else{
                    name_user.setEditable(false);
                    ciclo.setEditable(false);
                    name_user.setText(combo);
                    ind=cb.getSelectedIndex();

                    aux_num=""+(users_cpy.get(ind-1).getNumEstudante());

                    user_seleccionado=users_cpy.get(ind-1);
                     
                    if(user_seleccionado instanceof Licenciatura)
                        ciclo.setSelectedIndex(1);
                    if(user_seleccionado instanceof Mestrado)
                        ciclo.setSelectedIndex(2);
                    ciclo.setEnabled(false);
                     num_user.setText(aux_num);
                     //but_add.setEnabled(false);
                     lets_go.setEnabled(true);

                }
                    
        }
    }
    
    /**
     * Key Listener referente ao numero de estudante
     */
    private class EscutaKey implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            if (e.getKeyCode()== KeyEvent.VK_ENTER)
                return;
            String aux="";
            aux=num_user.getText();
            if(e.getExtendedKeyCode()==KeyEvent.VK_0 || e.getKeyCode()==KeyEvent.VK_1 ||e.getKeyCode()==KeyEvent.VK_2 ||e.getKeyCode()==KeyEvent.VK_3 ||e.getKeyCode()==KeyEvent.VK_4 ||e.getKeyCode()==KeyEvent.VK_5 ||e.getKeyCode()==KeyEvent.VK_6 ||e.getKeyCode()==KeyEvent.VK_7 ||e.getKeyCode()==KeyEvent.VK_8||e.getKeyCode()==KeyEvent.VK_9){
                conta++;
            }
            else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE && conta!=0)
                conta--;
            else if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_KP_RIGHT || e.getKeyCode()==KeyEvent.VK_KP_DOWN || e.getKeyCode()==KeyEvent.VK_KP_UP || e.getKeyCode()==KeyEvent.VK_KP_LEFT || e.getKeyCode()==KeyEvent.VK_SPACE )
                return;
            else{
                if(aux.equals("")==false || conta==0){
                    num_user.setText("");
                    conta=0;
                    lets_go.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Selecione um número!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                }
            }  
            
            
            
            if(conta==10){
                try {
                    verifica_numero_estudante(aux);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else lets_go.setEnabled(false);
            }

        @Override
        public void keyPressed(KeyEvent e) {
        }
        
    }
    
    /**
     * Listener referente ao botao que permite retirar uma viagem as viagens previamente geradas
     */
    private class ButtonRetiraViagemListeer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                String aux = lista_viagens.getSelectedValue().toString();
                int ind = viagens.indexOf(aux);
                if (viagemGeradas.get(ind) == viagemVisualiza)
                    limpa_esquerda();
                viagens.remove(viagens.get(ind));
                viagemGeradas.remove(viagemGeradas.get(ind));
                viagemEmString = viagens.toArray(new String[viagens.size()]);
                lista_viagens.setListData(viagemEmString);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selecione uma viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
    } 
    
    /**
     * Listener do botao que premite o utilizador selecionar a sua viagem
     */
    private class selectButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                String aux = lista_viagens.getSelectedValue().toString();
                int ind = viagens.indexOf(aux);
                if(viagemSelecionada != null)
                {
                    if(user_seleccionado instanceof Licenciatura)
                        viagemSelecionada.getHot().desincrementaPontuacao();
                    else
                        viagemSelecionada.getEvita().incrementaPontuacao();
                    for (Local l : viagemSelecionada.getLocais()) {
                        l.desincrementaPontuacao();
                    }
                    for (Iterator<PontoInteresse> iterator = viagemSelecionada.getPI().iterator(); iterator.hasNext();) {
                        PontoInteresse next = iterator.next();
                        next.desincrementaPontuacao();

                    }
                   
                }
                if(user_seleccionado instanceof Licenciatura)
                {
                    viagemSelecionada = viagemGeradas.get(ind);
                    viagemSelecionada.getHot().incrementaPontuacao();
                }
                else
                {
                    viagemSelecionada = viagemGeradas.get(ind);
                    viagemSelecionada.getEvita().desincrementaPontuacao();
                }
                for (Local l : viagemSelecionada.getLocais()) 
                    l.incrementaPontuacao();
                for (Iterator<PontoInteresse> iterator = viagemSelecionada.getPI().iterator(); iterator.hasNext();) {
                    PontoInteresse next = iterator.next();
                    next.incrementaPontuacao();
                    
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Selecione uma viagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            if(viagemSelecionada != null)
            {
                user_seleccionado.setViagem(viagemSelecionada);
                avisoSeleciona.setText("VIAGEM SELECIONADA");
                avisoSelecionaaux.setText("VIAGEM SELECIONADA");
            }
        }
    } 
    
    /**
     * Text Listener que verifica o numero de digitos que o utilizador escreve no numero de estudante
     */
    private class TextListener implements ActionListener {
        private String aux;
        private boolean auxiliar=false; 
            @Override
            
            public void actionPerformed(ActionEvent e)
            {
                JTextField teste= (JTextField)e.getSource();
                if(e.getSource()== name_user ){
                    verifica_nome_estudante(aux);
                    
                    }

                if(e.getSource()==num_user){
                    /*verifica_numero_estudante(aux);*/
                    return;
                        
                }
            }

   }
    
    /**
     * Verifica que o utilizador escreveu alguma coisa no nome
     * @param aux String que contem o que o utilizador escrever na textbox referente ao nome
     */
    private void verifica_nome_estudante(String aux){
        nome_seleccionado=aux;
 
        if(combo_seleccionado.equals(text_ciclo.get(1)) && (nome_seleccionado.equals("")==false) && numero_seleccionado!=0)
            lets_go.setEnabled(true);
        if ((combo_seleccionado.equals(text_ciclo.get(2)))&& (nome_seleccionado.equals("")==false &&numero_seleccionado!=0))
            lets_go.setEnabled(true);
        else if ((combo_seleccionado.equals(text_ciclo.get(0))) || (nome_seleccionado.equals("") || numero_seleccionado==0)){
        //but_add.setEnabled(false);
        lets_go.setEnabled(false);
            
        }

   }
    
    /**
     * Verifica que o utilizador escreveu um numero correto
     * @param aux String que contem o que o utilizador escrever na textbox referente ao numero de estudanyte
     * @throws InterruptedException -
     */
    private void verifica_numero_estudante(String aux) throws InterruptedException{
       
        try{

            numero_seleccionado=Long.parseLong(aux);

        }
        catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Selecione um número!", "Mensagem", JOptionPane.PLAIN_MESSAGE); 
        }
        if(combo_seleccionado.equals(text_ciclo.get(1)) && (nome_seleccionado.equals("")==false) && conta==10)
        {
            lets_go.setEnabled(true);

        }
        if ((combo_seleccionado.equals(text_ciclo.get(2)))&& (nome_seleccionado.equals("")==false) && conta==10){

            lets_go.setEnabled(true);
        }
        else if ((combo_seleccionado.equals(text_ciclo.get(0))) || (nome_seleccionado.equals("")) || conta!=10){
        //but_add.setEnabled(false);
        lets_go.setEnabled(false);
        }
   }
    
    /**
     * Listener que permite o utilizador fazer o login e ir para a proxima interface
     */
    private class ButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(combo_seleccionado.equals(text_ciclo.get(1)) && (nome_seleccionado.equals("")==false) && numero_seleccionado!=0 && conta == 10)
                    {
                        lets_go.setEnabled(true);
                        user_seleccionado=new Licenciatura(nome_seleccionado,numero_seleccionado);
                        users_cpy.add(user_seleccionado);

                    }
                    if ((combo_seleccionado.equals(text_ciclo.get(2)))&& (nome_seleccionado.equals("")==false &&numero_seleccionado!=0 && conta == 10)){
                        user_seleccionado=new Mestrado(nome_seleccionado,numero_seleccionado);
                        users_cpy.add(user_seleccionado);
                        lets_go.setEnabled(true);
                    }
                    else if ((combo_seleccionado.equals(text_ciclo.get(0))) || (nome_seleccionado.equals("") || numero_seleccionado==0 || conta != 10)){
                    //but_add.setEnabled(false);
                    lets_go.setEnabled(false);
                    }
                
                setVisible(false);

            
            }
                
        }
    
    /**
     * Listener do botao que permite o utilizador sair da aplicação
     */
    private class ButtonListenerSair implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            if(e.getSource()!=voltarButton){
            check=false;
            
            }
            else
                check=true;
        }
        
    }
    
    /**
     * Listener do botao que permite o utilizador verficar os Locais e Pontos de interesse favoritos
     */
    private class favListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Local> auxL = new ArrayList<Local>(locais);
            ArrayList<PontoInteresse> auxP = new ArrayList<PontoInteresse>(todos_pontos_interesse);
            Local moveL;
            PontoInteresse moveP;
            boolean flag;
            do{
                flag = false;
                for (int i=0;i<auxL.size()-1;i++) {
                    if (auxL.get(i).getPontuacao() < auxL.get(i+1).getPontuacao()) {
                        moveL = auxL.get(i);
                        auxL.set(i,auxL.get(i+1));
                        auxL.set(i+1,moveL);
                        flag = true;
                    }
                }
            }while(flag);
            auxL = new ArrayList<Local>(auxL.subList(0, 5));
            do{
                flag = false;
                for (int i=0;i<auxP.size()-1;i++) {
                    if (auxP.get(i).getPontuacao() < auxP.get(i+1).getPontuacao()) {
                        moveP = auxP.get(i);
                        auxP.set(i,auxP.get(i+1));
                        auxP.set(i+1,moveP);
                        flag = true;
                    }
                }
            }while(flag);
            auxP = new ArrayList<PontoInteresse>(auxP.subList(0, 5));
            String toWrite = "                       Locais:\n";
            for (Iterator<Local> iterator = auxL.iterator(); iterator.hasNext();) {
                Local next = iterator.next();
                toWrite = toWrite.concat(next.getNome()+" - "+next.getPontuacao()+"\n");
            }
            toWrite = toWrite.concat("\n                Pontos de Interesse:\n");
            for (Iterator<PontoInteresse> iterator = auxP.iterator(); iterator.hasNext();) {
                PontoInteresse next = iterator.next();
                toWrite = toWrite.concat(next.getNome()+" - "+next.getPontuacao()+"\n");
            }
            JOptionPane.showMessageDialog(panelPrincipal,
            toWrite,
            "MELHOR PONTUACAO",
            JOptionPane.WARNING_MESSAGE);
                
            
        }
        
    }
    
    /**
     * 
     * @return Retorna o utilizador selecionado
     */
    public Utilizador getUtilizadorSeleccionado(){
        return user_seleccionado;
    }
    
    /**
     * 
     * @return Retorna o nome do utilizaodr
     */
    public String getNomeUser(){
        return nome_seleccionado;
    }
    
    /**
     * 
     * @return uma verificação de a frame ja fechou
     */
    public boolean getCheck(){
        return check;
    }
    
    /**
     * 
     * @return Retorna uma ArrayList com todos os Pontos de interesse
     */
    private ArrayList<PontoInteresse> getsTodosPontoInteresses(){
        ArrayList<PontoInteresse> auxiliar=new ArrayList<>();
        for(Local next: locais){
            auxiliar.addAll(next.getPontosInteresse());
        }
        return auxiliar;
    }
    
    /**
     * 
     * @return Retorna uma ArrayList com todos os nomes dos Pontos de interesse com o tipo String
     */
    private ArrayList<String> getSTRTodosPontosInteresse(){
        String aux;
        ArrayList<String> array_aux=new ArrayList<>();
        for(PontoInteresse next: todos_pontos_interesse){
            aux=next.getNome()+ "->"+next.getLocal();
            array_aux.add(aux);
            
        }
        return array_aux; 
    }
    
    /**
     * 
     * @return Retorna uma ArrayList com todos os nomes dos Locais com o tipo String
     */
    private ArrayList<String> getSTRTodosLocais(){
        String aux;
        ArrayList<String> array_aux=new ArrayList<>();
        for(Local next: locais){
            aux=next.getNome();
            array_aux.add(aux);
            
        }
        return array_aux; 
    }
    
    /**
     * Faz o managemente da combobox do primeiro local
     */
    private void set_combo_um(){
        for (int i = 0; i < combo_opcoesLocal.size(); i++) {
                if(primeiroLocalCombo.getSelectedIndex() == i){
                    //Aqui
                    if(localum.compareTo(combo_opcoesLocal.get(i)) != 0){
                        ArrayList<String> copy = new ArrayList<>(piLocaltodos);
                        for (String ponto : copy) {
                            String[] auxiliar = ponto.split("\\|");
 
                            if (localum.compareTo(auxiliar[1])==0)
                                piLocaltodos.remove(ponto);
                        }
                        ArrayList<PontoInteresse> copia = new ArrayList<>(pitotal);
                        for (Iterator<PontoInteresse> iterator = copia.iterator(); iterator.hasNext();) {
                        PontoInteresse next = iterator.next();

                        if(next.getLocal().compareTo(localum)==0)
                        {

                        pitotal.remove(next);
                        custoPontoI-=next.getCusto();
                        }
                        }
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                    
                    }
                    if(combo_opcoesLocal.get(i).compareTo(localtres)==0 || combo_opcoesLocal.get(i).compareTo(localdois)==0 || combo_opcoesLocal.get(i).compareTo(auxiliar_evita)==0 ){
                        primeiroLocalCombo.setSelectedIndex(0);
                        custoViagem = 0;
                        if (custoViagem+custoPontoI > montante_int)
                            textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                        primeiroLocalPiList.removeAll();
                        piLocalum = new String[1];
                        piLocalum[0] = "Nenhum";
                        localum = "";
                        loc1 = null;
                        primeiroLocalPiList.setListData(piLocalum);
                        ArrayList<String> copy = new ArrayList<>(piLocaltodos);
                        for (String ponto : copy) {
                            String[] auxiliar = ponto.split("\\|");

                            for (Iterator<PontoInteresse> iterator = pitotal.iterator(); iterator.hasNext();) {
                                PontoInteresse next = iterator.next();
                                if(next.getLocal().compareTo(auxiliar[1])==0 && next.getNome().compareTo(auxiliar[0])==0)
                                    custoPontoI-=next.getCusto();
                                
                                
                            }

                            if (localum.compareTo(auxiliar[1])==0)
                                piLocaltodos.remove(ponto);
                        }
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                        
                        break;
                    }
                    if("Selecione o local".compareTo(combo_opcoesLocal.get(i))==0){
                            localum = "";
                            loc1 = null;
                            primeiroLocalPiList.removeAll();
                            piLocalum = new String[1];
                            piLocalum[0] = "Nenhum";
                            primeiroLocalPiList.setListData(piLocalum);
                            custoViagem = 0;
                        }
                    else
                    {
                        custoViagem = 0;
                         if (localum.compareTo(combo_opcoesLocal.get(i)) != 0) {
                            localum = combo_opcoesLocal.get(i);
                            for (Iterator<Local> loals = locais.iterator(); loals.hasNext();) {
                                Local next = loals.next();
                                if(next.getNome().compareTo(combo_opcoesLocal.get(i))==0){
                                    loc1 = next;
                                    piPrimeiroLocal = loc1.getPontosInteresse();
                                    piLocalum = next.nomePontosInteresse();
                                    primeiroLocalPiList.removeAll();
                                    primeiroLocalPiList.setListData(piLocalum);
                                }
                            }
                            if (loc2 != null && loc1 != null && loc3 != null) {
                            custoViagem += matriz_distancias[loc1.getId()][0]*0.05;
                            if (loc1.getId() > loc2.getId())
                                custoViagem += matriz_distancias[loc1.getId()][loc2.getId()]*0.05;
                            else
                                custoViagem += matriz_distancias[loc2.getId()][loc1.getId()]*0.05;
                            if (loc2.getId() > loc3.getId())
                                custoViagem += matriz_distancias[loc2.getId()][loc3.getId()]*0.05;
                            else
                                custoViagem += matriz_distancias[loc3.getId()][loc2.getId()]*0.05;
                            custoViagem += matriz_distancias[loc3.getId()][0]*0.05;
                            
                            }
                            else
                                custoViagem = 0;
                            
                        }
         
                    }
                    if (custoViagem+custoPontoI > montante_int)
                        textodoCusto.setForeground(Color.RED);
                    else
                        textodoCusto.setForeground(Color.GREEN);
                    textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                }
            } 
        }
    
    /**
     * Faz o managemente da combobox do primeiro local
     */
    private void set_combo_dois(){
        for (int i = 0; i < combo_opcoesLocal.size(); i++) {
                    if(segundoLocalCombo.getSelectedIndex() == i){
                        if(localdois.compareTo(combo_opcoesLocal.get(i)) != 0){
                        
                            ArrayList<String> copy = new ArrayList<>(piLocaltodos);
                            for (String ponto : copy) {
                                String[] auxiliar = ponto.split("\\|");
                                if (localdois.compareTo(auxiliar[1])==0)
                                    piLocaltodos.remove(ponto);
                            }
                            ArrayList<PontoInteresse> copia = new ArrayList<>(pitotal);
                            for (Iterator<PontoInteresse> iterator = copia.iterator(); iterator.hasNext();) {
                                PontoInteresse next = iterator.next();

                                if(next.getLocal().compareTo(localdois)==0)
                                {

                                    pitotal.remove(next);
                                    custoPontoI-=next.getCusto();
                                }
                            }
                            todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                        }
                        if(combo_opcoesLocal.get(i).compareTo(localtres)==0 || combo_opcoesLocal.get(i).compareTo(localum)==0)
                        {
                            segundoLocalCombo.setSelectedIndex(0);
                            segundoLocalPiList.removeAll();
                            piLocaldois = new String[1];
                            piLocaldois[0] = "Nenhum";
                            loc2 = null;
                            custoViagem = 0;
                            if (custoViagem+custoPontoI > montante_int)
                                textodoCusto.setForeground(Color.RED);
                            else
                                textodoCusto.setForeground(Color.GREEN);
                            textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                            localdois = "";
                            segundoLocalPiList.setListData(piLocaldois);
                            ArrayList<String> copy = new ArrayList<>(piLocaltodos);
                            for (String ponto : copy) {
                                String[] auxiliar = ponto.split("\\|");
                                if (localdois.compareTo(auxiliar[1])==0)
                                    piLocaltodos.remove(ponto);
                            }
                            todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                            break;
                        }
                        if("Selecione o local".compareTo(combo_opcoesLocal.get(i))==0)
                        {
                            loc2 = null;
                            localdois = "";
                            custoViagem = 0;
                            segundoLocalPiList.removeAll();
                            piLocaldois = new String[1];
                            piLocaldois[0] = "Nenhum";
                            segundoLocalPiList.setListData(piLocaldois);
                        }
                        else
                        {
                            custoViagem = 0;
                            localdois = combo_opcoesLocal.get(i);
                            for (Iterator<Local> loals = locais.iterator(); loals.hasNext();) {
                            Local next = loals.next();
                            if(next.getNome().compareTo(combo_opcoesLocal.get(i))==0){
                                loc2 = next;
                                piSegundoLocal = loc2.getPontosInteresse();
                                piLocaldois = next.nomePontosInteresse();
                                segundoLocalPiList.removeAll();
                                segundoLocalPiList.setListData(piLocaldois);

                                }
                            }
                            if (loc2 != null && loc1 != null && loc3 != null) {
                                custoViagem += matriz_distancias[loc1.getId()][0]*0.05;
                                if (loc1.getId() > loc2.getId())
                                    custoViagem += matriz_distancias[loc1.getId()][loc2.getId()]*0.05;
                                else
                                    custoViagem += matriz_distancias[loc2.getId()][loc1.getId()]*0.05;
                                if (loc2.getId() > loc3.getId())
                                    custoViagem += matriz_distancias[loc2.getId()][loc3.getId()]*0.05;
                                else
                                    custoViagem += matriz_distancias[loc3.getId()][loc2.getId()]*0.05;

                                custoViagem += matriz_distancias[loc3.getId()][0]*0.05;

                            }
                            else
                                custoViagem = 0;

                        }
                        if (custoViagem+custoPontoI > montante_int)
                            textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");

                    }
            }
    }
    
    /**
     * Faz o managemente da combobox do primeiro local
     */
    private void set_combo_tres(){
        for (int i = 0; i < combo_opcoesLocal.size(); i++) {
                if(terceiroLocalCombo.getSelectedIndex() == i){
                    if(localtres.compareTo(combo_opcoesLocal.get(i)) != 0){
                        ArrayList<String> copy = new ArrayList<>(piLocaltodos);
                        for (String ponto : copy) {
                            String[] auxiliar = ponto.split("\\|");
                            if (localtres.compareTo(auxiliar[1])==0)
                                piLocaltodos.remove(ponto);
                        }
                        ArrayList<PontoInteresse> copia = new ArrayList<>(pitotal);
                        for (Iterator<PontoInteresse> iterator = copia.iterator(); iterator.hasNext();) {
                            PontoInteresse next = iterator.next();

                            if(next.getLocal().compareTo(localtres)==0)
                            {

                                pitotal.remove(next);
                                custoPontoI-=next.getCusto();
                            }
                        }
                    todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                    }
                    if(combo_opcoesLocal.get(i).compareTo(localum)==0 || combo_opcoesLocal.get(i).compareTo(localdois)==0){
                        custoViagem = 0;
                        if (custoViagem+custoPontoI > montante_int)
                            textodoCusto.setForeground(Color.RED);
                        else
                            textodoCusto.setForeground(Color.GREEN);
                        textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                        terceiroLocalCombo.setSelectedIndex(0);
                        terceiroLocalPiList.removeAll();
                        piLocaltres = new String[1];
                        piLocaltres[0] = "Nenhum";
                        loc3 = null;
                        localtres = "";
                        terceiroLocalPiList.setListData(piLocaltres);
                        ArrayList<String> copy = new ArrayList<>(piLocaltodos);
                        for (String ponto : copy) {
                            String[] auxiliar = ponto.split("\\|");
                            if (localtres.compareTo(auxiliar[1])==0)
                                piLocaltodos.remove(ponto);
                        }
                        todosPiList.setListData(piLocaltodos.toArray(new String[piLocaltodos.size()]));
                        break;
                    }
                    
                    
                    if("Selecione o local".compareTo(combo_opcoesLocal.get(i))==0)
                    {
                        loc3 = null;
                        localtres = "";
                        custoViagem = 0;
                        terceiroLocalPiList.removeAll();
                        piLocaltres = new String[1];
                        piLocaltres[0] = "Nenhum";
                        terceiroLocalPiList.setListData(piLocaltres);
                    }
                    else
                    {
                        custoViagem = 0;
                        localtres = combo_opcoesLocal.get(i);
                        for (Iterator<Local> loals = locais.iterator(); loals.hasNext();) {
                            Local next = loals.next();
                            if(next.getNome().compareTo(combo_opcoesLocal.get(i))==0){
                                loc3 = next;
                                piTerceiroLocal = loc3.getPontosInteresse();
                                piLocaltres = next.nomePontosInteresse();
                                terceiroLocalPiList.removeAll();
                                terceiroLocalPiList.setListData(piLocaltres);
                            }
                        }
                        if (loc2 != null && loc1 != null && loc3 != null) {
                            custoViagem += matriz_distancias[loc1.getId()][0]*0.05;
                            if (loc1.getId() > loc2.getId())
                                custoViagem += matriz_distancias[loc1.getId()][loc2.getId()]*0.05;
                            else
                                custoViagem += matriz_distancias[loc2.getId()][loc1.getId()]*0.05;
                            if (loc2.getId() > loc3.getId())
                                custoViagem += matriz_distancias[loc2.getId()][loc3.getId()]*0.05;
                            else
                                custoViagem += matriz_distancias[loc3.getId()][loc2.getId()]*0.05;

                            custoViagem += matriz_distancias[loc3.getId()][0]*0.05;
                        }
                        else
                            custoViagem = 0;
                        
                    }
                    if (custoViagem+custoPontoI > montante_int)
                        textodoCusto.setForeground(Color.RED);
                    else
                        textodoCusto.setForeground(Color.GREEN);
                    textodoCusto.setText(df.format(custoViagem+custoPontoI)+"€");
                } 
            }
    }
    
    /**
     * Limpa a vizualização da viagem
     */
    private void limpa_esquerda(){
        tituloViagem.setText("");
        tituloViagemaux.setText("");
        img1L.setIcon(nada);
        img2L.setIcon(nada);
        img3L.setIcon(nada);
        img4L.setIcon(nada);
        contour2L.setIcon(nada);
        pinumL.setIcon(nada);
        pindoisL.setIcon(nada);
        pintresL.setIcon(nada);
        pinquatroL.setIcon(nada);
        contour.setIcon(nada);
        custoZero.setText("");
        distanciaZero.setText("");
        custoPrimeiro.setText("");
        distanciaPrimeiro.setText("");
        custoSegundo.setText("");
        distanciaSegundo.setText("");
        custoTerceiro.setText("");
        distanciaTerceiro.setText("");
        custoFinal.setText("");
        distanciaFinal.setText("");
        avisoSeleciona.setText("");
        avisoSelecionaaux.setText("");
        hotEvitaLabel.setText("");
        hotEvitaLabelaux.setText("");
        informacaoViagemArrayList.clear();
        informacaoViagem.setListData(informacaoViagemArrayList.toArray(new String[informacaoViagemArrayList.size()]));
        informacaoViagemscrollPane.setVisible(false);
        //panelPrincipal.remove(informacaoViagemscrollPane);
        panelPrincipal.add(background);
    }
}