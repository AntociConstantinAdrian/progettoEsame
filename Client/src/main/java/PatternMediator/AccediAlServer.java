package PatternMediator;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proto.GestionePrenotazioniVoliGrpc.*;
import proto.GestionePrenotazioniVoliGrpc;
public class AccediAlServer implements ActionListener
{
    private GestionePrenotazioniVoliBlockingStub clientStub;
    private int porta;
    private String ind;
    public AccediAlServer(int porta,String ind)
    {
        this.ind=ind;
        this.porta=porta;
    }
    public  GestionePrenotazioniVoliBlockingStub getclientStub()
    {
        return clientStub;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ind, porta)
                .usePlaintext()  // Utilizza una connessione non sicura (solo per scopi di test)
                .build();
        clientStub= GestionePrenotazioniVoliGrpc.newBlockingStub(channel);

    }
}
