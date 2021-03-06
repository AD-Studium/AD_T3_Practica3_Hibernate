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
public class Main {
	static Scanner menus = new Scanner(System.in);
	static Scanner teclado;
	static int menu;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teclado = new Scanner(System.in);
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
				String nombreCliente = teclado.nextLine();
				System.out.println("Indique los apellidos del cliente");
				String apellidosCliente=teclado.nextLine();
				System.out.println("Indique el email del cliente");
				String emailCliente=teclado.nextLine();
				System.out.println("Indique el DNI del cliente:");
				String dniCliente=teclado.nextLine();
				System.out.println("Indique la clave del cliente");
				String claveCliente=teclado.nextLine();
				Clientes cli1 = new Clientes(nombreCliente, apellidosCliente, emailCliente,dniCliente,claveCliente);
				FactoryCrud.create(cli1);
			}
			//2- Mostrar Cliente
			else if(menu==2) {
				FactoryCrud.readClientes();
			}
			//3- Actualizar Cliente
			else if(menu==3) {
				//Clientes cli1 = new Clientes("Jaime", "Romero", "jaime@grupostudium.com","12345678M","clavedeclienteLaura");
				//FactoryCrud.create(cli1);
				System.out.println("Introduzca los datos para modificar el cliente");
				System.out.println("Indique el id del cliente:");
				int idCliente = Integer.parseInt(teclado.nextLine());
				System.out.println("Indique el nombre del cliente:");
				String nombreCliente = teclado.nextLine();
				System.out.println("Indique los apellidos del cliente");
				String apellidosCliente=teclado.nextLine();
				System.out.println("Indique el email del cliente");
				String emailCliente=teclado.nextLine();
				System.out.println("Indique el DNI del cliente:");
				String dniCliente=teclado.nextLine();
				System.out.println("Indique la clave del cliente");
				String claveCliente=teclado.nextLine();
				Clientes cli = new Clientes(idCliente, nombreCliente, apellidosCliente, emailCliente,dniCliente,claveCliente);
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
