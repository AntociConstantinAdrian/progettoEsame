import com.google.protobuf.Timestamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import PatternMediator.*;
import proto.Operazioni.*;
public class TestClass
{
    @Test
    public void testPrenotazione()
    {
        AccediAlServer server=new AccediAlServer(8989,"127.0.0.1");
        VarieOperazioni varie=new VarieOperazioni(server.getclientStub());
        server.actionPerformed(null);
        Timestamp time=Timestamp.newBuilder().setSeconds(1693123200).build();
        Volo volo= Volo.newBuilder().setPartenza("Lamezia").setDestinazione("Roma").setData(time).build();
        Cliente cliente= Cliente.newBuilder().setNome("Luca").setCognome("Rossi").setIndirizzo("via bo").setIndirizzoEmail("luca@gmail.com").setCodiceFiscale("aa").build();
        Boolean vedi=varie.prenotaVolo(cliente,volo);
        Assertions.assertEquals(vedi,true);
    }

    @Test
    public void testAperturaSocket()
    {
        AccediAlServer server=new AccediAlServer(8989,"localhost");
        server.actionPerformed(null);
        Assertions.assertNotEquals(server, null);
    }
}
