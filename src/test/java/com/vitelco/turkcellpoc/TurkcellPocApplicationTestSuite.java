package com.vitelco.turkcellpoc;

import com.vitelco.turkcellpoc.controller.ProductControllerTest;
import com.vitelco.turkcellpoc.service.ProductServiceTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ProductControllerTest.class, ProductServiceTest.class})
public class TurkcellPocApplicationTestSuite {
}
