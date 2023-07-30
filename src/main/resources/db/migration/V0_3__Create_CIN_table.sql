create table if not exists
"employee"(
        "ìd"   int not null primary key,
        "cin" varchar
        constraint employee_pk fk references employee(id)
);