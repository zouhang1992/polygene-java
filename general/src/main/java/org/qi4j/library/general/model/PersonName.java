/*
 * Copyright (c) 2007, Sianny Halim. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.qi4j.library.general.model;

import org.qi4j.composite.Mixins;
import org.qi4j.composite.scope.PropertyField;
import org.qi4j.composite.scope.This;
import org.qi4j.property.ComputedPropertyInstance;
import org.qi4j.property.Property;

/**
 * Generic interface of PersonName that stores first and last name.
 */
@Mixins( PersonName.PersonNameMixin.class )
public interface PersonName extends HasName
{
    Property<String> firstName();

    Property<String> lastName();

    public final class PersonNameMixin implements HasName
    {
        @This PersonName personName;
        @PropertyField Property<String> name;

        public Property<String> name()
        {
            return new ComputedPropertyInstance<String>( name )
            {
                private String m_name = personName.firstName().get() + " " + personName.lastName().get();

                public String get()
                {
                    return m_name;
                }
            };
        }
    }
}
