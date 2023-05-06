package Blatt03;

import java.util.HashMap;
import java.util.Optional;
/** 2 GradeOverview:
 * puts all lectures with grades and the gained ects for one student in a HashMap
 * @author Samuel Gröner
 * Blatt 03
 * Tut 03
 *
 * referncesheet -> {@link Blatt03}
 * */
public class GradeOverview {
    /* 2.5 main:
     * testing GradeOverview
     * */
    public static void main(String[] args){
        GradeOverview student = new GradeOverview();
        student.addTestResult("PS",new Pair<>(1.0,8));
        student.addTestResult("A1",new Pair<>(1.25,8));
        student.addTestResult("AD",new Pair<>(1.75,6));
        System.out.println(student.currentECTS());
        System.out.println(student.getExamResults("PS"));
        System.out.println(student.totalGradeAverage());

        System.out.println(student.streamCurrentECTS());
        System.out.println(student.streamTotalGradeAverage());
    }

    /** 2.1 Field:
     * #GRADEOVERVIEW saves all lectures with the grades and ects
     * */
    private final HashMap<String, Pair<Double,Integer>> GRADEOVERVIEW = new HashMap<>();
    /** 2.1 addTestResult:
     * adds a lecture with the grade and the gained ects to {@link #GRADEOVERVIEW}
     * @param gradeAndECTS is the grade and ects of a lecture
     * @param lectureName is the name of the lecture
     * */
    public void addTestResult(String lectureName, Pair<Double,Integer> gradeAndECTS){
        GRADEOVERVIEW.put(lectureName,gradeAndECTS);
    }
    /** 2.2 currentECTS:
     * calculates the current amount of ects within all lectures
     * @return the amount of ects the student has
     * */
    public int currentECTS(){
        int ects = 0;
        for (Pair<Double,Integer> gradeAndECTS: GRADEOVERVIEW.values()) {
            ects += gradeAndECTS.getSecond();
        }
        return ects;
    }
    /** 2.3 getExamResults:
     * returns the exam results of a specified lecture as {@link Optional}
     * if the student hasn't yet attended to the lecture it returns an empty Optional
     * @param lectureName name of the lecture
     * @return returns the exam results
     * */
    public Optional<Pair<Double,Integer>> getExamResults(String lectureName){
        return Optional.ofNullable(GRADEOVERVIEW.get(lectureName));
    }
    /** 2.4 totalGradeAverage:
     * calculates the average grade of all lectures
     * lectures are weighted with the gained ects
     * @return the average grade of the student
     * */
    public double totalGradeAverage(){
        double grade = 0;
        for (Pair<Double,Integer> gradeAndECTS: GRADEOVERVIEW.values()) {
            grade += gradeAndECTS.getFirst()*gradeAndECTS.getSecond();
        }
        return grade/this.currentECTS();
    }
    /** 3.1 streamCurrentECTS:
     * stream version of {@link #currentECTS()}
     * @return the current ects
     * */
    public int streamCurrentECTS(){
        return GRADEOVERVIEW.values().stream().mapToInt(value ->
                value.getSecond()).sum();
    }
    /** 3.1 streamTotalGradeAverage:
     * stream version of {@link #totalGradeAverage()}
     * @return the average grade
     * */
    public double streamTotalGradeAverage(){
        return GRADEOVERVIEW.values().stream().mapToDouble(value ->
                value.getSecond()* value.getFirst()).sum()/this.streamCurrentECTS();
    }
}
