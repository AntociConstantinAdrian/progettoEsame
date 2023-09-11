package progettoCartella;
import PatternCommand.AggiungiVolo;
import PatternMediator.BottoneASServer;
import javax.swing.*;
import java.awt.*;
public class Main
{
    private static int porta=8989;
    private static String ind="localhost";
    public static void main(String[] args)
    {
        /*Inserisco il frame principale */
        JFrame frame=new JFrame("Server-Voli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,720);

        /*Inserisco i Bottoni e le caselle di testo necessarie*/
        JButton accendiButton=new JButton("Accendi-Server");
        JButton spegniButton=new JButton("Spegni-Server");
        JButton aggiungiVoloButton=new JButton("Aggiungi Volo");
        JTextField partenzaText=new JTextField();
        JTextField destinazioneText=new JTextField();
        JTextField dataText=new JTextField();

        /*Uso un JPanel per aggiungere i bottoni*/
        JPanel panelButton=new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.add(accendiButton);
        panelButton.add(spegniButton);
        panelButton.add(aggiungiVoloButton);

        /*Uso un JPanel per aggiungere le mie caselle di testo*/
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Inserisci partenza:"));
        panel.add(partenzaText);
        panel.add(new JLabel("Inserisci destinazione:"));
        panel.add(destinazioneText);
        panel.add(new JLabel("Inserisci data:"));
        panel.add(dataText);
        /*Per aggiungere il pannello al frame*/
        frame.add(panelButton,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.CENTER);

        BottoneASServer ap=new BottoneASServer(accendiButton,spegniButton,porta,ind);
        AggiungiVolo agv=new AggiungiVolo();
        agv.setDataText(dataText);
        agv.setDestinazioneText(destinazioneText);
        agv.setPartenzaText(partenzaText);
        agv.setSalva(aggiungiVoloButton);
        /*Assoccio i bottoni di accensione e spegnimento al loro notificatore*/
        accendiButton.addActionListener(dull->ap.notify(accendiButton));
        spegniButton.addActionListener(dull->ap.notify(spegniButton));
        aggiungiVoloButton.addActionListener(dull->agv.notify(aggiungiVoloButton));
        partenzaText.addActionListener(dull->agv.notify(partenzaText));
        destinazioneText.addActionListener(dull->agv.notify(destinazioneText));
        dataText.addActionListener(dull->agv.notify(dataText));

        /*All'Inizio solo il bottone di accensione puo' essere premuto*/
        accendiButton.setEnabled(true);
        aggiungiVoloButton.setEnabled(false);
        spegniButton.setEnabled(false);

        /*Per mostrare il frame*/
        frame.setVisible(true);


    }
}