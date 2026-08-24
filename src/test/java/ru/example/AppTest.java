package ru.example;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.example.service.CalculationService;
import ru.example.service.XmlValidationService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private XmlValidationService xmlValidationService;

	@Test
	public void calculateTest() {

		String testInputPath = "src/test/resources/SampleTest.xml";
		String testOutputPath = "src/test/resources/TestResults.xml";
		Path pathInput = Paths.get(testInputPath);
		Path pathOutput = Paths.get(testOutputPath);
		calculationService.calculate(pathInput, pathOutput);

		String sampleResult = "src/test/resources/SampleTestResult.xml";
		Path pathSample = Paths.get(sampleResult);
		try {
			Assert.assertTrue(FileUtils.contentEquals(pathOutput.toFile(), pathSample.toFile()));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			pathOutput.toFile().deleteOnExit();
		}
	}

	@Test
	public void validateTestValid() {

		String testInputPathValid = "src/test/resources/SampleTest.xml";
		Path pathInputValid = Paths.get(testInputPathValid);

		Assert.assertTrue(xmlValidationService.validate(pathInputValid));
	}

	@Test
	public void validateTestNotValid() {

		String testInputPathNotValid = "src/test/resources/SampleTestNotValid.xml";
		Path pathInputNotValid = Paths.get(testInputPathNotValid);

		Assert.assertFalse(xmlValidationService.validate(pathInputNotValid));

	}
}
