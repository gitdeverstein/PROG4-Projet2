create table if not exists
"employee"(
        "ìd"   int not null primary key,
        "phone_number" varchar
        constraint employee_pk fk references employee(id)
);