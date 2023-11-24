import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Conta {
    private Cliente cliente;
    private String numeroConta;

    public Conta(Cliente cliente, String numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}

class OperaBanco {
    private List<Cliente> clientes;
    private List<Conta> contas;

    public OperaBanco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public boolean cadastraCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            return true;
        } else {
            return false; // Cliente já cadastrado
        }
    }

    // Método para cadastrar conta
    public boolean cadastraConta(String cpf, String numeroConta) {
        Cliente cliente = buscaCliente(cpf);
        if (cliente != null) {
            Conta conta = new Conta(cliente, numeroConta);
            contas.add(conta);
            return true;
        } else {
            return false; // Cliente não encontrado
        }
    }


    // Método para exibir contas cadastradas
    public void exibirContas() {
        System.out.println("Lista de Contas:");
        for (Conta conta : contas) {
            System.out.println("Cliente: " + conta.getCliente().getNome());
            System.out.println("CPF: " + conta.getCliente().getCpf());
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("-------------------------");
        }
    }
}

 class Main {
    public static void main(String[] args) {
        OperaBanco operaBanco = new OperaBanco();
        Scanner scanner = new Scanner(System.in);

        // Cadastrar clientes
        System.out.println("Cadastro de Clientes");

        for (int i = 0; i < 2; i++) {
            System.out.println("Cliente " + (i + 1));
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Profissão: ");
            String profissao = scanner.nextLine();

            Cliente cliente = new Cliente(nome, cpf, profissao);
            if (operaBanco.cadastraCliente(cliente)) {
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Cliente já cadastrado!");
            }
        }

        // Cadastrar contas
        System.out.println("Cadastro de Contas");

        System.out.print("Digite o CPF do cliente: ");
        String cpfConta = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        if (operaBanco.cadastraConta(cpfConta, numeroConta)) {
            System.out.println("Conta cadastrada com sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
        }

        // Exibir contas cadastradas
        operaBanco.exibirContas();

        // Fechar o scanner
        scanner.close();
    }
}