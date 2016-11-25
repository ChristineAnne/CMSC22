package designPatterns;

public class King extends Character {
	
	public King(WeaponBehavior w){
		super.setWeapon(w);
	}
	
	void fight(){
		super.getWeapon().useWeapon();
	}
}
