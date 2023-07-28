create table if not exists
`createEmployee`(
        `ìd`   int not null auto_increment primary key
        constraint employee_pk,
        `first_name` varchar,
        `last_name` varchar,
        `registration_number` varchar,
        `birth_date` date,
        `profile` bytea,
        `gender` varchar,
        `personal_email` varchar,
        `address`    varchar,
        `CIN` varchar,
        `fonction` varchar,
        `chilrden_count` int,
        `cnaps_number` int,
        `engagementDate` date,
        `reisignationDate` date,
        `cnaps_number` int
);