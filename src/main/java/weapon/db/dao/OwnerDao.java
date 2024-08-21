package weapon.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import weapon.db.entity.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long>{

}
