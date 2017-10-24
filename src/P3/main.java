package P3;



import java.util.Scanner;
public class main {
	

	
	public static int leerInt(){
		String strNumero="";
		int numero=0;
		boolean lecturaBien=false;
		do{
			Scanner ent = new Scanner(System.in);
			System.out.print("> ");
			strNumero = ent.nextLine();
			try{
				numero= Integer.parseInt(strNumero);
				lecturaBien=true;
			}catch(Exception e){}
			
		}while(!lecturaBien);
		
		return numero;
	}
	public static String leerString(){
		String cadena="";
		do{
			Scanner ent = new Scanner(System.in);
			System.out.print("> ");
			cadena = ent.nextLine();
		}while(cadena.equalsIgnoreCase("") || cadena.equalsIgnoreCase("\n"));
		
		return cadena;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion=0;
		boolean salir=false;
		
		//Cliente
		 String dni;
		 String nombre;
		 String apellido;
		 String direccion;
		 int dia;
		 String mes;
		 int anio;
		 int dia1;
		 String mes1;
		 int anio1;
		 long numCuenta;
		 float ingreso, extraer;
		 
		 
		Scanner entrada = new Scanner (System.in);
		Banco banco = new Banco();
		

		
	
	do{
		System.out.println("1. -Alta Cliente");
		System.out.println("2. -Baja Cliente");
		System.out.println("3. -Mostrar Datos de un Cliente");
		System.out.println("4. -Listado General de Clientes");
		System.out.println("5. -Alta Cuenta");
		System.out.println("6. -Baja Cuenta");
		System.out.println("7. -Mostrar Datos de una Cuenta");
		System.out.println("8. -Listado General de Cuentas");
		System.out.println("9. -Ingresar Dinero");
		System.out.println("10. -Sacar Dinero");
		
		System.out.println("0.  Salir");
		
		System.out.println("Introduzca una opcion:");
		opcion = leerInt();

		
		switch(opcion) {
		
		case 1:
			if (banco.getNumClientes()<50)
			{
					System.out.println("Por favor, introduce el DNI del cliente");
					dni = leerString();
	            	System.out.println("Por favor, introduce el Nombre del cliente");
	            	nombre = leerString();
	            	System.out.println("Por favor, introduce el Apellido del cliente");
	            	apellido = leerString();
	            	
	            	System.out.println("Por favor, introduce la Direccion del cliente");
	            	direccion = leerString();
	            	
	            	System.out.println("Por favor, introduce la fecha de nacimiento del cliente");	
	            	System.out.println("----------------------------------------------------------------- \n");
	            	System.out.println("Por favor, introduce el día de la fecha de nacimiento del cliente");
	            	dia = leerInt();// entrada.nextInt();
	            	System.out.println("Por favor, introduce el mes de la fecha de nacimiento del cliente");
	            	mes = leerString();
	            	System.out.println("Por favor, introduce el año de nacimiento del cliente");
	            	anio = leerInt();//entrada.nextInt();
	            	
	            	Fecha FechaNac = new Fecha(dia, mes, anio);
	            	banco.agregarCliente(dni,nombre,apellido,direccion,FechaNac);
			}
			else
			{
				System.out.println("No se pueden dar de alta más clientes");
			}
			break;
			
		case 2:
			System.out.println("Por favor, introduce el DNI del cliente");
			dni = leerString();
			banco.borrarCliente(dni);
			break;
		
		case 3:
				System.out.println("Por favor, introduce el DNI del cliente");
				dni = leerString();
				banco.mostrarCliente(dni);
			break;
			
		case 4:
				banco.listarClientes();
			break;
			
		case 5:
			boolean volver=false;
			int opcion1;
			do
				{
				System.out.println("1. -Alta Cuenta");
				System.out.println("2. -Agregar titular cuenta");
				System.out.println("3. -Volver al menu principal");
				System.out.println("Introduzca una opcion:");
				opcion1 = leerInt();
				
				switch(opcion1) {
					case 1:
						System.out.println("Por favor, introduce el DNI del cliente");
						dni = leerString();
						Fecha apertura=null;
						Fecha cierre=null;
						do
						{
							System.out.println("Por favor, introduce la fecha de apertura de la cuenta");	
				        	System.out.println("----------------------------------------------------------------- \n");
				        	System.out.println("Por favor, introduce el día de la fecha de apertura");
				        	dia = leerInt();
				        	System.out.println("Por favor, introduce el mes de la fecha de apertura");
				        	mes = leerString();
				        	System.out.println("Por favor, introduce el año de la fecha de apertura");
				        	anio = leerInt();
				        	System.out.println("----------------------------------------------------------------- \n");
				        	System.out.println("Por favor, introduce la fecha de cierre de la cuenta");	
				        	System.out.println("----------------------------------------------------------------- \n");
				        	System.out.println("Por favor, introduce el día de la fecha de cierre");
				        	dia1 = leerInt();
				        	System.out.println("Por favor, introduce el mes de la fecha de cierre");
				        	mes1 = leerString();
				        	System.out.println("Por favor, introduce el año de la fecha de cierre");
				        	anio1 = leerInt();
				        	apertura = new Fecha(dia, mes, anio);
				        	cierre   = new Fecha(dia1,mes1,anio1);
				        	
						} while (apertura.comparaFecha(cierre) >= 0);//la fecha de apertura no puede ser igual ni mayor que fecha de cierre
			        	if(!banco.agregarCuenta(dni,apertura,cierre)){
			        		//System.out.println("Cuenta agregada correctamente");
			        		System.out.println("No se ha podido agregar la cuenta");
			        	}
			        	//else System.out.println("No se ha podido agregar la cuenta");
			        	break;
					
					case 2:
						System.out.println("Por favor, introduce el DNI del cliente");
						dni = leerString();
						System.out.println("Por favor, introduce el Numero de Cuenta a la que desee agregar el titular");
						numCuenta = entrada.nextLong();
						banco.agregarTitular(dni,numCuenta);
						break;
			        	
					case 3:
						volver=true;
						break;
					
					default:
						System.out.println("Por favor, introduzca una opcion correcta, del 1 al 3, ambos inclusive.");
						break;	
				}
				}while(!volver);
			break;
		
		case 6:
			System.out.println("Por favor, introduce el Numero de Cuenta que desee borrar");
			numCuenta = entrada.nextLong();
			banco.borrarCuenta(numCuenta);
			break;
			
		case 7:
			System.out.println("Por favor, introduce el Numero de Cuenta que desee mostrar");
			numCuenta = entrada.nextLong();
			banco.mostrarCuenta(numCuenta);
			break;
		
		case 8:
			banco.listarCuentas();
			break;
			
		case 9:
			System.out.println("Por favor, introduce el DNI del cliente");
			dni = leerString();
			System.out.println("Por favor, introduce el Numero de Cuenta que desee borrar");
			numCuenta = entrada.nextLong();
			System.out.println("Por favor, introduce la cantidad que desee ingresar en la cuenta");
			ingreso = entrada.nextLong();
			banco.ingresarSaldo(dni,numCuenta,ingreso);
			break;
			
		case 10:
			System.out.println("Por favor, introduce el DNI del cliente");
			dni = leerString();
			System.out.println("Por favor, introduce el Numero de Cuenta que desee borrar");
			numCuenta = entrada.nextLong();
			System.out.println("Por favor, introduce la cantidad que desee ingresar en la cuenta");
			extraer = entrada.nextLong();
			banco.extraerSaldo(dni,numCuenta,extraer);
			break;
			
		case 0:
			System.out.println("Gracias por utilizar la aplicación");
			salir=true;
			break;
			
		default:
			System.out.println("Por favor, introduzca una opcion correcta, del 0 al 10, ambos inclusive.");
			break;			
		}
		
	}while(!salir);
		


	}
}
	