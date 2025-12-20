public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredient, Long> {
    Optional<ActiveIngredient> findByName(String name);
    boolean existsByName(String name);
}
