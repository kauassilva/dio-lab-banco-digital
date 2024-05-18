# Sistema Bancário

Este repositório contém um sistema bancário simples implementado em Java.

## Classes

### Main

A classe `Main` é o ponto de entrada do programa. Ela cria um cliente, duas contas (corrente e poupança) e realiza operações de depósito, transferência e saque.

### Cliente

A classe `Cliente` representa um cliente do banco. Ela contém informações como nome, número de celular, email, CPF, nome da mãe e data de nascimento.

### Conta

A classe `Conta` é uma classe abstrata que implementa a interface `IConta`. Ela contém informações como agência, conta, saldo, cliente e uma lista de itens de extrato. Ela também implementa métodos para sacar, depositar, transferir dinheiro e imprimir informações da conta e do extrato.

### ContaCorrente e ContaPoupanca

As classes `ContaCorrente` e `ContaPoupanca` são subclasses de `Conta`. Elas sobrescrevem os métodos para imprimir informações da conta e do extrato.

### Banco

A classe `Banco` representa um banco. Ela contém informações como nome e uma lista de contas.

### ItemExtrato

A classe `ItemExtrato` implementa a interface `IItemExtrato`. Ela representa um item de extrato, que contém informações como data da operação, tipo de operação e valor.

### IConta e IItemExtrato

As interfaces `IConta` e `IItemExtrato` definem os métodos que devem ser implementados pelas classes `Conta` e `ItemExtrato`, respectivamente.

### TipoOperacao

O enum `TipoOperacao` define os tipos de operações que podem ser realizadas: DEPOSITO, SAQUE, TRANSFERENCIA_ENVIADA e TRANSFERENCIA_RECEBIDA.

## Como executar

- Você precisa ter o Java 8 ou superior instalado em seu computador;
- Você pode compilar e executar o programa usando o comando `java Main.java` no terminal.

## Amostra

### Código Java

````java
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
````

### Terminal

````
=== Conta Corrente ===
Titular: João Silva
Agencia: 1
Conta: 1
Saldo: 100,00

=== Conta Poupança ===
Titular: João Silva
Agencia: 1
Conta: 2
Saldo: 49,52

=== Extrato João Silva / Conta Corrente ===
[[DEPOSITO - 18/05/2024 19:14 - R$ 200,00], [TRANSFERENCIA_ENVIADA - 18/05/2024 19:14 - R$ 100,00]]

=== Extrato João Silva / Conta Poupança ===
[[TRANSFERENCIA_RECEBIDA - 18/05/2024 19:14 - R$ 100,00], [SAQUE - 18/05/2024 19:14 - R$ 50,48]]
````