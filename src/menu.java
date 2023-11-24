import java.util.Scanner;

public class menu {

    public static void menu(){
        System.out.println("Banco");
        System.out.println("0. Cadastrar Cliente");
        System.out.println("1. Cadastrar Conta");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Saldo");
        System.out.println("4. Consultar clientes");
        System.out.println("5. Sair");
        System.out.println("Opcao:");
    }

    public static void cadCliente(){
        System.out.println("Cadastro de Clientes.");
    }

    public static void cadConta(){
        System.out.println("Cadastro de Conta.");
    }

    public static void deposito(){
        System.out.println("Depósito.");
    }

    public static void saldo(){
        System.out.println("Verificar Saldo.");
    }

    public static void consulta(){
        System.out.println("Consultar Clientes.");
    }

    public static void sair(){
        System.out.println("Consultar Clientes.");
    }

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    CadastroCliente cadCliente = new CadastroCliente();


                    break;

                case 2:
                    cadConta();
                    break;

                case 3:
                    deposito();
                    break;

                case 4:
                    saldo();
                    break;

                case 5:
                    consulta();
                    break;

                case 6:
                    sair();

                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}