package desenvolvimento.cliente;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Endereco {

    // **Atributos**

    // Um identificador único para o endereço.
    private UUID codigo = UUID.randomUUID();

    // O nome da rua ou avenida.
    private String logradouro;

    // O número do imóvel.
    private String numero;

    // Um complemento ao endereço, como um apartamento, bloco ou ponto de referência.
    private String complemento;

    // O nome do bairro.
    private String bairro;

    // **Cidade**

    // A cidade em que o endereço está localizado.
    private Cidade cidade = new Cidade();

    // **Construtor**

    // O construtor padrão não inicializa nenhum atributo.
    public Endereco() {
    }

    // **Getters e setters**

    // Obtém o código do endereço.
    public UUID getCodigo() {
        return codigo;
    }

    // Define o código do endereço.
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    // Obtém o logradouro.
    public String getLogradouro() {
        return logradouro;
    }

    // Define o logradouro.
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    // Obtém o número.
    public String getNumero() {
        return numero;
    }

    // Define o número.
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Obtém o complemento.
    public String getComplemento() {
        return complemento;
    }

    // Define o complemento.
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Obtém o bairro.
    public String getBairro() {
        return bairro;
    }

    // Define o bairro.
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    /**
     * Cadastra as informações de endereço de um usuário.
     *
     * @author Adriano Santos
     */
    public void cadastrarInformacoesEndereco() {

        /**
         * Cria um scanner para ler dados do usuário.
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * Laço para entrada de dados.
         *
         * O laço continuará executando até que todas as informações de endereço sejam inseridas corretamente.
         */
        do {

            /**
             * Entrada de dados.
             *
             * Solicita ao usuário o logradouro, número, complemento e bairro.
             */
            System.out.print("Av/Rua: ");
            this.setLogradouro(scanner.nextLine());

            System.out.print("Número: ");
            this.setNumero(scanner.nextLine());

            System.out.print("Conjunto: ");
            this.setComplemento(scanner.nextLine());

            System.out.print("Bairro: ");
            this.setBairro(scanner.nextLine());

            /**
             * Validação das informações de endereço.
             *
             * Verifica se o logradouro, número, complemento e bairro não estão vazios.
             *
             * Também verifica se o número é um número inteiro.
             *
             * Se alguma informação estiver incorreta, uma mensagem de erro é exibida.
             */
            if (this.getLogradouro().trim().isEmpty()) {
                System.out.println("O logradouro não pode ser vazio.");
            }

            if (!this.getNumero().matches("\\d+")) {
                System.out.println("O número deve ser um número inteiro.");
            }

            if (!this.getComplemento().trim().isEmpty()) {
                if (this.getComplemento().trim().equals(" ")) {
                    System.out.println("O complemento não pode ser apenas espaços em branco.");
                }
            }

            if (this.getBairro().trim().isEmpty()) {
                System.out.println("O bairro não pode ser vazio.");
            }

        } while (!this.isInformacoesEnderecoValidas());

        /**
         * Cadastro da cidade.
         *
         * Chama o método `CadastrarCidade()` da classe `Cidade` para cadastrar a cidade do endereço.
         */
        cidade.CadastrarCidade();
    }


    /**
     * Verifica se as informações de endereço são válidas.
     *
     * @return true se as informações de endereço forem válidas, false caso contrário.
     */
    private boolean isInformacoesEnderecoValidas() {

        // Verifica se o logradouro está vazio
        if (this.getLogradouro().trim().isEmpty()) {
            // Retorna false se o logradouro estiver vazio
            return false;
        }

        // Verifica se o número é um número inteiro
        if (!this.getNumero().matches("\\d+")) {
            // Retorna false se o número não for um número inteiro
            return false;
        }

        // Verifica se o complemento está vazio
        if (!this.getComplemento().trim().isEmpty()) {
            // Verifica se o complemento não é apenas espaços em branco
            if (this.getComplemento().trim().equals(" ")) {
                // Retorna false se o complemento for apenas espaços em branco
                return false;
            }
        }

        // Verifica se o bairro está vazio
        if (this.getBairro().trim().isEmpty()) {
            // Retorna false se o bairro estiver vazio
            return false;
        }

        // As informações de endereço são válidas
        // Retorna true
        return true;
    }


    /**
     * Imprime as informações de endereço do objeto.
     *
     * @author Adriano Santos
     * @since 2023-08-30
     */
    public void imprimirInformacoesEndereco() {

        /**
         * Imprime o logradouro e o número.
         */
        System.out.println("Av/Rua: " + this.getLogradouro() + " - " + "Número: " + this.getNumero());

        /**
         * Imprime o complemento e o bairro.
         */
        System.out.println("Conjunto: " + this.getComplemento() + " - " + "Bairro: " + this.getBairro());

        /**
         * Chama o método `imprimirInformacoesCidade()` da cidade.
         */
        cidade.imprimirInformacoesCidade();
    }

}
