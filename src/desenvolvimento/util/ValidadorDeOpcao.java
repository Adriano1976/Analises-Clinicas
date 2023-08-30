package desenvolvimento.util;

public class ValidadorDeOpcao extends Throwable {
    private String opcao;

    public ValidadorDeOpcao(String opcao) {
        this.opcao = opcao;
    }

    public void validarOpcao() {
        try {
            int numero = Integer.parseInt(opcao);
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println(opcao + " : Opção Inválida.");
        }
    }
}

