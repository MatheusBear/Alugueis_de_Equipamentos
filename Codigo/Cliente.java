import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int id;
	private String nome;
	private List<Contrato> contratos = new ArrayList<>();

	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public String getNome() {
		return nome;
	}
	

	@Override
	public String toString() {
		return "\nCliente: " + "( Id: " + id + ", Nome: " + nome + " )\n";
	}
	
}
