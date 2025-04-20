package ch02_project;

public class CalSub implements ICalculator {
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}
