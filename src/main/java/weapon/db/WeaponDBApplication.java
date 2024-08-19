package weapon.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeaponDBApplication {

public static void main(String[] args) {
	SpringApplication.run(WeaponDBApplication.class, args);
} // MAIN

}// CLASS

//ViRo Notes:
//
//	This is a very simplified and maybe even inadequate break down of a "Weapon". The breakdown could include 
//	more details but we seek to Keep It Simple, Stupid (K.I.S.S.) Features we would have included on a larger
//	project would be things like caliber, weapon category, notable features, barrel length, and on and on.
//	Funnily enough, this allows for non-firearm weapons to be added.
//	Aditionally, manufacturer should probably be split into manuf as it's own table and manuf_weap as a join
//	table to reduce the number of repeated strings but again, K.I.S.S.
//
//	todo
//	entity classes
//	Error Handeler
//	model
//	Dao
//	Controller
//	Service
// 	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////