package br.com.projectcliente;

import br.com.projectcliente.dao.ClienteMapDAO;
import br.com.projectcliente.dao.IClienteDAO;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;
    private static boolean close = false;
    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        while(!close) {
            String option = JOptionPane.showInputDialog(null, "1. Cadastro\n2. Consulta\n3. Deletar\n4. Alterar\n5. Sair", "Digite a opção desejada!", JOptionPane.INFORMATION_MESSAGE);

            String data;

            switch (option) {
                case "1":
                    data = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula, conforme o exemplo:\nNome, CPF, Telefone, Estado, Cidade, Rua, Número", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    create(data);
                    break;
                case "2":
                    data = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Consulta", JOptionPane.INFORMATION_MESSAGE);
                    query(data);
                    break;
                case "3":
                    data = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Exlusão", JOptionPane.INFORMATION_MESSAGE);
                    delete(data);
                    break;
                case "4":
                    data = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula, conforme o exemplo:\nNome, CPF, Telefone, Estado, Cidade, Rua, Número", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    //update(data);
                    break;
                case "5":
                    closeModal(true);
                    break;
            }
        }
    }
    public static void create(String data){
        String[] dados = data.split(",");

        Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
        Boolean isCreated = iClienteDAO.create(cliente);

        if(isCreated){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Cliente ja foi cadastrado!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void query(String data){
        Cliente cliente = iClienteDAO.query(Long.parseLong(data));

        if(cliente != null){
            JOptionPane.showMessageDialog(null, cliente.toString(), "Consulta", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Cliente não encontrado", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void delete(String data){
        Boolean isDeleted = iClienteDAO.delete(Long.parseLong(data));

        if(isDeleted){
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Cliente não existente", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static boolean closeModal(boolean closeModal){
        if(closeModal){
            close = true;
            return true;
        }
        return false;
    }
}
