/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pricipal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author USUARIO
 */
public class Pricipal extends JFrame {

    public static void main(String[] args) {
        Pricipal miVentana = new Pricipal();
    }

    public JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    public JButton reinicio, nuevo;
    public JLabel turno, textX, textO;
    public JPanel tablero, textos;
    public JSplitPane div;
    public String letra = "X";
    public int winO = 0, winX = 0;


    public int puerto = 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String msj;

    public Pricipal() {
        this.cargaComponentes();
        this.setLocationRelativeTo(null);
        this.initServer();

    }

    public void cargaComponentes() {
        //Instancia de objetos
        this.div = new JSplitPane();
        this.tablero = new JPanel();
        this.textos = new JPanel();
        this.boton1 = new JButton();
        this.boton2 = new JButton();
        this.boton3 = new JButton();
        this.boton4 = new JButton();
        this.boton5 = new JButton();
        this.boton6 = new JButton();
        this.boton7 = new JButton();
        this.boton8 = new JButton();
        this.boton9 = new JButton();
        this.nuevo = new JButton();
        this.reinicio = new JButton();
        this.turno = new JLabel();
        this.textX = new JLabel();
        this.textO = new JLabel();

        //Crearndo ventana
        this.setTitle("Triqui");
        this.setVisible(true);
        this.setSize(new Dimension(700, 600));
        this.setPreferredSize(new Dimension(600, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        //Agregamos el Panel
        this.tablero.setPreferredSize(new Dimension(450, 500));
        this.tablero.setLayout(new GridLayout(3, 3));
        this.textos.setLayout(null);

        this.div.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.div.setLeftComponent(this.tablero);
        this.div.setRightComponent(this.textos);

        this.div.setEnabled(false);
        this.add(this.div);


        //Agregando Botones
        this.tablero.add(this.boton1);
        this.boton1.setContentAreaFilled(false);
        this.boton1.setBorder(new SoftBevelBorder(0));
        this.boton1.setFont(new Font("Times New Roma", 0, 80));
        this.boton1.setActionCommand("1");
        this.boton1.setEnabled(false);

        this.tablero.add(this.boton2);
        this.boton2.setContentAreaFilled(false);
        this.boton2.setBorder(new SoftBevelBorder(0));
        this.boton2.setFont(new Font("Times New Roma", 0, 80));
        this.boton2.setActionCommand("2");
        this.boton2.setEnabled(false);

        this.tablero.add(this.boton3);
        this.boton3.setContentAreaFilled(false);
        this.boton3.setBorder(new SoftBevelBorder(0));
        this.boton3.setFont(new Font("Times New Roma", 0, 80));
        this.boton3.setActionCommand("3");
        this.boton3.setEnabled(false);

        this.tablero.add(this.boton4);
        this.boton4.setContentAreaFilled(false);
        this.boton4.setBorder(new SoftBevelBorder(0));
        this.boton4.setFont(new Font("Times New Roma", 0, 80));
        this.boton4.setActionCommand("4");
        this.boton4.setEnabled(false);

        this.tablero.add(this.boton5);
        this.boton5.setContentAreaFilled(false);
        this.boton5.setBorder(new SoftBevelBorder(0));
        this.boton5.setFont(new Font("Times New Roma", 0, 80));
        this.boton5.setActionCommand("5");
        this.boton5.setEnabled(false);

        this.tablero.add(this.boton6);
        this.boton6.setContentAreaFilled(false);
        this.boton6.setBorder(new SoftBevelBorder(0));
        this.boton6.setFont(new Font("Times New Roma", 0, 80));
        this.boton6.setActionCommand("6");
        this.boton6.setEnabled(false);

        this.tablero.add(this.boton7);
        this.boton7.setContentAreaFilled(false);
        this.boton7.setBorder(new SoftBevelBorder(0));
        this.boton7.setFont(new Font("Times New Roma", 0, 80));
        this.boton7.setActionCommand("7");
        this.boton7.setEnabled(false);

        this.tablero.add(this.boton8);
        this.boton8.setContentAreaFilled(false);
        this.boton8.setBorder(new SoftBevelBorder(0));
        this.boton8.setFont(new Font("Times New Roma", 0, 80));
        this.boton8.setActionCommand("8");
        this.boton8.setEnabled(false);

        this.tablero.add(this.boton9);
        this.boton9.setContentAreaFilled(false);
        this.boton9.setBorder(new SoftBevelBorder(0));
        this.boton9.setFont(new Font("Times New Roma", 0, 80));
        this.boton9.setActionCommand("9");
        this.boton9.setEnabled(false);

        //Labels del lado derecho
        this.turno.setText("Es el Turno de: " + letra);
        this.turno.setBounds(50, 420, 200, 100);
        this.turno.setFont(new Font("Arial", 0, 14));
        this.textos.add(this.turno);

        this.textX.setText("X ha Ganado " + winX);
        this.textX.setBounds(50, 100, 200, 100);
        this.textX.setFont(new Font("Arial", 0, 14));
        this.textos.add(this.textX);

        this.textO.setText("O ha Ganado " + winO);
        this.textO.setBounds(50, 150, 200, 100);
        this.textO.setFont(new Font("Arial", 0, 14));
        this.textos.add(this.textO);

        //Botonoes del Lado Derecho
        this.nuevo.setBounds(60, 350, 100, 30);
        this.nuevo.setText("Nuevo");
        this.textos.add(this.nuevo);

        this.reinicio.setBounds(35, 300, 150, 30);
        this.reinicio.setText("Reiniciar Puntos");
        this.textos.add(this.reinicio);

        //Eventos De los Botones
        this.boton1.addActionListener(e -> {
            try {
                Pricipal.this.boton1Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton2.addActionListener(e -> {
            try {
                Pricipal.this.boton2Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton3.addActionListener(e -> {
            try {
                Pricipal.this.boton3Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton4.addActionListener(e -> {
            try {
                Pricipal.this.boton4Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton5.addActionListener(e -> {
            try {
                Pricipal.this.boton5Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton6.addActionListener(e -> {
            try {
                Pricipal.this.boton6Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton7.addActionListener(e -> {
            try {
                Pricipal.this.boton7Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton8.addActionListener(e -> {
            try {
                Pricipal.this.boton8Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.boton9.addActionListener(e -> {
            try {
                Pricipal.this.boton9Action(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.nuevo.addActionListener(e -> Pricipal.this.nuevoAction(e));
        this.reinicio.addActionListener(e -> {
            try {
                Pricipal.this.reinicioAction(e);
            } catch (IOException ex) {
                Logger.getLogger(Pricipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void jugada(JButton boton) throws IOException {
        if (this.letra.equals("X") && boton.getText().equals("")) {
            boton.setText(this.letra);
            this.jugadaGanada();
        } else if (this.letra.equals("O") && boton.getText().equals("")) {
            boton.setText(this.letra);
            this.jugadaGanada();
        }
        this.turno.setText("Es el Turno de: " + letra);
    }

    public void boton1Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-1");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton1);
    }

    public void boton2Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-2");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton2);
    }

    public void boton3Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-3");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton3);
    }

    public void boton4Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-4");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton4);
    }

    public void boton5Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-5");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton5);
    }

    public void boton6Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-6");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton6);
    }

    public void boton7Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-7");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton7);
    }

    public void boton8Action(ActionEvent e) throws IOException {
        this.jugada(this.boton8);
        try {
            this.dbuttons();
            this.salida.writeUTF("X-8");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton8);
    }

    public void boton9Action(ActionEvent e) throws IOException {
        
        try {
            this.dbuttons();
            this.salida.writeUTF("X-9");
            this.salida.writeUTF("O");
            System.out.println("Pase");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.jugada(this.boton9);
    }

    public void nuevoAction(ActionEvent e) {
        this.juegoNuevo();
    }

    public void reinicioAction(ActionEvent e) throws IOException {
        this.rContador();
        salida.writeUTF("X-R");
    }

    public void jugadaGanada() throws IOException {
        //Filas
        if (this.boton1.getText().equals(this.boton2.getText()) && this.boton2.getText().equals(this.boton3.getText()) && this.boton3.getText().equals(this.letra)) {
            this.ganador();
        } else if (this.boton4.getText().equals(this.boton5.getText()) && this.boton5.getText().equals(this.boton6.getText()) && this.boton6.getText().equals(this.letra)) {
            this.ganador();
        } else if (this.boton7.getText().equals(this.boton8.getText()) && this.boton8.getText().equals(this.boton9.getText()) && this.boton9.getText().equals(this.letra)) {
            this.ganador();

            //Columnas
        } else if (this.boton1.getText().equals(this.boton4.getText()) && this.boton4.getText().equals(this.boton7.getText()) && this.boton7.getText().equals(this.letra)) {
            this.ganador();
        } else if (this.boton2.getText().equals(this.boton5.getText()) && this.boton5.getText().equals(this.boton8.getText()) && this.boton8.getText().equals(this.letra)) {
            this.ganador();
        } else if (this.boton3.getText().equals(this.boton6.getText()) && this.boton6.getText().equals(this.boton9.getText()) && this.boton9.getText().equals(this.letra)) {
            this.ganador();

            //Diagonales
        } else if (this.boton1.getText().equals(this.boton5.getText()) && this.boton5.getText().equals(this.boton9.getText()) && this.boton9.getText().equals(this.letra)) {
            this.ganador();
        } else if (this.boton3.getText().equals(this.boton5.getText()) && this.boton5.getText().equals(this.boton7.getText()) && this.boton7.getText().equals(this.letra)) {
            this.ganador();
        } 
    }

    public void ganador() throws IOException {

        //Desabilita los botones
        /*this.boton1.setEnabled(false);
        this.boton2.setEnabled(false);
        this.boton3.setEnabled(false);
        this.boton4.setEnabled(false);
        this.boton5.setEnabled(false);
        this.boton6.setEnabled(false);
        this.boton7.setEnabled(false);
        this.boton8.setEnabled(false);
        this.boton9.setEnabled(false);*/
        
        this.dbuttons();

        if ("X" == this.letra) {
            //JOptionPane.showMessageDialog(null, "El ganador es: " + this.letra);
            this.winX += 1;
            this.textX.setText("X ha Ganado " + winX);
            this.salida.writeUTF("X-Win");
        } else if (this.letra.contains("O")) {
            this.winO += 1;
            this.textO.setText("O ha Ganado " + winO);
            System.out.println("+ 1 O");
        }

        JOptionPane.showMessageDialog(null, "El ganador es: " + this.letra);



    }

    public void juegoNuevo() {

        //Habilita y limpia los botones
        this.boton1.setEnabled(true);
        this.boton1.setText("");
        this.boton2.setEnabled(true);
        this.boton2.setText("");
        this.boton3.setEnabled(true);
        this.boton3.setText("");
        this.boton4.setEnabled(true);
        this.boton4.setText("");
        this.boton5.setEnabled(true);
        this.boton5.setText("");
        this.boton6.setEnabled(true);
        this.boton6.setText("");
        this.boton7.setEnabled(true);
        this.boton7.setText("");
        this.boton8.setEnabled(true);
        this.boton8.setText("");
        this.boton9.setEnabled(true);
        this.boton9.setText("");
        this.letra = "X";
        this.turno.setText("Es el Turno de: " + this.letra);

    }

    public void dbuttons() {
        this.boton1.setEnabled(false);
        this.boton2.setEnabled(false);
        this.boton3.setEnabled(false);
        this.boton4.setEnabled(false);
        this.boton5.setEnabled(false);
        this.boton6.setEnabled(false);
        this.boton7.setEnabled(false);
        this.boton8.setEnabled(false);
        this.boton9.setEnabled(false);
    }

    public void rContador() throws IOException {
        this.winO = 0;
        this.winX = 0;
        this.textX.setText("X ha Ganado " + winX);
        this.textO.setText("O ha Ganado " + winO);

    }

    public void abuttons() {

        if(this.boton1.getText().isEmpty()) {
            System.out.println("Boton 1 habilitado");
            this.boton1.setEnabled(true);
        }

        if (this.boton2.getText().isEmpty()) {
            this.boton2.setEnabled(true);
        }

        if (this.boton3.getText().isEmpty()) {
            this.boton3.setEnabled(true);
        }

        if (this.boton4.getText().isEmpty()) {
            this.boton4.setEnabled(true);
        }

        if (this.boton5.getText().isEmpty()) {
            this.boton5.setEnabled(true);
        }

        if (this.boton6.getText().isEmpty()) {
            this.boton6.setEnabled(true);
        }

        if (this.boton7.getText().isEmpty()) {
            this.boton7.setEnabled(true);
        }

        if (this.boton8.getText().isEmpty()) {
            this.boton8.setEnabled(true);
        }

        if (this.boton9.getText().isEmpty()) {
            this.boton9.setEnabled(true);
        }

    }

    public void initServer() {

        DataInputStream entrada;

        try {
            sc = new ServerSocket(puerto);
            so = new Socket();

            System.out.println("Esperando una conexion");
            so = sc.accept();
            System.out.println("Un cliente se ha conectado");

            //Canales de entrada y salida de datos
            entrada = new DataInputStream(so.getInputStream());
            salida = new DataOutputStream(so.getOutputStream());

            System.out.println("Confirmando conexion al cliente....");
            salida.writeUTF("conected");


            JOptionPane.showMessageDialog(null, "!!Que comience el juego¡¡ Tu eres: " + this.letra);
            this.juegoNuevo();
            msj = "start";
            salida.writeUTF("X");

            while (msj.compareTo("exit") != 0) {
                this.msj = entrada.readUTF();
                System.out.println(msj);

                if (this.msj.contains("X")) {
                    this.abuttons();
                    System.out.println("PASE1");
                    this.turno.setText("Es el Turno de: X");

                } else if (msj.contains("O")) {
                    System.out.println("PASE2");
                    this.turno.setText("Es el Turno de: O");
                    this.dbuttons();

                    if (msj.contains("-")) {
                        String[] r = msj.split("-");
                        System.out.println(r[1]);
                        if (msj.contains("Win")) {
                            this.letra =r[0];
                            this.ganador();
                            this.letra ="X";
                            this.dbuttons();
                        }

                        if (msj.contains("R")) {
                            this.dbuttons();
                            this.rContador();
                            this.letra ="X";

                            //salida.writeUTF("X");
                        }
                        else {
                            JButton boton = null;
                            switch (r[1]) {
                                case "1":
                                    boton = this.boton1;
                                    break;
                                case "2":
                                    boton = this.boton2;
                                    break;
                                case "3":
                                    boton = this.boton3;
                                    break;
                                case "4":
                                    boton = this.boton4;
                                    break;
                                case "5":
                                    boton = this.boton5;
                                    break;
                                case "6":
                                    boton = this.boton6;
                                    break;
                                case "7":
                                    boton = this.boton7;
                                    break;
                                case "8":
                                    boton = this.boton8;
                                    break;
                                case "9":
                                    boton = this.boton9;
                                    break;
                            }

                            if (boton != null) {
                                boton.setText("O");
                                salida.writeUTF("X");
                            }
                        }


                    }
                }
            }

        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
