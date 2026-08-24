package ru.example.service;

import org.springframework.stereotype.Service;
import ru.example.TermType;
import ru.example.xml.SimpleCalculator;
import ru.example.xml.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.collections4.CollectionUtils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {

    private static final Logger log = LoggerFactory.getLogger(CalculationService.class);

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
            log.error("An exception was thrown", e);
        }
    }

    private double calculateTerm(Term operation) {

        TermType typeOfTerm = getTypeOfTerm(operation);

        switch (typeOfTerm) {
            case TWO_NUMBERS:
                return doMath(operation.getArg().get(0), operation.getArg().get(1), operation.getOperationType());
            case TWO_OPERATIONS:
                return doMath(calculateTerm(operation.getOperation().get(0)), calculateTerm(operation.getOperation().get(1)), operation.getOperationType());
            case AGR1_AND_OPERATION1:
                return doMath(operation.getArg1(), calculateTerm(operation.getOperation1()), operation.getOperationType());
            case ARG2_AND_OPERATION2:
                return doMath(calculateTerm(operation.getOperation2()), operation.getArg2(), operation.getOperationType());
            default:
                return 0;
        }
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
        switch (operationType) {
            case "SUB":
                return agr1 - agr2;
            case "SUM":
                return agr1 + agr2;
            case "MUL":
                return agr1 * agr2;
            case "DIV":
                return agr1 / agr2;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operationType);
        }
    }
}