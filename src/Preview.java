
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Preview extends javax.swing.JFrame {
    Transazione trasf=new Transazione();
    Product output;
    String tipo;
    LinkedList list;
    ListaFilm lf1;
    public Preview(Product film, LinkedList lista, ListaFilm lf) {
        initComponents();
        l1.setText(film.getNome());
        l2.setText(film.getAttributi()[4]);
        //tipo=film.getTipo();
        output=film;
        list=lista;
        lf1=lf;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        l2 = new javax.swing.JLabel();
        Acquista = new javax.swing.JButton();
        Affitta = new javax.swing.JButton();
        Indietro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        l1.setText("prova");

        l2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(l2);

        Acquista.setText("Acquista");
        Acquista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcquistaActionPerformed(evt);
            }
        });

        Affitta.setText("Affitta");
        Affitta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AffittaActionPerformed(evt);
            }
        });

        Indietro.setText("Indietro");
        Indietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndietroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Affitta, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Acquista, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(Indietro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Acquista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Affitta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Indietro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-402)/2, (screenSize.height-395)/2, 402, 395);
    }// </editor-fold>//GEN-END:initComponents

    private void AcquistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcquistaActionPerformed
        trasf.acquista();
        Carrello car=new Carrello(trasf.prezzo(),"ACQUISTO",output,list,lf1);
        car.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_AcquistaActionPerformed

    private void AffittaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AffittaActionPerformed
        String i;
        i=JOptionPane.showInputDialog(null,"Inserisca per quanti giorni vuole affittare(1 2 3 4): " ,"ATTENZIONE!!" , JOptionPane.INFORMATION_MESSAGE);
        if(i.compareTo("1")==0 || i.compareTo("2")==0 || i.compareTo("3")==0 || i.compareTo("4")==0){
            int i2=Integer.parseInt(i);
            trasf.affitta(i2);
            Carrello car=new Carrello(trasf.prezzo(),"AFFITTO",output,list,lf1);
            car.setVisible(true);
            setVisible(false);
            dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Inserire valore corretto", "ATTENZIONE!!", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_AffittaActionPerformed

    private void IndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndietroActionPerformed
        tipo=output.getTipo();
        for(int i=0;i<list.size();i++){
            Product p=(Product)list.get(i);
            if(p.getNome().compareTo(output.getNome())==0){
                try {
                    p.setDisp("si");
                    lf1.salvaLista();
                } catch (IOException ex) {
                    Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        FilmSelezionati app = null;
        try {
            app = new FilmSelezionati(tipo);
        } catch (IOException ex) {
            Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
        }
        app.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_IndietroActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preview(null,null,null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acquista;
    private javax.swing.JButton Affitta;
    private javax.swing.JButton Indietro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    // End of variables declaration//GEN-END:variables
}

