public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    @Query("""
       SELECT r FROM InteractionRule r
       WHERE r.ingredientA.id = :id OR r.ingredientB.id = :id
    """)
    List<InteractionRule> findByIngredientId(Long id);

    @Query("""
       SELECT r FROM InteractionRule r
       WHERE (r.ingredientA.id = :id1 AND r.ingredientB.id = :id2)
          OR (r.ingredientA.id = :id2 AND r.ingredientB.id = :id1)
    """)
    Optional<InteractionRule> findRuleBetweenIngredients(Long id1, Long id2);
}
