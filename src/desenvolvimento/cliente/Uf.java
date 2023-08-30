package desenvolvimento.cliente;

import desenvolvimento.util.ISystemLine;

import java.util.Scanner;
import java.util.UUID;

public class Uf implements ISystemLine {

    private UUID codigo = UUID.randomUUID();
    private String sigla;
    private String nomeUf;

    public Uf() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeUf() {
        return nomeUf;
    }

    public void setNomeUf(String nomeUf) {
        this.nomeUf = nomeUf;
    }

    public void cadastrarInformacoesEstado() {

        Scanner scanner = new Scanner(System.in);

        boolean nomeUfValido = false;
        boolean siglaValida = false;

        while (!nomeUfValido || !siglaValida) {
            // Solicita o nome do estado
            System.out.print("Estado: ");
            this.setNomeUf(scanner.nextLine());

            if (this.getNomeUf().isEmpty()) {
                System.out.println("O nome do estado deve ser preenchido.");
                continue;
            }

            // Solicita a sigla do estado
            System.out.print("Sigla: ");
            this.setSigla(scanner.nextLine());

            if (this.getSigla().isEmpty()) {
                System.out.println("A sigla do estado deve ser preenchida.");
                continue;
            }

            if (this.getSigla().length() != 2) {
                System.out.println("A sigla do estado deve ter apenas duas letras.");
                continue;
            }

            nomeUfValido = true;
            siglaValida = true;
        }

        System.out.println(LINE + "\n\n");
    }


    public void imprimirInformacoesUf() {

        System.out.println("Estado: " + this.getNomeUf() + " - " + "Sigla: " + this.getSigla());
        System.out.println(LINE + "\n\n");
    }
}
