package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Scanner;
import java.util.UUID;

/**
 * Classe que representa convênios.
 *
 * @author Adriano Santos
 */
public class Convenio implements ISystemLine {

    /**
     * Código do convênio.
     */
    private UUID codigo = UUID.randomUUID();

    /**
     * Nome do convênio.
     */
    private String nomeConvenio;

    /**
     * Data e hora local.
     */
    private final DataHoraLocal dataHoraLocal = new DataHoraLocal();

    /**
     * Construtor da classe.
     */
    public Convenio() {
        // Inicializa o código do convênio com um UUID aleatório.
        this.codigo = UUID.randomUUID();
    }

    /**
     * Obtém o código do convênio.
     *
     * @return Código do convênio.
     */
    public UUID getCodigo() {
        return codigo;
    }

    /**
     * Define o código do convênio.
     *
     * @param codigo Código do convênio.
     */
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o nome do convênio.
     *
     * @return Nome do convênio.
     */
    public String getNomeConvenio() {
        return nomeConvenio;
    }

    /**
     * Define o nome do convênio.
     *
     * @param nomeConvenio Nome do convênio.
     */
    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    /**
     * Método para cadastrar as informações do convênio.
     *
     * @author [Seu nome]
     * @since [Data]
     */
    public void cadastrarInformacoesConvenio() {

        // Cria um objeto Scanner para ler a entrada do usuário.
        Scanner scanner = new Scanner(System.in);

        // Imprime um cabeçalho para as informações do convênio.
        System.out.println("\n" + LINE);
        System.out.println("|          INFORMAÇÕES SOBRE O CONVÊNIO         |");
        System.out.println(LINE);

        // Solicita ao usuário o nome do convênio.
        System.out.print("Nome do Convênio: ");

        // Lê a entrada do usuário e armazena em uma variável.
        String nomeConvenio = scanner.nextLine();

        // Enquanto o nome do convênio estiver vazio, solicita novamente ao usuário.
        while (nomeConvenio.isEmpty()) {
            System.out.println("O nome do convênio não pode ser vazio.");
            System.out.print("Nome do Convênio: ");
            nomeConvenio = scanner.nextLine();
        }

        // Define o nome do convênio no objeto atual.
        this.setNomeConvenio(nomeConvenio);

        // Imprime uma linha em branco para separar as informações.
        System.out.println(LINE + "\n\n");
    }


    // Imprime as informações sobre o convênio
    public void imprimirInformacoesConvenio() {

        // Imprime uma linha em branco
        System.out.println(LINE);

        // Imprime o título das informações do convênio
        System.out.println("|          INFORMAÇÕES SOBRE O CONVÊNIO          |");

        // Imprime outra linha em branco
        System.out.println(LINE);

        // Imprime a data e hora local
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Imprime o código do convênio
        System.out.println("Código: " + this.getCodigo());

        // Imprime o nome do convênio
        System.out.println("Nome: " + this.getNomeConvenio());

        // Imprime uma linha em branco
        System.out.println();
    }

    // Lista as informações sobre o convênio
    public void listarInformacoesConvenio() {

        // Imprime uma linha em branco
        System.out.println();

        // Imprime o nome do convênio
        System.out.println("    |   " + this.getNomeConvenio());
    }

}

