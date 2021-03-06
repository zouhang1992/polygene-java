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
package org.apache.polygene.library.sql.generator.grammar.modification;

import org.apache.polygene.library.sql.generator.Typeable;

/**
 * This is common interface for syntax elements representing the data source for columns in {@code INSERT INTO}
 * statement.
 *
 * @author Stanislav Muhametsin
 * @see InsertStatement
 */
public interface ColumnSource
    extends Typeable<ColumnSource>
{
    /**
     * This syntax element represents when default values of columns are wanted to be inserted into table.
     *
     * @author Stanislav Muhametsin
     */
    final class Defaults
        implements ColumnSource
    {
        private Defaults()
        {

        }

        /**
         * Returns {@link Defaults}.
         */
        public Class<? extends ColumnSource> getImplementedType()
        {
            return Defaults.class;
        }

        /**
         * The singleton reference to object of this class.
         */
        public static final Defaults INSTANCE = new Defaults();
    }
}
