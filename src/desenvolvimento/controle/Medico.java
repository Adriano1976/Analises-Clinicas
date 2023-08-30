package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Medico implements ISystemLine {

    private UUID codigo = UUID.randomUUID();
    private String CRM;
    private String nomeMedico;
    private String especialidade;
    DataHoraLocal dataHoraLocal = new DataHoraLocal();

    public Medico() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void cadastrarInformacoesMedico() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + LINE);
        System.out.println("|           INFORMAÇÕES SOBRE O MÉDICO          |");
        System.out.println(LINE);

        // Loop para o nome
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

        System.out.println(LINE + "\n\n");
    }


    public void imprimirInformacoesMedico() {

        System.out.println(LINE);
        System.out.println("|           INFORMAÇÕES SOBRE O MÉDICO            |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        System.out.println("Nome: " + this.getNomeMedico() + " - " + "CRM: " + this.getCRM());
        System.out.println("Especialidade: " + this.getEspecialidade());
        System.out.println();
    }

    public void listarInformacoesMedico() {

        System.out.println("   |  " + this.getCRM() + "   |  " + this.getNomeMedico());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medido = (Medico) o;
        return CRM == medido.CRM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CRM);
    }
}

