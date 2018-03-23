package io.springbootdemo.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springbootdemo.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService coursesService;
	
	@RequestMapping("/topics/{id}/course")
	public List<Course> getAllCourses(@PathVariable("id") String id1) {
		return coursesService.getAllCourse(id1);
	}
	
	@RequestMapping("/topics/{id}/course/{id}")
	public Course getCourses(@PathVariable("id") String id1) {
		return coursesService.getCourse(id1);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/course")
	public String addCourse(@RequestBody Course course) {
		String topicId=course.getTopicId_fk();
		course.setTopic(new Topic(topicId,"",""));
		coursesService.addCourse(course);
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		coursesService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		coursesService.deleteCourse(id);
	}
	@RequestMapping(method=RequestMethod.GET,value="/course/all")
	public List<Course> getAllCourses() {
		System.out.println("afasfaf");
		return coursesService.getAllCourse1();
	}
}
