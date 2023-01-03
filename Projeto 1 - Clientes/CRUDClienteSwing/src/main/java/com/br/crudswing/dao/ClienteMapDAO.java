package com.br.crudswing.dao;

import com.br.crudswing.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO{

    private final Map<Long, Cliente> map;

    public ClienteMapDAO(){
        this.map = new HashMap<>();
    }
    @Override
    public Boolean create(Cliente cliente) {
        if(this.map.containsKey(cliente.getCpf())){
            return false;
        }

        this.map.put(cliente.getCpf(), cliente);

        return true;
    }

    @Override
    public Boolean delete(Long cpf) {
        Cliente queryCliente = this.map.get(cpf);

        if(queryCliente != null){
            this.map.remove(queryCliente.getCpf(), queryCliente);
            return true;
        }
        return false;
    }

    @Override
    public void update(Cliente cliente) {
        Cliente queryCliente = this.map.get(cliente.getCpf());

        if (queryCliente != null){
            queryCliente.setName(cliente.getName());
            queryCliente.setPhone(cliente.getPhone());
            queryCliente.setState(cliente.getState());
            queryCliente.setCity(cliente.getCity());
            queryCliente.setStreet(cliente.getStreet());
            queryCliente.setNumber(cliente.getNumber());
        }
    }

    @Override
    public Cliente query(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> queryAll() {
        return this.map.values();
    }
}
