package model;

public class ClientePremium extends Cliente {
    public ClientePremium (String nome, String email, double saldo){
        super(nome, email, saldo);
    }

    @Override
    public double calcularDesconto(double valorOriginal){
        return valorOriginal * 0.9;
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo premium";
    }
    
}
 