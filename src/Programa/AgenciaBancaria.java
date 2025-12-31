package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes(){
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();
        input.nextLine();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa Agência!");
                System.exit(0);
                
            default:
                System.out.println("Opção inválida");
                operacoes();
                break;
            
        }

    }

    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = input.nextLine();

        System.out.println("\nCPF: ");
        String cpf = input.nextLine();

        System.out.println("\nEmail: ");
        String email = input.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for (Conta c : contasBancarias){
                if(c.getNumeroConta() == numeroConta){
                conta = c;
                }
            }
        }
        return conta;
    }


    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
        }else{
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar(){
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        }else{
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void transferir(){
        System.out.println("Número da conta do remetente: ");
        int numContaRemetente = input.nextInt();
        input.nextLine();

        Conta contaRemetente = encontrarConta(numContaRemetente);

        if(contaRemetente != null){
            System.out.println("Número da conta do destinatário: ");
            int numContaDestinatario = input.nextInt();
            input.nextLine();

            Conta contaDestinatario = encontrarConta(numContaDestinatario);

            if(contaDestinatario != null){
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();
                input.nextLine();

                contaRemetente.transferir(contaDestinatario, valor);
            }
        }
        operacoes();
    }

    public static void listar(){
        if(contasBancarias.size()>0){
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else{
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
