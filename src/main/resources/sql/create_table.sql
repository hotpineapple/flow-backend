CREATE TABLE fixed_extension (
    name varchar(20) PRIMARY KEY,
    is_blocked boolean
);

CREATE TABLE custom_extension (
    name varchar(20) PRIMARY KEY,
    enabled boolean,
    added_at datetime
);

