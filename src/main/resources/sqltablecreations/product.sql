CREATE TABLE product (
    product_id          VARCHAR(255) NOT NULL PRIMARY KEY,
    product_name        VARCHAR(255) NOT NULL,
    last_edited_by_date DATETIME     NOT NULL,
    object_type_id      VARCHAR(255) NOT NULL,
    FOREIGN KEY (object_type_id) REFERENCES object_type (object_type_id)
);