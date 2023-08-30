package desenvolvimento.controle;

import desenvolvimento.cliente.Paciente;
import desenvolvimento.util.DataHoraLocal;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import static desenvolvimento.controle.Controle.*;
import static desenvolvimento.util.ISystemLine.LINE;

public class PedidoExame {

    private UUID codigo = UUID.randomUUID();
    private Paciente paciente = new Paciente();
    private Medico medico = new Medico();
    private Convenio convenio = new Convenio();

    DataHoraLocal dataHoraLocal = new DataHoraLocal();

    public PedidoExame() {
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedido() {
        return medico;
    }

    public void setMedido(Medico medido) {
        this.medico = medido;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }


    public void cadastrarPedidoMedico(){

        Scanner scanner = new Scanner(System.in);

        System.out.println(LINE);
        System.out.println("|          INFORMAÇÕES DO PEDIDO MÉDICO          |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        System.out.println("\n\t * Relação dos Pacientes: ");
        System.out.println("Código  |   CPF           |  Nome Completo");

        for(int i = 0; i < contPaciente; i++) {
            System.out.print("    " + i);
            pacienteList[i].listarInformacoesPaciente();
        }
        System.out.println();

        System.out.print("Escolha o Paciênte [ Opção ] / [ 0 ] Sair : ");
        int codPacienteRecebido = scanner.nextInt();
        scanner.nextLine();
        Paciente grupoPacienteSelecionado = pacienteList[codPacienteRecebido];

        if (grupoPacienteSelecionado != null) {
            this.setPaciente(grupoPacienteSelecionado);
            this.setCodigo(getPaciente().getCodigo());
        } else {
            System.out.println("Lista de pacientes não existe.");
            return;
        }

        System.out.println("\n\t * Relação dos Médicos: ");
        System.out.println("Código  |  CRM     |  Nome do Médico");

        for(int i = 0; i < contMedico; i++){
            System.out.print("    " + i);
            medicoList[i].listarInformacoesMedico();
        }
        System.out.println();

        System.out.print("Escolha o Médidco [ Opção ] / [ 0 ] Sair : ");
        int codMedicoRecebido = scanner.nextInt();
        scanner.nextLine();
        Medico grupoMedicoSelecionado = medicoList[codMedicoRecebido];

        if (grupoMedicoSelecionado != null) {
            this.setMedido(grupoMedicoSelecionado);
            this.setCodigo(getMedido().getCodigo());
        } else {
            System.out.println("Grupo de exame não existe.");
            return;
        }

        System.out.println("\n\t * Relação dos Convênios");
        System.out.println("Código   |   Nome do Convênio");

        for(int i = 0; i < contConvenio; i++){
            System.out.print("    " + i);
            convenioList[i].listarInformacoesConvenio();
        }
        System.out.println();

        System.out.print("Escolha o Convênio [ Opção ] / [ 0 ] Sair : ");
        int codConvenioRecebido = scanner.nextInt();
        scanner.nextLine();
        Convenio grupoConvenioSelecionado = convenioList[codConvenioRecebido];

        if (grupoConvenioSelecionado != null) {
            this.setConvenio(grupoConvenioSelecionado);
            this.setCodigo(getConvenio().getCodigo());
        } else {
            System.out.println("Grupo de convênio não existe.");
            System.out.println("\n");
            return;
        }
    }

    public void imprimirInformacoesPedidoExame(){

        System.out.println("\n" + LINE);
        System.out.println("\t INFORMAÇÕES SOBRRE O PEDIDO DO EXAME");
        System.out.println(LINE);
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Médico: " + this.getMedido().getNomeMedico());
        System.out.println("Convênio: " + this.getConvenio().getNomeConvenio());
        System.out.println("Paciente: " + this.getPaciente().getNomeCompleto());
    }
}
