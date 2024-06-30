package com.example.guarantor.controller;

import com.example.guarantor.services.ThymeleafService;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private ThymeleafService thymeleafService;

	@GetMapping
	public void generatePdf() throws IOException {
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

		keyValues.put("statementDate", "15 December 2023");
		keyValues.put("paymentDueDate", "04 January 2024");
		keyValues.put("financingLimit", "1,00,00,000");

		keyValues.put("previousBalance", "1,00,00,000");
		keyValues.put("payment", "66,00,000");
		keyValues.put("overdue", "50,000");
		keyValues.put("currentBalance", "14,00,000");
		keyValues.put("minimumPayment", "18,000");

		Map<String, Object> model = new HashMap<>();
		model.put("keyValues", keyValues);

		String renderedHtml = thymeleafService.renderTemplate("demo.xhtml", model);

		System.out.println(renderedHtml);

		PdfRendererBuilder pdfRendererBuilder = new PdfRendererBuilder();
		pdfRendererBuilder.withHtmlContent(renderedHtml, "classpath:/static/");
		try (OutputStream outputStream = new FileOutputStream("test.pdf")) {
			pdfRendererBuilder.toStream(outputStream);
			System.out.println(pdfRendererBuilder.toStream(outputStream) + "nnnn");
			pdfRendererBuilder.run();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
