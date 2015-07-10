
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

interface ListaFilm{
    public Product getFilm(String nome, String [] attributi);
    public LinkedList riempiLista() throws IOException;
    public void salvaLista() throws IOException;
}

class ListaDVD implements ListaFilm{
    LinkedList lista1;
    public ListaDVD(){
        lista1=new LinkedList();
    }
    @Override
    public Product getFilm(String nome, String [] attributi){
        DVD dvd=new DVD(nome,attributi);
        return dvd;
    }
    @Override
    public LinkedList riempiLista() throws IOException{
        Scanner in;
        in=new Scanner(new File("input.txt"));
        while(in.hasNext()){
            String riga=in.nextLine();
            String [] campi=riga.split(",");
            Product a=getFilm(campi[0],campi);
            lista1.add(a);    
        }
        in.close();
        return lista1;
    }
    @Override
    public void salvaLista() throws IOException{
        FileWriter w=new FileWriter("input.txt");
        PrintWriter p=new PrintWriter(w);
        int i=0;
        while(i<lista1.size()){
            Product c=(Product) lista1.get(i);
            String vett[]=c.getAttributi();
            p.println(vett[0]+","+vett[1]+","+vett[2]+","+vett[3]+","+vett[4]);
            i++;
        }
        p.close();
    }
}


class ListaBLURAY implements ListaFilm{
    LinkedList lista1;
    public ListaBLURAY(){
        lista1=new LinkedList();
    }
    @Override
    public Product getFilm(String nome, String [] attributi){
        BLURAY blu_ray=new BLURAY(nome,attributi);
        return blu_ray;
    }
    @Override
    public LinkedList riempiLista() throws IOException{
        Scanner in;
        in=new Scanner(new File("input2.txt"));
        while(in.hasNext()){
            String riga=in.nextLine();
            String [] campi=riga.split(",");
            Product a=getFilm(campi[0],campi);
            lista1.add(a);    
        }
        in.close();
        return lista1;
    }
    @Override
    public void salvaLista() throws IOException{
        FileWriter w=new FileWriter("input2.txt");
        PrintWriter p=new PrintWriter(w);
        int i=0;
        while(i<lista1.size()){
            Product c=(Product) lista1.get(i);
            String vett[]=c.getAttributi();
            p.println(vett[0]+","+vett[1]+","+vett[2]+","+vett[3]+","+vett[4]);
            i++;
        }
        p.close();
    }
    
}

interface Product{
    public String getNome();
    public String [] getAttributi();
    public String getTipo();
    public void setDisp(String s);
}

class DVD implements Product{
    String nome;
    String [] attributi;
    String TIPO="DVD";
    public DVD(String nome, String [] attributi){
        this.nome=nome;
        this.attributi=attributi;
    }
    @Override
    public String getNome(){return nome;}
    @Override
    public String [] getAttributi(){return attributi;}
    @Override
    public String getTipo(){
        return TIPO;
    }
    @Override
    public void setDisp(String s){
        attributi[3]=s;
    }
}

class BLURAY implements Product{
    String nome;
    String [] attributi;
    String TIPO="BLURAY";
    public BLURAY(String nome, String [] attributi){
        this.nome=nome;
        this.attributi=attributi;
    }
    @Override
    public String getNome(){return nome;}
    @Override
    public String [] getAttributi(){return attributi;}
    @Override
    public String getTipo(){
        return TIPO;
    }
    @Override
    public void setDisp(String s){
        attributi[3]=s;
    }
}