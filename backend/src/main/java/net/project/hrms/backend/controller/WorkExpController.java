package net.project.hrms.backend.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.project.hrms.backend.exception.ResourceNotFoundException;
import net.project.hrms.backend.model.PersonalModel;
import net.project.hrms.backend.model.WorkExpModel;
import net.project.hrms.backend.repository.WorkRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/workexpe")

public class WorkExpController {
	
	
		
		   @Autowired
		    private WorkRepository workRepository;

		    @GetMapping
		    public List<WorkExpModel> getAllworkexpDetails(){
		        return workRepository.findAllByIsActive((byte) 1);
		        
		    }

		    // build create employee REST API
		    @PostMapping
		    public WorkExpModel createWorkExpModel(@RequestBody WorkExpModel workExpModel) {
		        return workRepository.save(workExpModel);
		    }

		    // build get employee by id REST API'
		    @GetMapping("{id}")
		    public ResponseEntity<WorkExpModel> getWorkExpModelById(@PathVariable  long id){
		    	WorkExpModel workExpModel = workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkExp not exist with id:" + id));
		        return ResponseEntity.ok(workExpModel);
		    }

		 
            @PutMapping("{id}")
		    public ResponseEntity<WorkExpModel> updatePersonalModel(@PathVariable long id,@RequestBody WorkExpModel workExpModelDetails) {
            	WorkExpModel updateWorkExpModel = workRepository.findById(id)
		                .orElseThrow(() -> new ResourceNotFoundException("Personal Information not exist with id: " + id));

            	updateWorkExpModel.setCompanyname(workExpModelDetails.getCompanyname());
            	updateWorkExpModel.setDate_of_joining(workExpModelDetails.getDate_of_joining());
            	updateWorkExpModel.setDate_of_leave(workExpModelDetails.getDate_of_leave());
            	updateWorkExpModel.setProjectname(workExpModelDetails.getProjectname());
            	updateWorkExpModel.setYear_of_exp(workExpModelDetails.getYear_of_exp());
		    		

		    	workRepository.save(updateWorkExpModel);

		        return ResponseEntity.ok(updateWorkExpModel);
		    }


		    // build delete employee REST API
		    @DeleteMapping("{id}")
		    public WorkExpModel deleteWorkExpModel(WorkExpModel id){

		    	ModelMapper modelmapper = new ModelMapper();
				
				Optional<WorkExpModel> responseDb = workRepository.findById(id.getId());		
				System.out.println(responseDb.get());
				WorkExpModel stdo = new WorkExpModel();
				
				if(responseDb.isEmpty() == false) {
					WorkExpModel st = responseDb.get();
					st.setIsActive((byte)0);
					workRepository.save(st);
					WorkExpModel dto = modelmapper.map(st, WorkExpModel.class);
					 return dto;
				}else {
					return null;
				}
		    }
		
}



