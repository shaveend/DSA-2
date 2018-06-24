import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class LIS{
	static void lis (int[] arr){
		int[] seq= new int[arr.length];
		int[] order = new int[arr.length];
		int[] temp =new int[arr.length];
		
		Arrays.fill(seq,1);
		Arrays.fill(order,-1);
		Arrays.fill(temp,-1);
		
		
		int max=-1;
		int max_index=0;
		
		for (int i=1;i<arr.length;i++){
			
			for(int j=0;j<i;j++){
				
				if((arr[i]> arr[j]) && (seq[i]<=seq[j])){
					seq[i]=seq[j]+1;
					
					if(max<seq[i]){
						max=seq[i];
						max_index=i;
					}
					
					order[i]=j;
				}
			}
		}
		System.out.println("The largest increasing Subsequence:");
		for( int q=(arr.length-1);q>=0;q--){
			if(seq[q]==max){
					max_index=q;
		
				for(int k=max-1;k>=0;k--){
					temp[k]=arr[max_index];
					max_index=order[max_index];
				}
		
				for (int l=0; l<max; l++){
					System.out.print(temp[l]+" ");
			
				}
			System.out.println();
			//break;
			}
		}
	}
	
	public static void main (String args[]){
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter number of participants : ");
		int n =reader.nextInt();
		while(n>1000 || n<1){
			System.out.println(" Enter New number between 1 and 1000");
			n=reader.nextInt();
			}
		reader.close();
		System.out.println(n);	
		int arr1[]= new int[n];
		Random rand = new Random();
		int rand_int;
		for (int p=0; p<n;p++){
			rand_int=rand.nextInt(n);
			System.out.print((arr1[p]=rand_int) +" ");
			
		}
		System.out.println();
		lis(arr1);
	}
}
		
			
			
			
			
