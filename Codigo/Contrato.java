import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Contrato {
	private int id;
	private Cliente cliente;
	private Equipamento equipamento;
	private String dataInicio;
	private String dataFim;
	private double valorTotal;
	private int quantidade;
	
	
	public Contrato(int id, Cliente cliente, Equipamento equipamento, int quantidade, String dataFim, String StartDate) {
		this.id = id;
		this.cliente = cliente;
		this.equipamento = equipamento;
		this.quantidade = quantidade;
		this.dataFim = dataFim;
		this.dataInicio = StartDate;
		this.valorTotal = this.geraValorTotal();
	}

	private double geraValorTotal() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate = LocalDate.parse(this.dataInicio, dateFormatter);
		LocalDate endDate = LocalDate.parse(this.dataFim, dateFormatter);
		return this.equipamento.getValor() * this.quantidade * startDate.until(endDate).getDays();
	}
	
	private int diasAlugados() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate = LocalDate.parse(this.dataInicio, dateFormatter);
		LocalDate endDate = LocalDate.parse(this.dataFim, dateFormatter);
		return startDate.until(endDate).getDays();
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

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
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
				+"\nDias Alugados: "
				+ diasAlugados()
				+ "\nValor Total: R$" 
				+ String.format("%.2f", valorTotal)
				+ "\nQuantidade: " 
				+ quantidade
				+ "\n";
	}

	public void get(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	
}
