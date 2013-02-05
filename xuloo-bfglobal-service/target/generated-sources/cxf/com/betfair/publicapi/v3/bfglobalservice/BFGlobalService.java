package com.betfair.publicapi.v3.bfglobalservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-02-04T16:20:33.044Z
 * Generated source version: 2.7.2
 * 
 */
@WebService(targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", name = "BFGlobalService")
@XmlSeeAlso({com.betfair.publicapi.types.global.v3.ObjectFactory.class, ObjectFactory.class})
public interface BFGlobalService {

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "login", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.Login")
    @WebMethod(action = "login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.LoginResponse")
    public com.betfair.publicapi.types.global.v3.LoginResp login(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.LoginReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "setChatName", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.SetChatName")
    @WebMethod(action = "setChatName")
    @ResponseWrapper(localName = "setChatNameResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.SetChatNameResponse")
    public com.betfair.publicapi.types.global.v3.SetChatNameResp setChatName(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.SetChatNameReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "transferFunds", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.TransferFunds")
    @WebMethod(action = "transferFunds")
    @ResponseWrapper(localName = "transferFundsResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.TransferFundsResponse")
    public com.betfair.publicapi.types.global.v3.TransferFundsResp transferFunds(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.TransferFundsReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getPaymentCard", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetPaymentCard")
    @WebMethod(action = "getPaymentCard")
    @ResponseWrapper(localName = "getPaymentCardResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetPaymentCardResponse")
    public com.betfair.publicapi.types.global.v3.GetPaymentCardResp getPaymentCard(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetPaymentCardReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "retrieveLIMBMessage", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.RetrieveLIMBMessage")
    @WebMethod(action = "retrieveLIMBMessage")
    @ResponseWrapper(localName = "retrieveLIMBMessageResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.RetrieveLIMBMessageResponse")
    public com.betfair.publicapi.types.global.v3.RetrieveLIMBMessageResp retrieveLIMBMessage(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.RetrieveLIMBMessageReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "addPaymentCard", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.AddPaymentCard")
    @WebMethod(action = "addPaymentCard")
    @ResponseWrapper(localName = "addPaymentCardResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.AddPaymentCardResponse")
    public com.betfair.publicapi.types.global.v3.AddPaymentCardResp addPaymentCard(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.AddPaymentCardReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "logout", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.Logout")
    @WebMethod(action = "logout")
    @ResponseWrapper(localName = "logoutResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.LogoutResponse")
    public com.betfair.publicapi.types.global.v3.LogoutResp logout(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.LogoutReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getActiveEventTypes", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetActiveEventTypes")
    @WebMethod(action = "getActiveEventTypes")
    @ResponseWrapper(localName = "getActiveEventTypesResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetActiveEventTypesResponse")
    public com.betfair.publicapi.types.global.v3.GetEventTypesResp getActiveEventTypes(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetEventTypesReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "viewReferAndEarn", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ViewReferAndEarn")
    @WebMethod(action = "viewReferAndEarn")
    @ResponseWrapper(localName = "viewReferAndEarnResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ViewReferAndEarnResponse")
    public com.betfair.publicapi.types.global.v3.ViewReferAndEarnResp viewReferAndEarn(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ViewReferAndEarnReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "viewProfileV2", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ViewProfileV2")
    @WebMethod(action = "viewProfileV2")
    @ResponseWrapper(localName = "viewProfileV2Response", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ViewProfileV2Response")
    public com.betfair.publicapi.types.global.v3.ViewProfileV2Resp viewProfileV2(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ViewProfileV2Req request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "withdrawByBankTransfer", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.WithdrawByBankTransfer")
    @WebMethod(action = "withdrawByBankTransfer")
    @ResponseWrapper(localName = "withdrawByBankTransferResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.WithdrawByBankTransferResponse")
    public com.betfair.publicapi.types.global.v3.WithdrawByBankTransferResp withdrawByBankTransfer(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.WithdrawByBankTransferReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getAllEventTypes", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetAllEventTypes")
    @WebMethod(action = "getAllEventTypes")
    @ResponseWrapper(localName = "getAllEventTypesResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetAllEventTypesResponse")
    public com.betfair.publicapi.types.global.v3.GetEventTypesResp getAllEventTypes(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetEventTypesReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "selfExclude", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.SelfExclude")
    @WebMethod(action = "selfExclude")
    @ResponseWrapper(localName = "selfExcludeResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.SelfExcludeResponse")
    public com.betfair.publicapi.types.global.v3.SelfExcludeResp selfExclude(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.SelfExcludeReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "updatePaymentCard", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.UpdatePaymentCard")
    @WebMethod(action = "updatePaymentCard")
    @ResponseWrapper(localName = "updatePaymentCardResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.UpdatePaymentCardResponse")
    public com.betfair.publicapi.types.global.v3.UpdatePaymentCardResp updatePaymentCard(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.UpdatePaymentCardReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "withdrawToPaymentCard", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.WithdrawToPaymentCard")
    @WebMethod(action = "withdrawToPaymentCard")
    @ResponseWrapper(localName = "withdrawToPaymentCardResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.WithdrawToPaymentCardResponse")
    public com.betfair.publicapi.types.global.v3.WithdrawToPaymentCardResp withdrawToPaymentCard(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.WithdrawToPaymentCardReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getAllCurrenciesV2", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetAllCurrenciesV2")
    @WebMethod(action = "getAllCurrenciesV2")
    @ResponseWrapper(localName = "getAllCurrenciesV2Response", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetAllCurrenciesV2Response")
    public com.betfair.publicapi.types.global.v3.GetCurrenciesV2Resp getAllCurrenciesV2(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetCurrenciesV2Req request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "modifyPassword", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ModifyPassword")
    @WebMethod(action = "modifyPassword")
    @ResponseWrapper(localName = "modifyPasswordResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ModifyPasswordResponse")
    public com.betfair.publicapi.types.global.v3.ModifyPasswordResp modifyPassword(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ModifyPasswordReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "modifyProfile", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ModifyProfile")
    @WebMethod(action = "modifyProfile")
    @ResponseWrapper(localName = "modifyProfileResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ModifyProfileResponse")
    public com.betfair.publicapi.types.global.v3.ModifyProfileResp modifyProfile(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ModifyProfileReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "keepAlive", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.KeepAlive")
    @WebMethod(action = "keepAlive")
    @ResponseWrapper(localName = "keepAliveResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.KeepAliveResponse")
    public com.betfair.publicapi.types.global.v3.KeepAliveResp keepAlive(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.KeepAliveReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "forgotPassword", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ForgotPassword")
    @WebMethod(action = "forgotPassword")
    @ResponseWrapper(localName = "forgotPasswordResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ForgotPasswordResponse")
    public com.betfair.publicapi.types.global.v3.ForgotPasswordResp forgotPassword(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ForgotPasswordReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "viewProfile", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ViewProfile")
    @WebMethod(action = "viewProfile")
    @ResponseWrapper(localName = "viewProfileResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ViewProfileResponse")
    public com.betfair.publicapi.types.global.v3.ViewProfileResp viewProfile(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ViewProfileReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "createAccount", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.CreateAccount")
    @WebMethod(action = "createAccount")
    @ResponseWrapper(localName = "createAccountResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.CreateAccountResponse")
    public com.betfair.publicapi.types.global.v3.CreateAccountResp createAccount(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.CreateAccountReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getEvents", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetEvents")
    @WebMethod(action = "getEvents")
    @ResponseWrapper(localName = "getEventsResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetEventsResponse")
    public com.betfair.publicapi.types.global.v3.GetEventsResp getEvents(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetEventsReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getSubscriptionInfo", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetSubscriptionInfo")
    @WebMethod(action = "getSubscriptionInfo")
    @ResponseWrapper(localName = "getSubscriptionInfoResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetSubscriptionInfoResponse")
    public com.betfair.publicapi.types.global.v3.GetSubscriptionInfoResp getSubscriptionInfo(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetSubscriptionInfoReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "depositFromPaymentCard", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.DepositFromPaymentCard")
    @WebMethod(action = "depositFromPaymentCard")
    @ResponseWrapper(localName = "depositFromPaymentCardResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.DepositFromPaymentCardResponse")
    public com.betfair.publicapi.types.global.v3.DepositFromPaymentCardResp depositFromPaymentCard(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.DepositFromPaymentCardReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "convertCurrency", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ConvertCurrency")
    @WebMethod(action = "convertCurrency")
    @ResponseWrapper(localName = "convertCurrencyResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.ConvertCurrencyResponse")
    public com.betfair.publicapi.types.global.v3.ConvertCurrencyResp convertCurrency(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.ConvertCurrencyReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "deletePaymentCard", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.DeletePaymentCard")
    @WebMethod(action = "deletePaymentCard")
    @ResponseWrapper(localName = "deletePaymentCardResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.DeletePaymentCardResponse")
    public com.betfair.publicapi.types.global.v3.DeletePaymentCardResp deletePaymentCard(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.DeletePaymentCardReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "getAllCurrencies", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetAllCurrencies")
    @WebMethod(action = "getAllCurrencies")
    @ResponseWrapper(localName = "getAllCurrenciesResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.GetAllCurrenciesResponse")
    public com.betfair.publicapi.types.global.v3.GetCurrenciesResp getAllCurrencies(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.GetCurrenciesReq request
    );

    @WebResult(name = "Result", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
    @RequestWrapper(localName = "submitLIMBMessage", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.SubmitLIMBMessage")
    @WebMethod(action = "submitLIMBMessage")
    @ResponseWrapper(localName = "submitLIMBMessageResponse", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/", className = "com.betfair.publicapi.v3.bfglobalservice.SubmitLIMBMessageResponse")
    public com.betfair.publicapi.types.global.v3.SubmitLIMBMessageResp submitLIMBMessage(
        @WebParam(name = "request", targetNamespace = "http://www.betfair.com/publicapi/v3/BFGlobalService/")
        com.betfair.publicapi.types.global.v3.SubmitLIMBMessageReq request
    );
}
