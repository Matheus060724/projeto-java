package model;

public class ClienteRegular extends Cliente {
    
    public ClienteRegular(String nome, String email, double saldo) {
        super(nome, email, saldo);
    }

    @Override
    public double calcularDesconto (double valorOriginal) {
        return valorOriginal;
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo regular";
    }

}
