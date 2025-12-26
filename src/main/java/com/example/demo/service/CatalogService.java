@Service
public class CatalogServiceImpl implements CatalogService {

    private final ActiveIngredientRepository ingredientRepo;
    private final MedicationRepository medicationRepo;

    public CatalogServiceImpl(ActiveIngredientRepository i, MedicationRepository m) {
        ingredientRepo = i;
        medicationRepo = m;
    }

    public ActiveIngredient addIngredient(ActiveIngredient ing) {
        if (ingredientRepo.existsByName(ing.getName()))
            throw new IllegalArgumentException("Ingredient exists");
        return ingredientRepo.save(ing);
    }

    public Medication addMedication(Medication med) {
        if (med.getIngredients().isEmpty())
            throw new IllegalArgumentException("Medication needs ingredient");
        return medicationRepo.save(med);
    }

    public List<Medication> getAllMedications() {
        return medicationRepo.findAll();
    }
}
