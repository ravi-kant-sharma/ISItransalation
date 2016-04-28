package integration.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2016-04-26T15:18:39.962+05:30
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://API.Integration/", name = "DataRequest30")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DataRequest30 {

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getMasterProjectIDRequest", output = "http://API.Integration/DataRequest30/getMasterProjectIDResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getMasterProjectID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "getCustomerRefNo_PrevOrder")
    @Action(input = "http://API.Integration/DataRequest30/getCustomerRefNo_PrevOrderRequest", output = "http://API.Integration/DataRequest30/getCustomerRefNo_PrevOrderResponse")
    @WebResult(name = "StringResult", targetNamespace = "http://API.Integration/", partName = "StringResult")
    public StringResult getCustomerRefNoPrevOrder(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setEN15038RequestedRequest", output = "http://API.Integration/DataRequest30/setEN15038RequestedResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setEN15038Requested(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "isEN15038", name = "isEN15038")
        boolean isEN15038,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/insertRequest", output = "http://API.Integration/DataRequest30/insertResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult insert(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/updateRequest", output = "http://API.Integration/DataRequest30/updateResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result update(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "RequestIN", name = "RequestIN")
        RequestIN requestIN,
        @WebParam(partName = "enableNullOrEmptyValues", name = "enableNullOrEmptyValues")
        boolean enableNullOrEmptyValues
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getRequestObjectRequest", output = "http://API.Integration/DataRequest30/getRequestObjectResponse")
    @WebResult(name = "RequestResult", targetNamespace = "http://API.Integration/", partName = "RequestResult")
    public RequestResult getRequestObject(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/deleteRequest", output = "http://API.Integration/DataRequest30/deleteResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result delete(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getCreationDateRequest", output = "http://API.Integration/DataRequest30/getCreationDateResponse")
    @WebResult(name = "DateResult", targetNamespace = "http://API.Integration/", partName = "DateResult")
    public DateResult getCreationDate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/addServiceRequest", output = "http://API.Integration/DataRequest30/addServiceResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result addService(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "service", name = "service")
        java.lang.String service,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setTypeOfProjectRequest", output = "http://API.Integration/DataRequest30/setTypeOfProjectResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setTypeOfProject(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "TypeOfProject", name = "TypeOfProject")
        java.lang.String typeOfProject
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setBriefDescriptionRequest", output = "http://API.Integration/DataRequest30/setBriefDescriptionResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setBriefDescription(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "briefDescription", name = "briefDescription")
        java.lang.String briefDescription,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setCustomerIDRequest", output = "http://API.Integration/DataRequest30/setCustomerIDResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setCustomerID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "customerID", name = "customerID")
        int customerID,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "getRequestNo_for_View")
    @Action(input = "http://API.Integration/DataRequest30/getRequestNo_for_ViewRequest", output = "http://API.Integration/DataRequest30/getRequestNo_for_ViewResponse")
    @WebResult(name = "StringResult", targetNamespace = "http://API.Integration/", partName = "StringResult")
    public StringResult getRequestNoForView(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getPropertyRequest", output = "http://API.Integration/DataRequest30/getPropertyResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public StringResult getProperty(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "propertyNameEnglish", name = "propertyNameEnglish")
        java.lang.String propertyNameEnglish
    );

    @WebMethod(operationName = "deregisterCallback_Observer")
    @Action(input = "http://API.Integration/DataRequest30/deregisterCallback_ObserverRequest", output = "http://API.Integration/DataRequest30/deregisterCallback_ObserverResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result deregisterCallbackObserver(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "RequestID", name = "RequestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setMasterProjectIDRequest", output = "http://API.Integration/DataRequest30/setMasterProjectIDResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setMasterProjectID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "MasterProjectID", name = "MasterProjectID")
        int masterProjectID
    );

    @WebMethod(operationName = "registerCallback_Notify")
    @Action(input = "http://API.Integration/DataRequest30/registerCallback_NotifyRequest", output = "http://API.Integration/DataRequest30/registerCallback_NotifyResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result registerCallbackNotify(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "ServerAuthenticationString", name = "ServerAuthenticationString")
        java.lang.String serverAuthenticationString,
        @WebParam(partName = "ServerAddress", name = "ServerAddress")
        java.lang.String serverAddress,
        @WebParam(partName = "EventType", name = "EventType")
        int eventType
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getOrderIDRequest", output = "http://API.Integration/DataRequest30/getOrderIDResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getOrderID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "registerCallback_Observer")
    @Action(input = "http://API.Integration/DataRequest30/registerCallback_ObserverRequest", output = "http://API.Integration/DataRequest30/registerCallback_ObserverResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result registerCallbackObserver(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "ServerAuthenticationString", name = "ServerAuthenticationString")
        java.lang.String serverAuthenticationString,
        @WebParam(partName = "ServerAddress", name = "ServerAddress")
        java.lang.String serverAddress,
        @WebParam(partName = "RequestID", name = "RequestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setOrderIDRequest", output = "http://API.Integration/DataRequest30/setOrderIDResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setOrderID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "orderID", name = "orderID")
        int orderID,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getBriefDescriptionRequest", output = "http://API.Integration/DataRequest30/getBriefDescriptionResponse")
    @WebResult(name = "StringResult", targetNamespace = "http://API.Integration/", partName = "StringResult")
    public StringResult getBriefDescription(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "copyDocument_toSourceFolder")
    @Action(input = "http://API.Integration/DataRequest30/copyDocument_toSourceFolderRequest", output = "http://API.Integration/DataRequest30/copyDocument_toSourceFolderResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result copyDocumentToSourceFolder(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "sourceLanguage", name = "sourceLanguage")
        java.lang.String sourceLanguage,
        @WebParam(partName = "uncFileName", name = "uncFileName")
        java.lang.String uncFileName,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getPriceRequest", output = "http://API.Integration/DataRequest30/getPriceResponse")
    @WebResult(name = "DoubleResult", targetNamespace = "http://API.Integration/", partName = "DoubleResult")
    public DoubleResult getPrice(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getCustomerIDRequest", output = "http://API.Integration/DataRequest30/getCustomerIDResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getCustomerID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setStatusRequest", output = "http://API.Integration/DataRequest30/setStatusResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setStatus(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "Status", name = "Status")
        int status,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getQuotationDateRequest", output = "http://API.Integration/DataRequest30/getQuotationDateResponse")
    @WebResult(name = "DateResult", targetNamespace = "http://API.Integration/", partName = "DateResult")
    public DateResult getQuotationDate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/addLanguageCombinationRequest", output = "http://API.Integration/DataRequest30/addLanguageCombinationResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result addLanguageCombination(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "sourceLanguage", name = "sourceLanguage")
        java.lang.String sourceLanguage,
        @WebParam(partName = "targetLanguage", name = "targetLanguage")
        java.lang.String targetLanguage,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getRequestIDRequest", output = "http://API.Integration/DataRequest30/getRequestIDResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getRequestID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "displayNo", name = "displayNo")
        java.lang.String displayNo,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getSubjectRequest", output = "http://API.Integration/DataRequest30/getSubjectResponse")
    @WebResult(name = "StringResult", targetNamespace = "http://API.Integration/", partName = "StringResult")
    public StringResult getSubject(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getWordCountRequest", output = "http://API.Integration/DataRequest30/getWordCountResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getWordCount(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setSubjectRequest", output = "http://API.Integration/DataRequest30/setSubjectResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setSubject(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "subject", name = "subject")
        java.lang.String subject,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "deregisterCallback_Notify")
    @Action(input = "http://API.Integration/DataRequest30/deregisterCallback_NotifyRequest", output = "http://API.Integration/DataRequest30/deregisterCallback_NotifyResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result deregisterCallbackNotify(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "EventType", name = "EventType")
        int eventType
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getQuoteIDRequest", output = "http://API.Integration/DataRequest30/getQuoteIDResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getQuoteID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setCustomerRefNoRequest", output = "http://API.Integration/DataRequest30/setCustomerRefNoResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setCustomerRefNo(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "CustomerRefNo", name = "CustomerRefNo")
        java.lang.String customerRefNo,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setQuoteIDRequest", output = "http://API.Integration/DataRequest30/setQuoteIDResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setQuoteID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "quoteID", name = "quoteID")
        int quoteID,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setPriceRequest", output = "http://API.Integration/DataRequest30/setPriceResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setPrice(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "price", name = "price")
        double price,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getStatusRequest", output = "http://API.Integration/DataRequest30/getStatusResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getStatus(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setCreationDateRequest", output = "http://API.Integration/DataRequest30/setCreationDateResponse")
    @WebResult(name = "DateResult", targetNamespace = "http://API.Integration/", partName = "DateResult")
    public Result setCreationDate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "date", name = "date")
        javax.xml.datatype.XMLGregorianCalendar date,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getRequestObjectListRequest", output = "http://API.Integration/DataRequest30/getRequestObjectListResponse")
    @WebResult(name = "RequestListResult", targetNamespace = "http://API.Integration/", partName = "RequestListResult")
    public RequestListResult getRequestObjectList(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestIDList", name = "requestIDList")
        IntegerList requestIDList
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setDeliveryDateRequest", output = "http://API.Integration/DataRequest30/setDeliveryDateResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setDeliveryDate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "date", name = "date")
        javax.xml.datatype.XMLGregorianCalendar date,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getCustomerRefNoRequest", output = "http://API.Integration/DataRequest30/getCustomerRefNoResponse")
    @WebResult(name = "StringResult", targetNamespace = "http://API.Integration/", partName = "StringResult")
    public StringResult getCustomerRefNo(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "setCustomerRefNo_PrevOrder")
    @Action(input = "http://API.Integration/DataRequest30/setCustomerRefNo_PrevOrderRequest", output = "http://API.Integration/DataRequest30/setCustomerRefNo_PrevOrderResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setCustomerRefNoPrevOrder(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "CustomerRefNo_PreviousOrder", name = "CustomerRefNo_PreviousOrder")
        java.lang.String customerRefNoPreviousOrder,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setWordCountRequest", output = "http://API.Integration/DataRequest30/setWordCountResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setWordCount(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "wordCount", name = "wordCount")
        int wordCount,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getDeliveryDateRequest", output = "http://API.Integration/DataRequest30/getDeliveryDateResponse")
    @WebResult(name = "DateResult", targetNamespace = "http://API.Integration/", partName = "DateResult")
    public DateResult getDeliveryDate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getEN15038RequestedRequest", output = "http://API.Integration/DataRequest30/getEN15038RequestedResponse")
    @WebResult(name = "BooleanResult", targetNamespace = "http://API.Integration/", partName = "BooleanResult")
    public BooleanResult getEN15038Requested(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "quoteRequest_byTemplate")
    @Action(input = "http://API.Integration/DataRequest30/quoteRequest_byTemplateRequest", output = "http://API.Integration/DataRequest30/quoteRequest_byTemplateResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult quoteRequestByTemplate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "QuoteTemplateID", name = "QuoteTemplateID")
        int quoteTemplateID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getTypeOfProjectRequest", output = "http://API.Integration/DataRequest30/getTypeOfProjectResponse")
    @WebResult(name = "StringResult", targetNamespace = "http://API.Integration/", partName = "StringResult")
    public StringResult getTypeOfProject(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "getAll_Requests")
    @Action(input = "http://API.Integration/DataRequest30/getAll_RequestsRequest", output = "http://API.Integration/DataRequest30/getAll_RequestsResponse")
    @WebResult(name = "IntegerArrayResult", targetNamespace = "http://API.Integration/", partName = "IntegerArrayResult")
    public IntegerArrayResult getAllRequests(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setCustomerContactIDRequest", output = "http://API.Integration/DataRequest30/setCustomerContactIDResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setCustomerContactID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "customerContactID", name = "customerContactID")
        int customerContactID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getRequestObject2Request", output = "http://API.Integration/DataRequest30/getRequestObject2Response")
    @WebResult(name = "RequestResult", targetNamespace = "http://API.Integration/", partName = "RequestResult")
    public RequestResult getRequestObject2(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestNumber", name = "requestNumber")
        java.lang.String requestNumber
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setQuotationDateRequest", output = "http://API.Integration/DataRequest30/setQuotationDateResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setQuotationDate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "date", name = "date")
        javax.xml.datatype.XMLGregorianCalendar date,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/getCustomerContactIDRequest", output = "http://API.Integration/DataRequest30/getCustomerContactIDResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult getCustomerContactID(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/setPropertyRequest", output = "http://API.Integration/DataRequest30/setPropertyResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result setProperty(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "propertyNameEnglish", name = "propertyNameEnglish")
        java.lang.String propertyNameEnglish,
        @WebParam(partName = "propertyValueEnglish", name = "propertyValueEnglish")
        java.lang.String propertyValueEnglish
    );

    @WebMethod(operationName = "copyDocument_toReferenceFolder")
    @Action(input = "http://API.Integration/DataRequest30/copyDocument_toReferenceFolderRequest", output = "http://API.Integration/DataRequest30/copyDocument_toReferenceFolderResponse")
    @WebResult(name = "Result", targetNamespace = "http://API.Integration/", partName = "Result")
    public Result copyDocumentToReferenceFolder(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "refLanguage", name = "refLanguage")
        java.lang.String refLanguage,
        @WebParam(partName = "uncFileName", name = "uncFileName")
        java.lang.String uncFileName,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod(operationName = "orderRequest_byTemplate")
    @Action(input = "http://API.Integration/DataRequest30/orderRequest_byTemplateRequest", output = "http://API.Integration/DataRequest30/orderRequest_byTemplateResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult orderRequestByTemplate(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID,
        @WebParam(partName = "OrderTemplateID", name = "OrderTemplateID")
        int orderTemplateID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/orderRequestRequest", output = "http://API.Integration/DataRequest30/orderRequestResponse")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult orderRequest(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "requestID", name = "requestID")
        int requestID
    );

    @WebMethod
    @Action(input = "http://API.Integration/DataRequest30/insert2Request", output = "http://API.Integration/DataRequest30/insert2Response")
    @WebResult(name = "IntegerResult", targetNamespace = "http://API.Integration/", partName = "IntegerResult")
    public IntegerResult insert2(
        @WebParam(partName = "UUID", name = "UUID")
        java.lang.String uuid,
        @WebParam(partName = "RequestIN", name = "RequestIN")
        RequestIN requestIN
    );
}
