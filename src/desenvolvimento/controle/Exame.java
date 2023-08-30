package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Scanner;
import java.util.UUID;

import static desenvolvimento.controle.Controle.*;
/**
 * Classe que representa um Exame.
 *
 * @author Adriano Santos
 */
public class Exame implements ISystemLine {

    private UUID codigo; // Código do exame
    private String descricaoExame; // Descrição do exame
    private String procedimentoExame; // Procedimento do exame
    private double valor; // Valor do exame
    private GrupoExame grupoExame = new GrupoExame(); // Grupo do exame
    DataHoraLocal dataHoraLocal = new DataHoraLocal(); // Data e hora do exame

    public Exame() {
        this.descricaoExame = ""; // Descrição do exame inicial
        this.procedimentoExame = ""; // Procedimento do exame inicial
        this.valor = 0.0; // Valor do exame inicial
    }

    public UUID getCodigo() {
        return codigo; // Retorna o código do exame
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo; // Define o código do exame
    }

    public String getDescricaoExame() {
        return descricaoExame; // Retorna a descrição do exame
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame; // Define a descrição do exame
    }

    public String getProcedimentoExame() {
        return procedimentoExame; // Retorna o procedimento do exame
    }

    public void setProcedimentoExame(String procedimentoExame) {
        this.procedimentoExame = procedimentoExame; // Define o procedimento do exame
    }

    public double getValor() {
        return valor; // Retorna o valor do exame
    }

    public void setValor(double valor) {
        this.valor = valor; // Define o valor do exame
    }

    public GrupoExame getGrupoExame() {
        return grupoExame; // Retorna o grupo do exame
    }

    public void setGrupoExame(GrupoExame grupoExame) {
        this.grupoExame = grupoExame; // Define o grupo do exame
    }

    public void cadastrarInformacoesExame() {

        // Cria um objeto Scanner para ler dados do usuário
        Scanner scanner = new Scanner(System.in);

        // Imprime um cabeçalho para a tela
        System.out.println("\n" + LINE);
        System.out.println("|            INFORMAÇÕES SOBRE O EXAME           |");
        System.out.println(LINE);

        // Imprime uma lista de grupos de exames
        System.out.println(" Opção    |      Grupos");

        for (int i = 0; i < contGrupoExame; i++) {
            // Imprime o número do grupo
            System.out.print("   " + i);
            // Imprime o nome do grupo
            grupoExameList[i].listarGrupoExame();
        }
        System.out.println();

        // Solicita ao usuário que selecione um grupo de exame
        System.out.print("Escolha o Grupo de Exame [ Opção ] / [ 0 ] Sair : ");
        int codGrupoExame = scanner.nextInt();
        scanner.nextLine();

        // Valida se o grupo de exame existe
        GrupoExame grupoExameSelecionado = grupoExameList[codGrupoExame];
        if (grupoExameSelecionado != null) {
            // Atribui o grupo de exame selecionado ao objeto
            this.setGrupoExame(grupoExameSelecionado);
            // Atribui o código do grupo de exame ao objeto
            this.setCodigo(getGrupoExame().getCodigo());
        } else {
            // Exibe uma mensagem de erro
            System.out.println("Grupo de exame não existe.");
            return;
        }

        // Valida a descrição do exame
        while (this.getDescricaoExame().isEmpty()) {
            // Solicita ao usuário que insira a descrição do exame
            System.out.print("Descrição do Exame: ");
            // Atribui a descrição inserida pelo usuário ao objeto
            this.setDescricaoExame(scanner.nextLine());

            // Valida se a descrição está vazia
            if (this.getDescricaoExame().isEmpty()) {
                // Exibe uma mensagem de erro
                System.out.println("O campo descrição do exame não pode ficar vazio.");
            }
        }

        // Valida o valor do exame
        while (this.getValor() <= 0) {
            // Solicita ao usuário que insira o valor do exame
            System.out.print("Valor: ");
            // Atribui o valor inserido pelo usuário ao objeto
            this.setValor(scanner.nextDouble());
            scanner.nextLine();

            // Valida se o valor é menor ou igual a zero
            if (this.getValor() <= 0) {
                // Exibe uma mensagem de erro
                System.out.println("O campo valor do exame deve ser maior que zero.");
            }
        }

        // Valida os procedimentos do exame
        while (this.procedimentoExame.isEmpty()) {
            // Solicita ao usuário que insira os procedimentos do exame
            System.out.print("Procedimentos: ");
            // Atribui os procedimentos inseridos pelo usuário ao objeto
            this.procedimentoExame = scanner.nextLine();
            System.out.println();

            // Valida se os procedimentos estão vazios
            if (this.procedimentoExame.isEmpty()) {
                // Exibe uma mensagem de erro
                System.out.println("O campo procedimentos do exame não pode ficar vazio.");
            }

            System.out.println("\n\n");
        }
    }


    public void imprimirDescricaoExame() {

        // Imprime uma linha em branco
        System.out.println(LINE);

        // Imprime um cabeçalho
        System.out.println("|            INFORMAÇÕES SOBRE O EXAME           |");

        // Imprime outra linha em branco
        System.out.println(LINE);

        // Imprime a data e hora atual
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Imprime o código do exame
        System.out.println("Código: " + this.getCodigo());

        // Imprime a descrição do exame
        System.out.println("Descrição do Exame: " + this.getDescricaoExame());

        // Imprime a descrição do grupo de exame
        System.out.println("Grupo de Exame: " + this.getGrupoExame().getDescricao());

        // Imprime o valor do exame
        System.out.println("Valor: R$ " + this.getValor());

        // Imprime os procedimentos do exame
        System.out.println("Procedimentos: " + this.getProcedimentoExame());

        // Imprime uma linhas em branco
        System.out.println();
    }

    public void listarDescricaoExame() {

        // Imprime a descrição do exame
        System.out.println(" | " + this.getDescricaoExame() + " | " + this.getValor());

        // Imprime uma linha em branco
        System.out.println();
    }

}
