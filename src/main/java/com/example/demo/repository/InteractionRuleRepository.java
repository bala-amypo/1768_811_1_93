public interface InteractionRuleRepository extends JpaRepository<InteractionRule, Long> {
    List<InteractionRule> findByIngredientId(Long ingredientId);
    Optional<InteractionRule> findRuleBetweenIngredients(Long id1, Long id2);
}
