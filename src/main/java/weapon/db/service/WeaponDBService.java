package weapon.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weapon.db.dao.ManufacturerDao;

@Service
public class WeaponDBService {

@Autowired
	private ManufacturerDao manufacturerDao;
//@Autowired
//	private WeaponDao weaponDao;
//@Autowired
//	private MIlitaryDao militaryDao;
		//ViRo: I'm still not sure if this all needs to be autowired Lmao
}
