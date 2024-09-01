-- Insertar usuarios
INSERT INTO USERS (username, email, password, created_at, updated_at) VALUES
('sanchdev', 'sanchdev@example.com', 'password123', '2024-08-27 14:30:00', '2024-08-27 14:30:00'),
('adrian', 'adrian@example.com', 'password456', '2024-08-27 15:00:00', '2024-08-27 15:00:00');

-- Insertar tareas para el usuario 'sanchdev'
INSERT INTO TASKS (name, description, status, due_date, created_at, updated_at, user_id) VALUES
('Complete Assignment', 'Finish the assignment on Hibernate.', 'PENDING', '2024-08-30 23:59:59', '2024-08-27 14:30:00', '2024-08-27 14:30:00', 1),
('Prepare Presentation', 'Prepare slides for the upcoming presentation.', 'IN_PROGRESS', '2024-09-02 12:00:00', '2024-08-27 14:30:00', '2024-08-27 14:30:00', 1);

-- Insertar tareas para el usuario 'adrian'
INSERT INTO TASKS (name, description, status, due_date, created_at, updated_at, user_id) VALUES
('Team Meeting', 'Discuss project updates and tasks with the team.', 'PENDING', '2024-09-01 10:00:00', '2024-08-27 15:00:00', '2024-08-27 15:00:00', 2),
('Code Review', 'Review the code submitted by the junior developers.', 'IN_PROGRESS', '2024-09-03 18:00:00', '2024-08-27 15:00:00', '2024-08-27 15:00:00', 2);
