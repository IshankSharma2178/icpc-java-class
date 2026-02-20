import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int test = sc.nextInt();
	    while(test --> 0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	        int opr = 0;
	        for(int i=0;i<n-1;i++){
	            if((arr[i]%2 == 0) == (arr[i+1] % 2 == 0)){
	                opr++;
	            }
	        }
	        System.out.println(opr);
	    }
	    
	}
}