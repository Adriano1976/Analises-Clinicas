package desenvolvimento.controle;

import desenvolvimento.cliente.Paciente;

public class Controle {

    public static Paciente[] pacienteList = new Paciente[10];
    public static Medico[] medicoList = new Medico[10];
    public static Convenio[] convenioList = new Convenio[10];
    public static PedidoExame[] pedidoExameList = new PedidoExame[10];
    public static GrupoExame[] grupoExameList = new GrupoExame[10];
    public static Exame[] exameList = new Exame[10];
    public static ExamePedidoExame[] examePedidoExameList = new ExamePedidoExame[10];

    public static int contPaciente = 0;
    public static int contMedico = 0;
    public static int contConvenio = 0;
    public static int contPedidoExame = 0;
    public static int contGrupoExame = 0;
    public static int contExame = 0;
    public static int contExamePedidoExame = 0;


    public static void imprimePaciente() {
        for (int i = 0; i < contPaciente; i++) {
            pacienteList[i].imprimirInformacoesPaciente();
        }
    }

    public static void imprimeConvenio() {
        for (int i = 0; i < contConvenio; i++) {
            convenioList[i].imprimirInformacoesConvenio();
        }
    }

    public static void imprimeMedico() {
        for (int i = 0; i < contMedico; i++) {
            medicoList[i].imprimirInformacoesMedico();
        }
    }

    public static void imprimePedidoExame() {
        for (int i = 0; i < contPedidoExame; i++) {
            pedidoExameList[i].imprimirInformacoesPedidoExame();
            for (int j = 0; j < contExamePedidoExame; j++) {
                examePedidoExameList[j].imprimirInformacoesExamePedidoExame();
            }
        }
    }

    public static void imprimeGrupoExame() {
        for (int i = 0; i < contGrupoExame; i++) {
            grupoExameList[i].imprimirInformacoesGrupoExame();
        }
    }

    public static void imprimeExame() {
        for (int i = 0; i < contExame; i++) {
            exameList[i].imprimirDescricaoExame();
        }
    }
}
