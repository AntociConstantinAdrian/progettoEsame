package progettoCartella;
import PatternMediator.SelezionaOperazione;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static int porta=8989;
    private static String ind="localhost";
    public static void main(String[] args)
    {
        /*Per il Login*/
        JTextField nomeText=new JTextField();
        JTextField cognomeText=new JTextField();
        JTextField dataNascitaText=new JTextField();
        JTextField codiceFiscaleText=new JTextField();
        JTextField indirizzoText=new JTextField();
        JTextField indirizzoEmailText=new JTextField();
        /*Bottone accedi per il "login"*/
        JButton accediLog=new JButton("Accedi");

        JFrame FrameAccesso=new JFrame("Client-Login");
        FrameAccesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameAccesso.setSize(520,320);
        JPanel pannelloAccesso=new JPanel();
        pannelloAccesso.setLayout(new GridLayout(8,2));
        pannelloAccesso.add(new JLabel("Inserisci nome"));
        pannelloAccesso.add(nomeText);
        pannelloAccesso.add(new JLabel("Inserisci cognome"));
        pannelloAccesso.add(cognomeText);
        pannelloAccesso.add(new JLabel("Inserisci data di Nascita [gg-MM-AA]"));
        pannelloAccesso.add(dataNascitaText);
        pannelloAccesso.add(new JLabel("Inserisci codiceFiscale"));
        pannelloAccesso.add(codiceFiscaleText);
        pannelloAccesso.add(new JLabel("Inserisci indirizzo"));
        pannelloAccesso.add(indirizzoText);
        pannelloAccesso.add(new JLabel("Inserisci indirizzo-Email"));
        pannelloAccesso.add(indirizzoEmailText);

        JPanel panelloBot=new JPanel();
        panelloBot.add(accediLog);
        FrameAccesso.add(accediLog);
        FrameAccesso.add(pannelloAccesso,BorderLayout.NORTH);
        FrameAccesso.setVisible(true);
        accediLog.setEnabled(false);

        JFrame frame=new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,720);
        frame.setVisible(false);
        /*Per prima cosa devo creare un frame per il Login */
        JButton accedi=new JButton("Accedi");
        /*Per seconda cosa creo un frame con un bottone che mi mostra i voli*/
        JButton mostra1=new JButton("Mostra-Voli");
        /*Per la prenotazione*/
        /*Cerco il volo*/
        JTextField partenzaText=new JTextField();
        JTextField destinazioneText=new JTextField();
        JTextField dataText=new JTextField();
        JTextField modificaDataText=new JTextField();
        JTextField codspec=new JTextField();
        /*Bottone salva prenotazione*/
        JButton salvaPren=new JButton("Salva-Prenotazione");
        /*Bottone per la modifica*/
        JButton modificaPrenotazione=new JButton("Modifica-Volo");
        /*Bottone per vedere i propri voli*/
        JButton vediVoliT=new JButton("Voli-Tuoi");
        /*Bottone per la notifica*/
        JButton notifica=new JButton("Notifiche");
        /*Programma Fedelta'*/
        JButton progf=new JButton("Iscriviti");
        /*Estratto Conto*/
        JButton estratto=new JButton("Estratto-Conto");

        /*Uso un JPanel*/
        JPanel panel=new JPanel();
        panel.add(accedi, BorderLayout.NORTH);
        panel.add(mostra1,BorderLayout.NORTH);
        panel.add(salvaPren,BorderLayout.NORTH);
        panel.add(modificaPrenotazione,BorderLayout.NORTH);
        panel.add(vediVoliT,BorderLayout.NORTH);
        panel.add(notifica,BorderLayout.NORTH);
        panel.add(progf,BorderLayout.NORTH);
        panel.add(estratto,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.NORTH);


        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(5, 2));
        panel1.add(new JLabel("Inserisci Partenza"));
        panel1.add(partenzaText);
        panel1.add(new JLabel("Inserisci Destinazione"));
        panel1.add(destinazioneText);
        panel1.add(new JLabel("Inserisci Data[Day-Month-Year Hours-Minutes]"));
        panel1.add(dataText);
        panel1.add(new JLabel("Inserisci Data Modificata"));
        panel1.add(modificaDataText);
        panel1.add(new JLabel("Inserisci codice Speciale(Per chi fa parte del Programma Fedelta')"));
        panel1.add(codspec);
        frame.add(panel1,BorderLayout.CENTER);


        SelezionaOperazione sel=new SelezionaOperazione(FrameAccesso,frame,estratto,progf,notifica,mostra1,accedi,vediVoliT,salvaPren,accediLog,modificaPrenotazione,codspec,partenzaText,destinazioneText,dataText,modificaDataText,nomeText,cognomeText,dataNascitaText,codiceFiscaleText,indirizzoText,indirizzoEmailText,porta,ind);
        accediLog.addActionListener(dull->sel.notify(accediLog));
        accedi.addActionListener(dull->sel.notify(accedi));
        mostra1.addActionListener(dull->sel.notify(mostra1));
        salvaPren.addActionListener(dull->sel.notify(salvaPren));
        partenzaText.addActionListener(dull->sel.notify(partenzaText));
        destinazioneText.addActionListener(dull->sel.notify(destinazioneText));
        dataText.addActionListener(dull->sel.notify(dataText));
        modificaDataText.addActionListener(dull->sel.notify(modificaDataText));
        nomeText.addActionListener(dull->sel.notify(nomeText));
        cognomeText.addActionListener(dull->sel.notify(cognomeText));
        dataNascitaText.addActionListener(dull->sel.notify(dataNascitaText));
        codiceFiscaleText.addActionListener(dull->sel.notify(codiceFiscaleText));
        indirizzoText.addActionListener(dull->sel.notify(indirizzoText));
        indirizzoEmailText.addActionListener(dull->sel.notify(indirizzoEmailText));
        vediVoliT.addActionListener(dull->sel.notify(vediVoliT));
        notifica.addActionListener(dull->sel.notify(notifica));
        progf.addActionListener(dull->sel.notify(progf));
        codspec.addActionListener(dull->sel.notify(codspec));
        estratto.addActionListener(dull->sel.notify(estratto));
        modificaPrenotazione.addActionListener(dul->sel.notify(modificaPrenotazione));

        mostra1.setEnabled(false);
        salvaPren.setEnabled(false);
        vediVoliT.setEnabled(false);
        notifica.setEnabled(false);
        progf.setEnabled(false);
        estratto.setEnabled(false);
        modificaPrenotazione.setEnabled(false);
    }
}
