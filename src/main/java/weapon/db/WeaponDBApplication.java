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
//	Funnily enough, this reducton allows for non-firearm weapons to be added. Bronze spears by sumerian smiths
//  wielded by an egyptian navy is a completely valid use of this DB.	
//	
//
//	todo
//	entity classes - Working on figurin out if we can treat MilWeap as a join table w/o making extra tables
//	Error Handeler - DONE
//	model - nsy
//	Dao - Manu done, Need Weapon, military, milweapon
//	Controller - nsy
//	Service - started
// 	
//
//	QUESTIONS
//		Can I add data to a join table (Ex Military Weapons)? How do I go about that? SHOULD I even do that?
//
//		Do I have to autowire every single dao in WDBService? Probably not, but best to ask
//
//		For the purpouses of the project, DBeav says that manufacturer to weapon is 1-1.n 1.n-1, does that
//			count as many-to-many still like how I have it annotated?
//
//		Non-Urgent ] Who do I talk to about my name on my certificate? I'm Trans and would like it to be my
// 			prefered name, since I don't know If i can get a 2nd application later on.
//
//		Non-Urgent ] I got BOGO classes for backend / frontend, and I don't know when the next set of front 
//			end begins. I want to be considered Full stack for job hunting purpouses but I don't want to just
//			sit on my certificate not supporting my family. Who do I talk to?
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////