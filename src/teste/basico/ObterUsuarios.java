package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = emf.createEntityManager();
		
		//String jpql="SELECT u FROM Usuario u";
		//TypedQuery<Usuario> query=em.createQuery(jpql,Usuario.class);
		//query.setMaxResults(4);
		
		List<Usuario> usuarios =em.createQuery("SELECT u FROM Usuario u",Usuario.class).setMaxResults(4).getResultList();
		
		for(Usuario a:usuarios) {
			System.out.println("ID:"+a.getId()+" NOME:"+a.getNome()+" EMAIL:"+a.getEmail());
		}
		
		em.close();
		emf.close();
		
	}
}
