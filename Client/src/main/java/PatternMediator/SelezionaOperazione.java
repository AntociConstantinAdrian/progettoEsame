package PatternMediator;
import javax.swing.*;
import com.google.protobuf.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import proto.Operazioni.*;
import proto.GestionePrenotazioniVoliGrpc;
public class SelezionaOperazione implements Mediator
{
    private JButton mostraVoli,accedi,accediL,prenotaVolo,modificaVolo,vediVoliT,notifica,progf,estratto;
    private JTextField partenza,destinazione,data,datamod,nome,cognome,dataNascita,codiceFiscale,indirizzo,indirizzoEmail,codspec;
    private int porta;
    private String ind;
    private GestionePrenotazioniVoliGrpc.GestionePrenotazioniVoliBlockingStub clientStub=null;
    private VarieOperazioni varie;
    private JFrame frame,frameA;
    private Cliente cliente;
    public SelezionaOperazione(JFrame frameA,JFrame frame,JButton estratto,JButton progf,JButton notifica,JButton mostraVoli,JButton accedi,JButton vediVoliT,
                               JButton prenotaVolo,JButton accediL, JButton modificaVolo,JTextField codspec,
                               JTextField partenza,JTextField destinazione,JTextField data,
                               JTextField datamod,JTextField nome,JTextField cognome,
                               JTextField dataNascita,JTextField codiceFiscale,JTextField indirizzo,
                               JTextField indirizzoEmail,int porta,String ind) {
        this.notifica=notifica;
        this.progf=progf;
        this.estratto=estratto;
        this.codspec=codspec;
        this.frameA=frameA;
        this.frame=frame;
        this.mostraVoli=mostraVoli;
        this.accedi=accedi;
        this.porta=porta;
        this.ind=ind;
        this.prenotaVolo=prenotaVolo;
        this.modificaVolo=modificaVolo;
        this.partenza=partenza;
        this.destinazione=destinazione;
        this.nome=nome;
        this.cognome=cognome;
        this.dataNascita=dataNascita;
        this.codiceFiscale=codiceFiscale;
        this.indirizzo=indirizzo;
        this.indirizzoEmail=indirizzoEmail;
        this.data=data;
        this.datamod=datamod;
        this.accediL=accediL;
        this.vediVoliT=vediVoliT;
    }
    public Timestamp dammiTimestamp(JTextField data,boolean ora)
    {
        String dataS=data.getText().trim();
        String inputFormat;
        if(ora==true)
        {
             inputFormat = "dd-MM-yyyy HH:mm";
        }
        else
        {
             inputFormat = "dd-MM-yyyy";
        }
        SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
        Date date;
        try {
            date = inputDateFormat.parse(dataS);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
        long timestampSeconds = date.getTime() / 1000;  // Converte in secondi
        int timestampNanos = 0;  // Imposta i nanosecondi a zero

        //timestamp conforme a quello di google remote procedure call
        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(timestampSeconds)
                .setNanos(timestampNanos)
                .build();
        return timestamp;
    }
    @Override
    public void notify(JComponent component)
    {
        if(component==accedi)
        {
            accedi.setEnabled(false);
            mostraVoli.setEnabled(true);
            vediVoliT.setEnabled(true);
            notifica.setEnabled(true);
            progf.setEnabled(true);
            estratto.setEnabled(true);
            AccediAlServer ac=new AccediAlServer(porta,ind);
            ac.actionPerformed(null);
            clientStub=ac.getclientStub();
            varie=new VarieOperazioni(clientStub);
            varie.subscribe(cliente);
        }
        else if(component==accediL)
        {
            frameA.setVisible(false);
            Timestamp timestamp=dammiTimestamp(dataNascita,false);
            cliente=Cliente.newBuilder()
                    .setNome(nome.getText().trim())
                    .setCognome(cognome.getText().trim())
                    .setDataDiNascita(timestamp)
                    .setIndirizzo(indirizzo.getText().trim())
                    .setIndirizzoEmail(indirizzoEmail.getText().trim())
                    .setCodiceFiscale(codiceFiscale.getText().trim()).build();
            frame.setVisible(true);
        }
        else if(component==nome || component==codiceFiscale || component==cognome || component==dataNascita || component==indirizzo || component==indirizzoEmail)
        {
           // if(sonoValidi())
            //{
                accediL.setEnabled(true);


            //}
        }
        else if(component==mostraVoli)
        {
            varie.dammiVoli(cliente);
        }
        else if(component==estratto)
        {
            varie.estratto(cliente);
        }
        else if(component==progf)
        {
            varie.iscriviti(cliente);
        }
        else if(component==notifica)
        {
            varie.notifiche(cliente);
        }
        else if(component==prenotaVolo)
        {
            Timestamp timestamp=dammiTimestamp(data,true);
            Volo volo=Volo.newBuilder()
                    .setPartenza(partenza.getText().trim())
                    .setDestinazione(destinazione.getText().trim())
                    .setData(timestamp).build();
            varie.prenotaVolo(cliente,volo);
            varie.accumulaPunti(cliente,volo,codspec.getText().trim());
        }
        else if(component==vediVoliT)
        {
            varie.vediVoliMiei(cliente);
        }
        else if(component==modificaVolo)
        {
            Timestamp timestamp=dammiTimestamp(data,true);
            Timestamp timestamp1=dammiTimestamp(datamod,true);
            Volo volo=Volo.newBuilder()
                    .setPartenza(partenza.getText().trim())
                    .setDestinazione(destinazione.getText().trim())
                    .setData(timestamp).build();
            varie.modificaVolo(cliente,volo,timestamp1);
        }
        else if(component==partenza || component==destinazione || component==data || component==codspec)
        {
            prenotaVolo.setEnabled(true);
            modificaVolo.setEnabled(false);
        }
        else if(component==partenza || component==destinazione || component==data || component==datamod)
        {
            prenotaVolo.setEnabled(false);
            modificaVolo.setEnabled(true);
        }
    }
    public boolean sonoValidi()
    {
        String nome1=nome.getText().trim();
        String cognome1=cognome.getText().trim();
        String codiceFiscale1=codiceFiscale.getText().trim();
        String dataNascita1=dataNascita.getText().trim();
        String indirizzo1=indirizzo.getText().trim();
        String indirizzoEmail1=indirizzoEmail.getText().trim();
        if(nome1!=null && cognome1!=null  && codiceFiscale1!=null  && dataNascita1!=null && indirizzo1!=null  && indirizzoEmail1!=null )
        {
            return true;
        }
        return false;
    }
}
