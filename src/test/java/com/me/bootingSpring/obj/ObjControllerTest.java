package com.me.bootingSpring.obj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class ObjControllerTest {

    @Mock
    private ObjRepository objRepository;
    //AutoCloseable autoCloseable;
    @Autowired
    private ObjService objService;
    private ObjController objController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //autoCloseable = MockitoAnnotations.openMocks(this);
        objService = new ObjService(objRepository);
        objController = new ObjController(objService);
        Obj obj1 = new Obj("first");
        Obj obj2 = new Obj("second");
    }

    @Test
    void getObjs() throws Exception {
        Obj obj1 = new Obj("first");
        Obj obj2 = new Obj("second");
        doReturn(List.of(obj1, obj2)).when(objRepository).findAll();

        List<Obj> result = objController.getObjs();
        Assertions.assertEquals(2, result.size());
        //autoCloseable.close();

    }

    @Test
    void addNewObj() {
    }

    @Test
    void deleteObject() {
    }

    @Test
    void updateObj() {
    }
}