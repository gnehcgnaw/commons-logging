/*
 * Copyright 2005 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

package org.apache.commons.logging.log4j;

import junit.framework.Test;

import org.apache.commons.logging.PathableTestSuite;
import org.apache.commons.logging.PathableClassLoader;


/**
 * TestCase for Log4J logging when the commons-logging jar file is in
 * the parent classpath.
 */

public class CustomConfigFullTestCase extends CustomConfigTestCase {


    public CustomConfigFullTestCase(String name) {
        super(name);
    }


    /**
     * Return the tests included in this test suite.
     */
    public static Test suite() throws Exception {
        PathableClassLoader parent = new PathableClassLoader(null);
        parent.useSystemLoader("junit.");
        parent.addLogicalLib("commons-logging");
        parent.addLogicalLib("log4j12");

        PathableClassLoader child = new PathableClassLoader(parent);
        child.addLogicalLib("testclasses");
        
        Class testClass = child.loadClass(CustomConfigFullTestCase.class.getName());
        return new PathableTestSuite(testClass, child);
    }
}