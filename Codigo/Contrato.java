import java.time.LocalDate;

public class Contrato {
	private int id;
	private Cliente cliente;
	private Equipamento equipamento;
	private LocalDate dataInicio = LocalDate.now();
	private LocalDate dataFim;
	private double valorTotal;
	private int quantidade;

	public Contrato(int id, Cliente cliente, Equipamento equipamento, int quantidade, LocalDate dataFim) {
		this.id = id;
		this.cliente = cliente;
		this.equipamento = equipamento;
		this.quantidade = quantidade;
		this.dataFim = dataFim;
		this.valorTotal = this.geraValorTotal();
	}

	private double geraValorTotal() {
		return this.equipamento.getValor() * this.quantidade * this.dataInicio.until(this.dataFim).getDays();
	}
	
	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		return "Contrato:" 
				+ "\nId: " 
				+ id 
				+ cliente 
				+ equipamento 
				+ "\nData Inicio: "
				+ dataInicio 
				+ "\nData Fim: " 
				+ dataFim 
				+ "\nValor Total: R$" 
				+ String.format("%.2f", valorTotal)
				+ "\nQuantidade: " 
				+ quantidade
				+ "\n";
	}
	
}
