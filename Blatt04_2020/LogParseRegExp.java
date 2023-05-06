package Blatt04_2020;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** Parses a log with regular expressions
 * @author Samuel Gröner
 * @lecture PvS
 *
 * */

public class LogParseRegExp {

    public static void main(String[] args) throws IOException {

        String input = readString();
        //System.out.println(input);
        Pattern pattern = genLogPattern();
        outputLog(pattern, input);
    }

    /** prints the log in the terminal
     * @param input is a string that contains the log
     * @param pattern contains a pattern with regular expressions
     *
     * */

    private static void outputLog(Pattern pattern, String input) {

        Matcher matcher = pattern.matcher(input);
        int count = 0;

        while(matcher.find()){

            System.out.println("Warning " + matcher.group(1) + " at line " + matcher.group(4) + " in file " + matcher.group(3));
            count++;
        }
        System.out.println("Found " + count + " warnings!");
    }

    /** generates a pattern with regular expressions
     * @return 's the generated pattern
     *
     * */

    private static Pattern genLogPattern() {
        return Pattern.compile("Warning (\\d+) of (\\d+):\n\n.*\n  at ([^\\s]+) line (\\d+)");
    }

    /** reads the log
     * @return 's the log as String
     *
     * */

    static String readString() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("build.log"));
        String input = in.readLine();
        String line;
        while ((line = in.readLine()) != null){
            input += "\n" + line;
        }
        return input;
    }
}
