package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo_4 {
	public static void main(String[] args) {
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...obtener la info del usuario con codigo 12
		Usuario u= em.find(Usuario.class,11);
		if(u==null) {
			System.out.println("Usuario NO EXISTE");
		}else {
			System.out.println("Usuario encontrdo: " +u.getNombre());
			System.out.println(u);
		}
		
		em.close();
		
		
		
		
	}

}
