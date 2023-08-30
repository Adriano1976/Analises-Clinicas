package desenvolvimento.controle;

import desenvolvimento.cliente.Paciente;
import desenvolvimento.util.DataHoraLocal;

import java.util.Scanner;
import java.util.UUID;

import static desenvolvimento.controle.Controle.*;
import static desenvolvimento.util.ISystemLine.LINE;

/**
 * Classe que representa um pedido de exame.
 *
 * @author Adriano Santos
 */
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


    public void cadastrarPedidoMedico() {

        // Cria um objeto Scanner para capturar a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Exibe uma mensagem de cabeçalho
        System.out.println(LINE);
        System.out.println("|          INFORMAÇÕES DO PEDIDO MÉDICO          |");
        System.out.println(LINE);
        System.out.println(dataHoraLocal.imprimirDataHoraLocal());

        // Exibe uma tabela com a lista de pacientes
        System.out.println("\n\t * Relação dos Pacientes: ");
        System.out.println("Código  |   CPF           |  Nome Completo");

        for (int i = 0; i < contPaciente; i++) {
            // Exibe o índice do paciente na lista
            System.out.print("    " + i);

            // Exibe as informações do paciente
            pacienteList[i].listarInformacoesPaciente();
        }
        System.out.println();

        // Solicita ao usuário que selecione um paciente
        System.out.print("Escolha o Paciênte [ Opção ] / [ 0 ] Sair : ");
        int codPacienteRecebido = scanner.nextInt();
        scanner.nextLine();

        // Verifica se o paciente foi selecionado
        Paciente grupoPacienteSelecionado = pacienteList[codPacienteRecebido];
        if (grupoPacienteSelecionado != null) {
            // Define o paciente selecionado no pedido médico
            this.setPaciente(grupoPacienteSelecionado);
            this.setCodigo(getPaciente().getCodigo());
        } else {
            // Exibe uma mensagem de erro
            System.out.println("Lista de pacientes não existe.");
            return;
        }

        // Exibe uma tabela com a lista de médicos
        System.out.println("\n\t * Relação dos Médicos: ");
        System.out.println("Código  |  CRM     |  Nome do Médico");

        for (int i = 0; i < contMedico; i++) {
            // Exibe o índice do médico na lista
            System.out.print("    " + i);

            // Exibe as informações do médico
            medicoList[i].listarInformacoesMedico();
        }
        System.out.println();

        // Solicita ao usuário que selecione um médico
        System.out.print("Escolha o Médidco [ Opção ] / [ 0 ] Sair : ");
        int codMedicoRecebido = scanner.nextInt();
        scanner.nextLine();

        // Verifica se o médico foi selecionado
        Medico grupoMedicoSelecionado = medicoList[codMedicoRecebido];
        if (grupoMedicoSelecionado != null) {
            // Define o médico selecionado no pedido médico
            this.setMedido(grupoMedicoSelecionado);
            this.setCodigo(getMedido().getCodigo());
        } else {
            // Exibe uma mensagem de erro
            System.out.println("Grupo de exame não existe.");
            return;
        }

        // Exibe uma tabela com a lista de convênios
        System.out.println("\n\t * Relação dos Convênios");
        System.out.println("Código   |   Nome do Convênio");

        for (int i = 0; i < contConvenio; i++) {
            // Exibe o índice do convênio na lista
            System.out.print("    " + i);

            // Exibe as informações do convênio
            convenioList[i].listarInformacoesConvenio();
        }
        System.out.println();

        // Exibe um menu para o usuário selecionar um convênio
        System.out.print("Escolha o Convênio [ Opção ] / [ 0 ] Sair : ");
        // Lê a opção do usuário
        int codConvenioRecebido = scanner.nextInt();
        scanner.nextLine();
        // Obtém o grupo de convênio selecionado
        Convenio grupoConvenioSelecionado = convenioList[codConvenioRecebido];

        // Se o grupo de convênio existe
        if (grupoConvenioSelecionado != null) {
            // Atribui o grupo de convênio ao objeto atual
            this.setConvenio(grupoConvenioSelecionado);
            this.setCodigo(getConvenio().getCodigo());
        } else {
            // Se o grupo de convênio não existe
            System.out.println("Grupo de convênio não existe.");
            System.out.println("\n");
            return;
        }
    }

    public void imprimirInformacoesPedidoExame() {

        System.out.println("\n" + LINE);
        System.out.println("\t INFORMAÇÕES SOBRRE O PEDIDO DO EXAME");
        System.out.println(LINE);
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Médico: " + this.getMedido().getNomeMedico());
        System.out.println("Convênio: " + this.getConvenio().getNomeConvenio());
        System.out.println("Paciente: " + this.getPaciente().getNomeCompleto());
    }
}
