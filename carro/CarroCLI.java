package carro;

import java.util.Scanner;

public class CarroCLI {
    private int opcaoIniciar;
    private Carro carro = new Carro();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar(){
        while (true) {
            System.out.println("-----------------------");
            System.out.println("VOCE ESTÁ FORA DO CARRO");
            System.out.println("-----------------------");
            System.out.println("");
            System.out.println("1 - Entrar no carro ");
            System.out.println("2 - Encerrar");
            System.out.println("");

            opcaoIniciar = Integer.parseInt(scanner.nextLine());

            if(opcaoIniciar == 2){
                System.out.println("ENCERRANDO . . .");
                System.out.println("");
                break;
                
            }
            else if(opcaoIniciar == 1){
               menuDentroDoCarro();
            }
            else{
                System.out.println("OPCAO INVALIDA");
                System.out.println("");
            }
        }
    }

    public void menuDentroDoCarro(){
            while (true) {
                System.out.println("--------------------");
                System.out.println("VOCE ENTROU NO CARRO");
                System.out.println("--------------------");
                System.out.println("");
                System.out.println("1 - Ligar carro ");
                System.out.println("2 - Sair do carro");
                System.out.println("");
                int opcaoNoCarro = Integer.parseInt(scanner.nextLine());

                if (opcaoNoCarro == 1){
                    menuComandos();
                }
                else if(opcaoNoCarro == 2){
                    iniciar();
                }
                else{
                    System.out.println("OPCAO INVALIDA");
                }
            }
        }
    public void menuComandos(){ 
        while(true){
            System.out.println("SELECIONE UM COMANDO: ");
            System.out.println("");
            System.out.println("1 - Desligar carro ");
            System.out.println("2 - Acelerar ");
            System.out.println("3 - Reduzir velocidade ");
            System.out.println("4 - Virar a esquerda ");
            System.out.println("5 - Virar a direita ");
            System.out.println("6 - Verificar velocidade ");
            System.out.println("7 - Passar marcha ");
        
            try{
                comando = Integer.parseInt(scanner.nextLine());
                System.out.println("");
                switch (comando) {
                    case 1:
                        carro.desligar();
                        break;
                    case 2:
                        carro.acelerar();
                        break;
                    case 3:
                        carro.diminuirVelocidade();
                        break;
                    case 4:
                        carro.virarEsquerda();
                        break;
                    case 5:
                        carro.virarDireita();
                        break;
                    case 6:
                        carro.getvelocidade();
                        break;
                    case 7:
                        carro.passaMarcha();
                        break;
                
                    default:
                        break;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Opcao inválida!!");
            }
        }   
    }
}
