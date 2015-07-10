
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Carrello extends javax.swing.JFrame {
    DefaultTableModel tableData;
    GestoreCarrello gestore;
    Product film;
    Utente u=Utente.Istance();
    int cred;
    String tipo="";
    LinkedList list;
    ListaFilm lf1;
    public Carrello(int prezzo, String trans, Product output, LinkedList lista,ListaFilm lf) {
        gestore=GestoreCarrello.Istance();
        tableData=gestore.getDefaultModel();
        initComponents();
        if (output!=null){
            film=output;
            gestore.inserisciElementi(film,prezzo);
            cred=gestore.aggiornaCredito(Integer.parseInt(u.getCredito()));
            gestore.riempiStorico(trans, prezzo,film);
            l4.setText(u.getCredito());
            l5.setText(""+gestore.aggiornaSpesa());
            l6.setText(""+cred);
            tipo=film.getTipo();
            if(cred<0){
                prosegui.setEnabled(false);
            }
            list=lista;
            lf1=lf;
        }
        else{
            cred=gestore.aggiornaCredito(Integer.parseInt(u.getCredito()));
            l4.setText(u.getCredito());
            l5.setText(""+gestore.aggiornaSpesa());
            l6.setText(""+cred);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tab2 = new javax.swing.JTable();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        prosegui = new javax.swing.JButton();
        ricarica = new javax.swing.JButton();
        deleteAll = new javax.swing.JButton();
        goToLista = new javax.swing.JButton();
        help = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab2.getTableHeader().setReorderingAllowed(false);
        tab2.setModel(tableData);
        tab2.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(tab2);

        l1.setText("Credito");

        l2.setText("Prezzo");

        l3.setText("Credito Residuo");

        l4.setText("jLabel4");

        l5.setText("jLabel5");

        l6.setText("jLabel6");

        prosegui.setText("Prosegui");
        prosegui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proseguiActionPerformed(evt);
            }
        });

        ricarica.setText("Ricarica");
        ricarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ricaricaActionPerformed(evt);
            }
        });

        deleteAll.setText("Elimina tutto");
        deleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllActionPerformed(evt);
            }
        });

        goToLista.setText("Lista");
        goToLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToListaActionPerformed(evt);
            }
        });

        help.setText("Credits");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        delete.setText("Elimina voce");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goToLista, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(ricarica, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prosegui, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l4)
                            .addComponent(l6)
                            .addComponent(l5))
                        .addGap(85, 85, 85)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete))
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l1)
                            .addComponent(l4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l2)
                            .addComponent(l5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l3)
                            .addComponent(l6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosegui)
                    .addComponent(ricarica)
                    .addComponent(goToLista)
                    .addComponent(help))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-569)/2, (screenSize.height-388)/2, 569, 388);
    }// </editor-fold>//GEN-END:initComponents

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Sviluppatori:\n Giovanni Modica\n Giovanni Pisana\nPer recuperare la password mandare una mail a admin@admin.it\nTel: 0932 666666 \nFax:0932 666667 \nSito:www.videoteca.it ", "Credits", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpActionPerformed

    private void proseguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proseguiActionPerformed
        u.setCredito(Integer.parseInt(l5.getText()));
        System.exit(0);
    }//GEN-LAST:event_proseguiActionPerformed

    private void goToListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToListaActionPerformed
        Sezione1 lista=new Sezione1();
        lista.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_goToListaActionPerformed

    private void deleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllActionPerformed
        for (int i=tab2.getRowCount()-1;i>=0 ;i--){
            for(int j=0;j<list.size();j++){
                Product p=(Product)list.get(j);
                if(p.getNome().compareTo((String)tab2.getValueAt(i,0))==0){
                    try {
                        p.setDisp("si");
                        lf1.salvaLista();
                    } catch (IOException ex) {
                        Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            gestore.eliminaVoceStorico(i);
            gestore.eliminaElemento(i);
        }
        l5.setText(""+gestore.aggiornaSpesa());
        l6.setText(""+gestore.aggiornaCredito(Integer.parseInt(l4.getText())));
        if(Integer.parseInt(l6.getText())>=0){
            prosegui.setEnabled(true);
        }
    }//GEN-LAST:event_deleteAllActionPerformed

    private void ricaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ricaricaActionPerformed
        String ricaricaS=JOptionPane.showInputDialog(rootPane, "Inserire banconote in pezzi da 5€ 10€ o 20€", "Ricarica", JOptionPane.INFORMATION_MESSAGE);
        int ricarica=Integer.parseInt(ricaricaS);
        int credito=Integer.parseInt(u.getCredito());
        ricarica=ricarica+credito;
        u.setCredito(ricarica);
        l4.setText(""+ricarica);
        int ris=ricarica-Integer.parseInt(l5.getText());
        l6.setText(""+ris);
        if(ris>=0){
            prosegui.setEnabled(true);
        }
    }//GEN-LAST:event_ricaricaActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(tab2.getSelectedRow()!=-1){
            int selectedRow = tab2.getSelectedRow();
            System.out.print(selectedRow);
            for(int i=0;i<list.size();i++){
                Product p=(Product)list.get(i);
                if(p.getNome().compareTo((String)tableData.getValueAt(selectedRow, 0))==0){
                    try {
                        p.setDisp("si");
                        lf1.salvaLista();
                    } catch (IOException ex) {
                        Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            gestore.eliminaElemento(selectedRow);
            gestore.eliminaVoceStorico(selectedRow);
            l5.setText(""+gestore.aggiornaSpesa());
            l6.setText(""+gestore.aggiornaCredito(Integer.parseInt(l4.getText())));
            if(Integer.parseInt(l6.getText())>=0){
                prosegui.setEnabled(true);
            }
            
        }
        else{
                JOptionPane.showMessageDialog(null, "Non hai selezionato nessuna voce", "ATTENZIONE!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrello(0,"",null,null,null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteAll;
    private javax.swing.JButton goToLista;
    private javax.swing.JButton help;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JButton prosegui;
    private javax.swing.JButton ricarica;
    private javax.swing.JTable tab2;
    // End of variables declaration//GEN-END:variables
}

