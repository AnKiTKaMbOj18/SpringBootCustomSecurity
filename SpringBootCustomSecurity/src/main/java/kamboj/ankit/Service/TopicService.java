package kamboj.ankit.Service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import kamboj.ankit.entity.Topic;

public interface TopicService {

	@Secured(value = { "ROLE_ADMIN","ROLE_USER" })
	public abstract List<Topic> getAllTopics();

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	public abstract Topic getTopicById(Long topicId);

	@Secured(value = { "ROLE_ADMIN" })
	public abstract boolean addTopic(Topic topic);

	@Secured(value = { "ROLE_ADMIN" })
	public abstract Topic updateTopic(Topic topic, Long topicId);

	@Secured(value = { "ROLE_ADMIN" })
	public abstract void deleteTopic(Long topicId);

}
