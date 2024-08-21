package weapon.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weapon.db.dao.ManufacturerDao;
import weapon.db.dao.OwnerDao;
import weapon.db.dao.WeaponDao;

@Service
public class WeaponDBService {

@Autowired
	private ManufacturerDao manufacturerDao;
@Autowired
	private WeaponDao weaponDao;
@Autowired
	private OwnerDao ownerDao;
		//ViRo: I'm still not sure if this all needs to be autowired Lmao
}
