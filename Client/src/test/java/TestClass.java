import com.google.protobuf.Timestamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import PatternMediator.*;
import proto.Operazioni.*;
public class TestClass
{
    @Test
    public void testAperturaSocket()
    {
        AccediAlServer server=new AccediAlServer(8989,"localhost");
        server.actionPerformed(null);
        Assertions.assertNotEquals(server, null);
    }
    @Test
    public void testPrenotazione()
    {
        AccediAlServer server=new AccediAlServer(8989,"127.0.0.1");
        server.actionPerformed(null);
        VarieOperazioni varie=new VarieOperazioni(server.getclientStub());
        /*Inserisco data Giusta*/
        Timestamp time=Timestamp.newBuilder().setSeconds(1695628800).setNanos(0).build();
        Timestamp dataNascita=Timestamp.newBuilder().setNanos(0).setSeconds(990568800).build();
        Volo volo= Volo.newBuilder().setPartenza("Lamezia").setDestinazione("Roma").setData(time).build();
        Cliente cliente= Cliente.newBuilder()
                .setNome("Luca")
                .setCognome("Rossi")
                .setIndirizzo("via bo").setIndirizzoEmail("luca@gmail.com").setCodiceFiscale("aa").setDataDiNascita(dataNascita).build();
        Boolean vedi=varie.prenotaVolo(cliente,volo);
        Assertions.assertEquals(vedi,true);
    }


}
