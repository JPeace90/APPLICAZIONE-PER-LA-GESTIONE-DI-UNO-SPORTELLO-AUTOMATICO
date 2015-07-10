
import javax.swing.JOptionPane;


public class Sezione0 extends javax.swing.JFrame {

    Utente iscorrente=Utente.Istance();
    int c=0;
    public Sezione0() {
        initComponents();
        iscorrente.setDp();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messaggio = new javax.swing.JLabel();
        testo = new javax.swing.JPasswordField();
        Avanti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messaggio.setText("Inserire la password");

        Avanti.setText("Avanti");
        Avanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvantiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Avanti)
                    .addComponent(messaggio)
                    .addComponent(testo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(messaggio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Avanti)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-402)/2, (screenSize.height-327)/2, 402, 327);
    }// </editor-fold>//GEN-END:initComponents

    private void AvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvantiActionPerformed
        if(testo.getText().compareTo(iscorrente.getPsw())!=0){
		JOptionPane.showMessageDialog(null,"Inserire password corretta", "Attenzione",JOptionPane.INFORMATION_MESSAGE);
                c++;
		testo.setText("");
                if(c==5){
                    JOptionPane.showMessageDialog(null,"Numero massimo di tentativi raggiunti", "Attenzione",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
	}
	else {
            Sezione1 s1=new Sezione1();
            s1.setVisible(true);
            setVisible(false);
            dispose();
				}
    }//GEN-LAST:event_AvantiActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Sezione0().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Avanti;
    private javax.swing.JLabel messaggio;
    private javax.swing.JPasswordField testo;
    // End of variables declaration//GEN-END:variables
}

