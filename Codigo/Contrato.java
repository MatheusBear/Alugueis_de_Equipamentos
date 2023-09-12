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
		return this.equipamento.getValor() * this.quantidade * this.dataFim.until(this.dataInicio).getDays();
	}


	@Override
	public String toString() {
		return "Contrato:" 
				+ "\nid=" 
				+ id 
				+ "\ncliente=" 
				+ cliente 
				+ "\nequipamento=" 
				+ equipamento 
				+ "\ndataInicio="
				+ dataInicio 
				+ "\ndataFim=" 
				+ dataFim 
				+ "\nvalorTotal=" 
				+ valorTotal 
				+ "\nquantidade=" 
				+ quantidade;
	}
}
