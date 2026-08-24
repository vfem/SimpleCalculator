package ru.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.example.service.CalculationService;
import ru.example.service.XmlValidationService;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class App implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Autowired
	private XmlValidationService xmlValidationService;

	@Autowired
	private CalculationService calculationService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 2) {
			log.info("Method is starting");
			String inputPath = args[0];
			log.info("InputFile path - {}", inputPath);
			String outputPath = args[1];
			log.info("OutputFile path - {}", outputPath);
			Path pathInput = Paths.get(inputPath);
			Path pathOutput = Paths.get(outputPath);
			if (xmlValidationService.validate(pathInput)) {
				calculationService.calculate(pathInput, pathOutput);
			}
			log.info("Method is finished");
		} else {
			log.error("Invalid parameters, args size is {}\n" +
							"Expecting 2 parameters: path to InputFile.xml, path to OutputFile.xml",
					args.length);
		}
	}
}