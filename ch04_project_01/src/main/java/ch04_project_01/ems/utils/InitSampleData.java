package ch04_project_01.ems.utils;

public class InitSampleData {
	
	/* 프로그램 실행에 필요한 샘플 데이터로 5명의 학생 정보를 각각 필드에 가짐
	– getter와 setter 메소드 존재 */
	
	private String[] sNums;
	private String[] sIds;
	private String[] sPws;
	private String[] sNames;
	private int[] sAges;
	private char[] sGenders;
	private String[] sMajors;
	
	public String[] getsNums() { return sNums; }
	public void setsNums(String[] sNums) { this.sNums = sNums; }
	
	public String[] getsIds() { return sIds; }
	public void setsIds(String[] sIds) { this.sIds = sIds; }
	
	public String[] getsPws() { return sPws; }
	public void setsPws(String[] sPws) { this.sPws = sPws; }
	
	public String[] getsNames() { return sNames; }
	public void setsNames(String[] sNames) { this.sNames = sNames; }
	
	public int[] getsAges() { return sAges; }
	public void setsAges(int[] sAges) { this.sAges = sAges; }
	
	public char[] getsGenders() { return sGenders; }
	public void setsGenders(char[] sGenders) { this.sGenders = sGenders; }
	
	public String[] getsMajors() { return sMajors; }
	public void setsMajors(String[] sMajors) { this.sMajors = sMajors; }
}
