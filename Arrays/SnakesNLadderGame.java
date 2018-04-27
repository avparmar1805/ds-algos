package Arrays;

public class SnakesNLadderGame {
	public static void main (String[] args) {
		// 1. {2,6,1,1,3,1} checks Sn[2] = 19 and num greater than 20
		// 2. {2,6,1,4,4,5,5,5,2} checks Sn[5] = 13, Sn[17] = 3
		// 3. {2,6,5,6,6,6} checks Sn[11] = 7

		int[] diceArray = {2,6,5,6,6,6,1} ;
		boolean isGameOpened = false;
		int currentDiceNum = 0;
		int boardIndex = 0;
		for(int i = 0; i<diceArray.length; i++) {
			currentDiceNum = diceArray[i];

			if(isGameOpened) {
				int index = boardIndex+currentDiceNum;
				if(index == 20) {
					System.out.println("Game over at i = " + i + "diceNum" + currentDiceNum);
					break;
				} else if(index < 20) {
					boardIndex+=currentDiceNum;

					switch(boardIndex) {
					case 2:
						boardIndex = 19;
						break;
					case 17:
						boardIndex = 3;
						break;
					case 5:
						boardIndex = 13;
						break;
					case 11:
						boardIndex = 7;
						break;
					}
				}
				else {
					System.out.println("Board index greater than 20 at i = " + i + " diceNum " + currentDiceNum);
				}
				System.out.println("Board index = "+ boardIndex +" at i = " + i + " diceNum " + currentDiceNum);
			}
			
			if((currentDiceNum == 6 || currentDiceNum == 1) && !isGameOpened) {
				isGameOpened = true;
				System.out.println("Game opened at i = " + i + " diceNum " + currentDiceNum );
			}

			
		}

	}
}
