package kamboj.ankit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import kamboj.ankit.Service.TopicService;
import kamboj.ankit.entity.Topic;

@RestController
@RequestMapping("/user")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> getAllTopics() {
		List<Topic> topic = topicService.getAllTopics();
		return new ResponseEntity<List<Topic>>(topic, HttpStatus.OK);
	}

	@GetMapping("/topic/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") Long id) {
		Topic topic = topicService.getTopicById(id);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}

	@PostMapping("/topic")
	public ResponseEntity<String> addTopic(@RequestBody Topic topic, UriComponentsBuilder builder) {
		boolean flag = topicService.addTopic(topic);
		if (flag == false) {
			return new ResponseEntity<String>("topic already exists", HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/topic/{id}").buildAndExpand(topic.getTopicId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/topic/{id}")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable("id") Long topicId) {
		Topic t = topicService.updateTopic(topic, topicId);
		return new ResponseEntity<Topic>(t, HttpStatus.OK);
	}

	@DeleteMapping("/topic/{id}")
	public ResponseEntity<Void> deleteTopic(@PathVariable("id") Long topicId) {
		topicService.deleteTopic(topicId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
