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

package com.nu1silva.testing.selenium.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ElementLocatorProperties {

    private static final Properties properties = new Properties();
    private static ElementLocatorProperties instance;

    static {
        try {
            getResourceStream();
            instance = new ElementLocatorProperties();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to read file. Locator mappings not set");
        }
    }

    private ElementLocatorProperties() {
    }

    public static ElementLocatorProperties getInstance() {
        return instance;
    }

    private static Properties getResourceStream() throws IOException {
        InputStream inputStream = ElementLocatorProperties.class.getResourceAsStream("/locator.properties");
        if (inputStream.available() > 0) {
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } else {
            return null;
        }
    }

    public String getElement(String key) {
        return properties.getProperty(key);
    }
}
