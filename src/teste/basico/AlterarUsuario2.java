package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 3L);
		
        em.detach(usuario);//objeto agora esta no estado nao gerenciado,ou seja,operacoes necessitam ser explicitas
        
		usuario.setNome("Vilma Oliveiras");
		usuario.setEmail("VilmaOliver2@gmail.com");

		em.merge(usuario);// merge altera um dado no banco de dados

		em.getTransaction().commit();
		em.close();

		emf.close();
	}
}
