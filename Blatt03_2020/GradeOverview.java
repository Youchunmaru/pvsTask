package Blatt03_2020;
import Blatt02_2020.Pair;

import java.util.HashMap;
import java.util.Optional;

public class GradeOverview {

    private final HashMap<String, Pair<Double, Integer>> GRADEOVERVIEW = new HashMap<>();

    /** Adds a test result to GradeOverview
     * @param lectureName name of the lecture in which the grade and ects was gained
     * @param gradeAndECTS the grade and ects to add
     *
     * */
    Pair<Double, Integer> addTestResult(String lectureName, Pair gradeAndECTS){
        return GRADEOVERVIEW.put(lectureName,gradeAndECTS);
    }
    /** returns the sum of all gained ects
     * @return sum of all gained ects
     *
     * */
    int currentECTS(){
        var values = GRADEOVERVIEW.values();
        int ects = 0;
        for (Pair<Double, Integer> gradeAndECTS: values) {

            ects += gradeAndECTS.getSecond();
        }
        return ects;
    }
    /** returns the Exam results of an specified lecture
     * @param lectureName name of the lecture
     *
     * */
    Optional<Pair<Double, Integer>> getExamResults(String lectureName){
        return Optional.ofNullable(GRADEOVERVIEW.get(lectureName));
    }
    /** returns the average grade of GradeOverview
     *
     * */
    double totalGradeAverage(){
        var values = GRADEOVERVIEW.values();
        double grade = 0;
        for (Pair<Double, Integer> gradeAndECTS: values) {
            grade += gradeAndECTS.getFirst()*gradeAndECTS.getSecond();
        }
        return (grade / this.currentECTS());
    }
    /** see {@link #currentECTS()}
     * @return sum of all gained ects
     *
     * */
    int currentECTSStream(){
        return GRADEOVERVIEW.values()
                .stream()
                .mapToInt(gradeAndECTS -> gradeAndECTS.getSecond())
                .sum();
    }
    /** see {@link #totalGradeAverage()}
     * @return the average grade
     *
     * */
    double totalGradeAverageStream(){
        return GRADEOVERVIEW.values()
                .stream()
                .mapToDouble(gradeAndECTS -> gradeAndECTS.getFirst()*gradeAndECTS.getSecond())
                .sum()/this.currentECTS();
    }
}
