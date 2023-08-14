package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 3L);

		usuario.setNome("Vilma Oliveira");
		usuario.setEmail("VilmaOliver2@gmail.com");

		em.merge(usuario);// merge altera um dado no banco de dados

		em.getTransaction().commit();
		em.close();

		emf.close();
	}
}
