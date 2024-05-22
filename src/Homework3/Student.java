package Homework3;

public class Student {
    private String studentNumber;
    private String studentName;
    private float milestone1;
    private float milestone2;
    private float terminalAssessment;
    private float averageGrade;

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getMilestone1() {
        return String.valueOf(milestone1);
    }

    public String getMilestone2() {
        return String.valueOf(milestone2);
    }

    public String getTerminalAssessment() {
        return String.valueOf(terminalAssessment);
    }

    public String getAverageGrade() {
        return String.valueOf(averageGrade);
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMilestone1(float milestone1) {
        this.milestone1 = milestone1;
    }

    public void setMilestone2(float milestone2) {
        this.milestone2 = milestone2;
    }

    public void setTerminalAssessment(float terminalAssessment) {
        this.terminalAssessment = terminalAssessment;
    }

    public void computeAverage() {
        this.averageGrade = (milestone1 * 0.25f) + (milestone2 * 0.40f) + (terminalAssessment * 0.35f);
    }
}
