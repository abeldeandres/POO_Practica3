package P3;

public class Fecha {
	private int Dia;
	private int Mes;
	private int Año;
	
	public Fecha(int dia, String mes, int año) {
		this.Dia = dia;
		this.Mes = numeroMes(mes);
		this.Año = año;
	}
	
	public String toString(){
		String cadena=""+this.Dia+"/"+this.Mes+"/"+this.Año;
		return cadena;
	}
	
	private static int numeroMes(String mes){
		if(mes.equalsIgnoreCase("Enero")){
			return 1;
		}
		else if(mes.equalsIgnoreCase("Febrero")){
			return 2;
		}
		else if(mes.equalsIgnoreCase("Marzo")){
			return 3;
		}
		else if(mes.equalsIgnoreCase("Abril")){
			return 4;
		}
		else if(mes.equalsIgnoreCase("Mayo")){
			return 5;
		}
		else if(mes.equalsIgnoreCase("Junio")){
			return 6;
		}
		else if(mes.equalsIgnoreCase("Julio")){
			return 7;
		}
		else if(mes.equalsIgnoreCase("Agosto")){
			return 8;
		}
		else if(mes.equalsIgnoreCase("Septiembre")){
			return 9;
		}
		else if(mes.equalsIgnoreCase("Octubre")){
			return 10;
		}
		else if(mes.equalsIgnoreCase("Noviembre")){
			return 11;
		}
		else if(mes.equalsIgnoreCase("Diciembre")){
			return 12;
		}
		else return -1;
	}
	/* Función comparaFecha, devuelve: 
	   -1 si fecha1 < fecha2 
	   0 si fecha1 = fecha2 
	   1 si fecha1 > fecha2 
	*/ 
	/**
	 * 
	 * @param fecha
	 * @return 1 si es mayor que fecha, 0 si son iguales y -1 si es menor
	 */
	public int comparaFecha(Fecha fecha) 
	{ 
	    int val; 
	    if(this.Año > fecha.Año){//Si el año actual es mayor que el año de la fecha externa
	    	val = 1;
	    }
	    else if(this.Año == fecha.Año){//Si el año actual es igual que el año de la fecha externa
	    	if(this.Mes > fecha.Mes){//Si el mes actual es mayor que el mes de la fecha externa
	    		val = 1;
	    	}
	    	else if(this.Mes == fecha.Mes){//Si el mes actual es igual que el mes de la fecha externa
	    		if(this.Dia>fecha.Dia) val = 1;//Si el dia actual es mayor que el dia de la fecha externa
	    		else if(this.Dia == fecha.Dia) val = 0;//Si el dia actual es igual que el dia de la fecha externa
	    		else val= -1;//Si el dia actual es igual que el dia de la fecha externa
	    	}
	    	else{//Si el mes actual es menor que el mes de la fecha externa
	    		val = -1;
	    	}
	    }
	    else{//Si el año actual es menor que el año de la fecha externa
	    	val = -1;
	    }

	    return val; 
	}
	
	
	public void mostrarFecha()
	{
		System.out.println(toString());
	}
}
