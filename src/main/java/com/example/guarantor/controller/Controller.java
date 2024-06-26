package com.example.guarantor.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@RestController
@RequestMapping("/jobs")
public class Controller {

	@GetMapping
	public void guarantor() throws IOException {

		String process = new String(
				Files.readAllBytes(Paths.get("src/main/resources/templates/demo1.html")));

		PdfRendererBuilder pdfRendererBuilder = new PdfRendererBuilder();
		pdfRendererBuilder.withHtmlContent(process, "classpath:/static/");
		OutputStream outputStream1 = new FileOutputStream("guarantor.pdf");

		pdfRendererBuilder.toStream(outputStream1);
		pdfRendererBuilder.run();

	}

}
