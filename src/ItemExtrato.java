import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ItemExtrato implements IItemExtrato {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private LocalDateTime dataOperacao;
    private TipoOperacao tipoOperacao;
    private BigDecimal valor;

    public ItemExtrato(TipoOperacao tipoOperacao, BigDecimal valor) {
        dataOperacao = LocalDateTime.now();
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    public LocalDateTime getDataOperacao() {
        return dataOperacao;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        validarDado();
        String valorFormatado = NumberFormat
                .getCurrencyInstance(new Locale("pt", "BR"))
                .format(valor.doubleValue());
        String dataFormatada = dataOperacao.format(formatter);
        return String.format("[%s - %s - %s]", tipoOperacao, dataFormatada, valorFormatado);
    }

    private void validarDado() {
        if (tipoOperacao == null || dataOperacao == null || valor == null)
            throw new IllegalStateException("Os campos não podem ser nulos");
    }

    @Override
    public void gerarItemExtrato(TipoOperacao tipoOperacao, BigDecimal valor) {

    }

}
