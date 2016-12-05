package lt.akademija.javatech;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String title);

    //Same as findByTitle. Just implemented using custom JPQL query as an example
    @Query("SELECT p FROM ProductEntity p WHERE p.title = :title")
    List<ProductEntity> findByTitleCustomQuery(@Param("title") String title);
}
