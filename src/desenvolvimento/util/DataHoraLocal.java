package desenvolvimento.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe para obter e formatar a data e hora local.
 *
 * @author Adriano Santos
 */
public class DataHoraLocal {

    /**
     * Data e hora atual.
     */
    private LocalDateTime dataHoraAtual;

    /**
     * Formatador de data e hora.
     */
    private DateTimeFormatter formatador;

    /**
     * Data e hora formatada.
     */
    private String dataHoraFormatada;

    /**
     * Construtor da classe.
     */
    public DataHoraLocal() {
        this.dataHoraAtual = LocalDateTime.now();
        this.formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHoraFormatada = dataHoraAtual.format(formatador);
    }

    /**
     * Obtém a data e hora formatada.
     *
     * @return a data e hora formatada
     */
    public String getDataHoraFormatada() {
        return dataHoraFormatada;
    }

    /**
     * Define a data e hora formatada.
     *
     * @param dataHoraFormatada a data e hora formatada
     */
    public void setDataHoraFormatada(String dataHoraFormatada) {
        this.dataHoraFormatada = dataHoraFormatada;
    }

    /**
     * Imprime a data e hora local.
     *
     * @return a data e hora local
     */
    public String imprimirDataHoraLocal() {

        System.out.println();
        return "Data e Hora Atual: " + this.getDataHoraFormatada();
    }
}
