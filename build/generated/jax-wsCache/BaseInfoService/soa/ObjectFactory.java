
package soa;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _GetSeriesResponseGetSeriesResult_QNAME = new QName("http://tempuri.org/", "GetSeriesResult");
    private final static QName _GetCityInputParam_QNAME = new QName("http://tempuri.org/", "inputParam");
    private final static QName _GetDealerResponseGetDealerResult_QNAME = new QName("http://tempuri.org/", "GetDealerResult");
    private final static QName _SendCallRecordResponseSendCallRecordResult_QNAME = new QName("http://tempuri.org/", "SendCallRecordResult");
    private final static QName _ConfirmOrderResponseConfirmOrderResult_QNAME = new QName("http://tempuri.org/", "ConfirmOrderResult");
    private final static QName _AcceptOrdersInfoResponseAcceptOrdersInfoResult_QNAME = new QName("http://tempuri.org/", "AcceptOrdersInfoResult");
    private final static QName _GetModelResponseGetModelResult_QNAME = new QName("http://tempuri.org/", "GetModelResult");
    private final static QName _GetLeadSaleResponseGetLeadSaleResult_QNAME = new QName("http://tempuri.org/", "GetLeadSaleResult");
    private final static QName _SendSitePvUvResponseSendSitePvUvResult_QNAME = new QName("http://tempuri.org/", "SendSitePvUvResult");
    private final static QName _GetCityResponseGetCityResult_QNAME = new QName("http://tempuri.org/", "GetCityResult");
    private final static QName _SendLandingPvResponseSendLandingPvResult_QNAME = new QName("http://tempuri.org/", "SendLandingPvResult");
    private final static QName _SendOnlineQuestionResponseSendOnlineQuestionResult_QNAME = new QName("http://tempuri.org/", "SendOnlineQuestionResult");
    private final static QName _GetOnlineAnswerResponseGetOnlineAnswerResult_QNAME = new QName("http://tempuri.org/", "GetOnlineAnswerResult");
    private final static QName _GetFeedBackLeadsResponseGetFeedBackLeadsResult_QNAME = new QName("http://tempuri.org/", "GetFeedBackLeadsResult");
    private final static QName _GetCarsPriceResponseGetCarsPriceResult_QNAME = new QName("http://tempuri.org/", "GetCarsPriceResult");
    private final static QName _GetSalesConsultantResponseGetSalesConsultantResult_QNAME = new QName("http://tempuri.org/", "GetSalesConsultantResult");
    private final static QName _SendLeadsResponseSendLeadsResult_QNAME = new QName("http://tempuri.org/", "SendLeadsResult");
    private final static QName _GetProvinceResponseGetProvinceResult_QNAME = new QName("http://tempuri.org/", "GetProvinceResult");
    private final static QName _SyncOperationLogsResponseSyncOperationLogsResult_QNAME = new QName("http://tempuri.org/", "SyncOperationLogsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetModelResponse }
     * 
     */
    public GetModelResponse createGetModelResponse() {
        return new GetModelResponse();
    }

    /**
     * Create an instance of {@link SendSitePvUv }
     * 
     */
    public SendSitePvUv createSendSitePvUv() {
        return new SendSitePvUv();
    }

    /**
     * Create an instance of {@link SendLandingPv }
     * 
     */
    public SendLandingPv createSendLandingPv() {
        return new SendLandingPv();
    }

    /**
     * Create an instance of {@link GetDealer }
     * 
     */
    public GetDealer createGetDealer() {
        return new GetDealer();
    }

    /**
     * Create an instance of {@link GetSeries }
     * 
     */
    public GetSeries createGetSeries() {
        return new GetSeries();
    }

    /**
     * Create an instance of {@link GetOnlineAnswerResponse }
     * 
     */
    public GetOnlineAnswerResponse createGetOnlineAnswerResponse() {
        return new GetOnlineAnswerResponse();
    }

    /**
     * Create an instance of {@link GetFeedBackLeadsResponse }
     * 
     */
    public GetFeedBackLeadsResponse createGetFeedBackLeadsResponse() {
        return new GetFeedBackLeadsResponse();
    }

    /**
     * Create an instance of {@link GetSalesConsultantResponse }
     * 
     */
    public GetSalesConsultantResponse createGetSalesConsultantResponse() {
        return new GetSalesConsultantResponse();
    }

    /**
     * Create an instance of {@link GetSeriesResponse }
     * 
     */
    public GetSeriesResponse createGetSeriesResponse() {
        return new GetSeriesResponse();
    }

    /**
     * Create an instance of {@link SendOnlineQuestionResponse }
     * 
     */
    public SendOnlineQuestionResponse createSendOnlineQuestionResponse() {
        return new SendOnlineQuestionResponse();
    }

    /**
     * Create an instance of {@link GetFeedBackLeads }
     * 
     */
    public GetFeedBackLeads createGetFeedBackLeads() {
        return new GetFeedBackLeads();
    }

    /**
     * Create an instance of {@link GetLeadSaleResponse }
     * 
     */
    public GetLeadSaleResponse createGetLeadSaleResponse() {
        return new GetLeadSaleResponse();
    }

    /**
     * Create an instance of {@link SyncOperationLogs }
     * 
     */
    public SyncOperationLogs createSyncOperationLogs() {
        return new SyncOperationLogs();
    }

    /**
     * Create an instance of {@link GetCityResponse }
     * 
     */
    public GetCityResponse createGetCityResponse() {
        return new GetCityResponse();
    }

    /**
     * Create an instance of {@link SyncOperationLogsResponse }
     * 
     */
    public SyncOperationLogsResponse createSyncOperationLogsResponse() {
        return new SyncOperationLogsResponse();
    }

    /**
     * Create an instance of {@link ConfirmOrderResponse }
     * 
     */
    public ConfirmOrderResponse createConfirmOrderResponse() {
        return new ConfirmOrderResponse();
    }

    /**
     * Create an instance of {@link AcceptOrdersInfo }
     * 
     */
    public AcceptOrdersInfo createAcceptOrdersInfo() {
        return new AcceptOrdersInfo();
    }

    /**
     * Create an instance of {@link GetProvinceResponse }
     * 
     */
    public GetProvinceResponse createGetProvinceResponse() {
        return new GetProvinceResponse();
    }

    /**
     * Create an instance of {@link SendLeadsResponse }
     * 
     */
    public SendLeadsResponse createSendLeadsResponse() {
        return new SendLeadsResponse();
    }

    /**
     * Create an instance of {@link GetLeadSale }
     * 
     */
    public GetLeadSale createGetLeadSale() {
        return new GetLeadSale();
    }

    /**
     * Create an instance of {@link SendCallRecord }
     * 
     */
    public SendCallRecord createSendCallRecord() {
        return new SendCallRecord();
    }

    /**
     * Create an instance of {@link GetOnlineAnswer }
     * 
     */
    public GetOnlineAnswer createGetOnlineAnswer() {
        return new GetOnlineAnswer();
    }

    /**
     * Create an instance of {@link ConfirmOrder }
     * 
     */
    public ConfirmOrder createConfirmOrder() {
        return new ConfirmOrder();
    }

    /**
     * Create an instance of {@link GetSalesConsultant }
     * 
     */
    public GetSalesConsultant createGetSalesConsultant() {
        return new GetSalesConsultant();
    }

    /**
     * Create an instance of {@link GetCarsPriceResponse }
     * 
     */
    public GetCarsPriceResponse createGetCarsPriceResponse() {
        return new GetCarsPriceResponse();
    }

    /**
     * Create an instance of {@link GetProvince }
     * 
     */
    public GetProvince createGetProvince() {
        return new GetProvince();
    }

    /**
     * Create an instance of {@link GetDealerResponse }
     * 
     */
    public GetDealerResponse createGetDealerResponse() {
        return new GetDealerResponse();
    }

    /**
     * Create an instance of {@link SendLandingPvResponse }
     * 
     */
    public SendLandingPvResponse createSendLandingPvResponse() {
        return new SendLandingPvResponse();
    }

    /**
     * Create an instance of {@link SendCallRecordResponse }
     * 
     */
    public SendCallRecordResponse createSendCallRecordResponse() {
        return new SendCallRecordResponse();
    }

    /**
     * Create an instance of {@link AcceptOrdersInfoResponse }
     * 
     */
    public AcceptOrdersInfoResponse createAcceptOrdersInfoResponse() {
        return new AcceptOrdersInfoResponse();
    }

    /**
     * Create an instance of {@link SendSitePvUvResponse }
     * 
     */
    public SendSitePvUvResponse createSendSitePvUvResponse() {
        return new SendSitePvUvResponse();
    }

    /**
     * Create an instance of {@link GetCarsPrice }
     * 
     */
    public GetCarsPrice createGetCarsPrice() {
        return new GetCarsPrice();
    }

    /**
     * Create an instance of {@link GetCity }
     * 
     */
    public GetCity createGetCity() {
        return new GetCity();
    }

    /**
     * Create an instance of {@link SendLeads }
     * 
     */
    public SendLeads createSendLeads() {
        return new SendLeads();
    }

    /**
     * Create an instance of {@link SendOnlineQuestion }
     * 
     */
    public SendOnlineQuestion createSendOnlineQuestion() {
        return new SendOnlineQuestion();
    }

    /**
     * Create an instance of {@link GetModel }
     * 
     */
    public GetModel createGetModel() {
        return new GetModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSeriesResult", scope = GetSeriesResponse.class)
    public JAXBElement<String> createGetSeriesResponseGetSeriesResult(String value) {
        return new JAXBElement<String>(_GetSeriesResponseGetSeriesResult_QNAME, String.class, GetSeriesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetCity.class)
    public JAXBElement<String> createGetCityInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetCity.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetSeries.class)
    public JAXBElement<String> createGetSeriesInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetSeries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = SyncOperationLogs.class)
    public JAXBElement<String> createSyncOperationLogsInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, SyncOperationLogs.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDealerResult", scope = GetDealerResponse.class)
    public JAXBElement<String> createGetDealerResponseGetDealerResult(String value) {
        return new JAXBElement<String>(_GetDealerResponseGetDealerResult_QNAME, String.class, GetDealerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetCarsPrice.class)
    public JAXBElement<String> createGetCarsPriceInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetCarsPrice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendCallRecordResult", scope = SendCallRecordResponse.class)
    public JAXBElement<String> createSendCallRecordResponseSendCallRecordResult(String value) {
        return new JAXBElement<String>(_SendCallRecordResponseSendCallRecordResult_QNAME, String.class, SendCallRecordResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConfirmOrderResult", scope = ConfirmOrderResponse.class)
    public JAXBElement<String> createConfirmOrderResponseConfirmOrderResult(String value) {
        return new JAXBElement<String>(_ConfirmOrderResponseConfirmOrderResult_QNAME, String.class, ConfirmOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AcceptOrdersInfoResult", scope = AcceptOrdersInfoResponse.class)
    public JAXBElement<String> createAcceptOrdersInfoResponseAcceptOrdersInfoResult(String value) {
        return new JAXBElement<String>(_AcceptOrdersInfoResponseAcceptOrdersInfoResult_QNAME, String.class, AcceptOrdersInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetModelResult", scope = GetModelResponse.class)
    public JAXBElement<String> createGetModelResponseGetModelResult(String value) {
        return new JAXBElement<String>(_GetModelResponseGetModelResult_QNAME, String.class, GetModelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetLeadSaleResult", scope = GetLeadSaleResponse.class)
    public JAXBElement<String> createGetLeadSaleResponseGetLeadSaleResult(String value) {
        return new JAXBElement<String>(_GetLeadSaleResponseGetLeadSaleResult_QNAME, String.class, GetLeadSaleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendSitePvUvResult", scope = SendSitePvUvResponse.class)
    public JAXBElement<String> createSendSitePvUvResponseSendSitePvUvResult(String value) {
        return new JAXBElement<String>(_SendSitePvUvResponseSendSitePvUvResult_QNAME, String.class, SendSitePvUvResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCityResult", scope = GetCityResponse.class)
    public JAXBElement<String> createGetCityResponseGetCityResult(String value) {
        return new JAXBElement<String>(_GetCityResponseGetCityResult_QNAME, String.class, GetCityResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = SendOnlineQuestion.class)
    public JAXBElement<String> createSendOnlineQuestionInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, SendOnlineQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetModel.class)
    public JAXBElement<String> createGetModelInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetDealer.class)
    public JAXBElement<String> createGetDealerInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetDealer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendLandingPvResult", scope = SendLandingPvResponse.class)
    public JAXBElement<String> createSendLandingPvResponseSendLandingPvResult(String value) {
        return new JAXBElement<String>(_SendLandingPvResponseSendLandingPvResult_QNAME, String.class, SendLandingPvResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = SendLeads.class)
    public JAXBElement<String> createSendLeadsInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, SendLeads.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendOnlineQuestionResult", scope = SendOnlineQuestionResponse.class)
    public JAXBElement<String> createSendOnlineQuestionResponseSendOnlineQuestionResult(String value) {
        return new JAXBElement<String>(_SendOnlineQuestionResponseSendOnlineQuestionResult_QNAME, String.class, SendOnlineQuestionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetProvince.class)
    public JAXBElement<String> createGetProvinceInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetProvince.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = SendLandingPv.class)
    public JAXBElement<String> createSendLandingPvInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, SendLandingPv.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOnlineAnswerResult", scope = GetOnlineAnswerResponse.class)
    public JAXBElement<String> createGetOnlineAnswerResponseGetOnlineAnswerResult(String value) {
        return new JAXBElement<String>(_GetOnlineAnswerResponseGetOnlineAnswerResult_QNAME, String.class, GetOnlineAnswerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetFeedBackLeadsResult", scope = GetFeedBackLeadsResponse.class)
    public JAXBElement<String> createGetFeedBackLeadsResponseGetFeedBackLeadsResult(String value) {
        return new JAXBElement<String>(_GetFeedBackLeadsResponseGetFeedBackLeadsResult_QNAME, String.class, GetFeedBackLeadsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCarsPriceResult", scope = GetCarsPriceResponse.class)
    public JAXBElement<String> createGetCarsPriceResponseGetCarsPriceResult(String value) {
        return new JAXBElement<String>(_GetCarsPriceResponseGetCarsPriceResult_QNAME, String.class, GetCarsPriceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSalesConsultantResult", scope = GetSalesConsultantResponse.class)
    public JAXBElement<String> createGetSalesConsultantResponseGetSalesConsultantResult(String value) {
        return new JAXBElement<String>(_GetSalesConsultantResponseGetSalesConsultantResult_QNAME, String.class, GetSalesConsultantResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = ConfirmOrder.class)
    public JAXBElement<String> createConfirmOrderInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, ConfirmOrder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = SendSitePvUv.class)
    public JAXBElement<String> createSendSitePvUvInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, SendSitePvUv.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = AcceptOrdersInfo.class)
    public JAXBElement<String> createAcceptOrdersInfoInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, AcceptOrdersInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendLeadsResult", scope = SendLeadsResponse.class)
    public JAXBElement<String> createSendLeadsResponseSendLeadsResult(String value) {
        return new JAXBElement<String>(_SendLeadsResponseSendLeadsResult_QNAME, String.class, SendLeadsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetLeadSale.class)
    public JAXBElement<String> createGetLeadSaleInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetLeadSale.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetProvinceResult", scope = GetProvinceResponse.class)
    public JAXBElement<String> createGetProvinceResponseGetProvinceResult(String value) {
        return new JAXBElement<String>(_GetProvinceResponseGetProvinceResult_QNAME, String.class, GetProvinceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetFeedBackLeads.class)
    public JAXBElement<String> createGetFeedBackLeadsInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetFeedBackLeads.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetSalesConsultant.class)
    public JAXBElement<String> createGetSalesConsultantInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetSalesConsultant.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SyncOperationLogsResult", scope = SyncOperationLogsResponse.class)
    public JAXBElement<String> createSyncOperationLogsResponseSyncOperationLogsResult(String value) {
        return new JAXBElement<String>(_SyncOperationLogsResponseSyncOperationLogsResult_QNAME, String.class, SyncOperationLogsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = GetOnlineAnswer.class)
    public JAXBElement<String> createGetOnlineAnswerInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, GetOnlineAnswer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParam", scope = SendCallRecord.class)
    public JAXBElement<String> createSendCallRecordInputParam(String value) {
        return new JAXBElement<String>(_GetCityInputParam_QNAME, String.class, SendCallRecord.class, value);
    }

}
