package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI extends Frame {
        
	private Label label;
	private TextArea result; 
	private Button button;
	private CheckboxGroup group;
	private Label playerScore;
	private Label comScore;
	private static int pScore = 0;
	private static int cScore = 0;
        private TextField Score1;
        private TextField Score2;
	
	Random rand = new Random();
		
	public GUI(){
            setLayout(new FlowLayout());
            
            group = new CheckboxGroup();
            label = new Label("Your choice:");
            
            Checkbox rock = new Checkbox("Rock", false, group);
            Checkbox paper = new Checkbox("Paper", false, group);
            Checkbox scissors = new Checkbox("Scissors", false, group);
            Checkbox lizard = new Checkbox("Lizard", false, group);
            Checkbox spock = new Checkbox("Spock", false, group);
            
            result = new TextArea("Result", 6, 40);
            result.setEditable(false); 
            
            button = new Button("RockPaperScissorsLizardSpock!");
            
            playerScore = new Label("Player's Score");
            comScore = new Label("Computer's Score");
            
            add(label);  
            add(rock);
            add(paper);
            add(scissors);
            add(lizard);
            add(spock);

            add(result);

            add(button);
            button.addActionListener(new MyActionListener());

            add(playerScore);
            Score1 = new TextField(Integer.toString(pScore) + "            ");
            Score1.setEditable(false);
            add(Score1);

            add(comScore);
            Score2 = new TextField(Integer.toString(cScore) + "            ");
            Score2.setEditable(false);
            add(Score2);
            
            setTitle("RockPaperScissorsLizardSpock");
            setResizable(false);
            setSize(550, 230);
            setVisible(true);
	}
	
        class MyActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e){ 
                
                // get the choice of the player
                String playerChoice = group.getSelectedCheckbox().getLabel(); 
                
                // get the choice of computer
                // computer choices are randomized and is generated in the method generateCompChoice()
                String computerChoice = generateCompChoice();
                
                // updates the text in TextArea result
                setResults(playerChoice, computerChoice, winner(playerChoice, computerChoice));  
            }
	}
	
        /*
         *   Increments the score of the winner
         *   If both the player and the computer have the same choice, then no one wins the round and the scores stay the same.
         */
        int winner(String playerChoice, String computerChoice){
            int cScoreTemp = cScore;
            int pScoreTemp = pScore;
            if(computerChoice.equals("Rock") && !(playerChoice.equals("Rock"))){
                if(playerChoice.equals("Lizard") || playerChoice.equals("Scissors")){
                    cScore += 1;
                }else{
                    pScore += 1;
                }
            }else if(computerChoice.equals("Paper") && !(playerChoice.equals("Paper"))){
                if(playerChoice.equals("Rock") || playerChoice.equals("Spock")){
                    cScore += 1;
                }else{
                    pScore += 1;
                }
            }else if(computerChoice.equals("Scissors") && !(playerChoice.equals("Scissors"))){
                if(playerChoice.equals("Paper") || playerChoice.equals("Lizard")){
                    cScore += 1;
                }else{
                    pScore += 1;
                }
            }else if(computerChoice.equals("Lizard") && !(playerChoice.equals("Lizard"))){
                if(playerChoice.equals("Spock") || playerChoice.equals("Paper")){
                    cScore += 1;
                }else{
                    pScore += 1;
                }
            }else if(computerChoice.equals("Spock") && !(playerChoice.equals("Spock"))) {
                if(playerChoice.equals("Rock") || playerChoice.equals("Scissors")){
                    cScore += 1;
                }else{
                    pScore += 1;
                }
            
            }
            
            // Updates Score1 and Score2 contents
            Score1.setText(Integer.toString(pScore));
            Score2.setText(Integer.toString(cScore));
            
            
            // The cScoreTemp and pScoreTemp initialized at the beginning of this method is used here in order
            // to find out who the winner of the round is; 1 stands for player and 2 stands for the computer
            if(cScore > cScoreTemp){
                return 2;
            }else if(pScore > pScoreTemp){
                return 1;
            }else{
                return 0;
            }
        }
        
        /*
         *  Generates the computer choice
         */
	String generateCompChoice(){
            int randNum = rand.nextInt((5 - 1) + 1) + 1;
            switch (randNum) {
                case 1:
                    return "Rock";
                case 2:
                    return "Paper";
                case 3:
                    return "Scissors";
                case 4:
                    return "Lizard";
                default:
                    return "Spock";
            }
	}
	
        // Updates result's contents
        void setResults(String playerChoice, String computerChoice, int winner){
            result.setText("Results:\n" + "Player chose " + playerChoice 
                            + "\nComputer chose " + computerChoice);
            
            switch (winner) {
                case 1:
                    result.append("\n\nYOU WON THIS ROUND.");
                    break;
                case 2:
                    result.append("\n\nCOMPUTER WON THIS ROUND.");
                    break;
                default:
                    result.append("\n\nNOBODY WON THIS ROUND.");
                    break;
            }
        }
        
	public static void main(String[] args){
            // I couldn't understand on how the dialog works
            
          //  Dialog dialog = new Dialog();
            
//            if(cScore == 5 || pScore == 5){
//                dialog = new Dialog(dialog);
//                dialog.setVisible(true);
//                dialog.setResizable(false);
//            }else{
                new GUI();
          //  }
            
	}
}
