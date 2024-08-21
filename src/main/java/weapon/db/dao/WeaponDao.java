package weapon.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import weapon.db.entity.Weapon;

public interface WeaponDao extends JpaRepository<Weapon, Long>{

}
