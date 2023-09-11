package PatternMediator;
import PatternCommand.Accendi;
import PatternCommand.Spegni;
import io.grpc.Server;
import javax.swing.*;

public class BottoneASServer implements Mediator
{
    private JButton accendi; /*Questa richiamera' una classe concreta*/
    private JButton spegni; /*Questa richiamera' una classe concreta*/
    private int porta;
    private String ind;
    private Server server;/*Mi server per chiudere il server*/
    public  BottoneASServer(JButton accendi,JButton spegni,int porta,String ind)
    {
        this.ind=ind;
        this.accendi=accendi;
        this.porta=porta;
        this.spegni=spegni;
    }
    @Override
    public void notify(JComponent component)
    {
        if(component==accendi)
        {
            /*Ecco come il bottone accendi richiama la classe Accendi*/
            spegni.setEnabled(true);
            accendi.setEnabled(false);
            Accendi ac=new Accendi(porta,ind);
            ac.actionPerformed(null);
            server=ac.getServer();
        }
        else
        {
            spegni.setEnabled(false);
            accendi.setEnabled(true);
            Spegni sp=new Spegni(server);
            sp.actionPerformed(null);
        }
    }
}
