package carro;

public class Carro {

    private boolean ligado;
    private int acelerar;
    private int velocidade = 0;
    private final int velocidadeMax = 120;
    private int marchaAtual = 0;


    public Carro(){
        desligar();
    } 


    public void ligar(){
        this.ligado = true;
        System.out.println("CARRO LIGADO");
        System.out.println("");
    }
    public void desligar(){
        if (marchaAtual == 0 && velocidade == 0){
            this.ligado = false;
            System.out.println("CARRO DESLIGADO");
            System.out.println("");
        }
        else{
            System.out.println("O carro deve estar em ponto morto(marcha 0)");
            System.out.println("e velocidade 0 (parado)");
            System.out.println("");
        }
    }

    public void acelerar(){
        if(marchaAtual == 0){
            System.out.println("MARCHA: " + marchaAtual);
            System.out.println("NAO É POSSIVEL ACELERAR EM PONTO MORTO");
            return;
        }
        else if(marchaAtual > 0){
            this.velocidade++;
            System.out.println("ACELERANDO . .");
        }
        else if(velocidade == velocidadeMax){
            System.out.println("Velocidade maxima atingida");
            return;
        }
    }

    public void diminuirVelocidade(){
        if(velocidade > 0){
            this.velocidade--;
            System.out.println("DIMINUINDO . . .");
        }
        if(velocidade == 0){
            System.out.println("CARRO PARANDO . . .");
            System.out.println("");
            System.out.println("CARRO PARADO!");
            return;
        }
    }

    public void virarEsquerda(){
        if(velocidade >= 1 && velocidade >= 40){
            System.out.println("VIRANDO A ESQUERDA");
        }
        else if(velocidade < 1){
            System.out.println("ACELERE PARA VIRAR");
            return;
        }
        else if(velocidade > 40){
            System.out.println("DIMINUA A VELOCIDADE PAARA VIRAR");
            return;
        }
        }
    public void virarDireita(){
        if(velocidade >= 1 && velocidade >= 40){
            System.out.println("VIRANDO A DIREITA");
        }
        else if(velocidade < 1){
            System.out.println("ACELERE PARA VIRAR");
            return;
        }
        else if(velocidade > 40){
            System.out.println("DIMINUA A VELOCIDADE PAARA VIRAR");
            return;
        }
    }
    
    public int getvelocidade(){
        return velocidade;
    }

    public void passaMarcha(){
        if (velocidade == 0){
            marchaAtual = 0;
        }
        if(velocidade > 0 && velocidade < 20){
            marchaAtual = 1;
        }
        else if(velocidade > 20 && velocidade <= 40){
            marchaAtual = 2;
        }
        else if(velocidade > 40 && velocidade <= 50){
            marchaAtual = 3;
        }
        else if(velocidade > 60 && velocidade <= 80){
            marchaAtual = 4;
        }
        else if(velocidade > 80 && velocidade <= 100){
            marchaAtual = 5;
        }
        else if(velocidade > 100 && velocidade <= 120){
            marchaAtual = 6;
        }
        
    }
}
