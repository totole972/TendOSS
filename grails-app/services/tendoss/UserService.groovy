package tendoss

class UserService {

	/**
	 * Adds a new user with a specific role.
	 * 
	 * @param user the user
	 * @param role the role
	 * @param enabled the flag indicating if the account is enabled
	 * @return the created user
	 */
	User addUser(User user, Role role, boolean enabled = true) {
		user.enabled = enabled
		user.save()
		if (!user.hasErrors()) {
			UserRole.create(user, role)
		}
		user
	}
}
