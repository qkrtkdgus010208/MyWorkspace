package ch02_project;

public class CalAdd implements ICalculator {
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
