@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService s) {
        service = s;
    }

    @PostMapping("/ingredient")
    public ActiveIngredient add(@RequestBody ActiveIngredient a) {
        return service.addIngredient(a);
    }

    @GetMapping("/medications")
    public List<Medication> list() {
        return service.getAllMedications();
    }
}
