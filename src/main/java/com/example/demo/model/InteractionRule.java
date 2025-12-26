@Entity
@Table(name = "interaction_rules",
       uniqueConstraints = @UniqueConstraint(columnNames = {"ingredientA_id","ingredientB_id"}))
public class InteractionRule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActiveIngredient ingredientA;

    @ManyToOne
    private ActiveIngredient ingredientB;

    private String severity;
    private String description;

    public InteractionRule() {}

    public InteractionRule(ActiveIngredient a, ActiveIngredient b, String s, String d) {
        ingredientA = a; ingredientB = b; severity = s; description = d;
    }

    // getters & setters
}
