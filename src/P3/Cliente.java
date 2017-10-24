package P3;

import java.util.Scanner;

public class Cliente {
		private String DNI;
		private String Nombre;
		private String Apellido;
		private String Direccion;
		private Fecha nacimiento;
		

		
		Scanner entrada = new Scanner (System.in);

		//CONSTRUCTOR
		public Cliente(String dni,String nombre,String apellido,String direccion,Fecha fNacimiento){
			this.DNI        = dni;
			this.Nombre     = nombre;
			this.Apellido   = apellido;
			this.Direccion  = direccion;
			this.nacimiento = fNacimiento;
		}
		
		
		//OTROS METODOS
		public String toString(){
			String cadena="";
			cadena += "Nombre    : "+Nombre+"\n";
			cadena += "Apellidos : "+Apellido+"\n";
			cadena += "DNI       : "+DNI+"\n";
			cadena += "Direccion : "+Direccion+"\n";
			cadena += "Nacimiento: "+nacimiento.toString()+"\n";
			
			return cadena;
		}
		public String toString2(){
			String cadena="";
			cadena += "Nombre    : "+Nombre+"\n";
			cadena += "Apellidos : "+Apellido+"\n";
			
			return cadena;
		}
		
		
	    public String getDNI() {
	        return DNI;
	    }

	    public void setDNI(String dni) {
	        this.DNI = dni;
	    }

	    

	    
		
		
		

	
}
