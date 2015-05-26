package freshlevel;

import java.util.ArrayList;
import java.util.Scanner;

public class MAXSUM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int cases = sc.nextInt();
		System.out.println("1");
		while(cases-->0){
			int count=sc.nextInt();
			System.out.println("2");
			int[] numb = new int[count];
			for(int i=0;i<count;i++){
				
				numb[i]=sc.nextInt();
			}
			result.add(greedysum(numb));
			
			
		}
		sc.close();
		for(int i=0;i<cases;i++){
			System.out.println(result.get(i));
		}
	}
	public static int greedysum(int[] numb){
		int rnumb=0;
		for(int i=0;i<numb.length;i++)
		{
			if(numb[i]>0){
				
				rnumb+=numb[i];
			}
			
		}
		return rnumb;
	}
}
