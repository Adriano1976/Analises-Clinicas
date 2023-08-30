package desenvolvimento.cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.DateValidator;
import desenvolvimento.util.ISystemLine;
import desenvolvimento.util.ValidarCPF;

import java.util.*;
import java.util.UUID;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + LINE);
        System.out.println("|          INFORMAÇÕES SOBRE O PARCIENTE         |");
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

        // Loop para o telefone
        while (true) {
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            // Valida o telefone
            if (!telefone.matches("\\d{11}")) {
                System.out.println("O número de telefone deve ter 11 dígitos.");
                continue;
            }

            this.setNumeroTelefone(telefone);
            break;
        }

        // Loop para o RG
        while (true) {
            System.out.print("RG: ");
            String rg = scanner.nextLine();

            // Valida o RG
            if (!rg.matches("\\d{9}")) {
                System.out.println("O RG deve ter 9 dígitos.");
                continue;
            }

            this.setRG(rg);
            break;
        }

        // Loop para o CPF
        while (true) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            // Valida o CPF
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

        while (true) {
            System.out.print("Data de Nascimento (Ex: 11/12/1976): ");
            String dataRecebida = scanner.nextLine();

            // Valida a data
            if (!DateValidator.isValid(dataRecebida)) {
                System.out.println("Data de nascimento inválida!");
                continue;
            }

            Date date = dateFormat.parse(dataRecebida);
            this.setDataNascimento(date);
            break;
        }

        endereco.cadastrarInformacoesEndereco();
    }

    public void imprimirInformacoesPaciente() {

        String stringData = dateFormat.format(this.getDataNascimento());

        System.out.println("\n" + LINE);
        System.out.println("|           INFORMAÇÕES SOBRE O PACIENTE           |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Informações do paciente
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Nome Completo: " + this.getNomeCompleto() + " - " + "Telefone: " + this.getNumeroTelefone());
        System.out.println("RG: " + this.getRG() + " - " + "CPF: " + this.getCPF());
        System.out.println("Data de Nascimento: " + stringData);

        // Informações do endereço
        endereco.imprimirInformacoesEndereco();
    }


    public void listarInformacoesPaciente() {

        System.out.println("   |   " + this.getCPF() + "  |  " + this.getNomeCompleto());
    }

}
