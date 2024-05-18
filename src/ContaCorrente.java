public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirConta() {
        System.out.println("=== Conta Corrente ===");
        imprimirInfosComuns();
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("=== Extrato %s / Conta Corrente ===%n", cliente.getNome());
        System.out.println(itensExtrato);
    }

}
