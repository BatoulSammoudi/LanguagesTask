package axsos.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import axsos.mvc.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
	List<Language> findAll();
}
