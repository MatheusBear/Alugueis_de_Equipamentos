import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestesUnitarios {

	private Cliente cliente;
	private Equipamento equipamento;
	private Contrato contrato;

	@BeforeEach
	public void defineValoresIniciais() {
		cliente = new Cliente(1, "Miguel");
		equipamento = new Equipamento(1, "Martelo", "Ferramentas", 10.0, 10);
		contrato = new Contrato(1,cliente, equipamento, 2, LocalDate.now().plusDays(7));
	}

	@Test
	public void verificaRegistroDeCliente() {
		assertEquals(1, cliente.getId());
		assertEquals("Miguel", cliente.getNome());
	}

	@Test
	public void verificaRegistroDeEquipamento() {
		assertEquals(1, equipamento.getId());
		assertEquals("Martelo", equipamento.getDescricao());
		assertEquals("Ferramentas", equipamento.getTipo());
		assertEquals(10.0, equipamento.getValor(), 0.001);
		assertEquals(10, equipamento.getQuantidadeDisponivel());
	}

	@Test
	public void verificaCriacaoDoContrato() {
		assertEquals(1,contrato.getId());
		assertEquals(cliente, contrato.getCliente());
		assertEquals(equipamento, contrato.getEquipamento());
		assertEquals(2, contrato.getQuantidade());
		assertEquals(LocalDate.now().plusDays(7), contrato.getDataFim());
		assertEquals(140.0, contrato.getValorTotal(), 0.001);
	}

	@Test
	public void verificaValorTotalDoContrato() {
		double valorEsperado = equipamento.getValor() * contrato.getQuantidade() * 7; // 1000 * 2 * 7 = 14000
		assertEquals(valorEsperado, contrato.getValorTotal(), 0.001);
	}

	@Test
	public void verificaAtualizacaoDaQuantidadeDisponivel() {
		int quantidadeContratada = contrato.getQuantidade();
		equipamento.setQuantidadeDisponivel(quantidadeContratada);
		int quantidadeEsperada = 10 - quantidadeContratada;
		assertEquals(quantidadeEsperada, equipamento.getQuantidadeDisponivel());
	}

	@Test
	public void verificaDataDeTerminoDoContrato() {
		LocalDate dataFimEsperada = LocalDate.now().plusDays(7);
		assertEquals(dataFimEsperada, contrato.getDataFim());
	}

}
