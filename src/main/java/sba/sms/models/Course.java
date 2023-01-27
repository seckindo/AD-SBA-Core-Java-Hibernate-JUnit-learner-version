package sba.sms.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="course")

public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	int id;
	@NonNull
	@Column(length=50)
	String name;
	@NonNull
	@Column(length=50)
	String instructor;

	@ToString.Exclude
	@ManyToMany( mappedBy = "courses",fetch=FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	List<Student> students = new LinkedList<>();

	@Override
	public int hashCode() {
		return Objects.hash(id, instructor, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return id == other.id && Objects.equals(instructor, other.instructor) && Objects.equals(name, other.name);
	}
	
	public Course(int id,String name, String instructor) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}
	
}
