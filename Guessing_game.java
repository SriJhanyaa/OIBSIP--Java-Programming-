/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Guessing_game {

	public static void main(String[] args) {int count=1,f=0,num=0,score=0;
		double rate=0.000;
		Scanner into=new Scanner(System.in);
		System.out.println("***********Welcome to Guessing game************\n\n");
		System.out.println("Enter the number of rounds");
		int rounds=into.nextInt();
		while(count<=rounds) {
			if(count==1||f==1) {
				num=(int)(Math.random()*(99)+1);
				//System.out.println("Actual Number "+num);
				f=0;
			}
			System.out.println("\nRound no. "+count+"----------\nEnter the number of your choice ranging from 1 to 100");
			int charac=into.nextInt();
			if(charac==num) {
				System.out.println("Congratulations!!\t Correct guess.\n");
				f=1;
				count++;
				score++;
			}
			else if(charac<num) {
				System.out.println("Nice try!\t the number is greater than "+charac+".\n");
				count++;
			}
			else if(charac>num) {
				System.out.println("Nice try!\tBut the number is lesser than "+charac+".\n");
				count++;
			}
			else {
				System.out.println("Please enter a valid number  between (1-100).\n");
				count++;
			}
		}
		rate=((double)(score/rounds))*100.000;
		System.out.println("-----------\nActual number was "+num+"\n");
		System.out.println("-----------\n Your Total score is "+score);
		System.out.println("\n");
		System.out.println("Thank you!!!!");
	}
}