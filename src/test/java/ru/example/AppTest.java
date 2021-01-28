package ru.example;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    //todo тест на валидность схеме добавить
    @Test
    public void calculateTest() {
        App app = new App();
        String testInputPath = "src/test/resources/SampleTest.xml";
        String testOutputPath = "src/test/resources/TestResults.xml";
        Path pathInput = Paths.get(testInputPath);
        Path pathOutput = Paths.get(testOutputPath);
        app.calculate(pathInput, pathOutput);

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
}
