public class Quick{
    public static boolean debug = false;
    
    public static int[] partition(int[] data,int left,int right){
	int index = (int)(left + Math.random()*(right-left+1));
	swap(data,index,left);
	if(debug){
	    print(index+"");
	    printlist(data);
	}

	int start = left+1;
	int end = right;
	int piv1 = left;
	int piv2 = left;
	while(start <= end){
	    if(data[start] > data[piv1]){
		swap(data,start,end);
		end--;
	    }else if(data[start] == data[piv1]){
		piv2++;
		start++;
	    }else{
		swap(data,piv1,start);
		if(piv2==piv1){
		    piv2++;
		    start++;
		}
		piv1++;
	    }
	}
	int[] ans = {piv1,piv2};
	return ans;
    }

    public static int partitionOld(int[] data,int left,int right){
	int index = (int)(left + Math.random()*(right-left+1));
	swap(data,index,left);
	if(debug){
	    print(index+"");
	    printlist(data);
	}

	int start = left+1;
	int end = right;
	while(start <= end){
	    if(data[start] > data[left]){
		swap(data,start,end);
		end--;
	    }else{
		swap(data,left,start);
		start++;
		left++;
	    }
	}
	return left;
    }
    
    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }

    private static void quickSort(int[]data,int left,int right){
	if(right-left>0){
	    int index[] = partition(data,left,right);
	    quickSort(data,index[1]+1,right);
       	    quickSort(data,left,index[0]-1);
	}
    }

    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }
    
    private static void quickSortOld(int[]data,int left,int right){
	if(right-left>0){
	    int index = partitionOld(data,left,right);
	    quickSortOld(data,index+1,right);
       	    quickSortOld(data,left,index-1);
	}
    }

    public static int quickselect(int[]data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    
    private static int quickselect(int[]data,int k,int left,int right){
	if(left==right){
	    return data[left];
	}
	int index[] = partition(data,left,right);
	if(index[0] == k){
	    return data[k];
	}else if(index[0] < k){
	    return quickselect(data,k,index[1]+1,right);
	}else{
	    return quickselect(data,k,left,index[0]-1);
	}
    }
    
    public static int quickselectOld(int[]data,int k){
	return quickselectOld(data,k,0,data.length-1);
    }
    
    private static int quickselectOld(int[]data,int k,int left,int right){
	if(left==right){
	    return data[left];
	}
	int index = partitionOld(data,left,right);
	if(index == k){
	    return data[k];
	}else if(index < k){
	    return quickselectOld(data,k,index+1,right);
	}else{
	    return quickselectOld(data,k,left,index-1);
	}
    }

     public static void swap(int[]data,int first,int second){
	int i = data[first];
	data[first] = data[second];
	data[second] = i;
    }

    public static void printlist(int[]data){
	String ans = "";
	for(int i =0;i<data.length;i++){
	    ans+=data[i]+",";
	}
	print(ans);
    }

    public static void print(String s){
	System.out.println(s);
    }

    public static String name(){
	return "7,Zhang,Wenjia";
    }
}
