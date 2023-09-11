package PatternMediator;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import com.google.protobuf.Timestamp;
import proto.Operazioni.*;
import proto.GestionePrenotazioniVoliGrpc;
public class VarieOperazioni
{
    private GestionePrenotazioniVoliGrpc.GestionePrenotazioniVoliBlockingStub clientStub;
    public VarieOperazioni(GestionePrenotazioniVoliGrpc.GestionePrenotazioniVoliBlockingStub clientStub)
    {
        this.clientStub=clientStub;
    }
    /*Cerca tutti i voli*/
    public void dammiVoli(Cliente cli)
    {
        try
        {
            Voli voli = clientStub.dammiTuttiVoli(cli);
            JFrame frame1 = new JFrame("Voli");
            //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setSize(1080, 720);

            String[] columnNames = {"Partenza", "Destinazione", "Data"};
            Object[][] data = new Object[voli.getVoliCount()][4];

            for (int i = 0; i < voli.getVoliCount(); i++) {
                Volo volo = voli.getVoli(i);
                data[i][0] = volo.getPartenza();
                data[i][1] = volo.getDestinazione();
                long seconds = volo.getData().getSeconds();
                long milliseconds = seconds * 1000L + volo.getData().getNanos() / 1000000L;
                Date date = new Date(milliseconds);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Formato desiderato
                String formattedDate = sdf.format(date);
                data[i][2] = formattedDate;
            }
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Impedisce la modifica delle celle
                }
            };
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame1.add(scrollPane);

            frame1.setVisible(true);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void subscribe(Cliente cli)
    {
        Informazione info=clientStub.subscribe(cli);
        System.out.println("Messaggio a scopo tecnico "+info.getMes());
    }
    public void notifiche(Cliente cli)
    {
        Informazione info=clientStub.inviaNotifica(cli);
        JFrame frame1=new JFrame("Notifiche");
        frame1.setSize(200,100);
        JLabel label=new JLabel(info.getMes());
        frame1.add(label);
        frame1.setVisible(true);
    }
    public void iscriviti(Cliente cli)
    {
        Informazione esito=clientStub.iscrizioneProgrammaFedelta(cli);
        JFrame frame1=new JFrame();
        frame1.setSize(400,100);
        JLabel label=new JLabel(esito.getMes());
        frame1.add(label);
        frame1.setVisible(true);
    }
    public void estratto(Cliente cli)
    {
        Estratti estratti=clientStub.estrattoContoFedelta(cli);
        JFrame frame1 = new JFrame("Estratto-Conto");
        frame1.setSize(1080, 720);
        if(estratti==null)
        {
            JLabel label=new JLabel("Nessun estratto conto per ora");
            frame1.add(label);
        }
        else {

            String[] columnNames = {"Partenza", "Destinazione", "Data", "Punti-Accumulati"};
            Object[][] data = new Object[estratti.getEstrattoContoCount()][4];

            for (int i = 0; i < estratti.getEstrattoContoCount(); i++) {
                EstrattoConto est = estratti.getEstrattoConto(i);
                data[i][0] = est.getVolo().getPartenza();
                data[i][1] = est.getVolo().getDestinazione();
                long seconds = est.getVolo().getData().getSeconds();
                long milliseconds = seconds * 1000L + est.getVolo().getData().getNanos() / 1000000L;
                Date date = new Date(milliseconds);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Formato desiderato
                String formattedDate = sdf.format(date);
                data[i][2] = formattedDate;
                data[i][3] = est.getPuntiAccumulati();
            }
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Impedisce la modifica delle celle
                }
            };
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame1.add(scrollPane);
        }
        frame1.setVisible(true);
    }
    public void accumulaPunti(Cliente cli,Volo volo,String codspec)
    {
        int codice=Integer.parseInt(codspec);
        DatiPunti dati=DatiPunti.newBuilder().setCodiceSegreto(codice).setVolo(volo).setCliente(cli).build();
        Informazione esito=clientStub.accumulaPuntiFedelta(dati);
        JFrame frame1=new JFrame();
        frame1.setSize(200,100);
        JLabel label=new JLabel(esito.getMes());
        frame1.add(label);
        frame1.setVisible(true);
    }
    /*Vedi Voli del cliente*/
    public void vediVoliMiei(Cliente cliente)
    {
        Voli voli=clientStub.dammiMieiVoli(cliente);
        JFrame frame1 = new JFrame("Voli-Miei");
       // frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1080, 720);

        String[] columnNames = {"Partenza", "Destinazione", "Data"};
        Object[][] data = new Object[voli.getVoliCount()][4];

        for (int i = 0; i < voli.getVoliCount(); i++) {
            Volo volo = voli.getVoli(i);
            data[i][0] = volo.getPartenza();
            data[i][1] = volo.getDestinazione();
            long seconds = volo.getData().getSeconds();
            long milliseconds = seconds * 1000L + volo.getData().getNanos() / 1000000L;
            Date date = new Date(milliseconds);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Formato desiderato
            String formattedDate = sdf.format(date);
            data[i][2] = formattedDate;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impedisce la modifica delle celle
            }
        };
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame1.add(scrollPane);

        frame1.setVisible(true);
    }
    /*Prenota un volo*/
    public boolean prenotaVolo(Cliente cliente,Volo volo)
    {

        Prenotazione prenotazione = Prenotazione.newBuilder()
                .setVolo(volo)
                .setCliente(cliente)
                .build();

        // Chiamata al metodo "prenotaVolo" del server
        Esito esito = clientStub.prenotaVolo(prenotazione);
        // Elabora l'esito
        if (esito.getEsito().getValue())
        {
            String mes="Prenotazione avvenuta con successo";
            mostraMessaggio(mes);
            return true;
        }
        else
        {
            String mes="Prenotazione non avvenuta con successo";
            mostraMessaggio(mes);
        }
        return false;

    }
    public void mostraMessaggio(String mes)
    {
        JFrame frameS=new JFrame();
        frameS.setSize(300,300);
        JPanel panel=new JPanel();
        panel.add(new JLabel(mes));
        frameS.add(panel);
        frameS.setVisible(true);
        System.out.println(mes);
    }
    public void modificaVolo(Cliente cliente, Volo volo, Timestamp datamod)
    {
        RichiestaModificaVolo ric= RichiestaModificaVolo.newBuilder().setVolo(volo).setCliente(cliente).setDataMod(datamod).build();
        Esito esito=clientStub.modificaPrenotazione(ric);
        String mes;
        if(esito.getEsito().getValue())
        {
            mes="Modifica avvenuta con successo";
            mostraMessaggio(mes);
        }
        else
        {
            mes="Modifica non avvenuta con successo";
            mostraMessaggio(mes);
        }
    }
}
