package axsos.mvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "language")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 2, max = 20)
	@NotNull
	private String name;
	@Size(min = 2, max = 20)
	@NotNull
	private String creator;
	@NotNull
	@NotBlank
	private String cuurentVersion;

	public Language(int id, @Size(min = 2, max = 20) String name, @Size(min = 2, max = 20) String creator,
			@NotNull String cuurentVersion) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.cuurentVersion = cuurentVersion;
	}

	public Language() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCuurentVersion() {
		return cuurentVersion;
	}

	public void setCuurentVersion(String cuurentVersion) {
		this.cuurentVersion = cuurentVersion;
	}

}
