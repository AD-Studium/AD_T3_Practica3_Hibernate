/**
 * 
 */
package hibernate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.Clientes;
/**
 * @author Alvca
 *
 */
public class FactoryCrud {
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Clientes.class).configure().buildSessionFactory();
		return sessionFactory;
	}

	public static void create(Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(cliente);
		transObj.commit();
		sessionObj.close();
		System.out.println("Cliente " + cliente.getIdCliente() + " insertada correctamente");
	} 
	@SuppressWarnings("rawtypes")
	public static List readClientes() {
		Session sessionObj = getSessionFactory().openSession();
		String query = "FROM Clientes";
		List resultado = sessionObj.createQuery(query).list();
		sessionObj.close();
		return resultado;
	} 
	public static void updateClientes(Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes clientesBD = (Clientes)
				sessionObj.load(Clientes.class, cliente.getIdCliente());

		/* Modificamos todos los atributos */

		clientesBD.setNombre(cliente.getNombre());
		clientesBD.setApellidos(cliente.getApellidos());
		clientesBD.setDni(cliente.getDni());
		clientesBD.setEmail(cliente.getEmail());
		clientesBD.setClave(cliente.getClave());

		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
	} 
	public static void deleteClientes(Clientes cliente) { 
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes clientesBD = (Clientes) sessionObj.load(Clientes.class, cliente.getIdCliente());
		sessionObj.delete(clientesBD);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente");
	}

} 
