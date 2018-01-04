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

package com.nu1silva.testing.selenium.testbase;

import com.nu1silva.testing.selenium.util.TestSuiteProperties;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private DriverManager driverManager = new DriverManager();

    protected void init() {
        WebDriver driver = driverManager.getWebDriver(TestSuiteProperties.getInstance().getElement("driver"));
    }

    public String getApplicationUrl() {
        logger.info("accessing Management Console LoginOperations page");
        return "https://seleniumdemo.nu1silva.com/index.html";
    }
}
