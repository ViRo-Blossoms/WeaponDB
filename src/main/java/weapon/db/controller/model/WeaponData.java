package weapon.db.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class WeaponData {

	private Long weaponId;
	private String weaponName;
	private String weaponDesigner;
	private String weaponOrigin;
	private Integer weaponFirstYearMade;
	private Set<WeaponManufacturer> manufacturers = new HashSet<>();
	private Set<WeaponRegisteredWeapon> registeredWeapon = new HashSet<>();
}// CLASS
