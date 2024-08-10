package client;

import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{

    Client vc;

    public Hilo (Client vc) {
        super();
        this.vc = vc;
    }

    @Override
    public void run() {
        try {
            vc.so = new Socket(vc.host, vc.puerto);/*conectar a un servidor en localhost con puerto 5000*/
            //creamos el flujo de datos por el que se enviara un mensaje
            vc.salida = new DataOutputStream(vc.so.getOutputStream());
            vc.entrada = new DataInputStream(vc.so.getInputStream());

            vc.msj = "start";

            while (vc.msj.compareTo("exit") != 0) {
                vc.msj = vc.entrada.readUTF();
                System.out.println(vc.msj);

                if (vc.msj.contains("conected")) {
                    JOptionPane.showMessageDialog(null, "!!Que comience el juego¡¡ Tu eres: O" );
                    vc.juegoNuevo();
                    vc.salida.writeUTF("X");
                } else if (vc.msj.contains("O")) {
                    vc.turno.setText("Es el Turno de: O");
                    vc.abuttons();

                }

                 else if (vc.msj.contains("X")) {
                    vc.turno.setText("Es el Turno de: X");
                    vc.dbuttons();

                    if (vc.msj.contains("-")) {
                        String[] r = vc.msj.split("-");
                        System.out.println(r[1]);
                        if (vc.msj.contains("Win")) {
                            vc.letra =r[0];
                            vc.ganador();
                            vc.letra ="O";
                            vc.dbuttons();
                        }
                        
                        if (vc.msj.contains("R")) {
                            vc.rContador();
                            vc.dbuttons();
                            //vc.salida.writeUTF("X");
                        }
                        else {
                            JButton boton = null;
                            switch (r[1]) {
                                case "1":
                                    boton = vc.boton1;
                                    break;
                                case "2":
                                    boton = vc.boton2;
                                    break;
                                case "3":
                                    boton = vc.boton3;
                                    break;
                                case "4":
                                    boton = vc.boton4;
                                    break;
                                case "5":
                                    boton = vc.boton5;
                                    break;
                                case "6":
                                    boton = vc.boton6;
                                    break;
                                case "7":
                                    boton = vc.boton7;
                                    break;
                                case "8":
                                    boton = vc.boton8;
                                    break;
                                case "9":
                                    boton = vc.boton9;
                                    break;
                            }

                            if (boton != null) {
                                boton.setText("X");
                                vc.salida.writeUTF("O");
                            }
                        }
                    };

                    }
                }




        }
        catch(Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
