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

package com.nu1silva.testing.selenium.operations;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nu1silva.testing.selenium.pageobjects.login.LoginPage;

import java.io.IOException;

public class LoginOperations {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private WebDriver driver;

    // Initialize and verify page
    public LoginOperations(WebDriver driver) throws IOException {
        this.driver = driver;
//        if (!(driver.getCurrentUrl().contains("index.html"))) {
//            throw new IllegalStateException("This is not the login page");
//        }
    }

    public void executeLogin(String username, String password) {
        logger.info("executing login as " + username);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.txtBoxUsername().sendKeys(username);
        loginPage.txtBoxPassword().sendKeys(password);
        loginPage.btnSignIn().click();
    }
}
