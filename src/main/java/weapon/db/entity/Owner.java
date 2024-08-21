package weapon.db.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Owner {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerId;
	private String firstName;
	private String lastName;
	private String streetAddress;	
@Column(unique = true)
	private Long nationalId;


@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "weapon_id")
	private Weapon weapon;
}// CLASS

//ViRo: Table is as follows, using the Barrett 82 as an example:
//
//		>Owner ID: Y
//			This is automatically generated and is used for identification and index purposes only.
//
//		>First Name: Barry
//			The non-military name of the weapon, per model. The Barrett M82A1 deserves its own entry, even
//			if the changes are small.
//
//		>Last Name: Ronn
//			The designer of the weapon. If the weapon was designed by a group, it's fine to list the group.
//
//		>Street Adress: Europia 50 blvd
//			The country where the weapon was designed. In the case of a joint venture, whatever group
//			the countries are allied through should be used (I.E. NATO, E.U., Axis) but listing the countries
//			seperated by commas is okay (Afghanistan, Denmark, United States of America, Zimbabwe).
//
//		>National ID: 9223372036854775807
//			The first known year where the weapon was being manufactured. 
//
//		} Many to One with Weapons
//			This is a fantasy world where a person may only own one gun, We call it Ouhtatexaas
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
