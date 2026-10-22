package contaBancaria;

public class ContaBancaria {
    
    private double saldo;
    private double chequeEspecial;
    private double depositoInicial;
    private double taxaCheque;
    private double limiteCheque;

    public ContaBancaria(float valor){
        depositoInicial = valor;
        saldo = depositoInicial;

        if (depositoInicial <= 500){
            chequeEspecial = 50;
            limiteCheque = 50;
            
        }
        else if (depositoInicial > 500){
            chequeEspecial =  depositoInicial * 0.50;
            limiteCheque = depositoInicial *0.50;
        }
    }

    public double consultarSaldo(){
        return saldo;
    }

    public double consultarChequeEspecial(){
        return limiteCheque;
    }

    public void depositar(float valor) {
        if(valor <= 0){
            System.out.println("Valor de deposito inválido!");
            System.out.println("");
            return;
        }

        if(taxaCheque > 0){
            double abatetaxa = Math.min(valor, taxaCheque);
            taxaCheque -= abatetaxa;

            double sobraDinheiro = valor - abatetaxa;

            saldo += sobraDinheiro;
            chequeEspecial += sobraDinheiro;
            if(chequeEspecial > limiteCheque){
                chequeEspecial = limiteCheque;
            }
        System.out.printf("Voce depositou R$ %.2f (Taxa debitada: R$ %.2f | Taxa restante: R$ %.2f)\n", valor, abatetaxa, taxaCheque);
        System.out.printf("Saldo Atual: R$ %.2f | Cheque especial disponível: R$ %.2f\n", saldo, chequeEspecial);
        }

        else {
            saldo += valor;
            chequeEspecial += valor;
            if(chequeEspecial > limiteCheque){
                chequeEspecial = limiteCheque;
            }
            System.out.printf("Voce depositou R$ %s\n",valor);
            System.out.printf("Saldo Atual: R$ %.2f | Cheque especial disponivel: R$ %.2f\n", saldo, chequeEspecial);
        }
    }

    public void sacar(float valor){
        calcularOperacao(valor);
    }

    public void pagarBoleto(float valor){
        calcularOperacao(valor);
    }

    public double usadoCheque() {
        return limiteCheque - chequeEspecial;
    }
    public double disponivelCheque(){
        return chequeEspecial;
    }

    public void calcularOperacao(double valor){

        if(valor <= 0 ){
            System.out.println("Valor da operacao invalida!");
            return;
        }

        double saldoResidual;
        
        if (saldo <= 0){     
            if (valor <= chequeEspecial){
                chequeEspecial -= valor;
                saldo =  saldo - valor;
                taxaCheque += valor * 0.20;
                System.out.println("Operacao de R$" + valor + " realizada!");
            }
            else{
                System.out.println("Saldo  insuficiente");
            }    
        }  
        else if(saldo > 0){
            if(valor <= (saldo +  chequeEspecial)){
                saldoResidual = saldo - valor;
                saldo = saldoResidual;
                if (saldoResidual < 0){
                    double usouCheque = Math.abs(saldoResidual);
                    chequeEspecial = chequeEspecial - usouCheque;
                    taxaCheque += usouCheque * 0.20;
                }
                System.out.println("Operacao de R$" + valor + " realizada!");
            }
            else{
                System.out.println("Saldo insuficiente");
            }
        }
    }

    public double taxaDoCheque(){
        return taxaCheque;
    }
}
