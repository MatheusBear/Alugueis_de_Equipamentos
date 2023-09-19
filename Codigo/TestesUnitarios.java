import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestesUnitarios {

    private List<Cliente> clientes;
    private List<Equipamento> equipamentos;
    private List<Contrato> contratos;
    
    @Before
    public void setUp() {
    	clientes = new ArrayList<>();
        equipamentos = new ArrayList<>();
        contratos = new ArrayList<>();
    }

    @After
    public void tearDown() {
        clientes = null;
        equipamentos = null;
        contratos = null;
    }
    
    
    @Test
    public void testCadastraCliente() {
        Controlador.sc = new java.util.Scanner("João");
        Cliente cliente = Controlador.cadastraCliente();
        assertEquals(1, cliente.getId());
        assertEquals("João", cliente.getNome());
        assertEquals(0, clientes.size());
    }

    @Test
    public void testCadastraEquipamento() {
    	Equipamento equipamento = new Equipamento(1, "Equipamento Teste", "Tipo Teste", 100.0, 10);
        equipamentos.add(equipamento);
        assertEquals(1, equipamentos.size());
        Equipamento equipamentoEsperado = equipamentos.get(0);
        assertEquals(1, equipamentoEsperado.getId());
        assertEquals("Equipamento Teste", equipamentoEsperado.getDescricao());
        assertEquals("Tipo Teste", equipamentoEsperado.getTipo());
        assertEquals(100.0, equipamentoEsperado.getValor(), 0.01); 
        assertEquals(10, equipamentoEsperado.getQuantidadeDisponivel());
    }
 
    

    @Test
    public void testValidaDataInicio() {
        Controlador.sc = new java.util.Scanner("31/12/2023");
        LocalDate dataInicio = Controlador.validaDataInicio();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertEquals(LocalDate.parse("31/12/2023", formatter), dataInicio);
    }

    @Test
    public void testValidaDataFim() {
        Controlador.sc = new java.util.Scanner("01/01/2024");
        LocalDate dataInicio = LocalDate.parse("01/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataFim = Controlador.validaDataFim(dataInicio);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertEquals(LocalDate.parse("01/01/2024", formatter), dataFim);
    }

    @Test
    public void testVerificaStatusDoContrato() {
        LocalDate dataFimPassada = LocalDate.now().minusDays(1);
        LocalDate dataFimFutura = LocalDate.now().plusDays(1);

        boolean statusPassado = Controlador.verificaStatusDoContrato(dataFimPassada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assertFalse(statusPassado);

        boolean statusFuturo = Controlador.verificaStatusDoContrato(dataFimFutura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assertTrue(statusFuturo);
    }
    
    
    


}
