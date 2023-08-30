package desenvolvimento.cliente;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Endereco {

    private UUID codigo = UUID.randomUUID();
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    private Cidade cidade = new Cidade();

    public Endereco() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public void cadastrarInformacoesEndereco() {

        Scanner scanner = new Scanner(System.in);

        // Laço para entrada de dados
        do {

            // Entrada de dados
            System.out.print("Av/Rua: ");
            this.setLogradouro(scanner.nextLine());

            // Validação do logradouro
            if (this.getLogradouro().trim().isEmpty()) {
                System.out.println("O logradouro não pode ser vazio.");
            }

            System.out.print("Número: ");
            this.setNumero(scanner.nextLine());

            // Validação do número
            if (!this.getNumero().matches("\\d+")) {
                System.out.println("O número deve ser um número inteiro.");
            }

            System.out.print("Conjunto: ");
            this.setComplemento(scanner.nextLine());

            // Validação do complemento
            if (!this.getComplemento().trim().isEmpty()) {
                // Validação se o complemento não é apenas espaços em branco
                if (this.getComplemento().trim().equals(" ")) {
                    System.out.println("O complemento não pode ser apenas espaços em branco.");
                }
            }

            System.out.print("Bairro: ");
            this.setBairro(scanner.nextLine());

            // Validação do bairro
            if (this.getBairro().trim().isEmpty()) {
                System.out.println("O bairro não pode ser vazio.");
            }

        } while (!this.isInformacoesEnderecoValidas());

        // Cadastro da cidade
        cidade.CadastrarCidade();
    }

    private boolean isInformacoesEnderecoValidas() {

        // Verifica se o logradouro está vazio
        if (this.getLogradouro().trim().isEmpty()) {
            return false;
        }

        // Verifica se o número é um número inteiro
        if (!this.getNumero().matches("\\d+")) {
            return false;
        }

        // Verifica se o complemento está vazio
        if (!this.getComplemento().trim().isEmpty()) {
            // Verifica se o complemento não é apenas espaços em branco
            if (this.getComplemento().trim().equals(" ")) {
                return false;
            }
        }

        // Verifica se o bairro está vazio
        if (this.getBairro().trim().isEmpty()) {
            return false;
        }

        // As informações de endereço são válidas
        return true;
    }


    public void imprimirInformacoesEndereco() {

        System.out.println("Av/Rua: " + this.getLogradouro() + " - " + "Número: " + this.getNumero());
        System.out.println("Conjunto: " + this.getComplemento() + " - " + "Bairro: " + this.getBairro());

        cidade.imprimirInformacoesCidade();
    }
}
