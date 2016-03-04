import java.util.*;
import java.io.*;

public class makelake{
    public int[][] field,instr;
    public int[] cowAt = new int[2];
    public int R,C,E,N,R_s,C_s,D_s;
    private Scanner in;
    public static String name = ",7,Zhang,Wenjia";
    private static boolean debug = false;
    
    public makelake(String file){
	try{
	    in = new Scanner(new File(file));
	    String all = "";
	    while(in.hasNextLine()){
		all+=in.nextLine()+"\n";
	    }
	    String[] lines = all.split("\n");
	    String[] line = lines[0].split(" ");
	    R = Integer.parseInt(line[0]);
	    C = Integer.parseInt(line[1]);
	    E = Integer.parseInt(line[2]);
	    N = Integer.parseInt(line[3]);
	    field = new int[R][C];
	    for(int row=1;row<=R;row++){
		line = lines[row].split(" ");
		for(int col = 0;col<line.length;col++){
		    field[row-1][col] = Integer.parseInt(line[col]);
		}
	    }
	    instr = new int[N][3];
	    for(int i=0;i<N;i++){
		line = lines[R+1+i].split(" ");
		for(int col=0;col<3;col++){
		    instr[i][col] = Integer.parseInt(line[col]);
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	}
	    
    }

    public String solve(){
	return solve(0) + name;
    }

    public int solve(int step){
	if(step==N){
	    int depth = 0;
	    for(int row =0;row<R;row++){
		for(int col=0;col<C;col++){
		    if(field[row][col]<E){
			depth += E - field[row][col];
		    }
		}
	    }
	    return depth*72*72;
	}else{
	    for(int i=0;i<instr[step][2];i++){
		int high = highest(instr[step][0]-1,instr[step][1]-1);
		for(int x=-1;x<2;x++){
		    for(int y=-1;y<2;y++){
			/*if(debug){
			    System.out.println(instr[step][0]+x+","+(instr[step][1]+y)+","+field[instr[step][0]+x][instr[step][1]+y]);
			    }*/
			if (field[instr[step][0]+x][instr[step][1]+y]==high){
			    field[instr[step][0]+x][instr[step][1]+y]-=1;
			}
		    }
		}
		if(debug){
		    System.out.println(highest(instr[step][0]-1,instr[step][1]-1)+"\n"+toString()+"\n");
		}
	    }
	    return solve(step+1);
	}
    }

    private int highest(int row,int col){
	int ans = Integer.MIN_VALUE;
	for(int x=0;x<3;x++){
	    for(int y=0;y<3;y++){
		if (field[row+x][col+y]>ans){
		    ans = field[row+x][col+y];
		}
	    }
	}
	return ans;
    }
    
    public String toString(){
	String ans = "";
	for(int row = 0;row<R;row++){
	    for(int col = 0;col<C;col++){
		ans += field[row][col] + " ";
	    }
	    ans += "\n";
	}
	if(debug){
	    for(int row = 0;row<N;row++){
		for(int col = 0;col<3;col++){
		    ans += instr[row][col] + " ";
		}
		ans += "\n";
	    }
	}
	return ans;
    }
}
