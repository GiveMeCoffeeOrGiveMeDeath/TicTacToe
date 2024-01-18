import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ticTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[]args) {

        

        int playerPosition = 0;

        char [][] gameBoard = {{' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '}};
        

        

        while(true){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your placement (1-9): ");
        playerPosition = keyboard.nextInt();

        while(playerPositions.contains(playerPosition) || cpuPositions.contains(playerPositions)) {

            System.out.println("Position taken! Enter a correct Position");
            playerPosition = keyboard.nextInt();
        }

        System.out.println();
        placePiece(gameBoard, playerPosition, "player");
        String result = checkWinner();
        if(result.length() > 0){
            System.out.println(result);
            break;
        }


        Random rand = new Random();
        int cpuPosition = rand.nextInt(9) + 1;
        while(playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
            cpuPosition = rand.nextInt(9) + 1;
        }
        placePiece(gameBoard, cpuPosition, "cpu");

        printBoard(gameBoard);
        result = checkWinner();
        if(result.length() > 0){
            System.out.println(result);
            break;
        }
        System.out.println(result);
        }
        
    }

    public static void printBoard(char[][] gameBoard){
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard,int position, String user) {
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(position);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch(position){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner(){
        
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftcolum = Arrays.asList(1,4,7);
        List middlecolum = Arrays.asList(2,5,8);
        List rightcolum = Arrays.asList(3,6,9);
        List leftAcross = Arrays.asList(1,5,9);
        List rightAcross = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftcolum);
        winning.add(middlecolum);
        winning.add(rightcolum);
        winning.add(leftAcross);
        winning.add(rightAcross);

        for(List l: winning){
        
            if(playerPositions.containsAll(l)){
                return "Congratulations you won!";
            }else if(cpuPositions.containsAll(l)){
                return "CPU wins! Sorry :(";
            }else if(playerPositions.size() + cpuPositions.size() == 9){
                return "CAT!";
            }
        }
        return "";
    }
}
    