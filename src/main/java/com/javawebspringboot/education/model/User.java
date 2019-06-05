package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_user", nullable = false)
	private Integer idUser;
	@Column(length = 45)
	private String username;
	@Column(length = 255)
	private String password;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "day_of_birth")
	private Date dayOfBirth;

	@ManyToMany()
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"), 
	inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id_role"))
	private List<Role> roleList;

	@ManyToMany
	@JoinTable(name = "user_subject", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_subject", referencedColumnName = "id_subject"))
	private List<Subject> subjects;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<ScoresTable> scoresTableList;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserLearningOutcome> userLearningoutcomeList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_department", referencedColumnName = "id_department")
	private Department department;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserSubjectCoursesGoal> userSubjectCoursesgoalList;

	public User() {
		super();
	}

	public User(String username, String password, String fullname, Date dayOfBirth, List<Role> roleList,
			List<Subject> subjects, List<ScoresTable> scoresTableList,
			List<UserLearningOutcome> userLearningoutcomeList, Department department,
			List<UserSubjectCoursesGoal> userSubjectCoursesgoalList) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.dayOfBirth = dayOfBirth;
		this.roleList = roleList;
		this.subjects = subjects;
		this.scoresTableList = scoresTableList;
		this.userLearningoutcomeList = userLearningoutcomeList;
		this.department = department;
		this.userSubjectCoursesgoalList = userSubjectCoursesgoalList;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<ScoresTable> getScoresTableList() {
		return scoresTableList;
	}

	public void setScoresTableList(List<ScoresTable> scoresTableList) {
		this.scoresTableList = scoresTableList;
	}

	public List<UserLearningOutcome> getUserLearningoutcomeList() {
		return userLearningoutcomeList;
	}

	public void setUserLearningoutcomeList(List<UserLearningOutcome> userLearningoutcomeList) {
		this.userLearningoutcomeList = userLearningoutcomeList;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<UserSubjectCoursesGoal> getUserSubjectCoursesgoalList() {
		return userSubjectCoursesgoalList;
	}

	public void setUserSubjectCoursesgoalList(List<UserSubjectCoursesGoal> userSubjectCoursesgoalList) {
		this.userSubjectCoursesgoalList = userSubjectCoursesgoalList;
	}

}
