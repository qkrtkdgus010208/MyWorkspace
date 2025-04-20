package ch02_project;

public class CalMul implements ICalculator {
	
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}
