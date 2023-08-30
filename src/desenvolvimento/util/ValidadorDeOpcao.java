package desenvolvimento.util;

/**
 * Classe para validar uma opção.
 *
 * @author Adriano Santos
 */
public class ValidadorDeOpcao extends Throwable {

    /**
     * Opção a ser validada.
     */
    private String opcao;

    /**
     * Construtor da classe.
     *
     * @param opcao Opção a ser validada.
     */
    public ValidadorDeOpcao(String opcao) {
        this.opcao = opcao;
    }

    /**
     * Valida a opção.
     *
     * @throws NumberFormatException Se a opção não for um número inteiro.
     */
    public void validarOpcao() throws NumberFormatException {
        // Converte a opção para um número inteiro.
        int numero = Integer.parseInt(opcao);

        // Imprime o número convertido.
        System.out.println(numero);
    }
}
