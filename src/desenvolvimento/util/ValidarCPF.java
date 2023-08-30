package desenvolvimento.util;

/**
 * Classe que representa uma validação de CPF
 *
 * @author Adriano Santos
 */
public class ValidarCPF {

    // Armazena os multiplicadores utilizados no cálculo do dígito verificador
    private static final int[] multiplicador = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    /**
     * Valida um CPF.
     *
     * @param cpf O CPF a ser validado.
     * @return True se o CPF for válido, false caso contrário.
     */
    public static boolean validar(String cpf) {
        // Verifica se o CPF é nulo ou possui o tamanho incorreto
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Converte o CPF em um array de inteiros
        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        // Calcula o primeiro dígito verificador
        int digito1 = calcularDigitoVerificador(digitos, 0, 9);

        // Calcula o segundo dígito verificador
        int digito2 = calcularDigitoVerificador(digitos, 1, 9);

        // Verifica se os dígitos verificadores coincidem com os valores esperados
        return digitos[9] == digito1 && digitos[10] == digito2;
    }

    /**
     * Calcula o dígito verificador de um CPF.
     *
     * @param digitos O array de dígitos do CPF.
     * @param inicio O índice do primeiro dígito a ser considerado.
     * @param fim O índice do último dígito a ser considerado.
     * @return O dígito verificador calculado.
     */
    private static int calcularDigitoVerificador(int[] digitos, int inicio, int fim) {
        // Calcula a soma dos produtos dos dígitos pelos multiplicadores
        int soma = 0;
        for (int i = inicio; i <= fim; i++) {
            soma += digitos[i] * multiplicador[i];
        }

        // Obtém o resto da divisão da soma por 11
        int resto = soma % 11;

        // Retorna o dígito verificador, que é 0 se o resto for 0 ou 11 - resto caso contrário
        return (resto == 0) ? 0 : 11 - resto;
    }
}
