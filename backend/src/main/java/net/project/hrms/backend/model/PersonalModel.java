package net.project.hrms.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal")

public class PersonalModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="email_id")
		private String emailId;
		
		@Column(name="gender")
		private String gender;
		
		@Column(name="age")
		private int age;
		
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		@Column(name="dob")
		private Date dob;
		
		@Column(name="mob_num")
		private Integer mob_num;
		
		@Column(name="isactive")
		private Byte isActive=1;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Integer getMob_num() {
			return mob_num;
		}

		public void setMob_num(Integer mob_num) {
			this.mob_num = mob_num;
		}

		public Byte getIsActive() {
			return isActive;
		}

		public void setIsActive(Byte isActive) {
			this.isActive = isActive;
		}

		


}
