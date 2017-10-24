package P3;


public class Cuenta {
		private long  numCuenta;
		private float Saldo;
		private float Limite;
		private Fecha apertura;
		private Fecha cierre;
		
		private Cliente titulares[]=new Cliente[5];
		private int numTitulares = 0;
		
		private static long N_CUENTA_INICIAL = 10000;
		private static final float LIMITE=100;
		
		public Cuenta(Cliente cliente,Fecha apertura,Fecha cierre){
			this.numCuenta = N_CUENTA_INICIAL++;
			this.Saldo  = 0;
			this.Limite = LIMITE;
			this.titulares[0]=cliente;
			this.numCuenta++;
			this.apertura = apertura;
			this.cierre   = cierre;
			this.numTitulares=1;
		}
		public Cuenta(Cliente titulares[],Fecha apertura,Fecha cierre){
			this.numCuenta = N_CUENTA_INICIAL++;
			this.Saldo  = 0;
			this.Limite = LIMITE;
			for(int i=0;i<titulares.length;i++){
				this.titulares[i] = titulares[i];
				this.numTitulares++;
			}
			this.apertura = apertura;
			this.cierre   = cierre;
		}
		
		
		public boolean existeTitular(String dni){
			int i=0;
			boolean encontrado=false;
			while(i<5 && !encontrado){
				if(this.titulares[i]!=null && this.titulares[i].getDNI().equalsIgnoreCase(dni)){
					encontrado=true;					
				}
				i++;
			}
			return encontrado;
		}
		public void agregarTitular(Cliente nuevoTitular){
			if(existeTitular(nuevoTitular.getDNI())){
				System.out.println("No se puede agregar un titular que ya existe");
			}
			else if(this.numTitulares<5){
				this.titulares[this.numTitulares] = nuevoTitular;
				this.numTitulares++;
			}
			else{
				System.out.println("No puedes agregar mas de 5 titulares");
			}
		}
		
		public String toString2(){
			String cadena="";
			cadena += "Nº Cuenta     : "+numCuenta+"\n";
			cadena += "Saldo         : "+Saldo+"\n";
			cadena += "Primer titular\n"+this.titulares[0].toString2()+"\n";
			
			return cadena;
		}
		public String toString(){
			String cadena="";
			cadena += "Nº Cuenta     : "+numCuenta+"\n";
			cadena += "Saldo         : "+Saldo+"\n";
			cadena += "Limite        : "+Limite+"\n";
			cadena += "Fecha Apertura: "+apertura.toString()+"\n";
			cadena += "Fecha Cierre  : "+cierre.toString()+"\n"; 
			cadena += "Primer titulares\n";
			for(int i=0;i<this.numTitulares;i++){
				cadena += this.titulares[i].toString2()+"\n";
			}
			
			return cadena;
		}
		
	    public float getSaldo() {
	        return Saldo;
	    }

	    public void ingresarSaldo(float ingreso) {
	        this.Saldo += ingreso;
	    }
	    public void sacarDinero(float extraer){
	    	if (this.Saldo-extraer >= (this.Limite)) {
	    		this.Saldo -= extraer;
	    		System.out.println("Por favor, recoja su dinero. \n\n Saldo actual en la cuenta: "+this.Saldo+ "\t euros");
	    	}
	    	else {
	    		System.out.println("Su saldo es insuficiente, no puede extraer tal importe, por favor seleccione un importe más bajo o ingrese dinero. \n");
	    	}
	    	
	    	
	    }
	 
	    public float getLimite() {
	        return Limite;
	    }
	    public long getNoCuenta(){
	    	return numCuenta;
	    }
	    
	    
	    
	   
    }
	    
	    
		

