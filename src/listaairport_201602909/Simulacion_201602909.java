/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaairport_201602909;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static listaairport_201602909.DatosSim_201602909.NoAviones;
import static listaairport_201602909.DatosSim_201602909.NoEM;
import static listaairport_201602909.DatosSim_201602909.NoER;
import listaairport_201602909.listas.Avion_201602909;
import listaairport_201602909.listas.Cola_201602909;
import listaairport_201602909.listas.ListaDobleEnlazada_201602909;
import listaairport_201602909.listas.ListaEnlazadaCircular_201602909;
import listaairport_201602909.listas.ListaEnlazadaColaPila_201602909;
import listaairport_201602909.listas.ListaEnlazadaSimple_201602909;
import listaairport_201602909.listas.ListaSimpleCola_201602909;
import listaairport_201602909.listas.Pasajero_201602909;
import listaairport_201602909.listas.Pila_201602909;

/**
 *
 * @author edgom
 */
public class Simulacion_201602909 extends javax.swing.JFrame {

    public static int TurnoAvion;
    public static int TurnoER;
    public static int TurnoMant;
    public ListaDobleEnlazada_201602909 la = new ListaDobleEnlazada_201602909("ListaAviones");
    public ListaEnlazadaSimple_201602909 les = new ListaEnlazadaSimple_201602909("ListaPasajeros");
    public ListaEnlazadaColaPila_201602909 lec = new ListaEnlazadaColaPila_201602909("ListaEstacionesRegistro");
    public Cola_201602909 cola1 = new Cola_201602909();
    public Cola_201602909 cola2 = new Cola_201602909();
    public Pila_201602909 pila = new Pila_201602909("Pila");
    public ListaEnlazadaCircular_201602909 lecir = new ListaEnlazadaCircular_201602909("ListaMaletas");
    public ListaSimpleCola_201602909 lsc = new ListaSimpleCola_201602909("ListaMantenimiento");
    public int cont = 0;
    public String aviones = "";
    public String pespera = "";
    public String nmaletas = "";
//    public String eregistro = "";
//    public String emant = "";

    public Simulacion_201602909() {
        initComponents();
        this.setLocationRelativeTo(null);
        Simulacion();
        laviones.repaint();
        ldesabordaje.repaint();
        ler.repaint();
        lequipaje.repaint();
        lmantenimiento.repaint();
    }

    public void Simulacion() {
        if (cont > 0) {
            if (TurnoAvion < NoAviones) {
                int nomantenimiento = 0;
                int desabordaje = 0;
                int nopasajeros = (int) ((Math.random() * 35) + 5);
                if ((nopasajeros >= 5) && (nopasajeros <= 10)) {
                    desabordaje = 1;
                    nomantenimiento = (int) ((Math.random() * 2) + 1);
                } else if ((nopasajeros >= 10) && (nopasajeros <= 25)) {
                    desabordaje = 2;
                    nomantenimiento = (int) ((Math.random() * 2) + 2);
                } else if ((nopasajeros >= 25) && (nopasajeros <= 40)) {
                    desabordaje = 3;
                    nomantenimiento = (int) ((Math.random() * 3) + 3);
                }
                Avion_201602909 avion = new Avion_201602909(TurnoAvion+ 1, nopasajeros, desabordaje, nomantenimiento);
                aviones += "Avion: " + avion.getNombre() + "\n";
                aviones += "No Pasajeros: " + avion.getNoPasajeros() + "\n";
                aviones += "Turnos: " + avion.NoTurnos + "\n";
                aviones += "Turnos Mantenimiento: " + avion.getNoTurnosMantenimiento() + "\n";
                aviones += "*********************************\n";
                la.insertarAlFin(avion);
                int pass = avion.getNoPasajeros();
//                if (cont > 1) {
//                    la.descontarTurnoAvion();
//                    la.eliminarAvion(la.buscar(0));
//                }
                la.infoDot();
                la.GenImagen("ListaAviones.dot", "Aviones.png");
                while (pass != 0) {
                    int nomaletas = (int) ((Math.random() * 3) + 1);
                    int nodocumentos = (int) ((Math.random() * 9) + 1);
                    int noturnos = (int) ((Math.random() * 2) + 1);
                    Pasajero_201602909 pasajero = new Pasajero_201602909(TurnoAvion + 1, nomaletas, nodocumentos, noturnos);
                    les.insertarAlFin(pasajero);

                    les.infoDot();
                    les.GenImagen("ListaPasajeros.dot", "Pasajeros.png");
                    int maleta = nomaletas;
                    switch (maleta) {
                        case 1:
                            lecir.insertarInicio(1);
                            break;
                        case 2:
                            lecir.insertarInicio(1);
                            lecir.insertarInicio(2);
                            break;
                        case 3:
                            lecir.insertarInicio(1);
                            lecir.insertarInicio(2);
                            lecir.insertarInicio(3);
                            break;
                        case 4:
                            lecir.insertarInicio(1);
                            lecir.insertarInicio(2);
                            lecir.insertarInicio(3);
                            lecir.insertarInicio(4);
                            break;
                    }
                    lecir.infoDot();
                    lecir.GenImagen("ListaMaletas.dot", "Maletas.png");

                    if (TurnoER < NoER) {
                        for (int i = 0; i <= 10; i++) {
                            cola1.insertar(pasajero);
                            pila.push(pasajero.getNoDocumentos());
                        }
                        lec.insertarALFin(cola1, pila);
                        lec.infoDot();
                        lec.GenImagen("ListaEstacionesRegistro.dot", "EstacionesRegistro.png");
                    }
                    pass--;
                    TurnoER++;
                    if (TurnoMant < NoEM) {
                        for (int k = 0; k <= TurnoMant; k++) {
                            cola2.insertar(avion);
                        }
                        lsc.insertarAlFin(cola2);
                        lsc.infoDot();
                        lsc.GenImagen("ListaMantenimiento.dot", "Mantenimiento.png");
                    }
                    TurnoMant++;

                }
                pespera += "Pasajeros Desabordaje\n";
                pespera += "No: " + les.tamaño() + "\n";
                pespera += "*********************************\n";
                nmaletas += " Total Maletas \n";
                nmaletas += "No: " + lecir.Tamaño() + "\n";
                nmaletas += "*********************************\n";
//                eregistro += "E. Registro Disponibles \n";
//                eregistro += "No: " + lec.tamaño() + "\n";
//                eregistro += "********************************\n";
//                emant += "E. Mantenimiento";
//                emant += "No. " + lsc.tamaño() + "\n";
//                emant += "********************************\n";
                TurnoAvion++;
                ColocarImagenes();
                Consola();
            }
        }
    }

    public void ColocarImagenes() {
        ImageIcon avio, pasajeros, estaciones, maletas, mantenimiento;
        Icon av, pass, er, mal, man;
        avio = new ImageIcon("Aviones.png");
        av = new ImageIcon(avio.getImage().getScaledInstance(laviones.getWidth(), laviones.getHeight(), Image.SCALE_SMOOTH));
        laviones.setIcon(av);
        laviones.repaint();
        pasajeros = new ImageIcon("Pasajeros.png");
        pass = new ImageIcon(pasajeros.getImage().getScaledInstance(ldesabordaje.getWidth(), ldesabordaje.getHeight(), Image.SCALE_SMOOTH));
        ldesabordaje.setIcon(pass);
        ldesabordaje.repaint();
        estaciones = new ImageIcon("EstacionesRegistro.png");
        er = new ImageIcon(estaciones.getImage().getScaledInstance(ler.getWidth(), ler.getHeight(), Image.SCALE_SMOOTH));
        ler.setIcon(er);
        ler.repaint();
        maletas = new ImageIcon("Maletas.png");
        mal = new ImageIcon(maletas.getImage().getScaledInstance(lequipaje.getWidth(), lequipaje.getHeight(), Image.SCALE_SMOOTH));
        lequipaje.setIcon(mal);
        lequipaje.repaint();
        mantenimiento = new ImageIcon("Mantenimiento.png");
        man = new ImageIcon(mantenimiento.getImage().getScaledInstance(lmantenimiento.getWidth(), lmantenimiento.getHeight(), Image.SCALE_SMOOTH));
        lmantenimiento.setIcon(man);
        lmantenimiento.repaint();
    }

    public void Consola() {
        String cadena = "";
        cadena += "*********************************\n";
        cadena += "      ListaAIRPORT-Consola       \n";
        cadena += "*********************************\n";
        cadena += "          ***Turno: " + cont + "***  \n";
        cadena += "*********************************\n";
        cadena += "          Avion AIRPORT            \n";
        cadena += aviones;
        cadena += "*********************************\n";
        cadena += pespera;
        cadena += "*********************************\n";
        cadena += nmaletas;
        cadena += "*********************************\n";
//        cadena += eregistro;
//        cadena += "*********************************\n";
//        cadena += emant;
//        cadena += "*********************************\n";
        if (cont == NoAviones + 2) {
            cadena += "*********************************\n";
            cadena += "       Fin Simulacion            \n";
            cadena += "*********************************\n";
        }
        txtconsola.setText(cadena);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        laviones = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ldesabordaje = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ler = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lequipaje = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lmantenimiento = new javax.swing.JLabel();
        btnpasarturno = new javax.swing.JButton();
        btnauto = new javax.swing.JButton();
        btnaviones = new javax.swing.JButton();
        btndesabordaje = new javax.swing.JButton();
        btner = new javax.swing.JButton();
        btnequipaje = new javax.swing.JButton();
        btnmantenimiento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtconsola = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ListaAIRPORT-Simulacion");
        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Colonna MT", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Aviones");

        jLabel2.setFont(new java.awt.Font("Colonna MT", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Desabordaje");

        jLabel4.setFont(new java.awt.Font("Colonna MT", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estacion de Registro");

        jLabel6.setFont(new java.awt.Font("Colonna MT", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Equipaje");

        jLabel8.setFont(new java.awt.Font("Colonna MT", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Mantenimiento");

        btnpasarturno.setBackground(new java.awt.Color(255, 255, 255));
        btnpasarturno.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btnpasarturno.setForeground(new java.awt.Color(0, 0, 0));
        btnpasarturno.setText("Avanzar Turno");
        btnpasarturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpasarturnoActionPerformed(evt);
            }
        });

        btnauto.setBackground(new java.awt.Color(255, 255, 255));
        btnauto.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btnauto.setForeground(new java.awt.Color(0, 0, 0));
        btnauto.setText("Simular-Auto");
        btnauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnautoActionPerformed(evt);
            }
        });

        btnaviones.setBackground(new java.awt.Color(255, 255, 255));
        btnaviones.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btnaviones.setForeground(new java.awt.Color(0, 0, 0));
        btnaviones.setText("Aviones");
        btnaviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnavionesActionPerformed(evt);
            }
        });

        btndesabordaje.setBackground(new java.awt.Color(255, 255, 255));
        btndesabordaje.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btndesabordaje.setForeground(new java.awt.Color(0, 0, 0));
        btndesabordaje.setText("Desabordaje");
        btndesabordaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesabordajeActionPerformed(evt);
            }
        });

        btner.setBackground(new java.awt.Color(255, 255, 255));
        btner.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btner.setForeground(new java.awt.Color(0, 0, 0));
        btner.setText("E. Registro");
        btner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnerActionPerformed(evt);
            }
        });

        btnequipaje.setBackground(new java.awt.Color(255, 255, 255));
        btnequipaje.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btnequipaje.setForeground(new java.awt.Color(0, 0, 0));
        btnequipaje.setText("Equipaje");
        btnequipaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnequipajeActionPerformed(evt);
            }
        });

        btnmantenimiento.setBackground(new java.awt.Color(255, 255, 255));
        btnmantenimiento.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        btnmantenimiento.setForeground(new java.awt.Color(0, 0, 0));
        btnmantenimiento.setText("Mantenimiento");
        btnmantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmantenimientoActionPerformed(evt);
            }
        });

        txtconsola.setBackground(new java.awt.Color(0, 0, 0));
        txtconsola.setColumns(20);
        txtconsola.setForeground(new java.awt.Color(0, 204, 0));
        txtconsola.setRows(5);
        jScrollPane1.setViewportView(txtconsola);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Terminar Simulacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laviones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(ldesabordaje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ler, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lequipaje, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnpasarturno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnmantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnauto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnequipaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btndesabordaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnaviones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(laviones, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(ldesabordaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ler, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnaviones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndesabordaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btner)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnequipaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lequipaje, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(btnmantenimiento)
                                    .addGap(47, 47, 47)
                                    .addComponent(btnauto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnpasarturno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(lmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpasarturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasarturnoActionPerformed
        if (cont > 0) {
            Simulacion();
            ColocarImagenes();
            Consola();
        }
        cont++;
    }//GEN-LAST:event_btnpasarturnoActionPerformed

    private void btnavionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnavionesActionPerformed
        PAvion_201602909 pa = new PAvion_201602909();
        pa.setVisible(true);
    }//GEN-LAST:event_btnavionesActionPerformed

    private void btndesabordajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesabordajeActionPerformed
        PDesabordaje_201602909 pda = new PDesabordaje_201602909();
        pda.setVisible(true);
    }//GEN-LAST:event_btndesabordajeActionPerformed

    private void btnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnerActionPerformed
        PERegistro_201602909 per = new PERegistro_201602909();
        per.setVisible(true);
    }//GEN-LAST:event_btnerActionPerformed

    private void btnequipajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnequipajeActionPerformed
        PEquipaje_201602909 pe = new PEquipaje_201602909();
        pe.setVisible(true);
    }//GEN-LAST:event_btnequipajeActionPerformed

    private void btnmantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmantenimientoActionPerformed
        PMantenimiento_201602909 pem = new PMantenimiento_201602909();
        pem.setVisible(true);
    }//GEN-LAST:event_btnmantenimientoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnautoActionPerformed
        while (cont != NoAviones + 3) {
            Simulacion();
            ColocarImagenes();
            Consola();
            cont++;
        }
    }//GEN-LAST:event_btnautoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulacion_201602909.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion_201602909.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion_201602909.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion_201602909.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Simulacion_201602909().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnauto;
    private javax.swing.JButton btnaviones;
    private javax.swing.JButton btndesabordaje;
    private javax.swing.JButton btnequipaje;
    private javax.swing.JButton btner;
    private javax.swing.JButton btnmantenimiento;
    private javax.swing.JButton btnpasarturno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel laviones;
    private javax.swing.JLabel ldesabordaje;
    private javax.swing.JLabel lequipaje;
    private javax.swing.JLabel ler;
    private javax.swing.JLabel lmantenimiento;
    private javax.swing.JTextArea txtconsola;
    // End of variables declaration//GEN-END:variables
}
