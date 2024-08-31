package weapon.db.entity;

import jakarta.persistence.CascadeType;
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
public class RegisteredWeapon {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registeredId;
	private String serialNumber;

@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "weapon_id")
	private Weapon weapon;
}// CLASS

//ViRo: Table is as follows, using the Barrett 82 as an example:
//
//		>Registered ID: Y
//			This is automatically generated and is used for identification and index purposes only.
//
//		>Serial Number: 0050
//			Weapons are assigned serial numbers just like phones and stand mixers, and should be largely
//			unique, the only reason that it doesnt have the column tage is becuase while some weapons get
//			fancy with it, some are just... in order that they were made, and that would cause problems.
//			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////