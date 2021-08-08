package axsos.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import axsos.mvc.models.Language;
import axsos.mvc.repository.LanguageRepository;

@Service
public class LanguageService {

	public final LanguageRepository languageRepo;

	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}

	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}

	public Language createNew(Language language) {
		return languageRepo.save(language);
	}

	public Language find(int id) {
		Optional<Language> optional = languageRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public void deleteLanguage(int id) {
		Language language = find(id);
		languageRepo.delete(language);
	}

	public Language updated(Language l) {
		return languageRepo.save(l) ; 
	}

}
