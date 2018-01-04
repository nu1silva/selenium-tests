/*
 *   Copyright (c) 2018, nu1silva.com. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 */

package com.nu1silva.testing.selenium.registration;

import com.nu1silva.testing.selenium.operations.LoginOperations;
import com.nu1silva.testing.selenium.testbase.DriverManager;
import com.nu1silva.testing.selenium.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterUsers {

    private DriverManager driverManager = new DriverManager();
    private WebDriver driver = driverManager.getWebDriver("chrome");
    private TestBase testBase = new TestBase();

    @Test
    public void testLogin() throws IOException {
        driver.get(testBase.getApplicationUrl());
        LoginOperations loginOperations = new LoginOperations(driver);
        loginOperations.executeLogin("test", "test");
        Assert.assertTrue(driver.getPageSource().contains("Welcome Nuwan"));
    }

    @AfterClass
    public void breakDown() {
        driver.quit();
    }
}
