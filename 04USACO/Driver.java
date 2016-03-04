public class Driver{
    public static void main(String[]args){
	if(args.length == 0){
	    return;
	}
	makelake test = new makelake(args[0]);
	
	System.out.println(test.solve());
    }
}
