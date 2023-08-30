package desenvolvimento.programa;

import desenvolvimento.controle.Convenio;
import desenvolvimento.cliente.Paciente;
import desenvolvimento.controle.Exame;
import desenvolvimento.controle.ExamePedidoExame;
import desenvolvimento.controle.GrupoExame;
import desenvolvimento.controle.Medico;
import desenvolvimento.util.ISystemLine;
import desenvolvimento.controle.PedidoExame;

import java.text.ParseException;
import java.util.Scanner;

import static desenvolvimento.controle.Controle.*;

public class Programa implements ISystemLine {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(LINE);
            System.out.println("|           SISTEMA ANALISES CLINICAS            |");
            System.out.println(LINE);
            System.out.println("| PACIENTE       [1 - CADASTRAR]   [2 - LISTAR]  |");
            System.out.println("| CONVÊNIO       [3 - CADASTRAR]   [4 - LISTAR]  |");
            System.out.println("| MÉDICO         [5 - CADASTRAR]   [6 - LISTAR]  |");
            System.out.println("| PEDIDO EXAME   [7 - CADASTRAR]   [8 - LISTAR]  |");
            System.out.println("| EXAME          [9 - CADASTRAR]   [10 - LISTAR] |");
            System.out.println("| GRUPO EXAME   [11 - CADASTRAR]   [12 - LISTAR] |");
            System.out.println("| SAIR          [0]                              |");
            System.out.println(LINE);
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            System.out.println();

            switch (opcao) {
                case 1 -> {
                    pacienteList[contPaciente] = new Paciente();
                    pacienteList[contPaciente].cadastrarInformacoesPaciente();
                    contPaciente++;
                }
                case 2 -> imprimePaciente();
                case 3 -> {
                    convenioList[contConvenio] = new Convenio();
                    convenioList[contConvenio].cadastrarInformacoesConvenio();
                    contConvenio++;
                }
                case 4 -> imprimeConvenio();
                case 5 -> {
                    medicoList[contMedico] = new Medico();
                    medicoList[contMedico].cadastrarInformacoesMedico();
                    contMedico++;
                }
                case 6 -> imprimeMedico();
                case 7 -> {
                    pedidoExameList[contPedidoExame] = new PedidoExame();
                    pedidoExameList[contPedidoExame].cadastrarPedidoMedico();
                    contPedidoExame++;
                    int resp = 1;
                    while (resp == 1) {
                        examePedidoExameList[contExamePedidoExame] = new ExamePedidoExame();
                        examePedidoExameList[contExamePedidoExame].cadastrarInformacoesExamePedidoExame();
                        contExamePedidoExame++;
                        System.out.println("\n");
                        System.out.print("Deseja cadastrar outro exame? [1 - Sim][0 - Não]: ");
                        resp = scanner.nextInt();
                        scanner.nextLine();
                    }
                }
                case 8 -> imprimePedidoExame();
                case 9 -> {
                    exameList[contExame] = new Exame();
                    exameList[contExame].cadastrarInformacoesExame();
                    contExame++;
                }
                case 10 -> imprimeExame();
                case 11 -> {
                    grupoExameList[contGrupoExame] = new GrupoExame();
                    grupoExameList[contGrupoExame].cadastrarInformacoesGrupoExame();
                    contGrupoExame++;
                }
                case 12 -> imprimeGrupoExame();
                default -> System.exit(0);
            }
        }
    }
}