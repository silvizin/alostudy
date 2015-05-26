package freshlevel;

import java.util.ArrayList;
import java.util.Scanner;

public class WEEKLYCALENDAR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < cases; i++) {

			int m = sc.nextInt();
			int d = sc.nextInt();
			String yoil = sc.next();
			result.add(calendar(m, d, yoil));

		}
		for (int i = 0; i < cases; i++) {
			System.out.println(result.get(i));
		}
	}

	public static int choicemax(int m) {
		int max = 0;
		int[][] month = { { 1, 3, 5, 7, 8, 10, 12 }, { 4, 6, 9,11 }, { 2 } };
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < month[a].length; b++) {
				if (m == month[a][b]) {
					if (a == 0) {
						max = 31;
					} else if (a == 1) {
						max = 30;
					} else if (a == 2) {
						max = 28;
					}
				}
			}

		}

		return max;
	}

	public static String calendar(int m, int d, String yoil) {
		String result = "";
		int where = 0;
		int[] ncal = new int[7];
		String[] s = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday" };

		for (int i = 0; i < 7; i++) {
			if (s[i].equals(yoil)) {
				where = i;
			}
			;
		}

		ncal = yo(m, d, where);
		for (int i = 0; i < 6; i++) {
			result += String.valueOf(ncal[i]) + " ";
		}
		result+=String.valueOf(ncal[6]);

		return result;
	}

	public static int[] yo(int m, int d, int where) {
		int[] result = new int[7];
		int max = choicemax( m);

		int dtmp = d;
		for (int k = where; k < result.length; k++) {

			result[k] = dtmp;
			dtmp++;
			if (dtmp > max) {
				dtmp = 1;
			}
		}
		
		int cnt = 0;
		int tmp = 0;
		for (int k = 0; k < result.length; k++) {
			if (result[k] == 0) {
				cnt++;
			}
		}
		
		tmp = d - 1;
		if(tmp==0){
			if(m==1){
				tmp=choicemax(12);
			}else{
			tmp=choicemax(m-1);}
		}
		for (int k = cnt-1; k >=0; k--) {
			result[k] = tmp;
			tmp--;
			if (tmp < 1) {
				if(m==1){
					tmp=choicemax(12);
				}else{
				tmp = choicemax(m-1);
				
				}
			}

		}

		return result;
	}
}