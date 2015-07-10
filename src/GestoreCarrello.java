
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class GestoreCarrello{
    DefaultTableModel tableData=new DefaultTableModel();
    String nome;
    public static String [] nomifilm=new String[4];
    public static int [] prezzifilm={0,0,0,0};
    private int j=0;
    private static GestoreCarrello gestore1=new GestoreCarrello("Carrello");
    private GestoreCarrello(String nome){
        tableData.addColumn("Film");
        tableData.addColumn("Tipo");
        tableData.addColumn("Transazione");
        tableData.addColumn("Prezzo");
        this.nome=nome;
    }
    public static GestoreCarrello Istance(){
        return gestore1;
    }
    public DefaultTableModel getDefaultModel(){
        return tableData;
    }
    public void inserisciElementi(Product film,int prezzo){
        nomifilm[j]=film.getNome();
        prezzifilm[j]=prezzo;
        j++;
    }
    public void eliminaElemento(int index){
        nomifilm[index]="vuoto";
        prezzifilm[index]=0;
        j--;
    }
    public int aggiornaSpesa(){
        int credTot=0;
        for (int i=0;i<prezzifilm.length;i++){
            credTot+=prezzifilm[i];
        }
        return credTot;
    }
    public int aggiornaCredito(int credUtente){
        int credAgg=credUtente-aggiornaSpesa();
        if(credAgg<0) JOptionPane.showMessageDialog(null, "Credito Insufficiente - Cliccare sul bottone ricarica per aggiungere nuovo credito", "ATTENZIONE!", JOptionPane.INFORMATION_MESSAGE);
        return credAgg;
    }
    public void riempiStorico(String tipoTrans,int prezzo2,Product film){
        String prezzo=""+prezzo2;
        tableData.addRow(new String[]{film.getNome(),film.getTipo(),tipoTrans,prezzo});
    }
    public void eliminaVoceStorico(int index){
        tableData.removeRow(index);
    }
}
