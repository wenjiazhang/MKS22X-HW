public class Driver{
    public static void main(String[]wot){
	QueenBoard board = new QueenBoard(8);
	System.out.println(board.solve());
	board.printSolution();
    }
}
