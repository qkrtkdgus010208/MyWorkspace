package ch03_project_03;

public class CalSub implements ICalculator {
	
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}
