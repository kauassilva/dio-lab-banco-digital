import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer conta;
    protected BigDecimal saldo;
    protected Cliente cliente;

    protected List<ItemExtrato> itensExtrato;

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        conta = SEQUENCIAL++;
        saldo = BigDecimal.valueOf(0);
        this.cliente = cliente;
        itensExtrato = new ArrayList<>();
    }

    @Override
    public void sacar(BigDecimal valor, boolean operacaoDireta) {
        validarValor(valor);
        validarSaldo(valor);
        saldo = saldo.subtract(valor);

        if (operacaoDireta)
            itensExtrato.add(new ItemExtrato(TipoOperacao.SAQUE, valor));
    }

    @Override
    public void depositar(BigDecimal valor, boolean operacaoDireta) {
        validarValor(valor);
        saldo = saldo.add(valor);

        if (operacaoDireta)
            itensExtrato.add(new ItemExtrato(TipoOperacao.DEPOSITO, valor));
    }

    @Override
    public void transferir(BigDecimal valor, Conta contaDestino) {
        sacar(valor, false);
        itensExtrato.add(new ItemExtrato(TipoOperacao.TRANSFERENCIA_ENVIADA, valor));

        contaDestino.depositar(valor, false);
        contaDestino.itensExtrato.add(new ItemExtrato(TipoOperacao.TRANSFERENCIA_RECEBIDA, valor));
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", cliente.getNome());
        System.out.printf("Agencia: %d%n", agencia);
        System.out.printf("Conta: %d%n", conta);
        System.out.printf("Saldo: %.2f%n", saldo);
    }

    private static void validarValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("O valor do saque deve ser positivo!");
    }

    private void validarSaldo(BigDecimal valor) {
        if (valor.compareTo(saldo) > 0)
            throw new IllegalArgumentException("Saldo insuficiente para o saque!");
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public Double getSaldo() {
        return saldo.doubleValue();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemExtrato> getItensExtrato() {
        return itensExtrato;
    }

}
