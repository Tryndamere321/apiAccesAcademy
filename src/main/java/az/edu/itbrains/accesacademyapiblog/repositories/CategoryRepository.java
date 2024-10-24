package az.edu.itbrains.accesacademyapiblog.repositories;

import az.edu.itbrains.accesacademyapiblog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
