-- Select the database
USE wizkidsDB;

INSERT INTO employee (employeeFirstName, employeeLastName, employeeEmail, employeePhone)
VALUES ('Rasmus', 'Sørensen', 'rs@wizkids.com', 40392910),
       ('Lasse', 'Hansen', 'lh@wizkids.com', 90302033),
       ('Mathias', 'Hellesøe', 'mh@wizkids.com', 42324010),
       ('Oliver', 'Ramstedt', 'or@wizkids.com', 50407583),
       ('Mikkel', 'Rasmussen', 'mr@wizkids.com', 39281630),
       ('Melinda', 'Jensen', 'mj@wizkids.com', 50307892);

INSERT INTO project (projectName, projectDesc, projectManagerName, projectExpectedTime, projectDeadline, projectDone)
VALUES ('Customer Registration System',
        'A system which uses the newest ITCA software to make the lives of customers quicker.', 'Sørensen, Rasmus',
        '60:00:00', '23-05-2020', 'Igang'),
       ('Website 2020', 'The new Wizkids website, which will incorporate php and javascript.', 'Hellesøe, Mathias',
        '75:00:00', '14-06-2019', 'Igang'),
       ('Food delivery system', 'A system made for Android which will be used by several restaurants in Denmark.',
        'Sørensen, Rasmus', '25:00:00', '23-02-2021', 'Afsluttet'),
       ('Novo nordisk quality control',
        'This new technology will be featured in Novo Nordisk as a mean to quality assurance.', 'Ramstedt, Oliver',
        '150:00:00', '05-12-2019', 'Igang'),
       ('Microsoft extension', 'An extension for Microsoft Office which will introduce new features.', 'Hansen, Lasse',
        '72:30:00', '01-01-2019', 'Igang'),
       ('DSB train tracking', 'An alterative train-tracking app, usable on both Iphones and Android.',
        'Ramstedt, Oliver', '10:30:00', '01-02-2020', 'Igang');

INSERT INTO sessiontime (sessionTimeDate, sessionTimeStart, sessionTimeEnd, sessionTimeEmpID, sessionTimeProID)
VALUES ('2019-05-13', '10:30:00', '15:45:00', 1, 1),
       ('2018-03-25', '08:30:00', '14:15:00', 2, 3),
       ('2019-05-19', '13:15:00', '18:00:00', 3, 4),
       ('2018-12-02', '08:30:00', '12:00:00', 4, 2),
       ('2018-10-14', '12:00:00', '16:00:00', 1, 6),
       ('2017-01-01', '08:30:00', '18:00:00', 2, 3),
       ('2019-05-19', '09:30:00', '14:50:00', 3, 5),
       ('2019-05-19', '10:30:00', '16:15:00', 4, 4),
       ('2019-05-19', '11:30:00', '14:38:00', 6, 3),
       ('2019-05-19', '07:30:00', '17:00:00', 2, 4),
       ('2019-05-19', '08:15:00', '16:12:00', 1, 2);