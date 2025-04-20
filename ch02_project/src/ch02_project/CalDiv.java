package ch02_project;

public class CalDiv implements ICalculator {
	
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return secondNum != 0 ? (firstNum / secondNum) : 0;
    }
}
