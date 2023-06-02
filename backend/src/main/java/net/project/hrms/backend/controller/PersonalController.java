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
	import net.project.hrms.backend.repository.PersonalRepository;

	@CrossOrigin("*")
	@RestController
	@RequestMapping("/personal")
	public class PersonalController {
		
		   @Autowired
		    private PersonalRepository personalRepository;

		    @GetMapping
		    public List<PersonalModel> getAllpersonalDetails(){
		        return personalRepository.findAllByIsActive((byte) 1);
		        
		    }

		    // build create employee REST API
		    @PostMapping
		    public PersonalModel createPersonalModel(@RequestBody PersonalModel personalModel) {
		        return personalRepository.save(personalModel);
		    }

		    // build get employee by id REST API'
		    @GetMapping("{id}")
		    public ResponseEntity<PersonalModel> getPersonalModelById(@PathVariable  long id){
		    	PersonalModel personalModel = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personal not exist with id:" + id));
		        return ResponseEntity.ok(personalModel);
		    }

		    // build update employee REST API
		    @PutMapping("{id}")
		    public ResponseEntity<PersonalModel> updatePersonalModel(@PathVariable long id,@RequestBody PersonalModel personalDetails) {
		    	PersonalModel updatePersonalModel = personalRepository.findById(id)
		                .orElseThrow(() -> new ResourceNotFoundException("Personal Information not exist with id: " + id));

		    	updatePersonalModel.setFirstName(personalDetails.getFirstName());
		    	updatePersonalModel.setLastName(personalDetails.getLastName());
		    	updatePersonalModel.setEmailId(personalDetails.getEmailId());
		    	updatePersonalModel.setAge(personalDetails.getAge());
		    	updatePersonalModel.setDob(personalDetails.getDob());
		    	updatePersonalModel.setGender(personalDetails.getGender());
		    	updatePersonalModel.setMob_num(personalDetails.getMob_num());
		    		    	

		        personalRepository.save(updatePersonalModel);

		        return ResponseEntity.ok(updatePersonalModel);
		    }

		    // build delete employee REST API
		    @DeleteMapping("{id}")
		    public PersonalModel deletePersonalModel(PersonalModel id){

		    	ModelMapper modelmapper = new ModelMapper();
				
				Optional<PersonalModel> responseDb = personalRepository.findById(id.getId());		
				System.out.println(responseDb.get());
				PersonalModel stdo = new PersonalModel();
				
				if(responseDb.isEmpty() == false) {
					PersonalModel st = responseDb.get();
					st.setIsActive((byte)0);
					personalRepository.save(st);
					PersonalModel dto = modelmapper.map(st, PersonalModel.class);
					 return dto;
				}else {
					return null;
				}
		    }
		
}
