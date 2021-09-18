package app;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Usuario;

public class Demo_8 {
	public static void main(String[] args) {
		// especificar la conexion de BD -DAOFACTORY
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// 2.Obtener el DAO
		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Usuario> query = em.createQuery("Select u  from Usuario u.usuario= :use and u.clave= :clv",
				Usuario.class);
		query.setParameter("use", "U002@gmail.com");
		query.setParameter("clv", "10002");

		try {
			Usuario u = query.getSingleResult();
			if (u == null) {
				System.out.println("Usuario NO EXISTE");
			} else {
				System.out.println("Usuario encontrdo: " + u.getNombre());
				System.out.println(u);
			}

			em.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
