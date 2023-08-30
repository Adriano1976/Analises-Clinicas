package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import static desenvolvimento.controle.Controle.*;

public class Exame implements ISystemLine {

    private UUID codigo;
    private String descricaoExame;
    private String procedimentoExame;
    private double valor;
    private GrupoExame grupoExame = new GrupoExame();
    DataHoraLocal dataHoraLocal = new DataHoraLocal();

    public Exame() {
        this.descricaoExame = "";
        this.procedimentoExame = "";
        this.valor = 0.0;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoExame() {
        return descricaoExame;
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
    }

    public String getProcedimentoExame() {
        return procedimentoExame;
    }

    public void setProcedimentoExame(String procedimentoExame) {
        this.procedimentoExame = procedimentoExame;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public GrupoExame getGrupoExame() {
        return grupoExame;
    }

    public void setGrupoExame(GrupoExame grupoExame) {
        this.grupoExame = grupoExame;
    }

    public void cadastrarInformacoesExame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + LINE);
        System.out.println("|            INFORMAÇÕES SOBRE O EXAME           |");
        System.out.println(LINE);
        System.out.println(" Opção    |      Grupos");

        System.out.println();
        for (int i = 0; i < contGrupoExame; i++) {
            System.out.print("   " + i);
            grupoExameList[i].listarGrupoExame();
        }
        System.out.println();

        System.out.print("Escolha o Grupo de Exame [ Opção ] / [ 0 ] Sair : ");
        int codGrupoExame = scanner.nextInt();
        scanner.nextLine();
        GrupoExame grupoExameSelecionado = grupoExameList[codGrupoExame];

        if (grupoExameSelecionado != null) {
            this.setGrupoExame(grupoExameSelecionado);
            this.setCodigo(getGrupoExame().getCodigo());
        } else {
            System.out.println("Grupo de exame não existe.");
            return;
        }

        // Valida a descrição do exame
        while (this.getDescricaoExame().isEmpty()) {
            System.out.print("Descrição do Exame: ");
            this.setDescricaoExame(scanner.nextLine());

            if (this.getDescricaoExame().isEmpty()) {
                System.out.println("O campo descrição do exame não pode ficar vazio.");
            }
        }

        // Valida o valor do exame
        while (this.getValor() <= 0) {
            System.out.print("Valor: ");
            this.setValor(scanner.nextDouble());
            scanner.nextLine();
            if (this.getValor() <= 0) {
                System.out.println("O campo valor do exame deve ser maior que zero.");
            }
        }

        // Valida os procedimentos do exame
        while (this.procedimentoExame.isEmpty()) {
            System.out.print("Procedimentos: ");
            this.procedimentoExame = scanner.nextLine();
            if (this.procedimentoExame.isEmpty()) {
                System.out.println("O campo procedimentos do exame não pode ficar vazio.");
            }
        }

    }

    public void imprimirDescricaoExame() {

        System.out.println(LINE);
        System.out.println("|            INFORMAÇÕES SOBRE O EXAME           |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Descrição do Exame: " + this.getDescricaoExame());
        System.out.println("Grupo de Exame: " + this.getGrupoExame().getDescricao());
        System.out.println("Valor: R$ " + this.getValor());
        System.out.println("Procedimentos: " + this.getProcedimentoExame());
        System.out.println("\n\n");
    }

    public void listarDescricaoExame() {

        System.out.println(" | " + this.getDescricaoExame() + " | " + this.getValor());
        System.out.println();
    }
}
