import java.time.LocalDate;

public class Cliente {

    private String nome;
    private String numeroCelular;
    private String email;
    private String cpf;
    private String nomeMae;
    private LocalDate dataNascimento;

    public Cliente(String nome, String numeroCelular, String email, String cpf, String nomeMae, LocalDate dataNascimento) {
        this.nome = nome;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.cpf = cpf;
        this.nomeMae = nomeMae;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
