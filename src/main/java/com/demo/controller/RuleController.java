@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService service;

    public RuleController(RuleService s) {
        service = s;
    }

    @PostMapping
    public InteractionRule add(@RequestBody InteractionRule r) {
        return service.addRule(r);
    }

    @GetMapping
    public List<InteractionRule> all() {
        return service.getAllRules();
    }
}
