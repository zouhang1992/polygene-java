/*  Copyright 2007 Niclas Hedhman.
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
package org.qi4j.library.framework.validation;

import java.util.ArrayList;
import java.util.List;
import org.qi4j.composite.scope.This;

public class ValidatableMixin
    implements Validatable
{
    @This Validatable validatable;

    public List<ValidationMessage> validate()
    {
        return new ArrayList<ValidationMessage>();
    }

    public void checkValid() throws ValidationException
    {
        List<ValidationMessage> messages = validatable.validate();
        if( messages.size() > 0 )
        {
            throw new ValidationException( messages );
        }
    }
}
