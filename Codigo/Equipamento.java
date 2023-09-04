public class Equipamento{
    private int id;
    private String descricao;
    private String tipo;
    private Double valor;
    private int quantidade;

    //Setters 
    public void setID(int ID){
        this.id = ID;
    }

    public void setDescricao(String Descricao){
        this.descricao = Descricao;
    }

    public void setTipo(String Tipo){
        this.tipo = Tipo;
    }

    public void setValor(Double Valor){
        this.valor = Valor;
    }

    public void setQuantidade(int Quantidade){
        this.quantidade = Quantidade;
    }

    //Getters
    public int getID(){
        return this.id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getTipo(){
        return this.tipo;
    }

    public Double getValor(){
        return this.valor;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    //Construtor
    public Equipamento(){

    }

    public Equipamento(int ID, String Descricao, String Tipo, double Valor, int Quantidade){
        this.id = ID;
        this.descricao = Descricao;
        this.tipo = Tipo;
        this.valor = Valor;
        this.quantidade = Quantidade;
    }
}