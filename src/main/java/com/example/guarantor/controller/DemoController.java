package com.example.guarantor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @GetMapping("/generate")
    public String generate(Model model) {
        Map<String, String> keyValues = new HashMap<>();
        keyValues.put("statementNo", "001");
        keyValues.put("sequenceNo", "002");
        keyValues.put("lineSeqNo", "003");
        keyValues.put("textLetterKey", "A1");
        keyValues.put("stmtRecordType", "Type1");
        keyValues.put("entryDate", "2024-06-28");
        keyValues.put("transactionDate", "2024-06-28");
        keyValues.put("formType", "Form1");
        keyValues.put("text", "Sample Text");
        keyValues.put("transAmount", "100.00");
        keyValues.put("defaultSign", "+");
        keyValues.put("currencyCode", "USD");
        keyValues.put("cardNumber", "1234-5678-9012-3456");
        keyValues.put("customerNumber", "Cust123");
        keyValues.put("processingDate", "2024-06-28");
        keyValues.put("latestDueDate", "2024-07-28");
        keyValues.put("amountDue", "1500");
        keyValues.put("transactionCodeGroup", "Group1");
        keyValues.put("balanceBroughtForward", "5000");
        keyValues.put("debitAmount", "200.00");
        keyValues.put("creditAmount", "300.00");
        keyValues.put("totalPftChargeAmount", "50.00");
        keyValues.put("balanceCarriedForward", "4800");
        keyValues.put("capitalisedProfit", "100.00");
        keyValues.put("acquirerReferenceNumber", "Ref12345");
        keyValues.put("ficheReference", "Fiche123");
        keyValues.put("merchantId", "Merchant123");
        keyValues.put("terminalId", "Terminal123");
        keyValues.put("terminalBatchNo", "Batch123");
        keyValues.put("lineSpaceBefore", "1");
        keyValues.put("lineSpaceAfter", "2");
        keyValues.put("embossingName", "John Doe");
        keyValues.put("postCode", "12345");
        keyValues.put("city", "CityName");
        keyValues.put("countryCode", "US");
        keyValues.put("pickUpCodeYN", "Y");
        keyValues.put("multiCurrencyYN", "N");
        keyValues.put("productId", "Prod123");
        keyValues.put("description", "Product Description");
        keyValues.put("productType", "TypeA");
        keyValues.put("emailAddress", "email@example.com");
        keyValues.put("senderName", "Sender Name");
        keyValues.put("recipientReference", "Recipient123");
        keyValues.put("otherPaymentDetails", "Payment Details");
        keyValues.put("dateTime", "2024-06-28T12:34:56");

        model.addAttribute("keyValues", keyValues);
        return "thymeleaf-demo";
    }

}
