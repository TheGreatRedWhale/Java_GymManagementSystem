package edu.au.cpsc.gymmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import edu.au.cpsc.gymmanagement.entity.Entity;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class RepositoryTest<E extends Entity, R extends Repository<E>> {

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  protected R repository;

  // ABSTRACT METHODS ------------------------------------------------------------------------------

  protected abstract E createEntity();

  protected abstract R createRepository();

  protected abstract void assertEntitiesFieldsAreEqual(E e1, E e2);

  protected abstract E updateEntityFields(E e);

  // UTILITY METHODS -------------------------------------------------------------------------------

  @BeforeEach
  public void setUp(){
    repository = createRepository();
  }

  // TEST METHODS ----------------------------------------------------------------------------------

  @Test
  public void when_entity_saved_id_returned() {
    E entity = createEntity();
    Long id = repository.save(entity);
    assertNotNull(id);
  }

  @Test
  public void when_entity_saved_twice_id_not_changed() {
    E entity = createEntity();
    repository.save(entity);
    Long oldId = entity.getId();
    repository.save(entity);
    assertEquals(oldId, entity.getId());
  }

  @Test
  public void when_entity_saved_id_set_in_original_entity_same_as_returned() {
    E entity = createEntity();
    Long id = repository.save(entity);
    assertNotNull(entity.getId());
    assertEquals(id, entity.getId());
  }

  @Test
  public void when_no_entities_then_find_all_returns_empty_list() {
    List<E> entities = repository.findAll();
    assertEquals(0, entities.size());
  }

  @Test
  public void when_entity_found_by_id_twice_then_objects_same() {
    E entity = createEntity();
    Long id = repository.save(entity);

    var entityFromRepository1 = repository.findOne(id);
    var entityFromRepository2 = repository.findOne(id);

    assertSame(entityFromRepository1, entityFromRepository2);
  }

  @Test
  public void when_entity_found_by_find_all_then_objects_same() {
    E entity = createEntity();
    Long id = repository.save(entity);
    List<E> entities = repository.findAll();
    var psFromRepository = repository.findOne(id);
    assertSame(entities.get(0), psFromRepository);
  }

  @Test
  public void when_no_entity_saved_then_null_returned_from_find_one() {
    E entity = repository.findOne(1L);
    assertNull(entity);
  }

  @Test
  public void when_entity_saved_then_returned_from_find_one() {
    E entity = createEntity();
    Long id = repository.save(entity);
    E entityFromRepository = repository.findOne(id);
    assertNotNull(entityFromRepository);
    assertEntitiesFieldsAreEqual(entity, entityFromRepository);
  }

  @Test
  public void when_entity_saved_then_returned_from_find_all() {
    E entity = createEntity();
    Long id = repository.save(entity);
    List<E> specifications = repository.findAll();
    assertEquals(1, specifications.size());
    E entityFromRepository = specifications.get(0);
    assertEquals(id, entityFromRepository.getId());
    assertEntitiesFieldsAreEqual(entity, entityFromRepository);
  }
}
