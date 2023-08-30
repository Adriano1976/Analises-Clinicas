package desenvolvimento.util;

public class ValidarCPF {

    private static final int[] multiplicador = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean validar(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int digito1 = calcularDigitoVerificador(digitos, 0, 9);
        int digito2 = calcularDigitoVerificador(digitos, 1, 9);

        return digitos[9] == digito1 && digitos[10] == digito2;
    }

    private static int calcularDigitoVerificador(int[] digitos, int inicio, int fim) {
        int soma = 0;
        for (int i = inicio; i <= fim; i++) {
            soma += digitos[i] * multiplicador[i];
        }

        int resto = soma % 11;

        return (resto == 0) ? 0 : 11 - resto;
    }
}
