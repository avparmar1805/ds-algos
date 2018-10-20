package feb4;

public class boardtravel {

	public static void main(String[] args) {
		int[] board = new int[21];
		board[2] = 19;
		board[5] = 13;
		board[11] = 7;
		board[17] = 3;
		
		int[] dices = {2, 3, 5, 6, 4, 5, 1, 1, 3, 5, 1, 2, 6, 4, 3, 2};
		int playerpos = 0;
		for(int i = 0; i < dices.length; i++){
			if(playerpos == 0){
				if(dices[i] == 1 || dices[i] == 6){
					playerpos = dices[i];
				}
			} else {
				if(playerpos + dices[i] < board.length){
					playerpos = playerpos + dices[i];
				} 
				
				if(board[playerpos] != 0) { // snake or ladder
					playerpos = board[playerpos];
				}
				
				if(playerpos == board.length - 1){
					System.out.println("Win");
					return;
				}
			}
		}
		
		System.out.println(playerpos);
	}

}
