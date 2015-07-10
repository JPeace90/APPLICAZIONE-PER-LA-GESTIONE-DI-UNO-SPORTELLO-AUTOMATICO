class Transazione{
    private State trans;
    public Transazione(){
        
    }
    public void acquista(){
        trans=new Acquista();
    }
    public void affitta(int i){
        trans=new Affitta(i);
    }
    public int prezzo(){
        return trans.getPrezzo();
    }
}

interface State{
    public int getPrezzo();
}

class Acquista implements State{
    public int prezzo;
    public Acquista(){
        prezzo=20;
    }
    @Override
    public int getPrezzo(){
        return prezzo;
    }
}

class Affitta implements State{
    public int prezzo,giorni;
    public Affitta(int i){
        prezzo=3;
        giorni=i;
    }
    @Override
    public int getPrezzo(){
        int prezzotot=giorni*prezzo;
        return prezzotot;
    }
}
