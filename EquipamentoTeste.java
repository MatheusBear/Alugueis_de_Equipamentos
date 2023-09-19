package Projeto1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Esta classe contém os testes para a classe Equipamento.
 */
public class EquipamentoTeste {

    private Equipamento equipamento;

    /**
     * Configuração inicial para cada teste.
     */
    @BeforeEach
    public void setUp() {
        equipamento = new Equipamento(1, "Equipamento de Teste", "Tipo de Teste", 100.0, 10);
    }

    /**
     * Testa o método getId da classe Equipamento.
     */
    @Test
    public void testGetId() {
        assertEquals(1, equipamento.getId());
    }

    /**
     * Testa o método getDescricao da classe Equipamento.
     */
    @Test
    public void testGetDescricao() {
        assertEquals("Equipamento de Teste", equipamento.getDescricao());
    }

    /**
     * Testa o método getTipo da classe Equipamento.
     */
    @Test
    public void testGetTipo() {
        assertEquals("Tipo de Teste", equipamento.getTipo());
    }

    /**
     * Testa o método getValor da classe Equipamento.
     */
    @Test
    public void testGetValor() {
        assertEquals(100.0, equipamento.getValor(), 0.01);
    }

    /**
     * Testa o método getQuantidadeDisponivel da classe Equipamento.
     */
    @Test
    public void testGetQuantidadeDisponivel() {
        assertEquals(10, equipamento.getQuantidadeDisponivel());
    }

    /**
     * Testa o método validaQuantidaDisponivel da classe Equipamento.
     */
    @Test
    public void testValidaQuantidaDisponivel() {
        assertTrue(equipamento.validaQuantidaDisponivel(5)); // Deve retornar true, pois tem 5 disponíveis
        assertEquals(5, equipamento.getQuantidadeDisponivel()); // A quantidade de equipamentos disponível deve ser atualizada para 5

        assertFalse(equipamento.validaQuantidaDisponivel(10)); // Deve retornar false, pois não há 10 disponíveis
        assertEquals(5, equipamento.getQuantidadeDisponivel()); // A quantidade de equipamentos disponível não deve mudar

        assertFalse(equipamento.validaQuantidaDisponivel(6)); // Deve retornar false, pois não há 6 equipamentos disponíveis
        assertEquals(5, equipamento.getQuantidadeDisponivel()); // A quantidade de equipamentos disponível não deve ter mudado
    }
}


