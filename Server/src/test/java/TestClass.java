import com.google.protobuf.Timestamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import PatternCommand.Accendi;
import service.GestionePrenotazioneVoliImpl;
import proto.Operazioni.*;
public class TestClass
{
        /*Verifico se il Server si accende */
        @Test
        public void AccendiServer()
        {
            Accendi accendi=new Accendi(8989,"localhost");
            accendi.actionPerformed(null);
            Assertions.assertNotEquals(accendi.getServer(),null);
        }
        @Test
        public void InserisciVoli()
        {
            GestionePrenotazioneVoliImpl impl=new GestionePrenotazioneVoliImpl();
            Timestamp data=Timestamp.newBuilder().setSeconds(1695628800).setNanos(0).build();
            Volo volo= Volo.newBuilder().setPartenza("Parigi").setDestinazione("Londra").setData(data).build();
        }

}