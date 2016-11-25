package designPatterns;

public class Troll extends Character {
	
	public Troll(WeaponBehavior w){
		super.setWeapon(w);
	}
	
	void fight(){
		super.getWeapon().useWeapon();
	}
}
