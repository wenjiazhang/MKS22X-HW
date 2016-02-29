public class QueenBoard{
    private int[][]board;
    public boolean debug=false;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	return solveH(0,0);
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH(int row,int col){
	if(debug){
	    System.out.println(row+","+col);
	}
	if(col==board.length){
	    return true;
	}
	if(row<board.length){
	    if(!addQueen(row,col) || !solveH(0,col+1)){
		removeQueen(row,col);
		return solveH(row+1,col);		
	    }else{
		return true;
	    }
	}
	return false;
    }
    //	return false;

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
	String ans = "";
	for(int row=0;row<board.length;row++){
	    for(int col=0;col<board[row].length;col++){
		if(board[row][col]!=1){
		    ans+="_ ";
		}else{
		    ans+="Q ";
		}
	    }
	    ans+="\n";
	}
	System.out.println(ans);
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    /*
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
    }
    */
    
}
