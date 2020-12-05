/**
 * 
 */
package hibernate;


import java.util.Scanner;

import pojos.Clientes;

/**
 * @author Alvca
 *
 */
public class main {
	static Scanner menus = new Scanner(System.in);
	static Scanner teclado = new Scanner(System.in);
	static int menu;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		do {
			//Creamos un menu para realizar las pruebas.
			System.out.println("Seleccione que desea hacer, introduzca el numero elegido:");
			System.out.println("1- Crear Cliente");
			System.out.println("2- Mostrar Cliente");
			System.out.println("3- Actualizar Cliente");
			System.out.println("4- Eliminar Cliente");
			System.out.println("Introduzca 0 para salir.");

			menu=menus.nextInt();
			//1- Crear Cliente
			if(menu==1) {
				System.out.println("Introduzca los datos para crear el cliente");
				System.out.println("Indique el nombre del cliente:");
				String nombreCliente = teclado.next();
				System.out.println("Indique los apellidos del cliente");
				String apellidosCliente=teclado.next();
				System.out.println("_Indique el email del cliente");
				String emailCliente=teclado.next();
				System.out.println("Indique el DNI del cliente:");
				String dniCliente=teclado.next();
				System.out.println("Indique la clave del cliente");
				String claveCliente=teclado.next();
				Clientes cli1 = new Clientes(nombreCliente, apellidosCliente, emailCliente,dniCliente,claveCliente);
				FactoryCrud.create(cli1);
			}
			//2- Mostrar Cliente
			else if(menu==2) {
				FactoryCrud.readClientes();
			}
			//3- Actualizar Cliente
			else if(menu==3) {
				System.out.println("Introduzca los datos para crear el cliente");
				System.out.println("Indique el nombre del cliente:");
				String nombreCliente = teclado.next();
				System.out.println("Indique los apellidos del cliente");
				String apellidosCliente=teclado.next();
				System.out.println("_Indique el email del cliente");
				String emailCliente=teclado.next();
				System.out.println("Indique el DNI del cliente:");
				String dniCliente=teclado.next();
				System.out.println("Indique la clave del cliente");
				String claveCliente=teclado.next();
				Clientes cli = new Clientes(nombreCliente, apellidosCliente, emailCliente,dniCliente,claveCliente);
				FactoryCrud.updateClientes(cli);
			}
			//4- Eliminar Cliente
			else if(menu==4) {
				System.out.println("Indique el ID del cliente a elimiar:");
				int id = teclado.nextInt();
				Clientes cli = new Clientes(id);
				FactoryCrud.deleteClientes(cli);
			}
		}
		while(menu!=0);
		System.out.println("Saliendo del Programa");
		teclado.close();
		menus.close();
	}
}
