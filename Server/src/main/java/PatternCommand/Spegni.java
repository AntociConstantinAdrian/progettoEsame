package PatternCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.Server;
public class Spegni implements ActionListener
{
    private Server server;
    public Spegni(Server server)
    {
        this.server=server;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        server.shutdown();
        try
        {
            server.awaitTermination();
        } catch (InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
