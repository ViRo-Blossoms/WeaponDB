package weapon.db.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import weapon.db.entity.Manufacturer;
import weapon.db.entity.RegisteredWeapon;
import weapon.db.entity.Weapon;

@Data
@NoArgsConstructor
public class WeaponData {

	private Long weaponId;
	private String weaponName;
	private String weaponDesigner;
	private String weaponOrigin;
	private Integer weaponFirstYearMade;
	private Set<ManufacturerData> manufacturers = new HashSet<>();
	private Set<RegisteredWeaponData> registeredWeapons = new HashSet<>();

public WeaponData(Weapon weapon) {
	weaponId = weapon.getWeaponId();
	weaponName = weapon.getWeaponName();
	weaponDesigner = weapon.getWeaponDesigner();
	weaponOrigin = weapon.getWeaponOrigin();
	weaponFirstYearMade = weapon.getWeaponFirstYearMade();
	
	for (Manufacturer manufacturer : weapon.getManufacturers())
	{
		manufacturers.add( new ManufacturerData(manufacturer)); //
	}
	
	for (RegisteredWeapon registeredWeapon : weapon.getRegisteredWeapons())
	{
		registeredWeapons.add( new RegisteredWeaponData(registeredWeapon) );
	}
} // WD

}// CLASS
