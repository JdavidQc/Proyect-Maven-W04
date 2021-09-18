package gestion;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import interfaz.InterfazProducto;
import modelo.Producto;

public class GestionarProducto implements InterfazProducto {

	// especificar la conexion de BD -DAOFACTORY
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");


	public boolean AgregarProducto(Producto p) {

		EntityManager em = fabrica.createEntityManager();
		try {	
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Error GestionProducto: " + e.getMessage());
		} finally {
			if(em.isOpen())
			em.close();

		}
		return false;
	}

	public boolean EliminarProducto(String codigo) {
		EntityManager em = fabrica.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Producto.class,codigo));
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Error GestionProducto: " + e.getMessage());
		} finally {
			if(em.isOpen())
				em.close();

		}
		return false;
	}

	public boolean ModificarProducto(Producto p) {
		EntityManager em = fabrica.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Error GestionProducto: " + e.getMessage());
		} finally {
			if(em.isOpen())
				em.close();
		}
		return false;
	}

	public Producto consultarProducto(String codigo) {
		EntityManager em = fabrica.createEntityManager();
		try {
			return em.find(Producto.class,codigo);
		} catch (Exception e) {
			System.out.println("Error GestionProducto: " + e.getMessage());
		} finally {
			em.close();
		}
		return null;
	}

	public ArrayList<Producto> listarProducto() {
		EntityManager em = fabrica.createEntityManager();
		try {
			TypedQuery<Producto> query = em.createQuery("Select p  from Producto p", Producto.class);
			return (ArrayList<Producto>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Error GestionProducto: " + e.getMessage());
		} finally {
			if(em.isOpen())
				em.close();
		}
		return null;
	}

	public String getCodigoCorrolativo() {
		String codigo =String.valueOf(this.listarProducto().size()+1);
		return "P"+ ("0000"+codigo).substring(codigo.length());
	}

}
