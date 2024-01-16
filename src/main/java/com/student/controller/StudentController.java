package com.student.controller;


	
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@RestController
public class StudentController {
		
	@Autowired
	StudentRepository repo;
		

	@PostMapping("/createstud")
	public Student create(@RequestBody Student stud)
	{
		return repo.save(stud);
	}

	@GetMapping("/getstud")
	public List<Student> get()
	{
		return repo.findAll(); 
	}
		
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Deleted....";
	}
		
	@PutMapping("/updatestud/{id}")
	public Student update(@PathVariable int id,@RequestBody Student s)
	{
		Student stud = repo.findById(id).get();
		stud.setId(id);
		stud.setName(s.getName());
		stud.setCourse(s.getCourse());
		
		return repo.save(stud);
	}
	

		
}
