package com.tefaz.mdm_backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MdmBackendApplicationTests {

    @Autowired
    private TableCreationService tableCreationService;

    @Test
    void contextLoads() {
        // Simply check if the service is being injected
        assert tableCreationService != null;
    }

}
