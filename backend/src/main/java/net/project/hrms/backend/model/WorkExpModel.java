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
@Table(name = "workexp")
	public class WorkExpModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name="company_name")
		private String companyname;
		
		@Column(name="year_of_exp")
		private int year_of_exp;
		
		@Column(name="project_name")
		private String projectname;
		
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		@Column(name="date_of_joining")
		private Date date_of_joining;
		
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		@Column(name="date_of_leave")
		private Date date_of_leave;
		

		@Column(name="isactive")
		private Byte isActive=1;


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCompanyname() {
			return companyname;
		}

		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}

		public int getYear_of_exp() {
			return year_of_exp;
		}

		public void setYear_of_exp(int year_of_exp) {
			this.year_of_exp = year_of_exp;
		}

		public String getProjectname() {
			return projectname;
		}

		public void setProjectname(String projectname) {
			this.projectname = projectname;
		}

		public Date getDate_of_joining() {
			return date_of_joining;
		}

		public void setDate_of_joining(Date date_of_joining) {
			this.date_of_joining = date_of_joining;
		}

		public Date getDate_of_leave() {
			return date_of_leave;
		}

		public void setDate_of_leave(Date date_of_leave) {
			this.date_of_leave = date_of_leave;
		}

		public Byte getIsActive() {
			return isActive;
		}

		public void setIsActive(Byte isActive) {
			this.isActive = isActive;
		}
		
}
