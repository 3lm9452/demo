package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.FileProcessor;
import com.example.demo.service.NumberService;


@Controller
public class FileUploadController {

	@Autowired
	private FileProcessor fileProcessor;
	
	@Autowired
	private NumberService numberService;


	@GetMapping("/fileUpload")
	public String listUploadedFiles(Model model) throws IOException {
		return "uploadForm";
	}
	@GetMapping("/fileUploadResult")
	public String goToResult(Model model) throws IOException {
		model.addAttribute("numbers",numberService.findAll());
		return "fileUploadResult";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		try {
			fileProcessor.processFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/fileUploadResult";
	}


}