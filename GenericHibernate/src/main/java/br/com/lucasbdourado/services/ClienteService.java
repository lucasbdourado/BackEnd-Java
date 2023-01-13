package br.com.lucasbdourado.services;

import br.com.lucasbdourado.repository.IClienteDAO;
import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.exceptions.DAOException;
import br.com.lucasbdourado.exceptions.MaisDeUmRegistroException;
import br.com.lucasbdourado.exceptions.TableException;
import br.com.lucasbdourado.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}
}
