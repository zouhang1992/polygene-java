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
package org.apache.polygene.api.type;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class HasAssignableToType<T extends HasTypes> extends HasTypesPredicate<T>
{
    public HasAssignableToType( Type type )
    {
        super( Collections.singletonList( type ) );
    }

    public HasAssignableToType( T hasTypes )
    {
        super( hasTypes.types().collect( toList() ) );
    }

    @Override
    protected Predicate<Type> matchPredicate( Type candidate )
    {
        // TODO; what to do if there is ParameterizedType here??
        // Now set to ClassCastException and see if anything surfaces
        Class<?> clazz = (Class<?>) candidate;
        return input -> !input.equals( candidate ) && ( (Class<?>) input ).isAssignableFrom( clazz );
    }
}
