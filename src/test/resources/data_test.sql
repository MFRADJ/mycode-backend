# -- Insert into users table
# INSERT INTO users (id, first_name, last_name, email, password, account_locked, enabled, created_at, updated_at)
# VALUES (1, 'John', 'Doe', 'john.doe@example.com', 'password', FALSE, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
# ON DUPLICATE KEY UPDATE email=email;
#
# INSERT INTO users (id, first_name, last_name, email, password, account_locked, enabled, created_at, updated_at)
# VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', 'password', FALSE, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
# ON DUPLICATE KEY UPDATE email=email;
#
# -- Insert roles
# INSERT INTO roles (id, name)
# VALUES (1, 'ROLE_USER')
# ON DUPLICATE KEY UPDATE name=name;
#
# INSERT INTO roles (id, name)
# VALUES (2, 'ROLE_PROFESSOR')
# ON DUPLICATE KEY UPDATE name=name;
#
# INSERT INTO roles (id, name)
# VALUES (3, 'ROLE_STUDENT')
# ON DUPLICATE KEY UPDATE name=name;
#
# -- Insert into professors table
# INSERT INTO professors (id)
# VALUES (1)
# ON DUPLICATE KEY UPDATE id=id;
#
# -- Insert into students table
# INSERT INTO students (id)
# VALUES (2)
# ON DUPLICATE KEY UPDATE id=id;
#
# -- Assign roles to users
# INSERT INTO user_roles (user_id, role_id)
# VALUES (1, 2)
# ON DUPLICATE KEY UPDATE user_id=user_id;
#
# INSERT INTO user_roles (user_id, role_id)
# VALUES (2, 3)
# ON DUPLICATE KEY UPDATE user_id=user_id;
