@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService u, PasswordEncoder e, JwtUtil j) {
        userService = u;
        encoder = e;
        jwtUtil = j;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest r) {
        User u = new User(
                r.getName(),
                r.getEmail(),
                encoder.encode(r.getPassword()),
                r.getRole()
        );
        return userService.registerUser(u);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest r) {
        User u = userService.findByEmail(r.getEmail());
        if (!encoder.matches(r.getPassword(), u.getPassword()))
            throw new RuntimeException("Invalid");

        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return new AuthResponse(token);
    }
}
