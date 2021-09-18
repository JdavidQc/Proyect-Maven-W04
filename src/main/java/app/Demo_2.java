package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo_2 {
	public static void main(String[] args) {
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...actualizar un nuevo usuario
		Usuario u= new Usuario();
		u.setCodigo(11);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("erenE@GMAIL.COM");
		u.setClave("titan");
		u.setFnacim("2021/08/27");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg,act,elim->Transacciones.
		em.getTransaction().begin();
		em.merge(u);//actualizar->si existe el cod/sino lo va a crear
		em.getTransaction().commit();
		System.out.println("Modifico ok");
		em.close();
		
		
		
		
	}

}
