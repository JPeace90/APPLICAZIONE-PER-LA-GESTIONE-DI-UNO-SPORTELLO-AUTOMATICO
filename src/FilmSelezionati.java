import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class FilmSelezionati extends javax.swing.JFrame {
    DefaultTableModel tableData=new DefaultTableModel();
    ListaFilm lista;
    LinkedList list;
    String tipo;
    public FilmSelezionati(String s) throws IOException {
        initComponents();
        tableData.addColumn("Titolo");
        tableData.addColumn("Durata");
        tableData.addColumn("Anno");
        tableData.addColumn("Disponibile");
        if(s.compareTo("DVD")==0){
            lista=new ListaDVD();
            list=lista.riempiLista();
            visualizzaDVD(list);
	}
        else{
            lista=new ListaBLURAY();
            list=lista.riempiLista();
            visualizzaBLURAY(list);
	}
        tipo=s;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        go = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable(){
            @Override public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Indietro = new javax.swing.JButton();
        goToCart = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(427, 500));
        setPreferredSize(new java.awt.Dimension(427, 500));
        setResizable(false);

        go.setText("Avanti");
        go.setAlignmentY(0.0F);
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });

        tabella.getTableHeader().setReorderingAllowed(false);
        tabella.setModel(tableData);
        tabella.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tabella);

        Indietro.setText("Indietro");
        Indietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndietroActionPerformed(evt);
            }
        });

        goToCart.setText("Vai al Carrello");
        goToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Indietro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(go, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(go)
                    .addComponent(Indietro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToCart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-429)/2, (screenSize.height-364)/2, 429, 364);
    }// </editor-fold>//GEN-END:initComponents

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        int selectedRow = tabella.getSelectedRow();
        if(selectedRow!=-1){
        String riga=(String) tabella.getValueAt(selectedRow, 0);
        String disponibile=(String)tabella.getValueAt(selectedRow, 3);
        if(disponibile.compareTo("si")==0){
            tabella.setValueAt("no", selectedRow, 3);
            for(int i=0;i<list.size();i++){
                Product p=(Product) list.get(i);
                //System.out.print(p.getNome()+" "+p.getAttributi()[3]);
                if(riga.compareTo(p.getNome())==0){
                    try {
                        p.setDisp("no");
                        lista.salvaLista();
                        //Product c=(Product)list.get(i);
                        //System.out.println(c.getNome()+" "+c.getAttributi()[3]);
                        Preview s3=new Preview(p,list,lista);
                        s3.setVisible(true);
                        setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(FilmSelezionati.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else JOptionPane.showMessageDialog(null, "Prodotto già selezionato o non disponibile", "ATTENZIONE!!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Non hai selezionato nessuna voce", "ATTENZIONE!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_goActionPerformed

    private void IndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndietroActionPerformed
        Sezione1 app=new Sezione1();
        app.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_IndietroActionPerformed

    private void goToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToCartActionPerformed
        Carrello c=new Carrello(0,"",null,null,null);
        setVisible(false);
        dispose();
        c.setVisible(true);
    }//GEN-LAST:event_goToCartActionPerformed
    public void visualizzaDVD(LinkedList list){
        for (int i=0;i<list.size();i++){
            DVD a=(DVD) list.get(i);
            tableData.addRow(new String[]{a.getAttributi()[0],a.getAttributi()[1],a.getAttributi()[2],a.getAttributi()[3]});
        }
    }
    
    public void visualizzaBLURAY(LinkedList list){
        for (int i=0;i<list.size();i++){
            BLURAY a=(BLURAY) list.get(i);
            tableData.addRow(new String[]{a.getAttributi()[0],a.getAttributi()[1],a.getAttributi()[2],a.getAttributi()[3]});
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new FilmSelezionati("DVD").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FilmSelezionati.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Indietro;
    private javax.swing.JButton go;
    private javax.swing.JButton goToCart;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables
}