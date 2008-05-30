/* Copyright 2008 Neo Technology, http://neotechnology.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.qi4j.entity.neo4j.test;

import org.junit.Test;
import org.qi4j.entity.neo4j.Configuration;

/**
 * @author Tobias Ivarsson (tobias.ivarsson@neotechnology.com)
 */
public class IndirectNeoEntityStoreTest extends DirectNeoEntityStoreTest
{
    public IndirectNeoEntityStoreTest()
    {
        super( Configuration.INDIRECT );
    }

    @Test
    public void testInitialization()
    {
        // This is just to make sure that the tools identifies this as a test class
    }
}
