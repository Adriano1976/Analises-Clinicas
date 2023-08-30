package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Convenio implements ISystemLine {

    private UUID codigo = UUID.randomUUID();
    private String nomeConvenio;
    DataHoraLocal dataHoraLocal = new DataHoraLocal();

    public Convenio() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public void cadastrarInformacoesConvenio() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + LINE);
        System.out.println("|          INFORMAÇÕES SOBRE O CONVÊNIO         |");
        System.out.println(LINE);
        System.out.print("Nome do Convênio: ");

        String nomeConvenio = scanner.nextLine();

        while (nomeConvenio.isEmpty()) {
            System.out.println("O nome do convênio não pode ser vazio.");
            System.out.print("Nome do Convênio: ");
            nomeConvenio = scanner.nextLine();
        }

        this.setNomeConvenio(nomeConvenio);

        System.out.println(LINE + "\n\n");
    }

    public void imprimirInformacoesConvenio() {

        System.out.println(LINE);
        System.out.println("|          INFORMAÇÕES SOBRE O CONVÊNCIO         |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        System.out.println("Código: " + this.getCodigo());
        System.out.println("Nome: " + this.getNomeConvenio());
        System.out.println();
    }

    public void listarInformacoesConvenio() {

        System.out.println("    |   " + this.getNomeConvenio());
    }
}

