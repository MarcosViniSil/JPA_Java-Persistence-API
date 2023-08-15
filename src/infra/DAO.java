package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Entidade;

public class DAO<E> {

	private static EntityManagerFactory emf;

	private  EntityManager em;

	private Class<E> classe;

	static {// so e executado 1 vez na contrucao
		try {
			emf = Persistence.createEntityManagerFactory("Exercicios_JPA");
		} catch (Exception e) {

		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		em = emf.createEntityManager();
		this.classe = classe;
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	public DAO<E> FecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> Incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> IncluirAtomico(E entidade){
		this.abrirTransacao().Incluir(entidade).FecharTransacao();
		return this;
	}
	
	public List<E> obterTodos(int limit,int offset){
		if(classe==null) {
			throw new UnsupportedOperationException("classe nula");
		}
		
		String jpql ="SELECT e FROM "+classe.getName() +" e";
		TypedQuery<E> query=em.createQuery(jpql,classe);
		query.setMaxResults(limit);
		query.setFirstResult(offset);
		
		return query.getResultList();
	}
	
	public void fechar() {
		em.close();
	}

}
