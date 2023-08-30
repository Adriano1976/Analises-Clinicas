package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

/**
 * Classe que representa um médico.
 *
 * @author Adriano Santos
 */
public class Medico implements ISystemLine {

    /**
     * Código do médico.
     */
    private UUID codigo = UUID.randomUUID();

    /**
     * CRM do médico.
     */
    private String CRM;

    /**
     * Nome do médico.
     */
    private String nomeMedico;

    /**
     * Especialidade do médico.
     */
    private String especialidade;

    /**
     * Data e hora local do sistema.
     */
    private final DataHoraLocal dataHoraLocal = new DataHoraLocal();

    /**
     * Construtor padrão.
     */
    public Medico() {
    }

    /**
     * Obtém o código do médico.
     *
     * @return Código do médico.
     */
    public UUID getCodigo() {
        return codigo;
    }

    /**
     * Define o código do médico.
     *
     * @param codigo Código do médico.
     */
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o CRM do médico.
     *
     * @return CRM do médico.
     */
    public String getCRM() {
        return CRM;
    }

    /**
     * Define o CRM do médico.
     *
     * @param CRM CRM do médico.
     */
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    /**
     * Obtém o nome do médico.
     *
     * @return Nome do médico.
     */
    public String getNomeMedico() {
        return nomeMedico;
    }

    /**
     * Define o nome do médico.
     *
     * @param nomeMedico Nome do médico.
     */
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    /**
     * Obtém a especialidade do médico.
     *
     * @return Especialidade do médico.
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Define a especialidade do médico.
     *
     * @param especialidade Especialidade do médico.
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void cadastrarInformacoesMedico() {

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Imprime uma mensagem de cabeçalho
        System.out.println("\n" + LINE);
        System.out.println("|           INFORMAÇÕES SOBRE O MÉDICO          |");
        System.out.println(LINE);

        // Loop para o nome
        // Valida se o nome foi informado e não está vazio
        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            if (!nome.isEmpty()) {
                this.setNomeMedico(nome);
                break;
            } else {
                System.out.println("O nome não pode ser vazio.");
            }
        }

        // Loop para o CRM
        // Valida se o CRM foi informado e é um número
        while (true) {
            System.out.print("CRM: ");
            String crm = scanner.nextLine();

            if (crm.isEmpty()) {
                System.out.println("O CRM não pode ser vazio.");
            } else if (!crm.matches("[0-9]+")) {
                System.out.println("O CRM deve ser um número.");
            } else {
                this.setCRM(crm);
                break;
            }
        }


        // Loop para a especialidade
        // Valida se a especialidade foi informada e não está vazia
        while (true) {
            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();

            if (!especialidade.isEmpty()) {
                this.setEspecialidade(especialidade);
                break;
            } else {
                System.out.println("A especialidade não pode ser vazia.");
            }
        }

        // Imprime uma mensagem de rodapé
        System.out.println(LINE + "\n\n");
    }


    public void imprimirInformacoesMedico() {

        // Imprime uma linha em branco
        System.out.println(LINE);

        // Imprime um cabeçalho
        System.out.println("|           INFORMAÇÕES SOBRE O MÉDICO            |");

        // Imprime outra linha em branco
        System.out.println(LINE);

        // Imprime a data e hora atual
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Imprime o nome do médico e o seu CRM
        System.out.println("Nome: " + this.getNomeMedico() + " - " + "CRM: " + this.getCRM());

        // Imprime a especialidade do médico
        System.out.println("Especialidade: " + this.getEspecialidade());

        // Imprime uma linha em branco
        System.out.println();
    }

    public void listarInformacoesMedico() {

        // Imprime o CRM e o nome do médico em um formato de tabela
        System.out.println("   |  " + this.getCRM() + "   |  " + this.getNomeMedico());
    }
}

