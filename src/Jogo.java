public class Jogo {

    private int id;                 
    private String titulo;      
    private String genero;      
    private int anoLancamento;      
    private double preco;           
    private boolean disponivel;     

    public Jogo(int id, String titulo, String genero, int anoLancamento, double preco, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        setAnoLancamento(anoLancamento); 
        this.preco = preco;
        this.disponivel = disponivel;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        if (anoLancamento > 2025) {

            throw new IllegalArgumentException("Ano de lançamento não pode ser maior que 2025.");
        }
        this.anoLancamento = anoLancamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Gênero: " + genero +
                " | Ano: " + anoLancamento +
                " | Preço: R$ " + String.format("%.2f", preco) +
                " | Status: " + (disponivel ? "Disponível" : "Indisponível");
    }
}
