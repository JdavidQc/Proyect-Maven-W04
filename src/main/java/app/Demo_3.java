package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo_3 {
	public static void main(String[] args) {
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...eliminar un nuevo usuario
		Usuario u= em.find(Usuario.class,11);
		if(u==null) {
			System.out.println("Usuario no existe");

		}else {
				// reg,act,elim->Transacciones.
		em.getTransaction().begin();
		em.remove(u);//eliminacion
		em.getTransaction().commit();
		System.out.println("eliminacion ok");
		em.close();
		}
	
		
		
		
		
	}

}
