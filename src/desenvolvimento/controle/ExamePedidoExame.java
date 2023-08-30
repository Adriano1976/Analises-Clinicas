package desenvolvimento.controle;

import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import static desenvolvimento.controle.Controle.*;

/**
 * Classe que representa pedido exame médico
 *
 * @author Adriano Santos
 */
public class ExamePedidoExame implements ISystemLine {

    // Atributos da classe ExamePedidoExame
    private UUID codigo = UUID.randomUUID(); // Código do exame
    private Date dataRealizacaoExame; // Data da realização do exame
    private Date dataExemePronto; // Data em que o exame ficará pronto
    private Date horaRealizacaoExame; // Hora da realização do exame
    private Date horaExamePronto; // Hora em que o exame ficará pronto
    private Exame examePedido; // Exame que foi pedido
    private String resultado; // Resultado do exame
    private Double valor; // Valor do exame

    // Formatters para formatar as datas e horas
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");

    // Data e hora local
    DataHoraLocal dataHoraLocal = new DataHoraLocal();

    // Objeto do exame
    Exame exame = new Exame();

    // Construtor da classe ExamePedidoExame
    public ExamePedidoExame() {
    }

    // Métodos getters e setters dos atributos
    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public Date getDataRealizacaoExame() {
        return dataRealizacaoExame;
    }

    public void setDataRealizacaoExame(Date dataRealizacaoExame) {
        this.dataRealizacaoExame = dataRealizacaoExame;
    }

    public Date getDataExemePronto() {
        return dataExemePronto;
    }

    public void setDataExemePronto(Date dataExemePronto) {
        this.dataExemePronto = dataExemePronto;
    }

    public Date getHoraRealizacaoExame() {
        return horaRealizacaoExame;
    }

    public void setHoraRealizacaoExame(Date horaRealizacaoExame) {
        this.horaRealizacaoExame = horaRealizacaoExame;
    }

    public Date getHoraExamePronto() {
        return horaExamePronto;
    }

    public void setHoraExamePronto(Date horaExamePronto) {
        this.horaExamePronto = horaExamePronto;
    }

    public Exame getExamePedido() {
        return examePedido;
    }

    public void setExamePedido(Exame examePedido) {
        this.examePedido = examePedido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    // Método para retornar o valor do exame
    public Double getValor() {
        return valor = exame.getValor();
    }

    // Método para setar o valor do exame
    public void setValor(Double valor) {
        this.valor = valor;
    }


    public void cadastrarInformacoesExamePedidoExame() throws ParseException {

        // Obtém a entrada do usuário para selecionar o exame
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + LINE);
        System.out.println("|       RELAÇÃO DE EXAMES DO PEDIDO MÉDICO       |");
        System.out.println(LINE);
        System.out.println("Código  |  Descrição       |  Valor");

        for (int i = 0; i < contExame; i++) {
            System.out.print("     " + i);
            exameList[i].listarDescricaoExame();
        }
        System.out.println();
        System.out.print("Escolha o Exame [ Opção ] / [ 0 ] Sair : ");
        int codExameRecebido = scanner.nextInt();
        scanner.nextLine();

        // Verifica se o exame selecionado é válido
        Exame grupoExameSelecionado = exameList[codExameRecebido];
        if (grupoExameSelecionado != null) {
            // Atribui o exame selecionado ao pedido de exame
            this.setExamePedido(grupoExameSelecionado);
            this.setCodigo(getExamePedido().getCodigo());
        } else {
            System.out.println("Lista de exame não existe.");
            return;
        }

        // Solicita a data de realização do exame
        System.out.print("Data da Realização do Exame [12/10/2023]: ");
        String dataRealizarExame = scanner.nextLine();

        // Valida o formato da data de realização do exame
        if (!dateFormat.isLenient() && !dateFormat.parse(dataRealizarExame).equals(dataRealizarExame)) {
            throw new IllegalArgumentException("Data de realização do exame inválida.");
        }

        // Atribui a data de realização do exame ao pedido de exame
        Date date1 = dateFormat.parse(dataRealizarExame);
        this.setDataRealizacaoExame(date1);

        // Solicita a data de entrega do exame
        System.out.print("Data da Entrega do Exame [10/10/2023]: ");
        String dataEntregaExame = scanner.nextLine();

        // Valida se a data de realização do exame é anterior à data de entrega do exame
        Date date2 = dateFormat.parse(dataEntregaExame);
        if (date1.after(date2)) {
            throw new IllegalArgumentException("Data de realização do exame não pode ser posterior à data de entrega do exame.");
        }

        // Valida o formato da data de entrega do exame
        if (!dateFormat.isLenient() && !dateFormat.parse(dataEntregaExame).equals(dataEntregaExame)) {
            throw new IllegalArgumentException("Data de entrega do exame inválida.");
        }

        // Atribui a data de entrega do exame ao pedido de exame
        this.setDataExemePronto(date2);

        // Solicita a hora de realização do exame
        System.out.print("Hora da Realização do Exame [10:52]: ");
        String horaRealizarExame = scanner.nextLine();
        Date hour1 = hourFormat.parse(horaRealizarExame);
        this.setHoraRealizacaoExame(hour1);

        // Valida o formato da hora de realização do exame
        if (!hourFormat.isLenient() && !hourFormat.parse(horaRealizarExame).equals(horaRealizarExame)) {
            throw new IllegalArgumentException("Hora de realização do exame inválida.");
        }

        // Solicita a hora de entrega do exame
        System.out.print("Hora da Entrega do Exame [10:25]: ");
        String horaEntregaExame = scanner.nextLine();
        Date hour2 = hourFormat.parse(horaEntregaExame);

        // Validar o formato da hora de entrega do exame
        if (!hourFormat.isLenient() && !hourFormat.parse(horaEntregaExame).equals(horaEntregaExame)) {
            throw new IllegalArgumentException("Hora de entrega do exame inválida.");
        }

        // Validar se a hora de entrega do exame é posterior à data de realização do exame
        date1 = dateFormat.parse(dataRealizarExame);
        if (date1.after(hour2)) {
            throw new IllegalArgumentException("Hora de entrega do exame não pode ser anterior à data de realização do exame.");
        }

        this.setHoraExamePronto(hour2);

        System.out.print("Valor do Exame: " + exame.getValor());
    }

    public void imprimirInformacoesExamePedidoExame() {

        // Imprime o código do pedido de exame
        System.out.println("Código: " + this.getCodigo());

        // Formata as datas de realização e entrega do exame
        String dataRealizarExameFormatada = dateFormat.format(this.getDataRealizacaoExame());
        String horaRealizarExameFormatada = hourFormat.format(this.getHoraRealizacaoExame());
        String dataRetirarExameFormatada = dateFormat.format(this.getDataExemePronto());
        String horaRetirarExameFormatada = hourFormat.format(this.getHoraExamePronto());

        // Imprime a data e hora de realização do exame
        System.out.println("Data da Realização: " + dataRealizarExameFormatada + " - " + horaRealizarExameFormatada);

        // Imprime a data e hora de entrega do exame
        System.out.println("Data da Entrega: " + dataRetirarExameFormatada + " - " + horaRetirarExameFormatada);

        // Imprime uma linha em branco
        System.out.println(LINE);

        // Imprime a descrição de cada exame do pedido
        System.out.println("Descrição do Exames: ");

        for (int i = 0; i < contExamePedidoExame; i++) {
            System.out.println(" - " + examePedidoExameList[i].getExamePedido().getDescricaoExame());
        }

        // Imprime uma linha em branco
        System.out.println();
    }

}
