package desenvolvimento.cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.DateValidator;
import desenvolvimento.util.ISystemLine;
import desenvolvimento.util.ValidarCPF;

import java.util.*;
import java.util.UUID;

/**
 * Classe que representa um paciente.
 *
 * @author Adriano Santos
 */
public class Paciente implements ISystemLine {

    private UUID codigo = UUID.randomUUID();
    private String nomeCompleto;
    private String numeroTelefone;
    private String RG;
    private String CPF;
    private Date dataNascimento;

    Endereco endereco = new Endereco();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DataHoraLocal dataHoraLocal = new DataHoraLocal();
    DateValidator dateValidator = new DateValidator();


    public Paciente() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void cadastrarInformacoesPaciente() throws ParseException {

        /*
         * Este método cadastra as informações de um paciente.
         *
         * @throws ParseException Se a data de nascimento não for válida.
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + LINE);
        System.out.println("|         INFORMAÇÕES SOBRE O PARCIENTE         |");
        System.out.println(LINE);

        // Loop para o nome
        while (true) {
            System.out.print("Nome completo: ");
            String nome = scanner.nextLine();

            // Valida o nome
            if (nome.isEmpty()) {
                System.out.println("O nome não pode ser vazio.");
                continue;
            }

            this.setNomeCompleto(nome);
            break;
        }

        /*
         * Valida o telefone
         *
         * O telefone deve ter 11 dígitos.
         */
        while (true) {
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            if (!telefone.matches("\\d{11}")) {
                System.out.println("O número de telefone deve ter 11 dígitos.");
                continue;
            }

            this.setNumeroTelefone(telefone);
            break;
        }

        /*
         * Valida o RG
         *
         * O RG deve ter 9 dígitos.
         */
        while (true) {
            System.out.print("RG: ");
            String rg = scanner.nextLine();

            if (!rg.matches("\\d{9}")) {
                System.out.println("O RG deve ter 9 dígitos.");
                continue;
            }

            this.setRG(rg);
            break;
        }

        /*
         * Valida o CPF
         *
         * O CPF deve ter 11 dígitos e ser válido.
         */
        while (true) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!cpf.matches("\\d{11}")) {
                System.out.println("O CPF deve ter 11 dígitos.");
                continue;
            }

            if (ValidarCPF.validar(cpf)) {
                System.out.println("CPF inválido");
                continue;
            }

            this.setCPF(cpf);
            break;
        }

        /*
         * Valida a data de nascimento
         *
         * A data de nascimento deve estar no formato dd/mm/aaaa.
         */
        while (true) {
            System.out.print("Data de Nascimento (Ex: 11/12/1976): ");
            String dataRecebida = scanner.nextLine();

            if (!DateValidator.isValid(dataRecebida)) {
                System.out.println("Data de nascimento inválida!");
                continue;
            }

            Date date = dateFormat.parse(dataRecebida);
            this.setDataNascimento(date);
            break;
        }

        // Delega a tarefa de cadastrar as informações de endereço para a classe Endereco
        endereco.cadastrarInformacoesEndereco();
    }


    /**
     * Imprime as informações do paciente.
     *
     * @author [Seu nome]
     * @since 2023-08-30
     */
    public void imprimirInformacoesPaciente() {

        // Converte a data de nascimento para uma string formatada
        String stringData = dateFormat.format(this.getDataNascimento());

        // Imprime uma linha em branco e o título
        System.out.println("\n" + LINE);
        System.out.println("|           INFORMAÇÕES SOBRE O PACIENTE           |");
        System.out.println(LINE);

        // Imprime a data e hora local
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Imprime as informações do paciente
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Nome Completo: " + this.getNomeCompleto() + " - " + "Telefone: " + this.getNumeroTelefone());
        System.out.println("RG: " + this.getRG() + " - " + "CPF: " + this.getCPF());
        System.out.println("Data de Nascimento: " + stringData);

        // Imprime as informações do endereço
        endereco.imprimirInformacoesEndereco();
    }


    public void listarInformacoesPaciente() {

        // Este método lista as informações do paciente.

        // Imprime o CPF e o nome completo do paciente.
        System.out.println("   |   " + this.getCPF() + "  |  " + this.getNomeCompleto());
    }

}
