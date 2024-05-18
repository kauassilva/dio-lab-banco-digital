import java.math.BigDecimal;

public interface IConta {

    void sacar(BigDecimal valor, boolean operacaoDireta);
    void depositar(BigDecimal valor, boolean operacaoDireta);
    void transferir(BigDecimal valor, Conta contaDestino);
    void imprimirConta();
    void imprimirExtrato();

}
