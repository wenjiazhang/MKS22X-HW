public class KnightBoard{
    public static boolean DEBUG=false;
    public int row,col;
    public int[][] board;

    public KnightBoard(int row,int col){
	this.row=row;
	this.col=col;
	board = new int[row+4][col+4];
	wipe();
    }

    public boolean solve(){
	return solve(0,0,1);
    }
   
    private boolean solve(int x,int y,int currentMove){
	if(DEBUG){
	    //System.out.println(x+","+y);
	}
	//bad spot
	if(board[x+2][y+2]!=0){
	    return false;
	}
	//put down
	board[x+2][y+2] = currentMove;
	//solved?
	if(currentMove == row*col){
	    return true;
	}

	if(solve(x+2,y+1,currentMove+1) ||
	   solve(x+2,y-1,currentMove+1) ||
	   solve(x-2,y+1,currentMove+1) ||
	   solve(x-2,y-1,currentMove+1) ||
	   solve(x+1,y+2,currentMove+1) ||
	   solve(x+1,y-2,currentMove+1) ||
	   solve(x-1,y+2,currentMove+1) ||
	   solve(x-1,y-2,currentMove+1)
	   ){
	    return true;
	}

	board[x+2][y+2] = 0;
	return false;
    }
    
    public void printSolution(){
	String ans = "";
	for(int row=0;row<this.row;row++){
	    for(int col=0;col<this.col;col++){
		if(board[row+2][col+2]<10){
		    ans+="_"+board[row+2][col+2]+" ";
		}else{
		    ans+=board[row+2][col+2]+" ";
		}
	    }
	    ans+="\n";
	}
	System.out.println(ans);
    }

    /*
      public void printSolution(){
	String ans = "";
	for(int row=0;row<this.row;row++){
	    for(int col=0;col<this.col;col++){
		if(board[row+2][col+2]<10){
		    ans+="_"+board[row+2][col+2]+" ";
		}else{
		    ans+=board[row+2][col+2]+" ";
		}
	    }
	    ans+="\n";
	}
	System.out.println(ans);
    }
     */

    private void wipe(){
	for(int i=0;i<board.length;i++){
	    board[i][0] = -1;
	    board[i][1] = -1;
	    board[i][board[0].length-1] = -1;
	    board[i][board[0].length-2] = -1;
	}
	for(int i=0;i<board[0].length;i++){
	    board[0][i] = -1;
	    board[1][i] = -1;
	    board[board.length-2][i] = -1;
	    board[board.length-1][i] = -1;
	}
	for(int row=0;row<this.row;row++){
	    for(int col=0;col<this.col;col++){
		board[row+2][col+2] = 0;
	    }
	}
    }
}
