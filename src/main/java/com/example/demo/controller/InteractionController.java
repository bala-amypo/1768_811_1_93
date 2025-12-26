@RestController
@RequestMapping("/interact")
public class InteractionController {

    private final InteractionService service;

    public InteractionController(InteractionService s) {
        service = s;
    }

    @PostMapping("/check")
    public InteractionCheckResult check(@RequestBody List<Long> ids) {
        return service.checkInteractions(ids);
    }

    @GetMapping("/result/{id}")
    public InteractionCheckResult get(@PathVariable Long id) {
        return service.getResult(id);
    }
}
