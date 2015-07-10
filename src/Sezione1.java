
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sezione1 extends javax.swing.JFrame {

    public Sezione1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dvd = new javax.swing.JButton();
        blu_ray = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dvd.setText("DVD");
        dvd.setAlignmentY(0.0F);
        dvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dvdActionPerformed(evt);
            }
        });

        blu_ray.setText("Blu-ray");
        blu_ray.setAlignmentY(0.0F);
        blu_ray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blu_rayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(dvd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(blu_ray, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(blu_ray)
                    .addComponent(dvd))
                .addGap(179, 179, 179))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-402)/2, (screenSize.height-327)/2, 402, 327);
    }// </editor-fold>//GEN-END:initComponents

    private void dvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dvdActionPerformed
        FilmSelezionati s2 = null;
        try {
            s2 = new FilmSelezionati("DVD");
        } catch (IOException ex) {
            Logger.getLogger(Sezione1.class.getName()).log(Level.SEVERE, null, ex);
        }
	s2.setVisible(true);
	setVisible(false);
	dispose();
    }//GEN-LAST:event_dvdActionPerformed

    private void blu_rayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blu_rayActionPerformed
        FilmSelezionati s3 = null;
        try {
            s3 = new FilmSelezionati("BLU-RAY");
        } catch (IOException ex) {
            Logger.getLogger(Sezione1.class.getName()).log(Level.SEVERE, null, ex);
        }
	s3.setVisible(true);
	setVisible(false);
	dispose();
    }//GEN-LAST:event_blu_rayActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Sezione1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blu_ray;
    private javax.swing.JButton dvd;
    // End of variables declaration//GEN-END:variables
}
