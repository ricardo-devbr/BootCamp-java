package contaBancaria;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("Vamos criar uma conta ?(s/n)");
        String criar = scanner.nextLine();
        
        if (!criar.equalsIgnoreCase("s")){
            System.out.println("Conta nao criada");
            return;
        }

        System.out.println("Digite seu nome para criacao da conta: ");
        String nome = scanner.nextLine();  
        System.out.println("");
        System.out.println("Digite o valor para deposito incial: ");
        float depositoInicial = Float.parseFloat(scanner.nextLine());
        var conta = new ContaBancaria(depositoInicial);

        System.out.println("----------//-------------");
        System.out.printf("%s, bem-vindo a sua conta\n", nome);
        System.out.println("----------//-------------");

        while (true) {

            System.out.println("Qual operacao deseja realizar?");
            System.out.println("");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar se estou usando cheque especial");
            System.out.println("7 - Sair");
            System.out.println("");

            try{
                int operacao = Integer.parseInt(scanner.nextLine());
                System.out.println("");
                switch (operacao) {
                    case 1:
                        System.out.printf("Seu saldo atual é: %s\n", conta.consultarSaldo());
                        break;
                    case 2:
                        System.out.printf("Seu limite do seu cheque especial é R$ %s\n ", conta.consultarChequeEspecial());
                        break;
                    case 3:
                        System.out.println("Digite o valor que deseja depositar: ");
                        float valorDeposito = Float.parseFloat(scanner.nextLine());
                        System.out.printf("Confirma o deposito de R$ %s ?(s/n)\n", valorDeposito);
                        String confirmaDeposito = scanner.nextLine();

                        if (confirmaDeposito.equalsIgnoreCase("s")){
                            conta.depositar(valorDeposito);
                        }
                        else{
                            System.out.println("Operacao cancelada");
                            continue;
                        }

                        break;
                    case 4:
                        System.out.println("Quanto voce deseja sacar?: ");                        
                        float valorSaque = Float.parseFloat(scanner.nextLine());
                        System.out.printf("Confirma o saque de R$ %s? (s/n) \n", valorSaque);
                        String confirmaSaque = scanner.nextLine();

                        if (confirmaSaque.equalsIgnoreCase("s")){
                            conta.sacar(valorSaque);
                        }
                        else{
                            System.out.println("Operacao cancelada\n");
                            continue;
                        }

                        break;
                    case 5:
                        System.out.println("Digite o valor do boleto que deseja pagar");
                        float valorBoleto = Float.parseFloat(scanner.nextLine());
                        System.out.printf("Confirma o pagamento do boleto de R$ %s? (s/n) \n", valorBoleto);
                        String confirmaBoleto = scanner.nextLine();
                        if (confirmaBoleto.equalsIgnoreCase("s")){
                            conta.pagarBoleto(valorBoleto);
                        }
                        else{
                            System.out.println("Operacao cancelada");
                            System.out.println("");
                            continue;
                        }
                        break;
                    case 6:
                        if (conta.usadoCheque() > 0){
                            System.out.println("Cheque especial em uso");
                            System.out.printf("Disponivel: %s | Usado: R$ %s \n",conta.disponivelCheque(), conta.usadoCheque());
                        }else{
                            System.out.println("Cheque especial nao está em uso");
                            System.out.println("Disponivel para uso" + conta.disponivelCheque());
                            System.out.println("");
                        }    
                        break;
                    case 7:
                        System.out.println("Encerrando o propragama . . .");
                        return;
                    default:
                        System.out.println("Opcao inválida, tente novamente...");
                        System.out.println("");
                        continue;
                }       
            }
            catch(NumberFormatException e){
                System.out.println("Opcao inválida!!");
            }
        }
    }   
}