package weapon.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import weapon.db.entity.RegisteredWeapon;

public interface RegisteredWeaponDao extends JpaRepository<RegisteredWeapon, Long>{

}
