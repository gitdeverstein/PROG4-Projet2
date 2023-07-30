create table if not exists
`entreprise`(
        `ìd`   int not null auto_increment primary key
        constraint employee_pk,
        `company_name`    varchar,
        `company_description` varchar,
        `company_slogan` varchar,
        `company_address` varchar,
        `contact_email` varchar,
        `phone_number` date,
        `companyFiscalIdentity` varchar,
        `logo` varchar
        constraint employee_pk fk references employee(id)
);