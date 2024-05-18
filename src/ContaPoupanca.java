public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirConta() {
        System.out.println("=== Conta Poupança ===");
        imprimirInfosComuns();
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("=== Extrato %s / Conta Poupança ===%n", cliente.getNome());
        System.out.println(itensExtrato);
    }

}
