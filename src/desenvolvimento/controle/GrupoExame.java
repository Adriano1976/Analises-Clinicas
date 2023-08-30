package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class GrupoExame implements ISystemLine {

    private UUID codigo = UUID.randomUUID();
    private String descricao;
    DataHoraLocal dataHoraLocal = new DataHoraLocal();

    public GrupoExame() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void cadastrarInformacoesGrupoExame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + LINE);
        System.out.println("|       INFORMAÇÕES SOBRE O GRUPO DE EXAME       |");
        System.out.println(LINE);

        String descricao;
        do {
            System.out.print("Descrição: ");
            descricao = scanner.nextLine();

            if (descricao.isEmpty() || descricao.trim().length() == 0) {
                System.out.println("O campo descrição não pode ficar vazio.");
            } else if (descricao.matches("^[0-9]+$")) {
                System.out.println("O campo descrição não pode ser um número.");
            }
        } while (descricao.isEmpty() || descricao.trim().length() == 0 || descricao.matches("^[0-9]+$"));

        this.setDescricao(descricao);

        System.out.println(LINE + "\n\n");
    }


    public void imprimirInformacoesGrupoExame() {

        System.out.println(LINE);
        System.out.println("|       INFORMAÇÕES SOBRE O GRUPO DE EXAME       |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println();
    }

    public void listarGrupoExame() {

        System.out.println("      |      " + this.getDescricao());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoExame that = (GrupoExame) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
