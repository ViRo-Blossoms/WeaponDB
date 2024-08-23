package weapon.db.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Weapon {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long weaponId;
	private String weaponName;
	private String weaponDesigner;
	private String weaponOrigin;
	private Integer weaponFirstYearMade;
	
@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "weapon_manufacturer", joinColumns = @JoinColumn(name = "weapon_id"), inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
	Set<Manufacturer> manufacturers;
	
@EqualsAndHashCode.Exclude
@ToString.Exclude
@OneToMany(mappedBy = "weapon", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<RegisteredWeapon> registeredWeapons;
}// CLASS

//ViRo: Table is as follows, using the Barrett 82 as an example:
//
//		>Weapon ID: Y
//			This is automatically generated and is used for identification and index purposes only.
//
//		>Name: Barrett M82
//			The non-military name of the weapon, per model. The Barrett M82A1 deserves its own entry, even
//			if the changes are small.
//
//		>Designer: Ronnie Barrett
//			The designer of the weapon. If the weapon was designed by a group, it's fine to list the group.
//
//		>Origin: USA
//			The country where the weapon was designed. In the case of a joint venture, whatever group
//			the countries are allied through should be used (I.E. NATO, E.U., Axis) but listing the countries
//			seperated by commas is okay (Afghanistan, Denmark, United States of America, Zimbabwe).
//
//		>First Year Made: 1982
//			The first known year where the weapon was being manufactured.
//
//		>Number Made: 10000
//			The number of the weapon made. So, weapons sometimes have very public and specific numbers for how
//			many were produced and some are very iffy if recorded at all. Specifics are prefered, followed by
//			estimates, best guesses, and simply null if there's nothing better. 
//
//		} Many to Many with Manufacturer 
//			Many manufacturers make many weapons and many weapons are made by many manufactures.
//
//		} One to Many with owners
//			This is a fantasy world where a person may only own one gun. We call it Ouhtatexaas.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

