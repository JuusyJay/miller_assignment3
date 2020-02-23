package miller_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	public int  studentAnswer, messageSelect, score = 0, difficulty, probType, intNum,
				intAnswer, intOne, intTwo, isDivision;
	private int restartChoice;
	
	
	SecureRandom secureRandom = new SecureRandom();
	Scanner in = new Scanner(System.in);
	
	public void quiz() {
		readDifficulty();
		readProblemType();
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
		System.out.print("Please select a difficulty 1-4:");
		do 
		{
			this.difficulty = in.nextInt();
		
		}while(this.difficulty < 1 || this.difficulty > 4);
		generateQuestionArgument();
		
	}
	
	public void readProblemType() {
		System.out.print("Please select a problem type 1-5:");

		do 
		{
			this.probType = in.nextInt();
		
		}while(this.probType < 1 || this.probType > 5);
	}
	
	public void generateQuestionArgument() {
		
		if(this.difficulty == 1) {

			this.intNum = 10;
		}
		else if(this.difficulty == 2){

			this.intNum = 100;
		}
		else if(this.difficulty == 3){

			this.intNum = 1000;
		}
		else if(this.difficulty == 4){
	
			this.intNum = 10000;
		}
		
		
	}
	
	public void askQuestion() {
		if(this.probType == 1) {
		
			
			this.intOne = secureRandom.nextInt(this.intNum);
			this.intTwo = secureRandom.nextInt(this.intNum);
			
			this.intAnswer = this.intOne + this.intTwo;
			
			System.out.printf("What is %d + %d?", this.intOne, this.intTwo);
		}
		else if (this.probType == 2) {
			
			
			this.intOne = secureRandom.nextInt(this.intNum);
			this.intTwo = secureRandom.nextInt(this.intNum);
			
			this.intAnswer = this.intOne * this.intTwo;
			
			System.out.printf("What is %d * %d?", this.intOne, this.intTwo);
		}
		else if (this.probType == 3) {
			
			
			this.intOne = secureRandom.nextInt(this.intNum);
			this.intTwo = secureRandom.nextInt(this.intNum);
			
			this.intAnswer = this.intOne - this.intTwo;
			
			System.out.printf("What is %d - %d?", this.intOne, this.intTwo);
		}
		else if (this.probType == 4) {
			
			this.intOne = secureRandom.nextInt(this.intNum) + 1;
			this.intTwo = secureRandom.nextInt(this.intNum) + 1;
			
			this.intAnswer = this.intOne / this.intTwo;
			
			System.out.printf("%d", this.intAnswer);
			System.out.printf("What is %d / %d?(Use integer division)", this.intOne, this.intTwo);
		}
		else{
			int i = secureRandom.nextInt(3) + 1;
			
			if(i == 1) {
			
				
				this.intOne = secureRandom.nextInt(this.intNum);
				this.intTwo = secureRandom.nextInt(this.intNum);
				
				this.intAnswer = this.intOne + this.intTwo;
				
				System.out.printf("What is %d + %d?", this.intOne, this.intTwo);
			}
			else if(i == 2) {
			
				
				this.intOne = secureRandom.nextInt(this.intNum);
				this.intTwo = secureRandom.nextInt(this.intNum);
				
				this.intAnswer = this.intOne * this.intTwo;
				
				System.out.printf("What is %d * %d?", this.intOne, this.intTwo);
			}
			else if(i == 3) {
				
				
				this.intOne = secureRandom.nextInt(this.intNum);
				this.intTwo = secureRandom.nextInt(this.intNum);
				
				this.intAnswer = this.intOne - this.intTwo;
				
				System.out.printf("What is %d - %d?", this.intOne, this.intTwo);
			}
			else if(i == 4) {
				
				this.intOne = secureRandom.nextInt(this.intNum) + 1;
				this.intTwo = secureRandom.nextInt(this.intNum) + 1;
				
				this.intAnswer = (this.intOne) / (this.intTwo);
				
				
				System.out.printf("What is %d / %d?(Use integer division)", this.intOne, this.intTwo);
			}
		}
	
		
		
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
		
		if(this.studentAnswer == this.intAnswer) {
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
		CAI5 cai5 = new CAI5();
		cai5.quiz();
	}
}
