package desenvolvimento.cliente;

import java.util.Scanner;
import java.util.UUID;

/**
 * Classe que representa uma cidade.
 */
public class Cidade {

    /**
     * Código da cidade.
     */
    private UUID codigo = UUID.randomUUID();

    /**
     * Nome da cidade.
     */
    private String nomeCidade;

    /**
     * DDD da cidade.
     */
    private String DDD;

    /**
     * Estado da cidade.
     */
    private Uf uf = new Uf();

    /**
     * Construtor padrão.
     */
    public Cidade() {
    }

    /**
     * Obtém o código da cidade.
     *
     * @return O código da cidade.
     */
    public UUID getCodigo() {
        return codigo;
    }

    /**
     * Define o código da cidade.
     *
     * @param codigo O novo código da cidade.
     */
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o nome da cidade.
     *
     * @return O nome da cidade.
     */
    public String getNome() {
        return nomeCidade;
    }

    /**
     * Define o nome da cidade.
     *
     * @param nomeCidade O novo nome da cidade.
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    /**
     * Obtém o DDD da cidade.
     *
     * @return O DDD da cidade.
     */
    public String getDDD() {
        return DDD;
    }

    /**
     * Define o DDD da cidade.
     *
     * @param DDD O novo DDD da cidade.
     */
    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    /**
     * Cadastra as informações da cidade.
     */
    public void CadastrarCidade() {

        Scanner scanner = new Scanner(System.in);

        // Loop principal
        while (true) {

            // Solicita o nome da cidade
            System.out.print("Cidade: ");
            String nomeCidade = scanner.nextLine();

            // Valida o nome da cidade
            if (nomeCidade.isEmpty()) {
                System.out.println("O nome da cidade não pode ser vazio.");
                continue;
            }

            // Solicita o DDD
            System.out.print("DDD: ");
            String ddd = scanner.nextLine();

            // Valida o DDD
            if (ddd.length() != 3) {
                System.out.println("O DDD deve ter 3 dígitos.");
                continue;
            }

            // Define os valores da cidade
            this.setNomeCidade(nomeCidade);
            this.setDDD(ddd);

            // Encerra o loop
            break;
        }

        // Cadastra as informações do estado
        uf.cadastrarInformacoesEstado();
    }

    /**
     * Imprime as informações da cidade.
     */
    public void imprimirInformacoesCidade() {

        System.out.println("Cidade: " + this.getNome() + " - " + "DDD: " + this.getDDD());

        uf.imprimirInformacoesUf();
    }
}
