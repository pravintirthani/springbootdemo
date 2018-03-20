package io.springbootdemo.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.springbootdemo.topic.Topic;

@Entity
public class Course {	
	
	@Id
	private String id;
	private String name;
	private String description;
	private String topicId_fk;
	 @ManyToOne
	private Topic topic;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course() {		
	}	
	public Course(String id, String name, String description,String topicId ) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=new Topic(topicId,"","");
	}
	public void add(Course topic) {
		// TODO Auto-generated method stub
		
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getTopicId_fk() {
		return topicId_fk;
	}
	public void setTopicId_fk(String topicId_fk) {
		this.topicId_fk = topicId_fk;
	}
	
	
}
