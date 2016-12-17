/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package org.apache.polygene.tools.shell.create.project;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.polygene.tools.shell.TestHelper;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DefaultProjectCreatorTest
{
    private DefaultProjectCreator underTest = new DefaultProjectCreator();

    @Test
    public void givenCorrectInputWhenCreatedProjectExpectCompleteProjectCreated()
        throws Exception
    {

        TestHelper.setPolygeneZome();
        File projectDir = new File( "PolygeneTest" );
        Map<String, String> properties = new HashMap<>();
        properties.put( "polygene.home", System.getProperty( "polygene.home" ) );
        properties.put( "root.package", "org.apache.polygene.test" );
        properties.put( "project.dir", "PolygeneTest" );
        properties.put( "project.name", "PolygeneTest" );
        properties.put( "template.dir", "etc/templates/restapp/files" );
        underTest.create( "PolygeneTest", projectDir, properties );

        assertThat( projectDir.exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/build.gradle" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/src" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/src/main/resources" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/src/main/java/org/apache/polygene/test/app/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/src/main/java/org/apache/polygene/test/app/PolygeneTest.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/src/test/java/org/apache/polygene/test/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/resources" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/config/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/config/ConfigModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/config/ConfigurationLayer.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/connectivity/ConnectivityLayer.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/connectivity/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/domain/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/domain/CrudModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/domain/DomainLayer.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/domain/OrderModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/domain/SecurityModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/infrastructure/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/infrastructure/FileConfigurationModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/infrastructure/IndexingModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/infrastructure/InfrastructureLayer.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/infrastructure/SerializationModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/infrastructure/StorageModule.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/java/org/apache/polygene/test/bootstrap/PolygeneTestApplicationAssembler.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "app/src/test/java/org/apache/polygene/test/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/build.gradle" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/main/resources" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "bootstrap/src/test/java/org/apache/polygene/test/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/build.gradle" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/resources" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/orders/Customer.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/orders/Order.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/orders/OrderItem.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/orders/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/security/HardcodedSecurityRepositoryMixin.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/security/SecurityRepository.java" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/main/java/org/apache/polygene/test/model/security/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "model/src/test/java/org/apache/polygene/test/package.html" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "gradle/wrapper/gradle-wrapper.jar" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "gradle/wrapper/gradle-wrapper.properties" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "gradlew" ).exists(), equalTo( true ) );
        assertTrue( new File( projectDir, "gradlew" ).canExecute() );
        assertThat( new File( projectDir, "gradlew.bat" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "build.gradle" ).exists(), equalTo( true ) );
        assertThat( new File( projectDir, "settings.gradle" ).exists(), equalTo( true ) );
    }
}