package ch03_project_03;

public class CalAdd implements ICalculator {
	
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
