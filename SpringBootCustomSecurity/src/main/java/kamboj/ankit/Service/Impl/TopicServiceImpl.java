package kamboj.ankit.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kamboj.ankit.Repository.TopicRepository;
import kamboj.ankit.Service.TopicService;
import kamboj.ankit.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	@Override
	public Topic getTopicById(Long topicId) {
		return topicRepository.findOne(topicId);
	}

	@Override
	public boolean addTopic(Topic topic) {
		Topic t = new Topic();

		t.setTopicId(topic.getTopicId());
		t.setTitle(topic.getTitle());
		t.setCategory(topic.getCategory());
		
		if (topicRepository.exists(t.getTopicId())) {
			return false;
		} else {
			topicRepository.save(t);
			return true;
		}
	}

	@Override
	public Topic updateTopic(Topic topic, Long topicId) {
		Topic t = topicRepository.findOne(topicId);
		if (t != null) {
			t.setTitle(topic.getTitle());
			t.setCategory(topic.getCategory());

			topicRepository.save(t);

		} else
			System.out.println("topic does'nt exist which u want to update");
		return t;
	}

	@Override
	public void deleteTopic(Long topicId) {
		Topic t = topicRepository.findOne(topicId);
		if (t != null) {
			topicRepository.delete(topicId);
		} else
			System.out.println("topic does'nt exist which u want to delete");

	}

}
