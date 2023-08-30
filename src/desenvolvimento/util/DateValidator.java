package desenvolvimento.util;

public class DateValidator {

    public static boolean isValid(String date) {
        // Verifica se a data está no formato DD/MM/AAAA
        if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }

        // Extrai os campos da data
        int dia = Integer.parseInt(date.substring(0, 2));
        int mes = Integer.parseInt(date.substring(3, 5));
        int ano = Integer.parseInt(date.substring(6, 10));

        // Verifica se o dia está no intervalo válido
        if (dia < 1 || dia > 31) {
            return false;
        }

        // Verifica se o mês está no intervalo válido
        if (mes < 1 || mes > 12) {
            return false;
        }

        // Verifica se o ano é maior ou igual a 1900
        if (ano < 1900) {
            return false;
        }

        return true;
    }
}
