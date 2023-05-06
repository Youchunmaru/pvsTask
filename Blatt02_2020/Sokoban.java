package Blatt02_2020;

public class Sokoban {

    public static void main(String[] args){

        char[][] sokoban = gen7x7Field();
        System.out.println(findPlayer(sokoban));
        ToString(sokoban);
        System.out.println(move(sokoban,"North"));
        ToString(sokoban);
        System.out.println(move(sokoban,"East"));
        ToString(sokoban);
        System.out.println(move(sokoban,"South"));
        ToString(sokoban);
        System.out.println(move(sokoban,"South"));
        ToString(sokoban);
        System.out.println(move(sokoban,"West"));
        ToString(sokoban);
    }
    static char[][] gen7x7Field(){
        char [][] sokoban = new char [7][];
        sokoban [0] = "#######". toCharArray ();
        sokoban [1] = "#.....#". toCharArray ();
        sokoban [2] = "#..$..#". toCharArray ();
        sokoban [3] = "#.$@$.#". toCharArray ();
        sokoban [4] = "#..$..#". toCharArray ();
        sokoban [5] = "#.....#". toCharArray ();
        sokoban [6] = "#######". toCharArray ();
        return sokoban;
    }
    static Pair findPlayer(char[][] array){

        Pair pair = new Pair(-1,-1);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(array[i][j] == '@'){
                    pair = new Pair(i,j);
                    return pair;
                }
            }
        }
        return pair;
    }
    static int[] moveDirection(String direction){

        int[] dir = {0,0,0,0};
        if (direction == "North") {
            dir[0] = 1;
            dir[2] = 2;
        }
        if (direction == "South") {
            dir[0] = -1;
            dir[2] = -2;
        }
        if (direction == "West") {
            dir[1] = 1;
            dir[3] = 2;
        }
        if (direction == "East") {
            dir[1] = -1;
            dir[3] = -2;
        }

        return dir;
    }
    static Boolean move(char[][] array, String direction){

        int[] dir = moveDirection(direction);
        Boolean move = false;
        Pair pair = findPlayer(array);
        if(array[(int)pair.getFirst()-dir[0]][(int)pair.getSecond()-dir[1]]=='$' && array[(int)pair.getFirst()-dir[2]][(int)pair.getSecond()-dir[3]]=='.'){
            move = true;
            array[(int)pair.getFirst()][(int)pair.getSecond()] = '.';
            array[(int)pair.getFirst()-dir[0]][(int)pair.getSecond()-dir[1]] = '@';
            array[(int)pair.getFirst()-dir[2]][(int)pair.getSecond()-dir[3]] = '$';
        }
        if(array[(int)pair.getFirst()-dir[0]][(int)pair.getSecond()-dir[1]]=='.'){
            move = true;
            array[(int)pair.getFirst()][(int)pair.getSecond()] = '.';
            array[(int)pair.getFirst()-dir[0]][(int)pair.getSecond()-dir[1]] = '@';
        }
        return move;
    }

    static void ToString(char[][] array){

        String sokobanField = "";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {

                sokobanField = sokobanField + array[i][j];
            }
            sokobanField = sokobanField + "\n";
        }
        System.out.println(sokobanField);
    }
}
