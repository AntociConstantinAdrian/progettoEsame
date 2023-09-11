package PatternCommand;
import PatternMediator.Mediator;
import com.google.protobuf.Timestamp;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import proto.Operazioni.*;
public class AggiungiVolo implements Mediator
{
    private JTextField partenzaText;
    private JTextField destinazioneText;
    private JTextField dataText;
    private JButton salva;
    public void setPartenzaText(JTextField partenzaText){this.partenzaText=partenzaText;}
    public void setDestinazioneText(JTextField destinazioneText){this.destinazioneText=destinazioneText;}
    public  void setDataText(JTextField dataText){this.dataText=dataText;}
    public void setSalva(JButton salva){this.salva=salva;}
    @Override
    public void notify(JComponent component)
    {
        if(component==partenzaText || component==destinazioneText || component==dataText)
        {
            salva.setEnabled(sonoValidi());
        }
        if(component==salva)
        {
            String partenza=partenzaText.getText().trim();
            String destinazione=destinazioneText.getText().trim();
            String data=dataText.getText().trim();
            String inputFormat = "dd-MM-yyyy HH:mm";
            SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
            Date date;
            try {
                date = inputDateFormat.parse(data);
            } catch (ParseException ex) {
                ex.printStackTrace();
                return;
            }
            long timestampSeconds = date.getTime() / 1000;  // Converte in secondi
            int timestampNanos = 0;  // Imposta i nanosecondi a zero

            //timestamp conforme a quello di google remote procedure call
            Timestamp timestamp = Timestamp.newBuilder()
                    .setSeconds(timestampSeconds)
                    .setNanos(timestampNanos)
                    .build();
            Volo volo= Volo.newBuilder().setPartenza(partenza).setData(timestamp).setDestinazione(destinazione).build();
            service.GestionePrenotazioneVoliImpl.setVolo(volo);
        }

    }
    public boolean sonoValidi()
    {
        String partenzat=partenzaText.getText().trim();
        String destinazionet=destinazioneText.getText().trim();
        String datat=dataText.getText().trim();
        String postit;
        if(partenzat!=null && destinazionet!=null &datat!=null)
        {
            return true;
        }
        return false;
    }
}
