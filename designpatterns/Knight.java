package designPatterns;

public class Knight extends Character {
	
	public Knight(WeaponBehavior w){
		super.setWeapon(w);
	}
	
	void fight(){
		super.getWeapon().useWeapon();
	}
}
