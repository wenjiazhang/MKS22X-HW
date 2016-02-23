public class Recursion{

    public Recursion(){};

    public String name(){
	return "Zhang,Wenjia";
    }

    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}else{
	    return sqrtH(n,1); 
	}
    }

    private double sqrtH(double n,double guess){
	//System.out.println(n+","+guess);
	if (Math.abs(n-guess*guess)/n < 0.00001){
	    return guess;
	}else{
	    return sqrtH(n,(n/guess+guess)/2);
	}
    }
}
