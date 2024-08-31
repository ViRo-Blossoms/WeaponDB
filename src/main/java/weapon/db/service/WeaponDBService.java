package weapon.db.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weapon.db.controller.model.ManufacturerData;
import weapon.db.controller.model.RegisteredWeaponData;
import weapon.db.controller.model.WeaponData;
import weapon.db.dao.ManufacturerDao;
import weapon.db.dao.RegisteredWeaponDao;
import weapon.db.dao.WeaponDao;
import weapon.db.entity.Manufacturer;
import weapon.db.entity.RegisteredWeapon;
import weapon.db.entity.Weapon;

@Service
public class WeaponDBService {

@Autowired
	private ManufacturerDao manufacturerDao;
@Autowired
	private WeaponDao weaponDao;
@Autowired
	private RegisteredWeaponDao registeredWeaponDao;

//WEAPON
@Transactional(readOnly = false)
public WeaponData saveWeapon(WeaponData weaponData) {
	Weapon weapon = findOrCreateWeapon(weaponData.getWeaponId());
	CopyWeaponFields(weapon, weaponData);
	Weapon wD = weaponDao.save(weapon);
	return new WeaponData(wD);
} // SW

private void CopyWeaponFields(Weapon weapon, WeaponData weaponData) {
	weapon.setWeaponId(weaponData.getWeaponId());
	weapon.setWeaponName(weaponData.getWeaponName());
	weapon.setWeaponDesigner(weaponData.getWeaponDesigner());
	weapon.setWeaponOrigin(weaponData.getWeaponOrigin());
	weapon.setWeaponFirstYearMade(weaponData.getWeaponFirstYearMade());
} // CWF

private Weapon findOrCreateWeapon(Long weaponId) {
	Weapon weapon;
	if(Objects.isNull(weaponId))
	{
		weapon = new Weapon();
	}
	else
	{
		weapon = findWeaponById(weaponId);
	}
	return weapon;
} // FOCW

private Weapon findWeaponById(Long weaponId) {
	return weaponDao.findById(weaponId).orElseThrow(() -> new NoSuchElementException(
			"Heads up, there's no Weapon with an ID of " + weaponId + "."));
} // FWBI

@Transactional(readOnly = true)
public List<WeaponData> retrieveAllWeapons() {
	List<Weapon> weapons = weaponDao.findAll();
	List<WeaponData> list = new LinkedList<>();
	for (Weapon weapon : weapons)
	{
		WeaponData wD = new WeaponData(weapon);
//		wD.getManufacturers().clear();   //I actually like being able to see it at the top level,
//		wD.getRegisteredWeapons().clear(); //but understand some may hate it. uncomment to hide it.
		list.add(wD);
	}
	return list;
} // RAW

@Transactional(readOnly = true)
public WeaponData retrieveWeaponById(Long weaponId) {
	Weapon weapon = findWeaponById(weaponId);
	return new WeaponData(weapon);
} // RWBI

@Transactional(readOnly = false)
public void DeleteWeaponById(Long weaponId) {
	Weapon weapon = findWeaponById(weaponId);
	weaponDao.delete(weapon);
} // DWBI

//MANUFACTURER
@Transactional(readOnly = false)
public ManufacturerData saveManufacturer(ManufacturerData manufacturerData, Long weaponId) {
	Weapon weapon = findWeaponById(weaponId);
	Long manufacturerId = manufacturerData.getManufacturerId();
	Manufacturer manufacturer = findOrCreateManufacturer(weaponId, manufacturerId);
	copyManufacturerFields(manufacturerData, manufacturer);
	weapon.getManufacturers().add(manufacturer);
	manufacturer.getWeapons().add(weapon);
	Manufacturer mD = manufacturerDao.save(manufacturer);
	return new ManufacturerData(mD);
} // SM

private void copyManufacturerFields(ManufacturerData manufacturerData, 
		Manufacturer manufacturer) {
	manufacturer.setManufacturerId(manufacturerData.getManufacturerId());
	manufacturer.setManufacturerName(manufacturerData.getManufacturerName());
} // CMF

private Manufacturer findOrCreateManufacturer(Long weaponId, Long manufacturerId) {
		Manufacturer manufacturer;
	if(Objects.isNull(manufacturerId))
	{
		manufacturer = new Manufacturer();
	}
	else
	{
		manufacturer = findManufacturerById(weaponId, manufacturerId);
	}
	return manufacturer;
} // FOCM


private Manufacturer findManufacturerById(Long weaponId, Long manufacturerId) {
	Manufacturer manufacturer = manufacturerDao.findById(manufacturerId).orElseThrow(() ->
		new NoSuchElementException("Heads up, there's no Manufacturers with an ID of " 
		+ manufacturerId));
	for (Weapon weapon : manufacturer.getWeapons())
	{
		if(weapon.getWeaponId() == weaponId)
		{
			return manufacturer;
		}
	}
	throw new IllegalArgumentException(
			"Heads up, there's no match for any Manufacturers with an ID of " +
			manufacturerId + ".");
} // FMBI

//REGISTERED WEAPON
@Transactional
public RegisteredWeaponData saveRegisteredWeapon(RegisteredWeaponData registeredWeaponData,
		Long weaponId) {
	Weapon weapon = findWeaponById(weaponId);
	Long registeredWeaponId = registeredWeaponData.getRegisteredId();
	RegisteredWeapon registeredWeapon = findOrCreateRegisteredWeapon(
		weaponId, registeredWeaponId);
	copyRegisteredWeaponFields(registeredWeaponData, registeredWeapon);
	registeredWeapon.setWeapon(weapon);
	weapon.getRegisteredWeapons().add(registeredWeapon);
	RegisteredWeapon rWD = registeredWeaponDao.save(registeredWeapon);
	return new RegisteredWeaponData(rWD);
} // SRW

private void copyRegisteredWeaponFields(RegisteredWeaponData registeredWeaponData,
		RegisteredWeapon registeredWeapon) {
	registeredWeapon.setRegisteredId(registeredWeaponData.getRegisteredId());
	registeredWeapon.setSerialNumber(registeredWeaponData.getSerialNumber());
} // CRWF

private RegisteredWeapon findOrCreateRegisteredWeapon(Long weaponId, 
		Long registeredWeaponId) {
	RegisteredWeapon registeredWeapon;
	if(Objects.isNull(registeredWeaponId))
	{
		registeredWeapon = new RegisteredWeapon();
	}
	else
	{
		registeredWeapon = findRegisteredWeaponById(weaponId, registeredWeaponId);
	}
	return registeredWeapon;
} // FOCRW

private RegisteredWeapon findRegisteredWeaponById(Long weaponId, Long registeredWeaponId) {
	RegisteredWeapon registeredWeapon = 
			registeredWeaponDao.findById(registeredWeaponId).orElseThrow(() ->
			new NoSuchElementException("Heads up, there's no Registered"
			+ " Weapons with an ID of " + registeredWeaponId));
	if(registeredWeapon.getWeapon().getWeaponId() == weaponId)
	{
		return registeredWeapon;
	}
	throw new IllegalArgumentException(
			"Heads up, there's no match for any Registered Weapons with an ID of"
			+ registeredWeaponId);
} // FRWBI

}// CLASS
