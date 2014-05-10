package br.com.bradesco.business;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.bradesco.dao.ContaDAO;
import br.com.bradesco.domain.Conta;

@Scope
@Service("contaDTO")
public class ContaDTOImpl implements ContaDTO {

    /**
     * Default constructor. 
     */
	
	@Autowired
	private ContaDAO contaDao;
	
    public ContaDTOImpl() {
        // TODO Auto-generated constructor stub
    }
    
   
	public void depositar(Conta conta) {
		// TODO Auto-generated method stub
		
		Conta contaCorrente = contaDao.obter(conta.getCodConta(), conta.getCodAgencia());
		if(contaCorrente != null){
			Double saldo = contaCorrente.getSaldo() + conta.getSaldo();
			contaCorrente.setSaldo(saldo);
		    contaDao.alterar(contaCorrente); 
		}else{
			contaDao.cadastrar(conta);
		}
	}


	public ContaDAO getContaDao() {
		return contaDao;
	}


	public void setContaDao(ContaDAO contaDao) {
		this.contaDao = contaDao;
	}
	
   
}
