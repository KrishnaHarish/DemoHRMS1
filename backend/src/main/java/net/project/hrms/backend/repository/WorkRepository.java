package net.project.hrms.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import net.project.hrms.backend.model.WorkExpModel;

public  interface WorkRepository extends JpaRepository<WorkExpModel, Long>{

	@Query(value ="select * from project_hrms.workexp where isactive=?", nativeQuery =true)
	 
	List<WorkExpModel> findAllByIsActive(byte isactive);


}
