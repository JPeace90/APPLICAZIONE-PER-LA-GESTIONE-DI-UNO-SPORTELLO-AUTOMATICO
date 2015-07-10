class Utente{
	private static Utente scheda=new Utente("Giovanni","0000");
	private String id;
	private String psw;
	public String[] dp;
	private Utente(String id, String psw){
		this.id=id;
		this.psw=psw;
		dp=new String[4];
	}
	public String getId(){return id;}
	public String getPsw(){return psw;}
	public static Utente Istance(){
		return scheda;
	}
	public void setDp(){
		dp[0]="Credito";
		dp[1]="20";
		dp[2]="Scadenza";
		dp[3]="24/12/2012";
	}
	public String getCredito(){
		return dp[1];
	}
        public void setCredito(int i){
            String j=""+i;
            dp[1]=j;
        }
}