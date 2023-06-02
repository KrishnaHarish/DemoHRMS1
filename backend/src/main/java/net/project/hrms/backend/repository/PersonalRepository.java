package net.project.hrms.backend.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.project.hrms.backend.model.PersonalModel;


public interface PersonalRepository extends JpaRepository<PersonalModel, Long>{


@Query(value ="select * from project_hrms.personal where isactive=?", nativeQuery =true)
List<PersonalModel> findAllByIsActive(byte isactive);

}

