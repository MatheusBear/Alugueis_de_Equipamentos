public class Equipamento {
	private int id;
	private String descricao;
	private String tipo;
	private Double valor;
	private int quantidadeDisponivel;

	public Equipamento(int id, String descricao, String tipo, Double valor, int quantidadeDisponivel) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public Double getValor() {
		return valor;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	private void setQuantidadeDisponivel(int alugados) {
		this.quantidadeDisponivel -= alugados;
	}

	public boolean validaQuantidaDisponivel(int alugados) {
		boolean verify = ((this.quantidadeDisponivel - alugados) >= 0) ? true : false;
		if(verify) {
			setQuantidadeDisponivel( alugados);
		}
		return verify;

	}

	@Override
	public String toString() {

		return "\nEquipamento:" + "\nid: " + id + "\nDescricao: " + descricao + "\nTipo: " + tipo + "\nValor: R$"
				+ String.format("%.2f", valor) + "\n";
	}
}
