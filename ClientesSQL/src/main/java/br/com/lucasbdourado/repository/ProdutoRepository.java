package br.com.lucasbdourado.repository;

import br.com.lucasbdourado.domain.Produto;
import br.com.lucasbdourado.repository.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IProdutoRepository{
    @Override
    public Integer create(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "INSERT INTO produto (cod, nome, price) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, produto.getCod());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, String.valueOf(produto.getPrice()));
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
    public Produto query(String cod) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Produto produto = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM produto WHERE cod = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cod);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCod(rs.getString("cod"));
                produto.setNome(rs.getString("nome"));
                produto.setPrice(rs.getFloat("price"));
            }
            return produto;
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
    public Integer delete(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "DELETE FROM produto WHERE cod = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, produto.getCod());
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
    public List<Produto> queryAll() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Produto> produtos = new ArrayList<>();
        ResultSet rs;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM produto";
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCod(rs.getString("cod"));
                produto.setNome(rs.getString("nome"));
                produto.setPrice(rs.getFloat("price"));
                produtos.add(produto);
            }
            return produtos;
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
    public Integer update(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionFactory.getConnection();
            String query = "UPDATE produto SET nome = ?, cod = ?, price = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, produto.getCod());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, String.valueOf(produto.getPrice()));
            preparedStatement.setString(4, Long.toString(produto.getId()));
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
