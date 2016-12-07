package automata;

public class RuleThread extends Thread {
	private int size;
	private int line[][];
	private int before;
	private int current;

	public RuleThread(int size){
		this.size = size;
		line = new int[size][size];
		line[0][line[0].length/2] = 1;
	}	

	public void run(){
		for(int i = 0; i < size-1; i++){
			for(int j = -1; j < line[i].length - 1; j++){
				if(j == -1){
					if(line[i][0] == 1 && line[i][1] == 0)
						line[i+1][0] = 1;
					if(line[i][0] == 1 && line[i][1] == 1)
						line[i+1][0] = 1;
					if(line[i][0] == 0 && line[i][1] == 1)
						line[i+1][0] = 1;
				}
				if(j == line[i].length - 2){
					if(line[i][j] == 1 && line[i][j+1] == 0)
						line[i+1][j+1] = 1;
					if(line[i][j] == 0 && line[i][j+1] == 1)
						line[i+1][j+1] = 1;
				}

				if(j != -1 && j != line[i].length - 2){
					if(line[i][j] == 1){
						if(line[i][j+1] == 0 && line[i][j+2] == 0)
							line[i+1][j+1] = 1;
					}
					if(line[i][j] == 0){
						if(line[i][j+1] == 1 && line[i][j+2] == 1)
							line[i+1][j+1] = 1;
						if(line[i][j+1] == 1 && line[i][j+2] == 0)
							line[i+1][j+1] = 1;
						if(line[i][j+1] == 0 && line[i][j+2] == 1)
							line[i+1][j+1] = 1;
					}
				}
			}
		}
		
	}

	public void display(){
		for(int i = 0; i < line.length; i++){
			for(int j = 0; j < line[i].length; j++)
				System.out.print(line[i][j]);
			System.out.println();
		}
	}
}