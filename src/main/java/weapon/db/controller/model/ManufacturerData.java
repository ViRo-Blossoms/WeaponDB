package weapon.db.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import weapon.db.entity.Manufacturer;

@Data
@NoArgsConstructor
public class ManufacturerData {

	private Long manufacturerId;
	private String manufacturerName;
	
public ManufacturerData (Manufacturer manufacturer) {
	manufacturerId = manufacturer.getManufacturerId();
	manufacturerName = manufacturer.getManufacturerName();
} // MD

}// CLASS
