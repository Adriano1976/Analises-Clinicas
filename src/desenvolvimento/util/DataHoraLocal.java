package desenvolvimento.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHoraLocal {

    LocalDateTime dataHoraAtual = LocalDateTime.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataHoraFormatada = dataHoraAtual.format(formatador);

    public DataHoraLocal() {
    }

    public String getDataHoraFormatada() {
        return dataHoraFormatada;
    }

    public void setDataHoraFormatada(String dataHoraFormatada) {
        this.dataHoraFormatada = dataHoraFormatada;
    }

    public String imprimirDataHoraLocal() {

        System.out.println();
        return "Data e Hora Atual: " + this.getDataHoraFormatada();
    }
}
