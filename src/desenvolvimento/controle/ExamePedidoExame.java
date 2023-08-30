package desenvolvimento.controle;

import desenvolvimento.cliente.Paciente;
import desenvolvimento.util.DataHoraLocal;
import desenvolvimento.util.ISystemLine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import static desenvolvimento.controle.Controle.*;

public class ExamePedidoExame implements ISystemLine {

    private UUID codigo = UUID.randomUUID();
    private Date dataRealizacaoExame;
    private Date dataExemePronto;
    private Date horaRealizacaoExame;
    private Date horaExamePronto;
    private Exame examePedido;
    private String resultado;
    private Double valor;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
    DataHoraLocal dataHoraLocal = new DataHoraLocal();
    Exame exame = new Exame();

    public ExamePedidoExame() {
    }

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

    public Double getValor() {
        return valor = exame.getValor();
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void cadastrarInformacoesExamePedidoExame() throws ParseException {

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
        Exame grupoExameSelecionado = exameList[codExameRecebido];

        if (grupoExameSelecionado != null) {
            this.setExamePedido(grupoExameSelecionado);
            this.setCodigo(getExamePedido().getCodigo());
        } else {
            System.out.println("Lista de exame não existe.");
            return;
        }

        System.out.print("Data da Realização do Exame [12/10/2023]: ");
        String dataRealizarExame = scanner.nextLine();

        // Validar o formato da data de realização do exame
        if (!dateFormat.isLenient() && !dateFormat.parse(dataRealizarExame).equals(dataRealizarExame)) {
            throw new IllegalArgumentException("Data de realização do exame inválida.");
        }

        Date date1 = dateFormat.parse(dataRealizarExame);
        this.setDataRealizacaoExame(date1);

        System.out.print("Data da Entrega do Exame [10/10/2023]: ");
        String dataEntregaExame = scanner.nextLine();

        // Validar se a data de realização do exame é anterior à data de entrega do exame
        Date date2 = dateFormat.parse(dataEntregaExame);
        if (date1.after(date2)) {
            throw new IllegalArgumentException("Data de realização do exame não pode ser posterior à data de entrega do exame.");
        }

        // Validar o formato da data de entrega do exame
        if (!dateFormat.isLenient() && !dateFormat.parse(dataEntregaExame).equals(dataEntregaExame)) {
            throw new IllegalArgumentException("Data de entrega do exame inválida.");
        }

        // Validar se a data de realização do exame é anterior à data de entrega do exame
        this.setDataExemePronto(date2);
        if (date1.after(date2)) {
            throw new IllegalArgumentException("Data de realização do exame não pode ser posterior à data de entrega do exame.");
        }

        System.out.print("Hora da Realização do Exame [10:52]: ");
        String horaRealizarExame = scanner.nextLine();
        Date hour1 = hourFormat.parse(horaRealizarExame);
        this.setHoraRealizacaoExame(hour1);

        // Validar o formato da hora de realização do exame
        if (!hourFormat.isLenient() && !hourFormat.parse(horaRealizarExame).equals(horaRealizarExame)) {
            throw new IllegalArgumentException("Hora de realização do exame inválida.");
        }

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

        String dataRealizarExameFormatada = dateFormat.format(this.getDataRealizacaoExame());
        String horaRealizarExameFormatada = hourFormat.format(this.getHoraRealizacaoExame());
        String dataRetirarExameFormatada = dateFormat.format(this.getDataExemePronto());
        String horaRetirarExameFormatada = hourFormat.format(this.getHoraExamePronto());

        System.out.println("Código: " + this.getCodigo());
        System.out.println("Data da Realização: " + dataRealizarExameFormatada + " - " + horaRealizarExameFormatada);
        System.out.println("Data da Entrega: " + dataRetirarExameFormatada + " - " + horaRetirarExameFormatada);
        System.out.println("Descrição do Exames: ");
        System.out.println(LINE);

        for (int i = 0; i < contExamePedidoExame; i++) {
            System.out.println(" - " + examePedidoExameList[i].getExamePedido().getDescricaoExame());
        }
        System.out.println();
    }
}
