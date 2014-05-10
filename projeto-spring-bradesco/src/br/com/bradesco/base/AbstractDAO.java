package br.com.bradesco.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

public class AbstractDAO<T> {
	private Class<T> entidade;
	
	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		
		return this.em;
	}
	
	public AbstractDAO(Class<T> entidade) {
        this.entidade = entidade;
    }
	@Transactional 
	public void cadastrar(T entidade){
		getEntityManager().persist(entidade);
	}
	@Transactional 
	public void alterar(T entidade){
		getEntityManager().merge(entidade);
		getEntityManager().flush();
	}
	@Transactional 
	public void excluir(T entidade){
		getEntityManager().remove(getEntityManager().merge(entidade));
		getEntityManager().flush();
	}
	
	public T obterPorId(Integer id){
		return getEntityManager().find(entidade, id);
	}
	
	public List<T> listar(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidade));
        return getEntityManager().createQuery(cq).getResultList();
    }
	
}
