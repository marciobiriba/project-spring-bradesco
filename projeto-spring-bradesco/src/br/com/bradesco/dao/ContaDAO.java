package br.com.bradesco.dao;

import br.com.bradesco.domain.Conta;


public interface ContaDAO {
	Conta obter(Long codConta, Integer codAgencia);

	void cadastrar(Conta conta);

	void alterar(Conta conta);

	void excluir(Conta conta);

	Conta obterPorId(Integer id);

	
}
