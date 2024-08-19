package weapon.db.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class MilitaryWeapon {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long milWeaponId;
	private String milWeaponName;
	private Integer milWeaponYearAdopted;
	private Integer milWeaponYearRetired;
	private Long milWeaponNumberPurchased;

@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToOne(cascade = CascadeType.ALL)
	private Weapon weapon;
	
@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToOne(cascade = CascadeType.ALL)
	private Military military;

}// CLASS

// ViRo:
//
//		>Weapon ID: Y
//			The ID number of the weapon being used by the associated military. This should be taken from 
//			the weapon table once it is placed in the database to avoid headaches.
//
//		>Military ID: Z
//			The ID number of the military using the associated weapon. This should be taken from the military 
//			table once it is placed in the database to avoid headaches.
//
//		>Name: AG90
//			The name given to the weapon once it's in military service. This can be null if the military
//			does not give it a new designation.
//
//		>Year Adopted: 1989
//			The year the weapon was adopted for use by the military. This should not be null because this table 
//			is for weapons adopted by a military and thus should have a year of adoption. Should the date not be 
//			know, an estimate is preffered and 0 if there is no better guess.
//
//		>Year Retired: null
//			The year the weapon was officially retiered for use by the military. This can and should be null
//			for weapons still in active service.
//
//		>Number Purchased: 100
//			the number of weapons purchased. This one is rather tricky since obviously military spending is
//			classified beyond how much was spent. 100 in this case was the initial purchase but there could
//			have been subsequent purchases that are simply not known about. Null is allowed should it be
//			impossible to know.
//
//		} Many to One with Weapon
//			Weapons are 'adopted' by military groups and tend to get given new names or designations. They're 
//			all the same at the end of the day.
//
//		} One to Many with Military
//			Military Weapons are usually just one part of a fighting force's line up. Militaries will have lots
//			and lots of military weapons.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
