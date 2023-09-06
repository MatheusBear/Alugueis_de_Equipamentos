import java.util.ArrayList;
import java.util.List;

public class Cliente{
    private int id;
    private String nome;
    private List<Contrato> contratos = new ArrayList<>();
  public Cliente(int id, String nome){
    this.id = id;
    this.nome = nome;
  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Contrato> getContratos() {
    return contratos;
  }

  public void setContratos(List<Contrato> contratos) {
    this.contratos = contratos;
  }

  @Override
  public String toString() {
    return "Cliente{" +
           "id=" + id +
           ", nome='" + nome + '\'';
  }
}