CREATE TABLE product
(
    id                  VARCHAR(255) NOT NULL PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    last_edited_by_date DATETIME     NOT NULL,
    object_type_id      VARCHAR(255) NOT NULL, -- Use VARCHAR(255) to match object_type_id data type
    FOREIGN KEY (object_type_id) REFERENCES object_type (object_type_id)
);
