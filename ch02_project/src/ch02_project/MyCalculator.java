package ch02_project;

public class MyCalculator {
	public void calculate(int fNum, int sNum, ICalculator calculator) {
		int value = calculator.doOperation(fNum, sNum); // 연산 실행
		System.out.println("result : " + value);
	}
}
