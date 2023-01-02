public class PrimeiraClasse {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        cliente.cadastrarEndereco("Rua 1");
        cliente.setCodigo(1);
        System.out.println(cliente.getCodigo());
        //cliente.toStringEndereco();
        String end = cliente.returnNomeCliente();
        System.out.println(end);
        System.out.println(cliente.getValorTotal());
    }
}
