package desenvolvimento.util;

/**
 * Classe para obter e formatar a data e hora local.
 *
 * @author Adriano Santos
 */
public class DateValidator {

    /**
     * Verifica se a data passada como parâmetro é válida.
     *
     * @param date A data a ser validada.
     * @return True se a data for válida, false caso contrário.
     */
    public static boolean isValid(String date) {
        /*
         * Verifica se a data está no formato DD/MM/AAAA.
         *
         * O padrão \\d{2} indica um número de dois dígitos.
         */
        if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }

        /*
         * Extrai os campos da data.
         */
        int dia = Integer.parseInt(date.substring(0, 2));
        int mes = Integer.parseInt(date.substring(3, 5));
        int ano = Integer.parseInt(date.substring(6, 10));

        /*
         * Verifica se o dia está no intervalo válido.
         *
         * Os dias de um mês variam de 1 a 31, exceto fevereiro, que tem 28 ou 29 dias.
         */
        if (dia < 1 || dia > 31) {
            return false;
        }

        /*
         * Verifica se o mês está no intervalo válido.
         *
         * Os meses de um ano variam de 1 a 12.
         */
        if (mes < 1 || mes > 12) {
            return false;
        }

        /*
         * Verifica se o ano é maior ou igual a 1900.
         *
         * O ano de 1900 é o primeiro ano do século XX.
         */
        if (ano < 1900) {
            return false;
        }

        return true;
    }
}
