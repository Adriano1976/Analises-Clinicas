package desenvolvimento.controle;

import desenvolvimento.cliente.Paciente;

/**
 * Classe que representa o controle.
 *
 * @author Adriano Santos
 */
public class Controle {

    public static Paciente[] pacienteList = new Paciente[10]; // Lista de pacientes
    public static Medico[] medicoList = new Medico[10]; // Lista de médicos
    public static Convenio[] convenioList = new Convenio[10]; // Lista de convênios
    public static PedidoExame[] pedidoExameList = new PedidoExame[10]; // Lista de pedidos de exame
    public static GrupoExame[] grupoExameList = new GrupoExame[10]; // Lista de grupos de exame
    public static Exame[] exameList = new Exame[10]; // Lista de exames
    public static ExamePedidoExame[] examePedidoExameList = new ExamePedidoExame[10]; // Lista de exames de pedidos de exame

    public static int contPaciente = 0; // Contador de pacientes
    public static int contMedico = 0; // Contador de médicos
    public static int contConvenio = 0; // Contador de convênios
    public static int contPedidoExame = 0; // Contador de pedidos de exame
    public static int contGrupoExame = 0; // Contador de grupos de exame
    public static int contExame = 0; // Contador de exames
    public static int contExamePedidoExame = 0; // Contador de exames de pedidos de exame


    // Imprime as informações de todos os pacientes
    public static void imprimePaciente() {
        for (int i = 0; i < contPaciente; i++) {
            System.out.println("Informações do paciente:");
            pacienteList[i].imprimirInformacoesPaciente();
        }
    }

    // Imprime as informações de todos os convênios
    public static void imprimeConvenio() {
        for (int i = 0; i < contConvenio; i++) {
            System.out.println();
            convenioList[i].imprimirInformacoesConvenio();
        }
    }

    // Imprime as informações de todos os médicos
    public static void imprimeMedico() {
        for (int i = 0; i < contMedico; i++) {
            System.out.println();
            medicoList[i].imprimirInformacoesMedico();
        }
    }

    // Imprime as informações de todos os pedidos de exame
    public static void imprimePedidoExame() {
        for (int i = 0; i < contPedidoExame; i++) {
            System.out.println("Informações do pedido de exame:");
            pedidoExameList[i].imprimirInformacoesPedidoExame();
            for (int j = 0; j < contExamePedidoExame; j++) {
                System.out.println("Informações do exame do pedido de exame:");
                examePedidoExameList[j].imprimirInformacoesExamePedidoExame();
            }
        }
    }

    // Imprime as informações de todos os grupos de exame
    public static void imprimeGrupoExame() {
        for (int i = 0; i < contGrupoExame; i++) {
            System.out.println("Informações do grupo de exame:");
            grupoExameList[i].imprimirInformacoesGrupoExame();
        }
    }

    // Imprime as informações de todos os exames
    public static void imprimeExame() {
        for (int i = 0; i < contExame; i++) {
            System.out.println("Descrição do exame:");
            exameList[i].imprimirDescricaoExame();
        }
    }
}
