package kamboj.ankit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topic_id")
	private Long topicId;
	
	@Column(name="title",length=100,nullable=false)
	private String title;
	
	@Column(name="category",length=100,nullable=false)
	private String category;

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
