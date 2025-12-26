@Entity
@Table(name = "active_ingredients")
public class ActiveIngredient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public ActiveIngredient() {}
    public ActiveIngredient(String name) { this.name = name; }

    // getters & setters
}
