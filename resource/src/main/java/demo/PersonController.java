package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@Autowired
	private PersonRepository repository;

	@RequestMapping("/person")
	public Iterable<Person> getAllPerson() {
		return repository.findAll();
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPerson(@PathVariable("id") long id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/person/", method = RequestMethod.POST)
	 public Person savePerson(@RequestBody Person person)
	 {
		 return repository.save(person);
	}
	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	 public Person updatePerson(@PathVariable("id") long id,@RequestBody Person newPerson)
	 {
		Person person = repository.findOne(id);
		person.setAddress(newPerson.getAddress());
		person.setEmail(newPerson.getEmail());
		person.setUsername(newPerson.getUsername());
		 return repository.save(person);
	}
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	 public void deletePerson(@PathVariable("id") long id)
	 {
		 repository.delete(id);
	}
}
