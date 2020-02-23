package miller_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	public int answer, studentAnswer, one, two;
	
	SecureRandom secureRandom = new SecureRandom();
	Scanner in = new Scanner(System.in);
	
	public void quiz() {
		askQuestion();
		readResponse();
		isAnswerCorrect();
	}
	
	
	public void askQuestion() {
		this.one = secureRandom.nextInt(10);
		this.two = secureRandom.nextInt(10);
		this.answer = this.one * this.two;
		System.out.printf("What is %d times %d?", this.one, this.two);
		
	}
	
	
	public void readResponse() {
		this.studentAnswer = in.nextInt();
	}
	
	
	public void isAnswerCorrect() {
		if(this.studentAnswer == this.answer)
		{
			displayCorrectResponse();
			System.exit(0);
		}
		else {
			displayIncorrectResponse();
			System.out.printf("What is %d times %d?", this.one, this.two);
			readResponse();
			isAnswerCorrect();
		}
	}
	
	
	public void displayCorrectResponse() {
		System.out.println("Very Good!");
	}
	
	
	public void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	
	
	public static void main(String[] args) {
		CAI1 cai1 = new CAI1();
		cai1.quiz();
	}
}
