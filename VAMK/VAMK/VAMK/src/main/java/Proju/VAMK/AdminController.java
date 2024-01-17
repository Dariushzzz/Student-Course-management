package Proju.VAMK;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private final AdminRepository AdminRepo;

    // Constructor for AdminController that takes an AdminRepository as a parameter
    public AdminController(AdminRepository ar) {
        this.AdminRepo = ar;
    }

    // POST mapping for "/login" endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin credentials) {

        // Print received JSON credentials to the console
        System.out.println("Received JSON: " + credentials.toString());

        // Create an Admin object with the provided username and password
        Admin data = new Admin(credentials.getUsername(), credentials.getPassword());

        // Retrieve an Admin object from the AdminRepository based on the provided username
        Admin admin = AdminRepo.findById(credentials.getUsername()).get();

        // Check if the retrieved admin is not null and if the provided credentials match
        if (admin != null && data.equals(admin)) {
            // Return a ResponseEntity with "Login succeeded" and HTTP status OK
            return new ResponseEntity<>("Login succeeded", HttpStatus.OK);
        } else {
            // Return a ResponseEntity with "Login failed" and HTTP status UNAUTHORIZED
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }
}
