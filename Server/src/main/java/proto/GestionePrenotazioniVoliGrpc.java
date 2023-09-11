package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: operazioni.proto")
public final class GestionePrenotazioniVoliGrpc {

  private GestionePrenotazioniVoliGrpc() {}

  public static final String SERVICE_NAME = "GestionePrenotazioniVoli";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Informazione> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = Operazioni.Cliente.class,
      responseType = Operazioni.Informazione.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Informazione> getSubscribeMethod() {
    io.grpc.MethodDescriptor<Operazioni.Cliente, Operazioni.Informazione> getSubscribeMethod;
    if ((getSubscribeMethod = GestionePrenotazioniVoliGrpc.getSubscribeMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getSubscribeMethod = GestionePrenotazioniVoliGrpc.getSubscribeMethod) == null) {
          GestionePrenotazioniVoliGrpc.getSubscribeMethod = getSubscribeMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Cliente, Operazioni.Informazione>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Cliente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Informazione.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("subscribe"))
                  .build();
          }
        }
     }
     return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Informazione> getInviaNotificaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "inviaNotifica",
      requestType = Operazioni.Cliente.class,
      responseType = Operazioni.Informazione.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Informazione> getInviaNotificaMethod() {
    io.grpc.MethodDescriptor<Operazioni.Cliente, Operazioni.Informazione> getInviaNotificaMethod;
    if ((getInviaNotificaMethod = GestionePrenotazioniVoliGrpc.getInviaNotificaMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getInviaNotificaMethod = GestionePrenotazioniVoliGrpc.getInviaNotificaMethod) == null) {
          GestionePrenotazioniVoliGrpc.getInviaNotificaMethod = getInviaNotificaMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Cliente, Operazioni.Informazione>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "inviaNotifica"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Cliente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Informazione.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("inviaNotifica"))
                  .build();
          }
        }
     }
     return getInviaNotificaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Voli> getDammiTuttiVoliMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dammiTuttiVoli",
      requestType = Operazioni.Cliente.class,
      responseType = Operazioni.Voli.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Voli> getDammiTuttiVoliMethod() {
    io.grpc.MethodDescriptor<Operazioni.Cliente, Operazioni.Voli> getDammiTuttiVoliMethod;
    if ((getDammiTuttiVoliMethod = GestionePrenotazioniVoliGrpc.getDammiTuttiVoliMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getDammiTuttiVoliMethod = GestionePrenotazioniVoliGrpc.getDammiTuttiVoliMethod) == null) {
          GestionePrenotazioniVoliGrpc.getDammiTuttiVoliMethod = getDammiTuttiVoliMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Cliente, Operazioni.Voli>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "dammiTuttiVoli"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Cliente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Voli.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("dammiTuttiVoli"))
                  .build();
          }
        }
     }
     return getDammiTuttiVoliMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Voli> getDammiMieiVoliMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dammiMieiVoli",
      requestType = Operazioni.Cliente.class,
      responseType = Operazioni.Voli.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Voli> getDammiMieiVoliMethod() {
    io.grpc.MethodDescriptor<Operazioni.Cliente, Operazioni.Voli> getDammiMieiVoliMethod;
    if ((getDammiMieiVoliMethod = GestionePrenotazioniVoliGrpc.getDammiMieiVoliMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getDammiMieiVoliMethod = GestionePrenotazioniVoliGrpc.getDammiMieiVoliMethod) == null) {
          GestionePrenotazioniVoliGrpc.getDammiMieiVoliMethod = getDammiMieiVoliMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Cliente, Operazioni.Voli>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "dammiMieiVoli"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Cliente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Voli.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("dammiMieiVoli"))
                  .build();
          }
        }
     }
     return getDammiMieiVoliMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.Prenotazione,
      Operazioni.Esito> getPrenotaVoloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrenotaVolo",
      requestType = Operazioni.Prenotazione.class,
      responseType = Operazioni.Esito.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Prenotazione,
      Operazioni.Esito> getPrenotaVoloMethod() {
    io.grpc.MethodDescriptor<Operazioni.Prenotazione, Operazioni.Esito> getPrenotaVoloMethod;
    if ((getPrenotaVoloMethod = GestionePrenotazioniVoliGrpc.getPrenotaVoloMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getPrenotaVoloMethod = GestionePrenotazioniVoliGrpc.getPrenotaVoloMethod) == null) {
          GestionePrenotazioniVoliGrpc.getPrenotaVoloMethod = getPrenotaVoloMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Prenotazione, Operazioni.Esito>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "PrenotaVolo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Prenotazione.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Esito.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("PrenotaVolo"))
                  .build();
          }
        }
     }
     return getPrenotaVoloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.RichiestaModificaVolo,
      Operazioni.Esito> getModificaPrenotazioneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModificaPrenotazione",
      requestType = Operazioni.RichiestaModificaVolo.class,
      responseType = Operazioni.Esito.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.RichiestaModificaVolo,
      Operazioni.Esito> getModificaPrenotazioneMethod() {
    io.grpc.MethodDescriptor<Operazioni.RichiestaModificaVolo, Operazioni.Esito> getModificaPrenotazioneMethod;
    if ((getModificaPrenotazioneMethod = GestionePrenotazioniVoliGrpc.getModificaPrenotazioneMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getModificaPrenotazioneMethod = GestionePrenotazioniVoliGrpc.getModificaPrenotazioneMethod) == null) {
          GestionePrenotazioniVoliGrpc.getModificaPrenotazioneMethod = getModificaPrenotazioneMethod = 
              io.grpc.MethodDescriptor.<Operazioni.RichiestaModificaVolo, Operazioni.Esito>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "ModificaPrenotazione"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.RichiestaModificaVolo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Esito.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("ModificaPrenotazione"))
                  .build();
          }
        }
     }
     return getModificaPrenotazioneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Informazione> getIscrizioneProgrammaFedeltaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IscrizioneProgrammaFedelta",
      requestType = Operazioni.Cliente.class,
      responseType = Operazioni.Informazione.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Informazione> getIscrizioneProgrammaFedeltaMethod() {
    io.grpc.MethodDescriptor<Operazioni.Cliente, Operazioni.Informazione> getIscrizioneProgrammaFedeltaMethod;
    if ((getIscrizioneProgrammaFedeltaMethod = GestionePrenotazioniVoliGrpc.getIscrizioneProgrammaFedeltaMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getIscrizioneProgrammaFedeltaMethod = GestionePrenotazioniVoliGrpc.getIscrizioneProgrammaFedeltaMethod) == null) {
          GestionePrenotazioniVoliGrpc.getIscrizioneProgrammaFedeltaMethod = getIscrizioneProgrammaFedeltaMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Cliente, Operazioni.Informazione>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "IscrizioneProgrammaFedelta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Cliente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Informazione.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("IscrizioneProgrammaFedelta"))
                  .build();
          }
        }
     }
     return getIscrizioneProgrammaFedeltaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.DatiPunti,
      Operazioni.Informazione> getAccumulaPuntiFedeltaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccumulaPuntiFedelta",
      requestType = Operazioni.DatiPunti.class,
      responseType = Operazioni.Informazione.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.DatiPunti,
      Operazioni.Informazione> getAccumulaPuntiFedeltaMethod() {
    io.grpc.MethodDescriptor<Operazioni.DatiPunti, Operazioni.Informazione> getAccumulaPuntiFedeltaMethod;
    if ((getAccumulaPuntiFedeltaMethod = GestionePrenotazioniVoliGrpc.getAccumulaPuntiFedeltaMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getAccumulaPuntiFedeltaMethod = GestionePrenotazioniVoliGrpc.getAccumulaPuntiFedeltaMethod) == null) {
          GestionePrenotazioniVoliGrpc.getAccumulaPuntiFedeltaMethod = getAccumulaPuntiFedeltaMethod = 
              io.grpc.MethodDescriptor.<Operazioni.DatiPunti, Operazioni.Informazione>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "AccumulaPuntiFedelta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.DatiPunti.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Informazione.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("AccumulaPuntiFedelta"))
                  .build();
          }
        }
     }
     return getAccumulaPuntiFedeltaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Estratti> getEstrattoContoFedeltaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EstrattoContoFedelta",
      requestType = Operazioni.Cliente.class,
      responseType = Operazioni.Estratti.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Operazioni.Cliente,
      Operazioni.Estratti> getEstrattoContoFedeltaMethod() {
    io.grpc.MethodDescriptor<Operazioni.Cliente, Operazioni.Estratti> getEstrattoContoFedeltaMethod;
    if ((getEstrattoContoFedeltaMethod = GestionePrenotazioniVoliGrpc.getEstrattoContoFedeltaMethod) == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        if ((getEstrattoContoFedeltaMethod = GestionePrenotazioniVoliGrpc.getEstrattoContoFedeltaMethod) == null) {
          GestionePrenotazioniVoliGrpc.getEstrattoContoFedeltaMethod = getEstrattoContoFedeltaMethod = 
              io.grpc.MethodDescriptor.<Operazioni.Cliente, Operazioni.Estratti>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GestionePrenotazioniVoli", "EstrattoContoFedelta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Cliente.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Operazioni.Estratti.getDefaultInstance()))
                  .setSchemaDescriptor(new GestionePrenotazioniVoliMethodDescriptorSupplier("EstrattoContoFedelta"))
                  .build();
          }
        }
     }
     return getEstrattoContoFedeltaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GestionePrenotazioniVoliStub newStub(io.grpc.Channel channel) {
    return new GestionePrenotazioniVoliStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GestionePrenotazioniVoliBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GestionePrenotazioniVoliBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GestionePrenotazioniVoliFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GestionePrenotazioniVoliFutureStub(channel);
  }

  /**
   */
  public static abstract class GestionePrenotazioniVoliImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Devo vedere i voli per prima cosa
     * </pre>
     */
    public void subscribe(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void inviaNotifica(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnimplementedUnaryCall(getInviaNotificaMethod(), responseObserver);
    }

    /**
     */
    public void dammiTuttiVoli(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Voli> responseObserver) {
      asyncUnimplementedUnaryCall(getDammiTuttiVoliMethod(), responseObserver);
    }

    /**
     */
    public void dammiMieiVoli(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Voli> responseObserver) {
      asyncUnimplementedUnaryCall(getDammiMieiVoliMethod(), responseObserver);
    }

    /**
     */
    public void prenotaVolo(Operazioni.Prenotazione request,
        io.grpc.stub.StreamObserver<Operazioni.Esito> responseObserver) {
      asyncUnimplementedUnaryCall(getPrenotaVoloMethod(), responseObserver);
    }

    /**
     */
    public void modificaPrenotazione(Operazioni.RichiestaModificaVolo request,
        io.grpc.stub.StreamObserver<Operazioni.Esito> responseObserver) {
      asyncUnimplementedUnaryCall(getModificaPrenotazioneMethod(), responseObserver);
    }

    /**
     */
    public void iscrizioneProgrammaFedelta(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnimplementedUnaryCall(getIscrizioneProgrammaFedeltaMethod(), responseObserver);
    }

    /**
     */
    public void accumulaPuntiFedelta(Operazioni.DatiPunti request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnimplementedUnaryCall(getAccumulaPuntiFedeltaMethod(), responseObserver);
    }

    /**
     */
    public void estrattoContoFedelta(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Estratti> responseObserver) {
      asyncUnimplementedUnaryCall(getEstrattoContoFedeltaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Cliente,
                Operazioni.Informazione>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getInviaNotificaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Cliente,
                Operazioni.Informazione>(
                  this, METHODID_INVIA_NOTIFICA)))
          .addMethod(
            getDammiTuttiVoliMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Cliente,
                Operazioni.Voli>(
                  this, METHODID_DAMMI_TUTTI_VOLI)))
          .addMethod(
            getDammiMieiVoliMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Cliente,
                Operazioni.Voli>(
                  this, METHODID_DAMMI_MIEI_VOLI)))
          .addMethod(
            getPrenotaVoloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Prenotazione,
                Operazioni.Esito>(
                  this, METHODID_PRENOTA_VOLO)))
          .addMethod(
            getModificaPrenotazioneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.RichiestaModificaVolo,
                Operazioni.Esito>(
                  this, METHODID_MODIFICA_PRENOTAZIONE)))
          .addMethod(
            getIscrizioneProgrammaFedeltaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Cliente,
                Operazioni.Informazione>(
                  this, METHODID_ISCRIZIONE_PROGRAMMA_FEDELTA)))
          .addMethod(
            getAccumulaPuntiFedeltaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.DatiPunti,
                Operazioni.Informazione>(
                  this, METHODID_ACCUMULA_PUNTI_FEDELTA)))
          .addMethod(
            getEstrattoContoFedeltaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Operazioni.Cliente,
                Operazioni.Estratti>(
                  this, METHODID_ESTRATTO_CONTO_FEDELTA)))
          .build();
    }
  }

  /**
   */
  public static final class GestionePrenotazioniVoliStub extends io.grpc.stub.AbstractStub<GestionePrenotazioniVoliStub> {
    private GestionePrenotazioniVoliStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GestionePrenotazioniVoliStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GestionePrenotazioniVoliStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GestionePrenotazioniVoliStub(channel, callOptions);
    }

    /**
     * <pre>
     *Devo vedere i voli per prima cosa
     * </pre>
     */
    public void subscribe(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inviaNotifica(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInviaNotificaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dammiTuttiVoli(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Voli> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDammiTuttiVoliMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dammiMieiVoli(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Voli> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDammiMieiVoliMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void prenotaVolo(Operazioni.Prenotazione request,
        io.grpc.stub.StreamObserver<Operazioni.Esito> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPrenotaVoloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modificaPrenotazione(Operazioni.RichiestaModificaVolo request,
        io.grpc.stub.StreamObserver<Operazioni.Esito> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getModificaPrenotazioneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void iscrizioneProgrammaFedelta(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIscrizioneProgrammaFedeltaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accumulaPuntiFedelta(Operazioni.DatiPunti request,
        io.grpc.stub.StreamObserver<Operazioni.Informazione> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAccumulaPuntiFedeltaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void estrattoContoFedelta(Operazioni.Cliente request,
        io.grpc.stub.StreamObserver<Operazioni.Estratti> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEstrattoContoFedeltaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GestionePrenotazioniVoliBlockingStub extends io.grpc.stub.AbstractStub<GestionePrenotazioniVoliBlockingStub> {
    private GestionePrenotazioniVoliBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GestionePrenotazioniVoliBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GestionePrenotazioniVoliBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GestionePrenotazioniVoliBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Devo vedere i voli per prima cosa
     * </pre>
     */
    public Operazioni.Informazione subscribe(Operazioni.Cliente request) {
      return blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Informazione inviaNotifica(Operazioni.Cliente request) {
      return blockingUnaryCall(
          getChannel(), getInviaNotificaMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Voli dammiTuttiVoli(Operazioni.Cliente request) {
      return blockingUnaryCall(
          getChannel(), getDammiTuttiVoliMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Voli dammiMieiVoli(Operazioni.Cliente request) {
      return blockingUnaryCall(
          getChannel(), getDammiMieiVoliMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Esito prenotaVolo(Operazioni.Prenotazione request) {
      return blockingUnaryCall(
          getChannel(), getPrenotaVoloMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Esito modificaPrenotazione(Operazioni.RichiestaModificaVolo request) {
      return blockingUnaryCall(
          getChannel(), getModificaPrenotazioneMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Informazione iscrizioneProgrammaFedelta(Operazioni.Cliente request) {
      return blockingUnaryCall(
          getChannel(), getIscrizioneProgrammaFedeltaMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Informazione accumulaPuntiFedelta(Operazioni.DatiPunti request) {
      return blockingUnaryCall(
          getChannel(), getAccumulaPuntiFedeltaMethod(), getCallOptions(), request);
    }

    /**
     */
    public Operazioni.Estratti estrattoContoFedelta(Operazioni.Cliente request) {
      return blockingUnaryCall(
          getChannel(), getEstrattoContoFedeltaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GestionePrenotazioniVoliFutureStub extends io.grpc.stub.AbstractStub<GestionePrenotazioniVoliFutureStub> {
    private GestionePrenotazioniVoliFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GestionePrenotazioniVoliFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GestionePrenotazioniVoliFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GestionePrenotazioniVoliFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Devo vedere i voli per prima cosa
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Informazione> subscribe(
        Operazioni.Cliente request) {
      return futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Informazione> inviaNotifica(
        Operazioni.Cliente request) {
      return futureUnaryCall(
          getChannel().newCall(getInviaNotificaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Voli> dammiTuttiVoli(
        Operazioni.Cliente request) {
      return futureUnaryCall(
          getChannel().newCall(getDammiTuttiVoliMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Voli> dammiMieiVoli(
        Operazioni.Cliente request) {
      return futureUnaryCall(
          getChannel().newCall(getDammiMieiVoliMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Esito> prenotaVolo(
        Operazioni.Prenotazione request) {
      return futureUnaryCall(
          getChannel().newCall(getPrenotaVoloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Esito> modificaPrenotazione(
        Operazioni.RichiestaModificaVolo request) {
      return futureUnaryCall(
          getChannel().newCall(getModificaPrenotazioneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Informazione> iscrizioneProgrammaFedelta(
        Operazioni.Cliente request) {
      return futureUnaryCall(
          getChannel().newCall(getIscrizioneProgrammaFedeltaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Informazione> accumulaPuntiFedelta(
        Operazioni.DatiPunti request) {
      return futureUnaryCall(
          getChannel().newCall(getAccumulaPuntiFedeltaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Operazioni.Estratti> estrattoContoFedelta(
        Operazioni.Cliente request) {
      return futureUnaryCall(
          getChannel().newCall(getEstrattoContoFedeltaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_INVIA_NOTIFICA = 1;
  private static final int METHODID_DAMMI_TUTTI_VOLI = 2;
  private static final int METHODID_DAMMI_MIEI_VOLI = 3;
  private static final int METHODID_PRENOTA_VOLO = 4;
  private static final int METHODID_MODIFICA_PRENOTAZIONE = 5;
  private static final int METHODID_ISCRIZIONE_PROGRAMMA_FEDELTA = 6;
  private static final int METHODID_ACCUMULA_PUNTI_FEDELTA = 7;
  private static final int METHODID_ESTRATTO_CONTO_FEDELTA = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GestionePrenotazioniVoliImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GestionePrenotazioniVoliImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((Operazioni.Cliente) request,
              (io.grpc.stub.StreamObserver<Operazioni.Informazione>) responseObserver);
          break;
        case METHODID_INVIA_NOTIFICA:
          serviceImpl.inviaNotifica((Operazioni.Cliente) request,
              (io.grpc.stub.StreamObserver<Operazioni.Informazione>) responseObserver);
          break;
        case METHODID_DAMMI_TUTTI_VOLI:
          serviceImpl.dammiTuttiVoli((Operazioni.Cliente) request,
              (io.grpc.stub.StreamObserver<Operazioni.Voli>) responseObserver);
          break;
        case METHODID_DAMMI_MIEI_VOLI:
          serviceImpl.dammiMieiVoli((Operazioni.Cliente) request,
              (io.grpc.stub.StreamObserver<Operazioni.Voli>) responseObserver);
          break;
        case METHODID_PRENOTA_VOLO:
          serviceImpl.prenotaVolo((Operazioni.Prenotazione) request,
              (io.grpc.stub.StreamObserver<Operazioni.Esito>) responseObserver);
          break;
        case METHODID_MODIFICA_PRENOTAZIONE:
          serviceImpl.modificaPrenotazione((Operazioni.RichiestaModificaVolo) request,
              (io.grpc.stub.StreamObserver<Operazioni.Esito>) responseObserver);
          break;
        case METHODID_ISCRIZIONE_PROGRAMMA_FEDELTA:
          serviceImpl.iscrizioneProgrammaFedelta((Operazioni.Cliente) request,
              (io.grpc.stub.StreamObserver<Operazioni.Informazione>) responseObserver);
          break;
        case METHODID_ACCUMULA_PUNTI_FEDELTA:
          serviceImpl.accumulaPuntiFedelta((Operazioni.DatiPunti) request,
              (io.grpc.stub.StreamObserver<Operazioni.Informazione>) responseObserver);
          break;
        case METHODID_ESTRATTO_CONTO_FEDELTA:
          serviceImpl.estrattoContoFedelta((Operazioni.Cliente) request,
              (io.grpc.stub.StreamObserver<Operazioni.Estratti>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GestionePrenotazioniVoliBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GestionePrenotazioniVoliBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Operazioni.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GestionePrenotazioniVoli");
    }
  }

  private static final class GestionePrenotazioniVoliFileDescriptorSupplier
      extends GestionePrenotazioniVoliBaseDescriptorSupplier {
    GestionePrenotazioniVoliFileDescriptorSupplier() {}
  }

  private static final class GestionePrenotazioniVoliMethodDescriptorSupplier
      extends GestionePrenotazioniVoliBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GestionePrenotazioniVoliMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GestionePrenotazioniVoliGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GestionePrenotazioniVoliFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getInviaNotificaMethod())
              .addMethod(getDammiTuttiVoliMethod())
              .addMethod(getDammiMieiVoliMethod())
              .addMethod(getPrenotaVoloMethod())
              .addMethod(getModificaPrenotazioneMethod())
              .addMethod(getIscrizioneProgrammaFedeltaMethod())
              .addMethod(getAccumulaPuntiFedeltaMethod())
              .addMethod(getEstrattoContoFedeltaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
