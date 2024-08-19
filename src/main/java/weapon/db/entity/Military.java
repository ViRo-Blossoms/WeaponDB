package weapon.db.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Military {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long militaryId;
	private String militaryName;
	private String militaryCountry;
	
@OneToMany(cascade = CascadeType.ALL)
	Set<MilitaryWeapon> militaryWeapons;
	
}// CLASS

//ViRo:
//
//		>Military ID: Z
//			This is automatically generated and is used for identification and index purposes only.
//
//		>Name: Swedish Army
//			The name of the military group. This cannot be null, as it's the main part of this table. Some
//			countries may hae only one fighting force, or the force may be the combined effort of many
//			countries. Some countries may have multiple forces, so the US Marines and the US Navy are entitled
//			to their own entries.
//
//		>Country: Sweden
//			The name of the country the military is from. If the military is the combined force of many
//			countries, then listing the countries seperated by commas is okay (Afghanistan, Denmark, 
//			United States of America, Zimbabwe).
//
//		} Many to one with Military Weapons
//			Military Weapons are usually just one part of a fighting force's line up. Militaries will have lots
//			and lots of military weapons.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
