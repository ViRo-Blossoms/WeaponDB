package weapon.db.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import weapon.db.entity.RegisteredWeapon;

@Data
@NoArgsConstructor
public class RegisteredWeaponData {
	
	private Long registeredId;
	private String serialNumber;
	
public RegisteredWeaponData (RegisteredWeapon registeredWeapon) {
	registeredId = registeredWeapon.getRegisteredId();
	serialNumber = registeredWeapon.getSerialNumber();
} //RWD

}// CLASS
