public class Equipamento{
    private int id;
    private String descricao;
    private String tipo;
    private Double valor;
  private Equipamento(){}
  public Equipamento(int id, String descricao, String tipo, double valor){
    this.id = id;
    this.descricao = descricao;
    this.tipo = tipo;
    this.valor = valor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "Equipamento{" +
           "id=" + id +
           ", descricao='" + descricao + '\'' +
           ", tipo='" + tipo + '\'' +
           ", valor=" + valor +
           '}';
  }
}