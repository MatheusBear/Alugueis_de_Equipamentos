import java.time.LocalDateTime;

public class Contrato{
    private int id;
    private Cliente cliente = new Cliente();
    private Equipamento equipamento = new Equipamento();
    private LocalDateTime dataInicio = LocalDateTime.now();
    private LocalDateTime dataFim;
    private double valorTotal;

    int idItems = 0;

    //Setters

    public void setId(int ID){
        this.id = ID;
    }

    public void setCliente(Cliente Cliente){
        this.cliente = Cliente;
    }

    public void setEquipamento(Equipamento Equipamento){
        this.equipamento = Equipamento;
    }

    public void setDataFim(LocalDateTime DataFim){
        this.dataFim = DataFim;
    }

    public void setValorTotal(int ValorTotal){
        this.valorTotal = ValorTotal;
    }

    //Getters
    public int getID(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public Equipamento getEquipamento(){
        return this.equipamento;
    }

    public LocalDateTime getDataInicio(){
        return this.dataInicio;
    }

    public LocalDateTime getDataFim(){
        return this.dataFim;
    }

    public double getValorTotal(){
        return this.valorTotal;
    }
}