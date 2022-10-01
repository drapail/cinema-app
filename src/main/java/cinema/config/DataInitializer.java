package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService,
                           UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        User superUser = new User();
        superUser.setEmail("admin@i.ua");
        superUser.setPassword("admin123");
        superUser.setRoles(Set.of(adminRole));
        userService.add(superUser);

        User regularUser = new User();
        regularUser.setEmail("regular@i.ua");
        regularUser.setPassword("regular321");
        regularUser.setRoles(Set.of(userRole));
        userService.add(regularUser);
    }
}
