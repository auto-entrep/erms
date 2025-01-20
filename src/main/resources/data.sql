
--INITIALISATION TABLE UTILISATEURS
--admin/admin
--login2/password2
--login3/password3
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD, USER_ACTIVE) values (1, 'admin', '$2a$10$AR6DSIOSMkCZgAdP7gL8xeRshcTMzzwayBT6SYspVSD8X4CL.vmP6', 1);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD, USER_ACTIVE) values (2, 'login2', '$2a$10$Pc06qidisuJpEe0zVJ4DG.9pyOKfM..l/XZUKGUSFOTcIDVulpgGi', 1);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD, USER_ACTIVE) values (3, 'login3', '$2a$10$r6I/pN/24fqncA4366NJMezP.Pwb8XSpzPmE7Wh2dtmawfcAZt3em', 0);--inactif user

--INITIALISATION TABLE ROLE
INSERT INTO ROLE(ROLE_ID,ROLE_NAME) VALUES (1,'ROLE_ADMIN');
INSERT INTO ROLE(ROLE_ID,ROLE_NAME) VALUES (2,'ROLE_USER');


-- TABLE DE JOINTURE
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (2,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (3,2);

COMMIT;