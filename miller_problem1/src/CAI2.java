package miller_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
	public int answer, studentAnswer, one, two, messageSelect;
	
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
		this.messageSelect = secureRandom.nextInt(4);
		
		switch (this.messageSelect) {
		case 0: System.out.println("Very Good!");
				break;
		case 1: System.out.println("Excellent!");
				break;
		case 2:	System.out.println("Nice work!");
				break;
		case 3:	System.out.println("Keep up the good work!");
				break;
		}
	}

		
	public void displayIncorrectResponse() {
		
		this.messageSelect = secureRandom.nextInt(4);
		
		switch (this.messageSelect) {
			case 0: System.out.println("No. Please try again.");
					break;
			case 1: System.out.println("Wrong. Try once more.");
					break;
			case 2:	System.out.println("Don't give up!");
					break;
			case 3:	System.out.println("No. Keep trying.");
					break;
		}
	}

	
	
	public static void main(String[] args) {
		CAI2 cai2 = new CAI2();
		cai2.quiz();
	}
}
