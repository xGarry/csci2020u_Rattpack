package sample;

import javafx.beans.property.*;

public class StudentRecord {

    private StringProperty letterGrade;
    private FloatProperty assignment, midterm, finalExam, finalMark;

    private StringProperty sid;

    public void setSid(String value) {
        sidProperty().set(value);
    }

    public String getSid() {
        return sidProperty().get();
    }

    public StringProperty sidProperty() {
        if (sid == null) sid = new SimpleStringProperty(this, "sid");
        return sid;
    }

    public void setAssignment(float value) {
        assignmentProperty().set(value);
    }

    public float getAssignment() {
        return assignmentProperty().get();
    }

    public FloatProperty assignmentProperty() {
        if (assignment == null) assignment = new SimpleFloatProperty(this, "assignment");
        return assignment;
    }

    public void setMidterm(float value) {
        midtermProperty().set(value);
    }

    public float getMidterm() {
        return midtermProperty().get();
    }

    public FloatProperty midtermProperty() {
        if (midterm == null) midterm = new SimpleFloatProperty(this, "midterm");
        return midterm;
    }

    public void setFinalExam(float value) {
        finalExamProperty().set(value);
    }

    public float getFinalExam() {
        return finalExamProperty().get();
    }

    public FloatProperty finalExamProperty() {
        if (finalExam == null) finalExam = new SimpleFloatProperty(this, "finalExam");
        return finalExam;
    }

    public void setFinalMark() {
        float value = ((getAssignment() / 100) * 0.2f) + ((getMidterm() / 100) * 0.3f) + ((getFinalExam() / 100) * 0.5f);
        finalMarkProperty().set(value);
    }

    public float getFinalMark() {
        return finalMarkProperty().get();
    }

    public FloatProperty finalMarkProperty() {
        if (finalMark == null) finalMark = new SimpleFloatProperty(this, "finalMark");
        return finalMark;
    }

    public void setLetterGrade() {
        String grade;
        if (getFinalMark() >= 90) {
            grade = "A";
        } else if (getFinalMark() >= 80) {
            grade = "B";
        } else if (getFinalMark() >= 70) {
            grade = "C";
        } else if (getFinalMark() >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        this.letterGrade = grade;
    }

    public String getLetterGrade() {
        return letterGradeProperty().get();
    }

    public StringProperty letterGradeProperty() {
        if (letterGrade == null) letterGrade = new SimpleStringProperty(this, "finalMark");
        return letterGrade;
    }
}

