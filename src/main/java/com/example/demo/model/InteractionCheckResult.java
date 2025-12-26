@Entity
@Table(name = "interaction_check_results")
public class InteractionCheckResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medications;

    @Column(columnDefinition = "TEXT")
    private String interactions;

    private LocalDateTime checkedAt;

    @PrePersist
    public void onCreate() {
        checkedAt = LocalDateTime.now();
    }

    public InteractionCheckResult() {}

    public InteractionCheckResult(String meds, String inter) {
        medications = meds;
        interactions = inter;
    }

    // getters & setters
}
