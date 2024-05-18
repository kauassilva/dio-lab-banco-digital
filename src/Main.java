import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Silva", "(11) 98765-4321", "joao.silva@example.com", "123.456.789-00", "Maria Silva", LocalDate.of(1980, 1, 1));

        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);

        contaCorrente.depositar(BigDecimal.valueOf(200), true);

        contaCorrente.transferir(BigDecimal.valueOf(100), contaPoupanca);

        contaPoupanca.sacar(BigDecimal.valueOf(50.48), true);

        contaCorrente.imprimirConta();
        System.out.println();
        contaPoupanca.imprimirConta();
        System.out.println();

        contaCorrente.imprimirExtrato();
        System.out.println();
        contaPoupanca.imprimirExtrato();
    }

}