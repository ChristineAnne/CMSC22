package automata;

import java.util.Scanner;

class RuleThirty{

	public static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws Exception {
    	long startTime = System.currentTimeMillis();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter a number: ");
        
        int x;
        do{
			x = sc.nextInt();
			if(x <= 1){
				System.out.println("Please enter again: ");		
			}			
		}while(x <= 0);
      
        RuleThread[] worker = new RuleThread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
        	
            worker[i] = new RuleThread(x);
        }

        int i;
        for (i = 0; i < THREAD_COUNT; i++) {
            worker[i].start();
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        worker[i - 1].display();
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
        sc.close();
    }
}