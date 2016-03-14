public class Driver{
    public static void main(String[]args){
	int[] test = {9,5,1,9,0,5,-11,88};
	Sorts.mergesort(test);
	print(test);
    }

    public static void print(int[]data){
	String ans = "";
	for(int i=0;i<data.length;i++){
	    ans+=data[i]+", ";
	}
	System.out.println(ans);
    }
}