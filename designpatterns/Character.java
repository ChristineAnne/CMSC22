package designPatterns;

public abstract class Character {
	WeaponBehavior weapon;
	
	abstract void fight();
	
	public void setWeapon(WeaponBehavior w){
		this.weapon = w;
	}
	
	public WeaponBehavior getWeapon(){
		return weapon;
	}

}
