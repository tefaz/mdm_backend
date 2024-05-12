CREATE TABLE object_type (
    object_type_id      VARCHAR(255) NOT NULL PRIMARY KEY,
    object_type_name    VARCHAR(255) NOT NULL,
    last_edited_by_date DATETIME     NOT NULL
);