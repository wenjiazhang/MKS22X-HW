import java.util.*;
public class Driver{
    public static int length = 4000000;
    public static long start,end,time=0;
    public static void main(String[]args){
        
	for(int i=0;i<3;i++){
	    int[] test = new int[length];
	    for(int e=0;e<length;e++){
		test[e] = (int)(Math.random()*4);
		//test[e] = (int)(Math.random()*Integer.MAX_VALUE*2-Integer.MAX_VALUE);
	    }
	    start = System.currentTimeMillis();
	    Arrays.sort(test);
	    end = System.currentTimeMillis();
	    time+=(end-start);
	}
	Quick.print("Array sort time: "+(time/3)+"ms");
	time = 0;
	for(int i=0;i<3;i++){
	    int[] test = new int[length];
	    for(int e=0;e<length;e++){
		//test[e] = (int)(Math.random()*4);
		test[e] = (int)(Math.random()*Integer.MAX_VALUE*2-Integer.MAX_VALUE);
	    }
	    start = System.currentTimeMillis();
	    Quick.quickSortOld(test);
	    end = System.currentTimeMillis();
	    time+=(end-start);
	}
	Quick.print("QuicksortOld time: "+(time/3)+"ms");
	time = 0;
	for(int i=0;i<3;i++){
	    int[] test = new int[length];
	    for(int e=0;e<length;e++){
		test[e] = (int)(Math.random()*4);
		//test[e] = (int)(Math.random()*Integer.MAX_VALUE*2-Integer.MAX_VALUE);
	    }
	    start = System.currentTimeMillis();
	    Quick.quickSort(test);
	    end = System.currentTimeMillis();
	    time+=(end-start);
	}
	Quick.print("Quicksort time: "+(time/3)+"ms");

	/*
	  for(int i=0;i<100;i++){
	    int[] test = new int[length];
	    int[] answer = new int[length];
	    for(int e=0;e<length;e++){
		test[e] = (int)(Math.random()*4);
		//test[e] = (int)(Math.random()*Integer.MAX_VALUE*2-Integer.MAX_VALUE);
		answer[e] = test[e];
	    }
	    //Quick.printlist(test);
	    Quick.quickSort(test);
	    Arrays.sort(answer);
	    
	    if(!Arrays.equals(answer,test)){
		System.out.println("BAD: "+i+"\n");
		Quick.printlist(answer);
		Quick.printlist(test);
		return;
	    }
	}
	 */
    }
}
