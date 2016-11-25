package designPatterns;

public class CharacterTest {
	
	public static Character queen, king, knight, troll;
	
	public static void fight(){
		queen.fight();
		king.fight();
		knight.fight();
		troll.fight();
		System.out.println();
	}
	
	public static void main(String[] args){
		WeaponBehavior knife = new KnifeBehavior();
		WeaponBehavior bowAndArrow = new BowAndArrowBehavior();
		WeaponBehavior sword = new SwordBehavior();
		WeaponBehavior axe = new AxeBehavior();
		
		queen = new Queen(bowAndArrow); //thwaack... thud
		king = new King(knife); // whook
		knight = new Knight(sword); // shickk
		troll = new Troll(axe); // chugg
		fight();
		
		queen = new Queen(knife); // whook
		king = new King(sword); // shickk
		knight = new Knight(axe); // chugg
		troll = new Troll(bowAndArrow); //thwaak... thud
		fight();
		
		queen = new Queen(sword); // shickk
		king = new King(bowAndArrow); // thwaak... thud
		knight = new Knight(knife); // whook
		troll = new Troll(knife); //whook
		fight();
		
		queen = new Queen(sword);
		king = new King(sword);
		knight = new Knight(sword);
		troll = new Troll(sword);
		fight();
		
	}
}
