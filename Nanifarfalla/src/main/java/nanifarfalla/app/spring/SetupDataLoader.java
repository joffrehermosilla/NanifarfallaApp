package nanifarfalla.app.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.model.Role;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.repository.PrivilegeRepository;
import nanifarfalla.app.repository.RoleRepository;
import nanifarfalla.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// API

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}

		// == create initial privileges
		final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

		// == create initial roles
		final List<Privilege> adminPrivileges = new ArrayList<Privilege>(
				Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
		final List<Privilege> userPrivileges = new ArrayList<Privilege>(
				Arrays.asList(readPrivilege, passwordPrivilege));
		final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", userPrivileges);

		// == create initial user
		createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<Role>(Arrays.asList(adminRole)));

		alreadySetup = true;
	}

	@Transactional
	private final Privilege createPrivilegeIfNotFound(final String name) {
		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilege = privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Transactional
	private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role(name);
		}
		role.setPrivileges(privileges);
		role = roleRepository.save(role);
		return role;
	}

	@Transactional
	private final Usuario createUserIfNotFound(final String email, final String firstName, final String lastName,
			final String password, final Collection<Role> roles) {
		Usuario user = userRepository.findByEmail(email);
		if (user == null) {
			user = new Usuario();
			user.setNombre_usuario(firstName);
			// user.setFirstName(firstName);
			user.setPaterno_usuario(lastName);
			// user.setLastName(lastName);
			user.setPassword_usuario(passwordEncoder.encode(password));
			// user.setPassword(passwordEncoder.encode(password));
			user.setEmail(email);
			// user.setEmail(email);
			user.setEnabled2(true);
		}
		user.setRoles(roles);
		user = userRepository.save(user);
		return user;
	}

}