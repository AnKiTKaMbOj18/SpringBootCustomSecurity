package kamboj.ankit.Repository;

import org.springframework.data.repository.CrudRepository;

import kamboj.ankit.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {

}
