import java.math.BigDecimal;

public interface IItemExtrato {

    void gerarItemExtrato(TipoOperacao tipoOperacao, BigDecimal valor);

}
