package PatternCommand;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.GestionePrenotazioneVoliImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Accendi implements ActionListener
{
    private Server server;
    private int porta;
    private String ind;
    public Accendi(int porta,String ind)
    {
        this.ind=ind;
        this.porta=porta;
    }
    public Server getServer()
    {
        return server;/*Ritorno il server perche' mi serve per la chiusura*/
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        server = ServerBuilder.forPort(porta).addService(new GestionePrenotazioneVoliImpl()).build();
        try {
            server.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
