package dev.patika.patika0302.repository;

import dev.patika.patika0302.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository extends CrudRepository<Todo, Integer> {
}
