package ch06_project_01.ems.member;

public class Student {
	
	/* 기본적인 학생 정보를 포함
	– sNum 필드 : 학생을 구분하는 학번
	– 생성자에서 필드 초기화에 필요한 모든 값을 받음
	– 모든 필드에 대한 getter와 setter 메소드가 존재 */

	private String sNum;
	private String sId;
	private String sPw;
	private String sName;
	private int sAge;
	private char sGender;
	private String sMajor;
	
	public Student(String sNum, String sId, String sPw, String sName,
			int sAge, char sGender, String sMajor) {
		this.sNum = sNum;
		this.sId = sId;
		this.sPw = sPw;
		this.sName = sName;
		this.sAge = sAge;
		this.sGender = sGender;
		this.sMajor = sMajor;
	}
	
	public String getsNum() { return sNum; }
	public void setsNum(String sNum) { this.sNum = sNum; }
	
	public String getsId() { return sId; }
	public void setsId(String sId) { this.sId = sId; }
	
	public String getsPw() { return sPw; }
	public void setsPw(String sPw) { this.sPw = sPw; }
	
	public String getsName() { return sName; }
	public void setsName(String sName) { this.sName = sName; }
	
	public int getsAge() { return sAge; }
	public void setsAge(int sAge) { this.sAge = sAge; }
	
	public char getsGender() { return sGender; }
	public void setsGender(char sGender) { this.sGender = sGender; }
	
	public String getsMajor() { return sMajor; }
	public void setsMajor(String sMajor) { this.sMajor = sMajor; }
}