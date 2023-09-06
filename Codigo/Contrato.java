import java.time.LocalDate;

public class Contrato {
  private int id;
  private Cliente cliente;
  private Equipamento equipamento;
  private LocalDate dataInicio = LocalDate.now();
  private LocalDate dataFim;
  private double valorTotal;
  private int quantidade;

  public Contrato(Cliente cliente, Equipamento equipamento, int quantidade, LocalDate dataFim) {
    this.cliente = cliente;
    this.equipamento = equipamento;
    this.quantidade = quantidade;
    this.dataFim = dataFim;
    this.valorTotal = this.geraValorTotal();
  }

  private double geraValorTotal() {
    return this.equipamento.getValor()
        * this.quantidade
        * this.dataFim.until(this.dataInicio).getDays();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Equipamento getEquipamento() {
    return equipamento;
  }

  public void setEquipamento(Equipamento equipamento) {
    this.equipamento = equipamento;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDate getDataFim() {
    return dataFim;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  @Override
  public String toString() {
    return "Contrato{" +
           "id=" + id +
           ", cliente=" + cliente +
           ", equipamento=" + equipamento +
           ", dataInicio=" + dataInicio +
           ", dataFim=" + dataFim +
           ", valorTotal=" + valorTotal +
           ", quantidade=" + quantidade +
           '}';
  }
}
