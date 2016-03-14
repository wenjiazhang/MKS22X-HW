public class Sorts{
    public static boolean debug = false;
    
    public static void  mergesort(int[]data){
	mergesort(data,0,data.length-1);
    }

    public static void mergesort(int[]data,int start,int end){
	if(end-start==1 && data[start]>data[end]){
	    int i = data[start];
	    data[start] = data[end];
	    data[end] = i;
	}else if(end-start>1){
	    mergesort(data,start,(int)((end+start)/2));
	    mergesort(data,(int)((end+start)/2)+1,end);
	    merge(data,start,(int)((end+start)/2),(int)((end+start)/2)+1,end);
	}
	
    }

    public static void merge(int[]data,int start1,int end1,int start2,int end2){
	//int now = start1;
	if(debug){print(data);}
	while(start1<start2 && (end1-start1>=0 || end2-start2>=0)){
	    if(debug){System.out.println(start1+": "+data[start1]+"; "+start2+": "+data[start2]);}
	    if(data[start1]>data[start2]){
		shuffle(data,start1,start2);
		start1++;
		start2++;
	    }else{
		start1++;
	    }
	    if(debug){print(data);}
	}
    }

    public static void shuffle(int[]data,int start,int index){
	int target = data[index];
	for(int i=index;i>start;i--){
	    data[i] = data[i-1];
	}
	data[start] = target;
    }

    public static void print(int[]data){
        String ans = "";
        for(int i=0;i<data.length;i++){
            ans+=data[i]+", ";
        }
        System.out.println(ans);
    }
    
    public static String name(){
	return "7,Zhang,Wenjia";
    }
}
