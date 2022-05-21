package pl.sdacademy.unit.test.advance.exercises.task2;

public class AnimalService {
    private AnimalRepository animalRepository;

    public Animal getById(long id) {
        return animalRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not exist with id " + id));
    }

    public Animal add(String name, String type) {
        AnimalDto animalDto = new AnimalDto(name, type);
        return animalRepository.add(animalDto);
    }
}
