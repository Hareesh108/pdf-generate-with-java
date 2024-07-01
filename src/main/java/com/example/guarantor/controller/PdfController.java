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

		keyValues.put("statementDate", "15 December 2023");
		keyValues.put("paymentDueDate", "04 January 2024");
		keyValues.put("financingLimit", "1,00,00,000");

		keyValues.put("previousBalance", "1,00,00,000");
		keyValues.put("payment", "66,00,000");
		keyValues.put("overdue", "50,000");
		keyValues.put("currentBalance", "14,00,000");
		keyValues.put("minimumPayment", "18,000");

		keyValues.put("payment1", "123456789");
		keyValues.put("payment2", "15 December 2023");
		keyValues.put("payment3", "15 Jun 2023");
		keyValues.put("payment4", "14,00,045.60");
		keyValues.put("payment5", "18,005.67");

		Map<String, Object> model = new HashMap<>();
		model.put("keyValues", keyValues);

		String renderedHtml = thymeleafService.renderTemplate("demo.xhtml", model);

		PdfRendererBuilder pdfRendererBuilder = new PdfRendererBuilder();
		pdfRendererBuilder.withHtmlContent(renderedHtml, "classpath:/static/");
		try (OutputStream outputStream = new FileOutputStream("test.pdf")) {
			pdfRendererBuilder.toStream(outputStream);
			pdfRendererBuilder.run();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
