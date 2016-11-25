package designPatterns;

public class Queen extends Character {
	
	public Queen(WeaponBehavior w){
		super.setWeapon(w);;
	}
	
	void fight(){
		super.getWeapon().useWeapon();
	}
}
