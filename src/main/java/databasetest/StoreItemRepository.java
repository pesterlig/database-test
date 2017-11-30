package databasetest;

import org.springframework.data.repository.CrudRepository;

public interface StoreItemRepository extends CrudRepository<StoreItem, Long> {

}