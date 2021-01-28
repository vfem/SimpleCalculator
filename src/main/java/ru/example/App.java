package ru.example;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.xml.SimpleCalculator;
import ru.example.xml.Term;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App implements ru.example.SimpleCalculator {
	//todo MORE logging!!!!!111
	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		if (args.length == 2) {
			log.info("Method is starting");
			String inputPath = args[0];
			log.info("InputFile path - {}", inputPath);
			String outputPath = args[1];
			log.info("OutputFile path - {}",outputPath);
			Path pathInput = Paths.get(inputPath);
			Path pathOutput = Paths.get(outputPath);
			App app = new App();
			app.calculate(pathInput, pathOutput);
			log.info("Method is finished");
		} else {
			log.error("Invalid parameters, args size is {}\n" +
					"Expecting 2 parameters: absolute path to InputFile.xml, absolute path to OutputFile.xml",
					args.length);
		}
	}

	public void calculate(Path file, Path resultFile) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SimpleCalculator.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			SimpleCalculator simpleCalculator = (SimpleCalculator) jaxbUnmarshaller.unmarshal(file.toFile());
			List<SimpleCalculator.Expressions.Expression> expressions = simpleCalculator.getExpressions().getExpression();

			List<SimpleCalculator.ExpressionResults.ExpressionResult> calculatedExpressionResults = new ArrayList<>();

			for (SimpleCalculator.Expressions.Expression expression : expressions) {

				Term operation = expression.getOperation();

				double result = calculateTerm(operation);

				SimpleCalculator.ExpressionResults.ExpressionResult expressionResult = new SimpleCalculator.ExpressionResults.ExpressionResult();
				expressionResult.setResult(result);
				log.info("Calculated expression = {} ", result);
				calculatedExpressionResults.add(expressionResult);
			}

			SimpleCalculator.ExpressionResults outputResults = new SimpleCalculator.ExpressionResults();
			outputResults.setExpressionResults(calculatedExpressionResults);

			simpleCalculator.setExpressionResults(outputResults);
			simpleCalculator.setExpressions(null);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "SimpleCalculator.xsd");
			jaxbMarshaller.marshal(simpleCalculator, resultFile.toFile());
		} catch (JAXBException e) {
			log.error("Exception occur", e);
		}
	}

	private double calculateTerm(Term operation) {

		TermType typeOfTerm = getTypeOfTerm(operation);

		if (TermType.TWO_NUMBERS == typeOfTerm) {
			Integer agr1 = operation.getArg().get(0);
			Integer agr2 = operation.getArg().get(1);

			String operationType = operation.getOperationType();

			return doMath(agr1, agr2, operationType);
		}

		if (TermType.TWO_OPERATIONS == typeOfTerm) {
			Term subOperation1 = operation.getOperation().get(0);
			Term subOperation2 = operation.getOperation().get(1);

			String operationType = operation.getOperationType();

			return doMath(calculateTerm(subOperation1), calculateTerm(subOperation2), operationType);
		}

		if (TermType.AGR1_AND_OPERATION1 == typeOfTerm) {
			Integer agr1 = operation.getArg1();
			Term subOperation1 = operation.getOperation1();

			String operationType = operation.getOperationType();

			return doMath(agr1, calculateTerm(subOperation1), operationType);
		}

		if (TermType.ARG2_AND_OPERATION2 == typeOfTerm) {
			Term subOperation2 = operation.getOperation2();
			Integer agr2 = operation.getArg2();

			String operationType = operation.getOperationType();

			return doMath(calculateTerm(subOperation2), agr2, operationType);
		}

		return 0;
	}

	private TermType getTypeOfTerm(Term operation) {
		if (CollectionUtils.isNotEmpty(operation.getArg())) {
			return TermType.TWO_NUMBERS;
		}
		if (CollectionUtils.isNotEmpty(operation.getOperation())) {
			return TermType.TWO_OPERATIONS;
		}
		if (operation.getOperation1() != null) {
			return TermType.AGR1_AND_OPERATION1;
		}
		if (operation.getOperation2() != null) {
			return TermType.ARG2_AND_OPERATION2;
		}

		return TermType.UNKNOWN_TYPE;
	}

	private double doMath(double agr1, double agr2, String operationType) {
		double result = 0;

		if ("SUB".equals(operationType)) {
			result = agr1 - agr2;
		} else if ("SUM".equals(operationType)) {
			result = agr1 + agr2;
		} else if ("MUL".equals(operationType)) {
			result = agr1 * agr2;
		} else if ("DIV".equals(operationType)) {
			result = agr1 / agr2;
		}

		return result;
	}
}
