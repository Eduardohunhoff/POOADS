import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String cpf;
    private String profissao;

    public Cliente(String nome, String cpf, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getProfissao() {
        return profissao;
    }
}

public class CadastroCliente {
    private List<Cliente> clientes;

    // Construtor
    public CadastroCliente() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }


    public static void main(String[] args) {
        CadastroCliente cadastro = new CadastroCliente();
        Scanner scanner = new Scanner(System.in);

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
            cadastro.adicionarCliente(cliente);
        }



        scanner.close();
    }
}