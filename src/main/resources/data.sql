INSERT INTO USER(name,email,password) VALUES ('Zeus', 'zeus@olympus.com', '$2a$10$p4jjgP0qWaJ2eg0vJqVQSeGWOdN9OlsvGtIzI7XGRArX5a2qlNtyG');
INSERT INTO USER(name,email,password) VALUES ('Mod', 'moderator@nkforum.com', '$2a$10$p4jjgP0qWaJ2eg0vJqVQSeGWOdN9OlsvGtIzI7XGRArX5a2qlNtyG');

INSERT INTO PROFILE(id,name) VALUES(1, 'ROLE_USER');
INSERT INTO PROFILE(id,name) VALUES(2, 'ROLE_MODERATOR');

INSERT INTO USER_PROFILE_LIST(user_id, profile_list_id) values (1,1);
INSERT INTO USER_PROFILE_LIST(user_id, profile_list_id) values (2,2);


INSERT INTO COURSE(name,category) VALUES ('Spring Boot', 'Programming');
INSERT INTO COURSE(name, category) VALUES('Android', 'Programming');
INSERT INTO COURSE(name, category) VALUES('Postgres', 'Database');
INSERT INTO COURSE(name,category) VALUES ('Spring Data', 'Programming');

INSERT INTO TOPIC(title,message,creation_date,status,author_id,course_id) VALUES('SpringBoot Not Running', 'SpringBoot is giving a bean not found exception...', '2020-05-01', 'NOT_ANSWERED', 1,1);
INSERT INTO TOPIC(title,message,creation_date,status,author_id,course_id) VALUES('Android is not loading the Main Activity', 'The Main Activity is return an exception', '2020-05-01', 'NOT_ANSWERED', 1,2);
INSERT INTO TOPIC(title,message,creation_date,status,author_id,course_id) VALUES('How to do a correct Many to Many relationship', 'My Many to Many Relationship is having some issues when I do a search with Joins', '2020-06-01', 'NOT_ANSWERED', 1,3);

