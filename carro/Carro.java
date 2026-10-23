package carro;

public class Carro {

    private boolean ligado;
    private int velocidade = 0;
    private final int velocidadeMax = 120;
    private int marchaAtual = 0;


    public Carro(){
        desligar();
    } 


    public void ligar(){
        this.ligado = true;
        System.out.println("------CARRO LIGADO------");
        System.out.println("");
    }
    public void desligar(){
        if (marchaAtual == 0 && velocidade == 0){
            this.ligado = false;
            System.out.println("------CARRO DESLIGADO------");
            System.out.println("");
        }
        else{
            System.out.println("O CARRO DEVE ESTAR EM PONTO MORTO PARAB DESLIGAR(marcha 0)");
            System.out.println("e velocidade 0 (parado)");
            System.out.println("");
        }
    }

    public void acelerar(){
        if(marchaAtual == 0){
            System.out.println("MARCHA: " + marchaAtual);
            System.out.println("NAO É POSSIVEL ACELERAR EM PONTO MORTO");
            System.out.println("");
            return;
        }

        int velMaxMarcha = velocidadeMarcha(marchaAtual);

        if(velocidade >= velMaxMarcha){
            System.out.println("");
            System.out.println("FAVOR TROCAR DE MARCHA PARA ACELERAR");
            System.out.println("");
            return;
        }
        else if(velocidade == velocidadeMax){
            System.out.println("Velocidade maxima atingida");
            return;
        }
        
        this.velocidade++;
        System.out.println("ACELERANDO . . . " + velocidade + "KM/H");

    }

    public void diminuirVelocidade(){
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }

        if (velocidade == 0) {
            System.out.println("O CARRO JÁ ESTÁ PARADO (0 KM/H)!");
            return;
        }

        int velMinimaDaMarcha = velocidadeMarcha(marchaAtual - 1);

        if (marchaAtual > 1 && velocidade <= velMinimaDaMarcha) {
            System.out.println("");
            System.out.println("REDUZA A MARCHA PARA CONTINUAR DESACELERANDO");
            System.out.println("");
            return;
        }

        this.velocidade--;
        System.out.println("DIMINUINDO . . . " + velocidade + " KM/H");

        // 5. Se chegou a 0 na 1ª marcha, avisa que parou
        if (velocidade == 0) {
            System.out.println("CARRO PARADO! (Coloque em ponto morto para desligar)\n");
        }
}

    public void virarEsquerda(){
        if(velocidade >= 1 && velocidade >= 40){
            System.out.println("VIRANDO A ESQUERDA");
        }
        else if(velocidade < 1){
            System.out.println("VELOCIDADE ATUAL: " + getvelocidade());
            System.out.println("ACELERE PARA VIRAR A ESQUERDA");
            return;
        }
        else if(velocidade > 40){
            System.out.println("VELOCIDADE MAXIMA ATINGIDA: "+ velocidadeMax + "KM/H");
            System.out.println("DIMINUA A VELOCIDADE PARA VIRAR A ESQUERDA");
            return;
        }
        }
    public void virarDireita(){
        if(velocidade >= 1 && velocidade >= 40){
            System.out.println("VIRANDO A DIREITA");
        }
        else if(velocidade < 1){
            System.out.println("VELOCIDADE ATUAL: " + getvelocidade());
            System.out.println("ACELERE PARA VIRAR DIREITA");
            return;
        }
        else if(velocidade > 40){
            System.out.println("VELOCIDADE MAXIMA ATINGIDA: "+ velocidadeMax + "KM/H");
            System.out.println("DIMINUA A VELOCIDADE PAARA VIRAR DIREITA");
            return;
        }
    }
    
    public int getvelocidade(){
        return velocidade;
    }

    public int velocidadeMarcha(int marcha){

        switch (marcha){
            case 1:
                return 20;
            case 2:
                return 40;
            case 3:
                return 60;
            case 4:
                return 80;
            case 5:
                return 100;
            case 6:
                return 120;
            default:
                return 0;
        }
    }
    public void passaMarcha(){
        if (marchaAtual >= 6 ){
            System.out.println("JA ESTÁ NA ULTIMA MARCHA");
            return;
        }
        if (marchaAtual == 0){
            marchaAtual = 1;
            System.out.println("ENGATANDO " + marchaAtual + "ª MARCHA ");
            return;
        }
        int velmaxAtual = velocidadeMarcha(marchaAtual);
        if(velocidade < velmaxAtual){
            System.out.println("ACELERE MAIS PARA TROCAR DE MARCHA");
            return;
        }

        marchaAtual++;
        getMarchaAtual();
    }
public void reduzirMarcha() {
    if (marchaAtual <= 0) {
        System.out.println("Já está em ponto morto!");
        return;
    }

    if (marchaAtual == 1 && velocidade == 0) {
        marchaAtual = 0;
        System.out.println("Ponto morto engatado.");
        return;
    }

    int velMaxMarchaMin = velocidadeMarcha(marchaAtual - 1);

    if (velocidade > velMaxMarchaMin) {
        System.out.println("");
        System.out.println("REDUZA A VELOCIDADE PARA REDUZIR A MARCHA.");
        System.out.println("");
        return;
    }

    marchaAtual--;
    System.out.println("Marcha reduzida para: " + marchaAtual + "ª marcha!");
}

    public void getMarchaAtual (){
        System.out.println("ENGATANDO " + marchaAtual + "ª MARCHA ");
    }
}
