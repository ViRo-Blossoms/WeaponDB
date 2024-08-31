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
//	Funnily enough, this reducton allows for non-firearm weapons to be added.
//
//	It took a while to get the layout as it is and honestly we wish we could have managed to make our first few
//	iterations work, but I'd rather be confident I could do better next time rather than not complete the
//	bootcamp. Going forward I'll be looking into setting up a schema with .sql files then tapping into it with
//	springboot instead of letting springboot create them for me.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////