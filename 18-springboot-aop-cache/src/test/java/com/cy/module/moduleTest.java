package com.cy.module;

import com.cy.moduleService.module;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class moduleTest {
    @Autowired
    private module  module;
    @Test
    void  moduleTest(){
        List<String> object = module.findPermissions();
            object=  module.findPermissions();
            object=   module.findPermissions();
    }
}
