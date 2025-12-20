@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService us, PasswordEncoder pe, JwtUtil ju) {
        this.userService = us;
        this.encoder = pe;
        this.jwtUtil = ju;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req) {
        return userService.register(
            new User(req.name, req.email, req.password, req.role)
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        User u = userService.findByEmail(req.email);
        if (!encoder.matches(req.password, u.getPassword()))
            throw new RuntimeException("Invalid credentials");
        return jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
    }
}
