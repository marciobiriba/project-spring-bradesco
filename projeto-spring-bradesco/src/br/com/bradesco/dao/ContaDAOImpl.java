package br.com.bradesco.dao;

import javax.persistence.NoResultException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import br.com.bradesco.base.AbstractDAO;
import br.com.bradesco.domain.Conta;

@Scope
@Repository("contaDAO")
public class ContaDAOImpl extends AbstractDAO<Conta> implements ContaDAO {

    /**
     * Default constructor. 
     */

    public ContaDAOImpl() {
        // TODO Auto-generated constructor stub
    	super(Conta.class);
    }
    
    @Override
	public Conta obter(Long codConta, Integer codAgencia) {
		// TODO Auto-generated method stub
		Conta contaRetorno = null;
		try{
		  contaRetorno = (Conta) getEntityManager().createQuery("Select c from Conta c "
				  				+ "where c.codAgencia = :CODAGENCIA and c.codConta = :CODCONTA")
	    		.setParameter("CODAGENCIA", codAgencia)
	    		.setParameter("CODCONTA", codConta)
	    		.getSingleResult();
		}catch (NoResultException e){
			
		}
		return contaRetorno;
	}
    

}
