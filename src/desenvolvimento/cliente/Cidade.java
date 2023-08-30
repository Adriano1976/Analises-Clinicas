package desenvolvimento.cliente;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Cidade {

    private UUID codigo = UUID.randomUUID();
    ;
    private String nomeCidade;
    private String DDD;

    private Uf uf = new Uf();

    public Cidade() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }


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


    public void imprimirInformacoesCidade() {

        System.out.println("Cidade: " + this.getNome() + " - " + "DDD: " + this.getDDD());

        uf.imprimirInformacoesUf();
    }
}
