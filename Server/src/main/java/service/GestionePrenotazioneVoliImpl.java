package service;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;
import proto.Operazioni.*;
import proto.GestionePrenotazioniVoliGrpc.*;
public class GestionePrenotazioneVoliImpl extends GestionePrenotazioniVoliImplBase {
    /*IN QUESTA LISTA MI PRENDO TUTTI I VOLI PRESENTI AGGIUNTI DAL SERVER*/
    private static List<Volo> voliPresenti = Collections.synchronizedList(new LinkedList<>());
    /*QUESTA MAPPA PER OGNI VOLO MI TIENE TRACCIA DEI CLIENTI CHE LO HANNO PRENOTATO*/
    private static Map<Volo, List<Cliente>> listaVoli = Collections.synchronizedMap(new HashMap<Volo, List<Cliente>>());
    private static List<Cliente> clienti = Collections.synchronizedList(new LinkedList<Cliente>());
    /*QUESTA MAPPA MI REGISTRA I CLIENTI FEDELTA*/
    private static Map<Cliente, Map<Integer, List<EstrattoConto>>> clientiFedelta = Collections.synchronizedMap(new HashMap<>());

    public GestionePrenotazioneVoliImpl() {
        /*Il costruttore mi richiama i metodi per riempire le varie mappe */
        super();
        caricaDaFileJsonClientiFedelta();//Riempie clientiFedelta.
        caricaDaFileJsonListaVoli();//Riempie listaVoli
        recuperaPersistenzaVoli();//Riempie voliPresenti
    }

    /**
     * Inserisco qui i metodi di utilita'
     */

    /*Questo metodo controlla la data dei voli per vedere se mancano meno di num giorni*/
    public static boolean controllaDataVolo(Timestamp dataVoloTimestamp, int num) {
        Instant instantDataVolo = Instant.ofEpochSecond(dataVoloTimestamp.getSeconds(), dataVoloTimestamp.getNanos());
        LocalDate dataVoloLocalDate = instantDataVolo.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate oggi = LocalDate.now();
        long giorniMancanti = ChronoUnit.DAYS.between(oggi, dataVoloLocalDate);
        if (giorniMancanti <= num) {
            return true;
        }
        return false;
    }

    public static void setVolo(Volo volo) {
        if (voliPresenti == null) {
            voliPresenti = new ArrayList<>();
        }
        voliPresenti.add(volo);
        aggiungiVoliAFileJson();
    }

    public static void aggiungiVoliAFileJson() {
        Gson gson = new Gson();
        String filePath = "C:\\ProgettoIngegneriaAntoci\\Server\\src\\main\\java\\fileJson\\VoliJson.json";
        //Voli voli=Voli.newBuilder().addAllVoli(voliPresenti).build();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            gson.toJson(voliPresenti, fileWriter);
            System.out.println("Voli aggiunti al file JSON con successo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Volo> deserializzaVoliDaFileJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Volo>>() {
            }.getType();
            List<Volo> voli = gson.fromJson(reader, listType);
            return voli;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
   /* public static Voli fromJsonFileVoli(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(reader, Voli.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    private static void recuperaPersistenzaVoli() //viene richiamato dal costruttore quindi non c'è bisogno di utilizzare blocchi synchronizzati
    {
        String filePath = "C:\\ProgettoIngegneriaAntoci\\Server\\src\\main\\java\\fileJson\\VoliJson.json";
        //Voli voli=fromJsonFileVoli(filePath);
       /* for(int i=0;i<voli.getVoliCount();i++)
        {
            if(controllaDataVolo(voli.getVoli(i).getData()))
            {
                voliPresenti.add(voli.getVoli(i));
               System.out.println(voliPresenti.get(i).getPartenza());
            }
        }*/
        voliPresenti = deserializzaVoliDaFileJson(filePath);
    }//recuperaPersistenzaAppelliPrevisti

    public void caricaDaFileJsonListaVoli() {
        Gson gson = new Gson();
        String prenotazioniFilePath = "C:\\ProgettoIngegneriaAntoci\\Server\\src\\main\\java\\fileJson\\PrenotazioniVoli.json";

        try (Reader prenotazioniReader = new FileReader(prenotazioniFilePath)) {
            JsonObject prenotazioniJsonObject = gson.fromJson(prenotazioniReader, JsonObject.class);

            if (prenotazioniJsonObject.has("prenotazione_")) {
                JsonArray prenotazioniJsonArray = prenotazioniJsonObject.getAsJsonArray("prenotazione_");

                for (JsonElement prenotazioneElement : prenotazioniJsonArray) {
                    JsonObject prenotazioneObject = prenotazioneElement.getAsJsonObject();

                    Volo volo = gson.fromJson(prenotazioneObject.getAsJsonObject("volo_"), Volo.class);
                    Cliente cliente = gson.fromJson(prenotazioneObject.getAsJsonObject("cliente_"), Cliente.class);
                    listaVoli.computeIfAbsent(volo, k -> new ArrayList<>()).add(cliente);
                }
            } else {
                // Il file JSON delle prenotazioni è vuoto.
                System.out.println("Il file JSON delle prenotazioni è vuoto.");
                // Esegui altre azioni o gestisci il caso vuoto come desideri.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scriviSuFileJson(Prenotazioni pren, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(pren, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scriviSuFileJsonClientiFedelta(DatiClientiFedelta dati) {
        String filePath = "C:\\ProgettoIngegneriaAntoci\\Server\\src\\main\\java\\fileJson\\ProgrammaFedelta.json"; // Specifica il percorso del tuo file JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        for (int i = 0; i < dati.getDatiCount(); i++) {
            System.out.println(dati.getDati(i).getCliente().getNome());
        }
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(dati, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaDaFileJsonClientiFedelta() {
        String filePath = "C:\\ProgettoIngegneriaAntoci\\Server\\src\\main\\java\\fileJson\\ProgrammaFedelta.json";
        Gson gson = new Gson();
        try (Reader datiReader = new FileReader(filePath)) {
            JsonObject datiJsonObject = gson.fromJson(datiReader, JsonObject.class);

            if (datiJsonObject.has("dati_")) {
                JsonArray datiJsonArray = datiJsonObject.getAsJsonArray("dati_");

                for (JsonElement datiElement : datiJsonArray) {
                    JsonObject datiObject = datiElement.getAsJsonObject();

                    int codiceSegreto = datiObject.get("codiceSegreto_").getAsInt();
                    Cliente cliente = gson.fromJson(datiObject.getAsJsonObject("cliente_"), Cliente.class);
                    Map<Integer, List<EstrattoConto>> mappaInterna = new HashMap<>();
                    if (datiObject.has("estratti_")) {
                        JsonObject estrattiObject = datiObject.getAsJsonObject("estratti_");
                        JsonArray estrattiArray = estrattiObject.getAsJsonArray("estrattoConto_");
                        List<EstrattoConto> es = new LinkedList<>();
                        for (JsonElement estrattoElement : estrattiArray) {
                            EstrattoConto estrattoConto = gson.fromJson(estrattoElement.getAsJsonObject(), EstrattoConto.class);
                            es.add(estrattoConto);
                        }
                        mappaInterna.put(codiceSegreto, es);
                    }
                    System.out.println(cliente.getNome() + " Aggiunto");
                    clientiFedelta.put(cliente, mappaInterna);
                }
            } else {
                // Il file JSON delle prenotazioni è vuoto.
                System.out.println("Il file JSON delle prenotazioni è vuoto.");
                // Esegui altre azioni o gestisci il caso vuoto come desideri.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aggiornaProgrammaFedeltaJson() {
        List<DatiClienteFedelta> listaDati = new ArrayList<>();

        synchronized (clientiFedelta) {
            for (Map.Entry<Cliente, Map<Integer, List<EstrattoConto>>> entry : clientiFedelta.entrySet()) {
                Cliente cliente = entry.getKey();
                Map<Integer, List<EstrattoConto>> mappaInterna2 = entry.getValue();

                List<DatiClienteFedelta> listaDatiCliente = new ArrayList<>();
                synchronized (mappaInterna2) {
                    for (Map.Entry<Integer, List<EstrattoConto>> entry2 : mappaInterna2.entrySet()) {
                        Estratti estratti = Estratti.newBuilder().addAllEstrattoConto(entry2.getValue()).build();
                        DatiClienteFedelta dato = DatiClienteFedelta.newBuilder()
                                .setCliente(cliente)
                                .setCodiceSegreto(entry2.getKey())
                                .setEstratti(estratti)
                                .build();
                        listaDatiCliente.add(dato);
                    }
                }

                listaDati.addAll(listaDatiCliente);
            }
        }

        DatiClientiFedelta dati = DatiClientiFedelta.newBuilder().addAllDati(listaDati).build();
        scriviSuFileJsonClientiFedelta(dati);
    }

    @Override
    public void iscrizioneProgrammaFedelta(Cliente request, StreamObserver<Informazione> responseObserver) {
        Informazione esito;
        if (clientiFedelta == null) {
            /*Caso in cui ancora non si e' registrato nessuno per essere un cliente Fedelta
            quindi avro' una mappa nulla non inizializzata*/
            clientiFedelta = new HashMap<>();
        }
        /*Se e' vuota significa che vi e'presente il cliente come chiave se non e' vuota e il cliente non c'e' fa le istruzioni
         * all'interno dell'IF*/
        if (!clientiFedelta.containsKey(request)) {
            Random random = new Random();
            int codiceCasuale = random.nextInt(Integer.MAX_VALUE / 10000);//Genero codice casuale segreto
            boolean trovato = true;
            /*Il While  serve per vedere se quel codice e' unico*/
            while (trovato == true) {
                trovato = false;
                for (Map.Entry<Cliente, Map<Integer, List<EstrattoConto>>> entry : clientiFedelta.entrySet()) {
                    if (entry.getValue().containsKey(codiceCasuale)) {
                        trovato = true;
                    }
                }
                if (trovato == true) {
                    codiceCasuale = random.nextInt(Integer.MAX_VALUE / 10000);
                }
            }
            /*Inserisco tutto nella mappa*/
            HashMap<Integer, List<EstrattoConto>> mappaInterna = new HashMap<>();
            mappaInterna.put(codiceCasuale, new ArrayList<>());
            clientiFedelta.put(request, mappaInterna);
            aggiornaProgrammaFedeltaJson();
            esito = Informazione.newBuilder().setMes("Iscrizione avvenuta con successo, ecco il codice" + codiceCasuale).build();
            responseObserver.onNext(esito);

        } else {
            esito = Informazione.newBuilder().setMes("Errore oppure sei gia' Iscritto").build();
            responseObserver.onNext(esito);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void accumulaPuntiFedelta(DatiPunti request, StreamObserver<Informazione> responseObserver) {
        if (clientiFedelta.containsKey(request.getCliente())) {
            Map<Integer, List<EstrattoConto>> lista = clientiFedelta.get(request.getCliente());
            if (lista.containsKey(request.getCodiceSegreto())) {
                Random random = new Random();
                int punti = random.nextInt(100);
                EstrattoConto esc = EstrattoConto.newBuilder().setVolo(request.getVolo()).setPuntiAccumulati(punti).build();
                List<EstrattoConto> est = lista.get(request.getCodiceSegreto());
                if (est == null) {
                    est = new ArrayList<EstrattoConto>();
                }
                est.add(esc);
                lista.put(request.getCodiceSegreto(), est);
                aggiornaProgrammaFedeltaJson();
                Informazione esito = Informazione.newBuilder().setMes("Successo punti aggiunti").build();
                responseObserver.onNext(esito);

            }
            clientiFedelta.put(request.getCliente(), lista);
        } else {
            Informazione esito = Informazione.newBuilder().setMes("Errore Accumula-Punti").build();
            responseObserver.onNext(esito);
        }
        responseObserver.onCompleted();
    }

    /**
     *
     */
    @Override
    public void estrattoContoFedelta(Cliente request, StreamObserver<Estratti> responseObserver) {
        Estratti estratti = null;
        synchronized (clientiFedelta) {
            Map<Integer, List<EstrattoConto>> mappaFedelta = clientiFedelta.get(request);
            if (mappaFedelta == null) {
                mappaFedelta = new HashMap<>();
            }
            System.out.println("Sono qui GSONFEDELTA");
            for (Map.Entry<Integer, List<EstrattoConto>> entry : mappaFedelta.entrySet()) {
                if (entry.getValue() != null) {
                    estratti = Estratti.newBuilder().addAllEstrattoConto(entry.getValue()).build();
                }

            }
        }
        responseObserver.onNext(estratti);
        responseObserver.onCompleted();
    }

    @Override
    public void subscribe(Cliente request, StreamObserver<Informazione> responseObserver) {
        if (clienti.contains(request)) {
            Informazione info = Informazione.newBuilder().setMes("Presente").build();
            responseObserver.onNext(info);
            System.out.println(info.getMes() + " " + request.getCognome());
        } else {
            synchronized (clienti) {
                clienti.add(request);
            }
            Informazione info = Informazione.newBuilder().setMes("Aggiunto").build();
            responseObserver.onNext(info);
            System.out.println(info.getMes() + " " + request.getCognome());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void dammiTuttiVoli(Cliente request, StreamObserver<Voli> responseObserver) {

        Voli.Builder voliBuilder = Voli.newBuilder(); // Crea un nuovo builder
        // Assicurati che voliPresenti sia una collezione valida (ad esempio, una List)
        if (voliPresenti != null) {
            voliBuilder.addAllVoli(voliPresenti); // Aggiungi gli elementi dalla collezione
        }

        Voli voli = voliBuilder.build(); // Costruisci l'oggetto Voli

        responseObserver.onNext(voli);
        responseObserver.onCompleted();


    }

    @Override
    public void inviaNotifica(Cliente request, StreamObserver<Informazione> responseObserver) {
        String mes = "Benvenuto " + request.getCognome() + " " + request.getNome();

        for (int i = 0; i < voliPresenti.size(); i++) {
            if (controllaDataVolo(voliPresenti.get(i).getData(), 3)) {
                mes = " Per il volo: " + voliPresenti.get(i).getPartenza() + "-" + voliPresenti.get(i).getDestinazione() + "mancano meno di 3 giorni";
            }
        }
        Informazione info = Informazione.newBuilder().setMes(mes).build();
        responseObserver.onNext(info);
        responseObserver.onCompleted();
    }

    @Override
    public void dammiMieiVoli(Cliente request, StreamObserver<Voli> responseObserver) {
        List<Volo> voliC = new ArrayList<>();

        for (Map.Entry<Volo, List<Cliente>> entry : listaVoli.entrySet()) {
            List<Cliente> clientiDelVolo = entry.getValue();
            if (clientiDelVolo.contains(request)) {
                voliC.add(entry.getKey());
            }
        }

        Voli response = Voli.newBuilder().addAllVoli(voliC).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void prenotaVolo(Prenotazione request, StreamObserver<Esito> responseObserver) {
        Esito esito = Esito.newBuilder().setEsito(BoolValue.of(false)).build();
        ;

        if (voliPresenti.contains(request.getVolo())) {
            if (!listaVoli.containsKey(request.getVolo())) {
                listaVoli.put(request.getVolo(), new ArrayList<>());
            }
            List<Cliente> cliente = listaVoli.get(request.getVolo());
            cliente.add(request.getCliente());
            listaVoli.put(request.getVolo(), cliente);
            String filePath = "C:\\ProgettoIngegneriaAntoci\\Server\\src\\main\\java\\fileJson\\PrenotazioniVoli.json";
            List<Prenotazione> listaPrenotazioni = new ArrayList<>();
            for (Map.Entry<Volo, List<Cliente>> entry : listaVoli.entrySet()) {

                for (int i = 0; i < entry.getValue().size(); i++) {
                    Prenotazione pren = Prenotazione.newBuilder().setCliente(entry.getValue().get(i)).setVolo(entry.getKey()).build();
                    listaPrenotazioni.add(pren);
                }
            }
            Prenotazioni pren = Prenotazioni.newBuilder().addAllPrenotazione(listaPrenotazioni).build();
            scriviSuFileJson(pren, filePath);
            esito = Esito.newBuilder().setEsito(BoolValue.of(true)).build();
        }
        responseObserver.onNext(esito);
        responseObserver.onCompleted();
    }

    /**
     *
     */
    @Override
    public void modificaPrenotazione(RichiestaModificaVolo request, StreamObserver<Esito> responseObserver) {
        Volo volovecchio = request.getVolo();
        Timestamp dataNuova = request.getDataMod();
        Volo.Builder voloNuovo = Volo.newBuilder();
        synchronized (listaVoli) {
            for (Map.Entry<Volo, List<Cliente>> entry : listaVoli.entrySet()) {
                List<Cliente> clientiVoli = entry.getValue();
                synchronized (clientiVoli) {
                    if (entry.getKey().getDestinazione().equals(volovecchio.getDestinazione()) && entry.getKey().getPartenza().equals(volovecchio.getPartenza()) && entry.getKey().getData().getSeconds() == dataNuova.getSeconds()) {
                         clientiVoli.add(request.getCliente());
                    }
                }
            }
            synchronized (voliPresenti) {
                for (int i = 0; i < voliPresenti.size(); i++) {
                    if (voliPresenti.get(i).getPartenza().equals(volovecchio.getPartenza()) && voliPresenti.get(i).getDestinazione().equals(volovecchio.getDestinazione()) && voliPresenti.get(i).getData().getSeconds() == dataNuova.getSeconds()) {
                        voloNuovo.setPartenza(voliPresenti.get(i).getPartenza()).setDestinazione(voliPresenti.get(i).getDestinazione()).setData(dataNuova).build();
                    }
                }
            }
            synchronized (clientiFedelta) {
                for (Map.Entry<Cliente, Map<Integer, List<EstrattoConto>>> entry : clientiFedelta.entrySet()) {
                    if (entry.getKey().getCognome().equals(request.getCliente().getCognome())) {
                        System.out.println("il cliente c'e'");
                        Map<Integer, List<EstrattoConto>> mappaInterna = entry.getValue();
                        synchronized (mappaInterna) {
                            for (Map.Entry<Integer, List<EstrattoConto>> entry1 : mappaInterna.entrySet()) {
                                List<EstrattoConto> mappaVoli = entry1.getValue();
                                synchronized (mappaVoli) {
                                    for (int i = 0; i < mappaVoli.size(); i++) {
                                        if (mappaVoli.get(i).getVolo().getPartenza().equals(volovecchio.getPartenza()) && mappaVoli.get(i).getVolo().getData().getSeconds()==volovecchio.getData().getSeconds() && mappaVoli.get(i).getVolo().getDestinazione().equals(volovecchio.getDestinazione())) {
                                            int punti = mappaVoli.get(i).getPuntiAccumulati();
                                            mappaVoli.remove(i);
                                            EstrattoConto estrattoConto = EstrattoConto.newBuilder().setVolo(voloNuovo).setPuntiAccumulati(punti).build();
                                            mappaVoli.add(estrattoConto);
                                            System.out.println("ci siamo");
                                            break;
                                        }
                                    }
                                    mappaInterna.put(entry1.getKey(), mappaVoli);
                                    clientiFedelta.put(request.getCliente(), mappaInterna);
                                    break;
                                }
                            }

                        }
                    }
                }
            }
            aggiornaProgrammaFedeltaJson();
            Esito esitoPositivo = Esito.newBuilder().setEsito(BoolValue.of(true)).build();
            responseObserver.onNext(esitoPositivo);
            responseObserver.onCompleted();
        }
    }
}
