import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Conta {
    private String numero;
    private String agencia;
    private Cliente cliente;
    private double saldo;

    // Construtor
    public Conta(String numero, String agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido. O valor deve ser maior que zero.");
        }
    }

    // Getter para obter o saldo
    public double getSaldo() {
        return saldo;
    }
    
    public void debitar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Valor de débito inválido ou saldo insuficiente.");
        }
    }
}