package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Scanner;
import java.util.UUID;

/**
 * Classe que representa um grupo de exames.
 *
 * @author [Seu nome]
 */

public class GrupoExame implements ISystemLine {

    /**
     * Código do grupo de exame.
     */
    private UUID codigo;

    /**
     * Descrição do grupo de exame.
     */
    private String descricao;

    /**
     * Data e hora local da criação do grupo de exame.
     */
    private DataHoraLocal dataHoraLocal;

    /**
     * Construtor padrão.
     */
    public GrupoExame() {
        // Inicializa o código do grupo de exame com um UUID aleatório.
        this.codigo = UUID.randomUUID();

        // Inicializa a data e hora local da criação do grupo de exame.
        this.dataHoraLocal = new DataHoraLocal();
    }

    /**
     * Obtém o código do grupo de exame.
     *
     * @return o código do grupo de exame.
     */
    public UUID getCodigo() {
        return codigo;
    }

    /**
     * Define o código do grupo de exame.
     *
     * @param codigo o código do grupo de exame.
     */
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém a descrição do grupo de exame.
     *
     * @return a descrição do grupo de exame.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do grupo de exame.
     *
     * @param descricao a descrição do grupo de exame.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void cadastrarInformacoesGrupoExame() {

        // Cria um objeto Scanner para ler entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibe um cabeçalho para as informações do grupo de exame
        System.out.println("\n" + LINE);
        System.out.println("|       INFORMAÇÕES SOBRE O GRUPO DE EXAME       |");
        System.out.println(LINE);

        // Solicita a descrição do grupo de exame
        String descricao;
        do {
            System.out.print("Descrição: ");
            descricao = scanner.nextLine();

            // Valida a descrição
            if (descricao.isEmpty() || descricao.trim().length() == 0) {
                System.out.println("O campo descrição não pode ficar vazio.");
            } else if (descricao.matches("^[0-9]+$")) {
                System.out.println("O campo descrição não pode ser um número.");
            }
        } while (descricao.isEmpty() || descricao.trim().length() == 0 || descricao.matches("^[0-9]+$"));

        // Define a descrição do grupo de exame
        this.setDescricao(descricao);

        // Exibe uma linha em branco para separar as informações
        System.out.println(LINE + "\n\n");
    }


    /**
     * Imprime as informações sobre o grupo de exame.
     */
    public void imprimirInformacoesGrupoExame() {

        // Imprime uma linha em branco.
        System.out.println(LINE);

        // Imprime uma linha com o título das informações.
        System.out.println("|       INFORMAÇÕES SOBRE O GRUPO DE EXAME       |");

        // Imprime uma linha em branco.
        System.out.println(LINE);

        // Imprime a data e hora atual.
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Imprime o código do grupo de exame.
        System.out.println("Código: " + this.getCodigo());

        // Imprime a descrição do grupo de exame.
        System.out.println("Descrição: " + this.getDescricao());

        // Imprime uma linha em branco.
        System.out.println();
    }

    /**
     * Lista o grupo de exame.
     */
    public void listarGrupoExame() {

        // Imprime uma linha em branco.
        System.out.println();

        // Imprime a descrição do grupo de exame.
        System.out.print("      |      " + this.getDescricao());
    }

}
