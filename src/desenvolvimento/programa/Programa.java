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

/**
 * Classe que representa o programa principal.
 *
 * @author Adriano Santos
 */
public class Programa implements ISystemLine {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Exibe uma linha em branco
            System.out.println(LINE);

            // Exibe o cabeçalho do sistema
            System.out.println("|           SISTEMA ANALISES CLINICAS            |");

            // Exibe uma linha em branco
            System.out.println(LINE);

            // Exibe as opções do menu
            System.out.println("| PACIENTE       [1 - CADASTRAR]   [2 - LISTAR]  |");
            System.out.println("| CONVÊNIO       [3 - CADASTRAR]   [4 - LISTAR]  |");
            System.out.println("| MÉDICO         [5 - CADASTRAR]   [6 - LISTAR]  |");
            System.out.println("| PEDIDO EXAME   [7 - CADASTRAR]   [8 - LISTAR]  |");
            System.out.println("| EXAME          [9 - CADASTRAR]   [10 - LISTAR] |");
            System.out.println("| GRUPO EXAME   [11 - CADASTRAR]   [12 - LISTAR] |");
            System.out.println("| SAIR          [0]                              |");

            // Exibe uma linha em branco
            System.out.println(LINE);

            // Solicita a opção do usuário
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            // Exibe uma linha em branco
            System.out.println();

            // Trata a opção selecionada
            switch (opcao) {
                case 1 -> {
                    // Cadastra um novo paciente
                    pacienteList[contPaciente] = new Paciente();
                    pacienteList[contPaciente].cadastrarInformacoesPaciente();
                    contPaciente++;
                }
                case 2 -> {
                    // Imprime a lista de pacientes
                    imprimePaciente();
                }
                case 3 -> {
                    // Cadastra um novo convênio
                    convenioList[contConvenio] = new Convenio();
                    convenioList[contConvenio].cadastrarInformacoesConvenio();
                    contConvenio++;
                }
                case 4 -> {
                    // Imprime a lista de convênios
                    imprimeConvenio();
                }
                case 5 -> {
                    // Cadastra um novo médico
                    medicoList[contMedico] = new Medico();
                    medicoList[contMedico].cadastrarInformacoesMedico();
                    contMedico++;
                }
                case 6 -> {
                    // Imprime a lista de médicos
                    imprimeMedico();
                }
                case 7 -> {
                    // Cadastra um novo pedido de exame
                    pedidoExameList[contPedidoExame] = new PedidoExame();
                    pedidoExameList[contPedidoExame].cadastrarPedidoMedico();
                    contPedidoExame++;

                    // Cadastra os exames do pedido de exame
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
                case 8 -> {
                    // Imprime a lista de pedidos de exame
                    imprimePedidoExame();
                }
                case 9 -> {
                    // Cadastra um novo exame
                    exameList[contExame] = new Exame();
                    exameList[contExame].cadastrarInformacoesExame();
                    contExame++;
                }
                case 10 -> {
                    // Imprime a lista de exames
                    imprimeExame();
                }
                case 11 -> {
                    // Cadastra um novo grupo de exame
                    grupoExameList[contGrupoExame] = new GrupoExame();
                    grupoExameList[contGrupoExame].cadastrarInformacoesGrupoExame();
                    contGrupoExame++;
                }
                case 12 -> {
                    // Imprime a lista de grupos de exame
                    imprimeGrupoExame();
                }
                default -> {
                    // Sai do programa
                    System.exit(0);
                }
            }

        }
    }
}