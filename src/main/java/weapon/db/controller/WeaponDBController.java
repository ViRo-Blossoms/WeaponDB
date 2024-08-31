package weapon.db.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import weapon.db.controller.model.ManufacturerData;
import weapon.db.controller.model.RegisteredWeaponData;
import weapon.db.controller.model.WeaponData;
import weapon.db.service.WeaponDBService;

@RestController
@RequestMapping("/weapondb")
@Slf4j
public class WeaponDBController {

@Autowired
private WeaponDBService weaponDBService;

//WEAPON
@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
public WeaponData createWeapon(@RequestBody WeaponData weaponData) {
	log.info("Creating weapon {}", weaponData);
	return weaponDBService.saveWeapon(weaponData);
} // CW - Create

@PutMapping("/{weaponId}")
public WeaponData updateWeapon(@PathVariable Long weaponId, 
		@RequestBody WeaponData weaponData) {
	weaponData.setWeaponId(weaponId);
	log.info("Updating weapon {}", weaponData);
	return weaponDBService.saveWeapon(weaponData);
} // UW - Update

@GetMapping
public List<WeaponData> listOutWeapons() {
	log.info("Listing out all weapons");
	return weaponDBService.retrieveAllWeapons();
} // LOW - Read

@GetMapping("/{weaponId}")
public WeaponData getWeaponById(@PathVariable Long weaponId) {
	log.info("Looking for a weapon with the ID {}", weaponId);
	return weaponDBService.retrieveWeaponById(weaponId);
} // GWBI - Read

@DeleteMapping("/{weaponId}")
public Map<String, String> deleteWeapon(@PathVariable Long weaponId) {
	log.info("Deleting the weapon with an ID of {}", weaponId);
	weaponDBService.DeleteWeaponById(weaponId);
	return Map.of("message", "Weapon Deleted."); 
} // DW - Delete

//MANUFACTURER
@PostMapping("/{weaponId}/manufacturer")
@ResponseStatus(code = HttpStatus.CREATED)
public ManufacturerData createManufacturer(@PathVariable Long weaponId,
		@RequestBody ManufacturerData manufacturerData) {
	log.info("Creating Manufacturer {}", manufacturerData);
	return weaponDBService.saveManufacturer(manufacturerData, weaponId);
} // CM - Create

//REGISTERED WEAPON
@PostMapping("/{weaponId}/registered_weapon")
@ResponseStatus(code = HttpStatus.CREATED)
public RegisteredWeaponData createRegisteredWeapon(@PathVariable Long weaponId,
		@RequestBody RegisteredWeaponData registeredWeaponData) {
	log.info("Creating Registered Weapon {}", registeredWeaponData);
	return weaponDBService.saveRegisteredWeapon(registeredWeaponData, weaponId);
} // CRW - Create

}// CLASS
