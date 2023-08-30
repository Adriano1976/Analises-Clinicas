package desenvolvimento.cliente;

import desenvolvimento.util.ISystemLine;

import java.util.Scanner;
import java.util.UUID;

/**
 * Esta classe representa um estado.
 */
public class Uf implements ISystemLine {

    /**
     * O código do estado.
     */
    private UUID codigo = UUID.randomUUID();

    /**
     * A sigla do estado.
     */
    private String sigla;

    /**
     * O nome do estado.
     */
    private String nomeUf;

    /**
     * Construtor default.
     */
    public Uf() {
    }

    /**
     * Obtém o código do estado.
     *
     * @return O código do estado.
     */
    public UUID getCodigo() {
        return codigo;
    }

    /**
     * Define o código do estado.
     *
     * @param codigo O novo código do estado.
     */
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém a sigla do estado.
     *
     * @return A sigla do estado.
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * Define a sigla do estado.
     *
     * @param sigla A nova sigla do estado.
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * Obtém o nome do estado.
     *
     * @return O nome do estado.
     */
    public String getNomeUf() {
        return nomeUf;
    }

    /**
     * Define o nome do estado.
     *
     * @param nomeUf O novo nome do estado.
     */
    public void setNomeUf(String nomeUf) {
        this.nomeUf = nomeUf;
    }

    /**
     * Cadastra as informações do estado.
     */
    public void cadastrarInformacoesEstado() {

        Scanner scanner = new Scanner(System.in);

        boolean nomeUfValido = false;
        boolean siglaValida = false;

        while (!nomeUfValido || !siglaValida) {
            // Solicita o nome do estado.
            System.out.print("Estado: ");
            this.setNomeUf(scanner.nextLine());

            // Verifica se o nome do estado foi preenchido.
            if (this.getNomeUf().isEmpty()) {
                System.out.println("O nome do estado deve ser preenchido.");
                continue;
            }

            // Solicita a sigla do estado.
            System.out.print("Sigla: ");
            this.setSigla(scanner.nextLine());

            // Verifica se a sigla do estado foi preenchida.
            if (this.getSigla().isEmpty()) {
                System.out.println("A sigla do estado deve ser preenchida.");
                continue;
            }

            // Verifica se a sigla do estado tem o tamanho correto.
            if (this.getSigla().length() != 2) {
                System.out.println("A sigla do estado deve ter apenas duas letras.");
                continue;
            }

            nomeUfValido = true;
            siglaValida = true;
        }
    }

    /**
     * Imprime as informações do estado.
     */
    public void imprimirInformacoesUf() {

        System.out.println("Estado: " + this.getNomeUf() + " - " + "Sigla: " + this.getSigla());
    }
}
