import java.util.ArrayList;

public class OperaBanco {
	
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();

    public boolean cadastraCliente(String nome, String cpf, String profissao) {

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("CPF já cadastrado. Não é possível cadastrar novamente.");
                return false;
            }
        }

        Cliente novoCliente = new Cliente(nome, cpf, profissao);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
        return true;
    }
    
    public boolean cadastraConta(String cpf, String numeroConta, String agencia) {
        // Verifica se o cliente existe
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("CPF não encontrado. Não é possível cadastrar a conta.");
            return false;
        }

        // Cria uma nova conta e a adiciona à lista
        Conta novaConta = new Conta(numeroConta, agencia, clienteEncontrado);
        contas.add(novaConta);
        System.out.println("Conta cadastrada com sucesso!");
        return true;
    }

    public void exibirContas() {
        System.out.println("\nLista de Contas:");
        for (Conta conta : contas) {
            System.out.println("Número da Conta: " + conta.getNumero() +
                    ", Agência: " + conta.getAgencia() +
                    ", Cliente: " + conta.getCliente().getNome());
        }
    }

    public void exibirClientes() {
        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() +
                    ", CPF: " + cliente.getCpf() +
                    ", Profissão: " + cliente.getProfissao());
        }
    }
    
    public boolean depositar(String numeroConta, double valor) {
        // Verifica se a conta existe
        Conta contaEncontrada = null;
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                contaEncontrada = conta;
                break;
            }
        }

        if (contaEncontrada == null) {
            System.out.println("Conta não encontrada. Não é possível realizar o depósito.");
            return false;
        }

        // Realiza o depósito
        contaEncontrada.depositar(valor);

        // Exibe o saldo atualizado
        System.out.println("Depósito realizado na conta de " + contaEncontrada.getCliente().getNome() +
                " - Saldo atualizado: " + contaEncontrada.getSaldo() + " reais");

        return true;
    }
    
    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        // Verifica se as contas de origem e destino existem
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroContaOrigem)) {
                contaOrigem = conta;
            }
            if (conta.getNumero().equals(numeroContaDestino)) {
                contaDestino = conta;
            }
        }

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta de origem ou destino não encontrada. Não é possível realizar a transferência.");
            return false;
        }

        // Verifica se a conta de origem possui saldo suficiente
        if (contaOrigem.getSaldo() < valor) {
            System.out.println("Saldo insuficiente na conta de origem. Não é possível realizar a transferência.");
            return false;
        }

        // Realiza a transferência
        contaOrigem.debitar(valor);
        contaDestino.depositar(valor);

        // Exibe os saldos atualizados
        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Conta de " + contaOrigem.getCliente().getNome() + " - Saldo atualizado: " + contaOrigem.getSaldo() + " reais");
        System.out.println("Conta de " + contaDestino.getCliente().getNome() + " - Saldo atualizado: " + contaDestino.getSaldo() + " reais");

        return true;
    }
    
    public double verificarSaldo(String numeroConta) {
        // Verifica se a conta existe
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                // Retorna o saldo da conta
                return conta.getSaldo();
            }
        }

        System.out.println("Conta não encontrada. Não é possível verificar o saldo.");
        return -1; // Valor negativo indica que a conta não foi encontrada
    }
    
    public void exibirNomesClientes() {
        System.out.println("\nNomes de todos os clientes cadastrados:");

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }
}
