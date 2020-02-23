package miller_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	
	public int answer, studentAnswer, one, two, messageSelect, score = 0, restartChoice;
	
	SecureRandom secureRandom = new SecureRandom();
	Scanner in = new Scanner(System.in);
	
	public void quiz() {
		for(int i=0; i<10; i++)
		{
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		displayCompletionMessage();
		restart();
	}
	
	
	public void askQuestion() {
		this.one = secureRandom.nextInt(10);
		this.two = secureRandom.nextInt(10);
		this.answer = this.one * this.two;
		System.out.printf("What is %d times %d?", this.one, this.two);
		
	}
	
	public void restart() {
		
		System.out.println("Press 1 to Try Again or 0 to Exit.");
		this.restartChoice = in.nextInt();
		
		int num = this.restartChoice;
		
		if(num == 1) 
		{
			quiz();
		}
		else 
		{
			System.exit(0);
		}
	}
	
	
	public void readResponse() {
		this.studentAnswer = in.nextInt();
	}
	
	public int calculateScore(int newScore) {
		
		newScore = this.score * 10;
		
		return newScore;
	}
	
	public void isAnswerCorrect() {
		if(this.studentAnswer == this.answer)
		{
			displayCorrectResponse();
			this.score++;
		}
		else {
			displayIncorrectResponse();
			
		}
	}
	
	
	public void displayCompletionMessage() {
		
		if(calculateScore(this.score) < 75)
		{
			System.out.printf("Your Score: %d",calculateScore(this.score));
			System.out.print("%\n");
			System.out.println("Please ask your teacher for extra help.");
		}
		else {
			System.out.printf("Your Score: %d",calculateScore(this.score));
			System.out.print("%\n");
			System.out.println("Congratulations, you are ready to go to the next level!");
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
		CAI3 cai3 = new CAI3();
		cai3.quiz();
	}
}
