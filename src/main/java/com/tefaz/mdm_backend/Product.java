package com.tefaz.mdm_backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "last_edited_by_date")
    private Timestamp lastEditedByDate;

    @Column(name = "object_type_id")
    private String objectTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(String objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getProductId() {
        return productId;
    }
}