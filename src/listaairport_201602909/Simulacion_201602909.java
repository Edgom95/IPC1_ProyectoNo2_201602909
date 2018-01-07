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
import static listaairport_201602909.DatosSim_201602909.NoER;
import listaairport_201602909.listas.Avion_201602909;
import listaairport_201602909.listas.Cola_201602909;
import listaairport_201602909.listas.ListaDobleEnlazada_201602909;
import listaairport_201602909.listas.ListaEnlazadaCircular_201602909;
import listaairport_201602909.listas.ListaEnlazadaColaPila_201602909;
import listaairport_201602909.listas.ListaEnlazadaSimple_201602909;
import listaairport_201602909.listas.Pasajero_201602909;
import listaairport_201602909.listas.Pila_201602909;

/**
 *
 * @author edgom
 */
public class Simulacion_201602909 extends javax.swing.JFrame {
  
    public static int T1;
    public static int T2;
    public ListaDobleEnlazada_201602909 la = new ListaDobleEnlazada_201602909("ListaAviones");
    public ListaEnlazadaSimple_201602909 les = new ListaEnlazadaSimple_201602909("ListaPasajeros");
    public ListaEnlazadaColaPila_201602909 lec = new ListaEnlazadaColaPila_201602909("ListaEstacionesRegistro"); 
    public Cola_201602909 cola = new Cola_201602909();
    public Pila_201602909 pila = new Pila_201602909("Pila");
    public ListaEnlazadaCircular_201602909 lecir = new ListaEnlazadaCircular_201602909("ListaMaletas");
    public int cont=0;

    public Simulacion_201602909() {
        initComponents();
        this.setLocationRelativeTo(null);
        Simulacion();
    }

    public void Simulacion() {

        if (T1 < NoAviones) {
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
            Avion_201602909 avion = new Avion_201602909(T1 + 1, nopasajeros, desabordaje, nomantenimiento);  // (nombre,no_pasajeros,no_turnos,no_turnos_mantenimiento)
            la.insertarAlFin(avion);
            int pass = avion.getNoPasajeros();
            la.infoDot();
            la.GenImagen("ListaAviones.dot", "Aviones.png");
            la.descontarTurnoAvion();
            if (avion.getNoTurnos() == 0) {
                la.eliminarAvion(avion);
            }
            while (pass != 0) {
                int nomaletas = (int) ((Math.random() * 3) + 1);
                int nodocumentos = (int) ((Math.random() * 9) + 1);
                int noturnos = (int) ((Math.random() * 2) + 1);
                int j=1;
                Pasajero_201602909 pasajero = new Pasajero_201602909(T1 + 1, nomaletas, nodocumentos, noturnos);
                les.insertarAlFin(pasajero);
                les.infoDot();
                les.GenImagen("ListaPasajeros.dot", "Pasajeros.png");
//                les.descontarTurnoPasajero();
//                if (pasajero.getNoTurnos() == 0) {
//                    les.eliminarPasajero(pasajero);
//                }
                int maleta = nomaletas;
                switch (maleta) {
                    case 1:
                        lecir.insertarInicio(1);
                        lecir.infoDot();
                        lecir.GenImagen("ListaMaletas.dot", "Maletas.png");
                        break;
                    case 2:
                        lecir.insertarInicio(1);
                        lecir.insertarInicio(2);
                        lecir.infoDot();
                        lecir.GenImagen("ListaMaletas.dot", "Maletas.png");
                        break;
                    case 3:
                        lecir.insertarInicio(1);
                        lecir.insertarInicio(2);
                        lecir.insertarInicio(3);
                        lecir.infoDot();
                        lecir.GenImagen("ListaMaletas.dot", "Maletas.png");
                        break;
                    case 4:
                        lecir.insertarInicio(1);
                        lecir.insertarInicio(2);
                        lecir.insertarInicio(3);
                        lecir.insertarInicio(4);
                        lecir.infoDot();
                        lecir.GenImagen("ListaMaletas.dot", "Maletas.png");
                }
                
                if (T2 < NoER) {
                    for (int i = 0; i <= 10; i++) {
                        cola.insertar(pasajero);
                        pila.push(pasajero.getNoDocumentos());
                    }
                    lec.insertarALFin(cola,pila);
                    lec.infoDot();
                    lec.GenImagen("ListaEstacionesRegistro.dot", "EstacionesRegistro.png");
                }
                pass--;
                T2++;
            }
            T1++;
            ColocarImagenes();
        }
    }
    
    public void ColocarImagenes() {
        ImageIcon aviones, pasajeros, estaciones, maletas;
        Icon av, pass, er, mal;
        aviones = new ImageIcon("Aviones.png");
        av = new ImageIcon(aviones.getImage().getScaledInstance(laviones.getWidth(), laviones.getHeight(), Image.SCALE_SMOOTH));
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
        simauto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setTitle("ListaAIRPORT");
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

        simauto.setBackground(new java.awt.Color(255, 255, 255));
        simauto.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        simauto.setForeground(new java.awt.Color(0, 0, 0));
        simauto.setText("Simular-Auto");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Aviones");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Desabordaje");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("E. Registro");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Equipaje");

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Colonna MT", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Mantenimiento");

        jLabel3.setFont(new java.awt.Font("Colonna MT", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Consola");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ldesabordaje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(simauto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnpasarturno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(laviones, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ldesabordaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lequipaje, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnpasarturno)
                                .addGap(21, 21, 21)
                                .addComponent(simauto)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ler, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpasarturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasarturnoActionPerformed
    Simulacion();
    ColocarImagenes();
    cont++;
    }//GEN-LAST:event_btnpasarturnoActionPerformed

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
    private javax.swing.JButton btnpasarturno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel laviones;
    private javax.swing.JLabel ldesabordaje;
    private javax.swing.JLabel lequipaje;
    private javax.swing.JLabel ler;
    private javax.swing.JLabel lmantenimiento;
    private javax.swing.JButton simauto;
    // End of variables declaration//GEN-END:variables
}
