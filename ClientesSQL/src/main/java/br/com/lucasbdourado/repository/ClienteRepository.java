package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Cliente;
import br.com.lucasbdourado.repository.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IClienteRepository{
    @Override
    public Integer create(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "INSERT INTO cliente (cod, nome) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cliente.getCod());
            preparedStatement.setString(2, cliente.getNome());
            return preparedStatement.executeUpdate();
        } catch (Exception e){
            throw e;
        }finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Cliente query(String cod) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM cliente WHERE cod = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cod);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCod(rs.getString("cod"));
                cliente.setNome(rs.getString("nome"));
            }
            return cliente;
        } catch (Exception e){
            throw e;
        }finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Integer delete(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "DELETE FROM cliente WHERE cod = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cliente.getCod());
            return preparedStatement.executeUpdate();
        } catch (Exception e){
            throw e;
        }finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public List<Cliente> queryAll() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Cliente> clients = new ArrayList<>();
        ResultSet rs;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM cliente";
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCod(rs.getString("cod"));
                cliente.setNome(rs.getString("nome"));
                clients.add(cliente);
            }
            return clients;
        } catch (Exception e){
            throw e;
        }finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Integer update(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "UPDATE cliente SET nome = ?, cod = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cliente.getCod());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, Long.toString(cliente.getId()));
            return preparedStatement.executeUpdate();
        } catch (Exception e){
            throw e;
        }finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }
}
