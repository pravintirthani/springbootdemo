package io.springbootdemo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> topics=new ArrayList<>( Arrays.asList(
//			new Course("Spirng","Spring FrameWork","Spring FrameWork Description"),
//			new Course("java","core java","core Java Description"),
//			new Course("javascript","javascript","javascript Description")
//			)
//		);
	public  List<Course>  getAllCourse(String topicId){
		List<Course> topics=new ArrayList<>();		
		courseRepository.findByTopicId(topicId)
		.forEach(topics::add);
		return topics;
	}
	
	public Course getCourse(String id) {
//		return courseRepository.findByName(name);
		return courseRepository.findOne(id);
	 }
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);		
	}

	public void deleteCourse(String id) {	
		courseRepository.delete(id);
	}
	
}
