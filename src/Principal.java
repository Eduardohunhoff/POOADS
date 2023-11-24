import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        OperaBanco operaBanco = new OperaBanco();
        
        int opcao;

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Realizar Depósito");
            System.out.println("4 - Realizar Transferência");
            System.out.println("5 - Verificar Saldo");
            System.out.println("6 - Exibir Nomes de Todos os Clientes");
            System.out.println("7 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite a profissão do cliente: ");
                    String profissao = scanner.nextLine();

                    // Cadastrar cliente
                    operaBanco.cadastraCliente(nome, cpf, profissao);

                    // Exibir lista de clientes
                    operaBanco.exibirClientes();
                    break;
                case 2:

                    // Solicitar dados da conta
                    System.out.print("Digite o CPF do cliente para cadastrar a conta: ");
                    String cpfConta = scanner.nextLine();

                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();

                    System.out.print("Digite o número da agência: ");
                    String agencia = scanner.nextLine();

                    // Cadastrar conta
                    operaBanco.cadastraConta(cpfConta, numeroConta, agencia);

                    // Exibir lista de contas
                    operaBanco.exibirContas();


                    break;
                case 3:
                    
                    System.out.print("Digite o número da conta para realizar o depósito: ");
                    String numeroContaDeposito = scanner.nextLine();

                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();

                    // Realizar depósito
                    operaBanco.depositar(numeroContaDeposito, valorDeposito);

                    // Exibir lista de contas atualizada
                    operaBanco.exibirContas();


                    break;
                case 4:

                    // Solicitar dados da transferência
                    System.out.print("Digite o número da conta de origem: ");
                    String numeroContaOrigem = scanner.nextLine();

                    System.out.print("Digite o número da conta de destino: ");
                    String numeroContaDestino = scanner.nextLine();

                    System.out.print("Digite o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();

                    // Realizar transferência
                    operaBanco.transferir(numeroContaOrigem, numeroContaDestino, valorTransferencia);

                    // Exibir lista de contas atualizada
                    operaBanco.exibirContas();
                    break;
                case 5:
                    // Verificar saldo
                    System.out.print("Digite o número da conta para verificar o saldo: ");
                    String numeroContaSaldo = scanner.nextLine();
                    double saldo = operaBanco.verificarSaldo(numeroContaSaldo);

                    if (saldo >= 0) {
                        System.out.println("Saldo da conta: " + saldo + " reais");
                    }
                    break;
                case 6:
                    // Exibir nomes de todos os clientes cadastrados
                    operaBanco.exibirNomesClientes();
                    break;
                case 7:
                    // Sair do sistema
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 7);
        
	}

}
