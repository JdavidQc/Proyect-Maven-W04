package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo_01 {
	public static void main(String[] args) {
		//especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		EntityManager em=fabrica.createEntityManager();
		//procesos...registrar un nuevo usuario
		Usuario u= new Usuario();
		u.setCodigo(10);
		u.setNombre("MICHELLA");
		u.setApellido("ECHEVARRIA");
		u.setUsuario("MICHE@GMAIL.COM");
		u.setClave("123MICHE");
		u.setFnacim("2021/08/27");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg,act,elim->Transacciones.
		em.getTransaction().begin();
		em.persist(u);//agregar
		em.getTransaction().commit();
		System.out.println("Registro ok");
		em.close();
		
		
		
		
	}

}
