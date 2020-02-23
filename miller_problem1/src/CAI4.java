package miller_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	
	public int answer, studentAnswer, one, two, messageSelect, score = 0, difficulty, num;
	private int restartChoice;
	
	SecureRandom secureRandom = new SecureRandom();
	Scanner in = new Scanner(System.in);
	
	public void quiz() {
		readDifficulty();
		for(int i=0; i<10; i++)
		{
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		displayCompletionMessage();
		this.score = 0;
		restart();
	}
	
	public void readDifficulty() {
		System.out.print("Please select a difficulty 1-4");
		do 
		{
			this.difficulty = in.nextInt();
		
		}while(this.difficulty < 1 || this.difficulty > 4);
		generateQuestionArgument();
		
	}
	
	public void generateQuestionArgument() {
		
		if(this.difficulty == 1) {
			this.num = 10;
		}
		else if(this.difficulty == 2){
			this.num = 100;
		}
		else if(this.difficulty == 3){
			this.num = 1000;
		}
		else if(this.difficulty == 4){
			this.num = 10000;
		}
		
		
	}
	
	public void askQuestion() {
		this.one = secureRandom.nextInt(this.num);
		this.two = secureRandom.nextInt(this.num);
		this.answer = this.one * this.two;
		System.out.printf("What is %d times %d?", this.one, this.two);
		
	}
	public int getRestartChoice(int choice) {
		return choice;
	}
	public void restart() {
		
		System.out.println("Press 1 to Try Again or 0 to Exit.");
		
		int num = getRestartChoice(this.restartChoice);
		num = in.nextInt();
		
		
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
		CAI4 cai4 = new CAI4();
		cai4.quiz();
	}
}
