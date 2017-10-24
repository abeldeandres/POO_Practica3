package P3;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Cliente> arrayClientes;
	private ArrayList<Cuenta> arrayCuentas;
	
	public Banco(){
			this.arrayClientes = new ArrayList<Cliente>();
			this.arrayCuentas  = new ArrayList<Cuenta>();
	}
	
	
	
	public Cliente buscarYDevuelveCliente(String dni){
		int i=0;
		boolean encontrado=false;
		Cliente clienteEncontrado=null;
		while(i<arrayClientes.size() && !encontrado){
			if(arrayClientes.get(i).getDNI().equalsIgnoreCase(dni)){
				encontrado=true;
				clienteEncontrado=arrayClientes.get(i);
			}
			i++;
		}
		return clienteEncontrado;
	}
	public boolean buscarCliente(String dni){
		Cliente cliAux = buscarYDevuelveCliente(dni);
		if(cliAux==null){
			return false;
		}
		else{
			return true;
		}
	}
	public void agregarCliente(String dni,String nombre,String apellido,String direccion,Fecha fNacimiento){
		Cliente cliente = new Cliente(dni,nombre,apellido,direccion,fNacimiento);
		if(buscarCliente(dni)){
			System.out.println("CLiente ya existe");
		}
		else{
			this.arrayClientes.add(cliente);
		}
	}
	
	public void borrarCliente(String dni){
		Cliente cliAux = buscarYDevuelveCliente(dni);
		if(cliAux!=null){
			this.arrayClientes.remove(cliAux);
		}
		else{
			System.out.println("CLiente NO existe");
		}
	}
	
	public void mostrarCliente(String dni){
		Cliente cliAux = buscarYDevuelveCliente(dni);
		System.out.println(cliAux.toString());
		
	}
	public void listarClientes(){
		for(int i=0;i<arrayClientes.size();i++){
			System.out.println(arrayClientes.get(i).toString2());
		}
	}
	
	private int numeroCuentasCliente(String dni){
		int cont=0;
		/*for(Cuenta c:this.arrayCuentas){
			if(c.existeTitular(dni)) cont++;
		}*/
		for(int i=0;i<arrayCuentas.size();i++){
			if (arrayCuentas.get(i).existeTitular(dni))
			{
				cont++;
			}
		}
		return cont;
	}
	
	public boolean agregarCuenta(String dni,Fecha apertura, Fecha cierre){
		Cliente cliAux = buscarYDevuelveCliente(dni);
		if(cliAux!=null){
			//Se pregunta cuantas cuentas tiene el cliente.
			int numC=numeroCuentasCliente(dni);
			if (numC<6)
			{
				Cuenta cuenta = new Cuenta(cliAux, apertura, cierre);
				this.arrayCuentas.add(cuenta);
				System.out.println("El numero de cuenta creado es: "+cuenta.getNoCuenta()+"");
			}
			else
			{
				System.out.println("Se ha llegado al limite de cuentas por usuario.");
			}
			return true;
		}
		else return false;
	}
	private Cuenta buscarYDevuelveCuenta(long numeroCuenta){
		int i=0;
		boolean encontrado=false;
		Cuenta cuentaEncontrada=null;
		while(i<arrayCuentas.size() && !encontrado){
			if(arrayCuentas.get(i).getNoCuenta()==numeroCuenta){
				encontrado=true;
				cuentaEncontrada=arrayCuentas.get(i);
			}
			i++;
		}
		return cuentaEncontrada;
	}
	public void borrarCuenta(long numCuenta){
		Cuenta cuenAux = buscarYDevuelveCuenta(numCuenta);
		if(cuenAux!=null){
			arrayCuentas.remove(cuenAux);
		}
		else{
			System.out.println("La cuenta: "+numCuenta+" no existe");
		}
	}
	
	public void mostrarCuenta(long numCuenta){
		Cuenta cuenAux = buscarYDevuelveCuenta(numCuenta);
		if(cuenAux!=null){
			System.out.println(cuenAux.toString());
		}
		else{
			System.out.println("La cuenta: "+numCuenta+" no existe");
		}
	}
	
	
	public void listarCuentas(){
		for(int i=0;i<arrayCuentas.size();i++){
			System.out.println(arrayCuentas.get(i).toString2());
		}
	}
	
	public void ingresarSaldo(String dni,long numeroCuenta,float ingreso){
		Cliente cliAux= buscarYDevuelveCliente(dni);
		Cuenta  cuentAux = buscarYDevuelveCuenta(numeroCuenta);
		if(cliAux!=null && cuentAux!=null){
			cuentAux.ingresarSaldo(ingreso);
		}
	}
	
	public void agregarTitular(String dni,long numeroCuenta){
		Cliente cliAux= buscarYDevuelveCliente(dni);
		Cuenta  cuentAux = buscarYDevuelveCuenta(numeroCuenta);
		if(cliAux!=null && cuentAux!=null){
			int numC=numeroCuentasCliente(dni);
			if (numC<6)
			{
				cuentAux.agregarTitular(cliAux);
			}
			else
			{
				System.out.println("Se ha llegado al limite de cuentas por usuario.");
			}
			
		}
		else{
			System.out.println("No existe usuario o cuenta");
		}
	}
	
	public void extraerSaldo(String dni, long numeroCuenta, float extraer){
		Cliente cliAux= buscarYDevuelveCliente(dni);
		Cuenta  cuentAux = buscarYDevuelveCuenta(numeroCuenta);
		if(cliAux!=null && cuentAux!=null){
			cuentAux.sacarDinero(extraer);
		}
	}
	
	
    public int getNumClientes() {
        return arrayClientes.size();
    }
    
    public int getNumCuentas() {
        return arrayCuentas.size();
    }
    

    
}
