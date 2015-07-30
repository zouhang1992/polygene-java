/*
 * Copyright (c) 2008, Edward Yakop. All Rights Reserved.
 * Copyright (c) 2009, Niclas Hedhman. All Rights Reserved.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.apache.zest.envisage.school.domain.school.assembly;

import org.apache.zest.bootstrap.Assembler;
import org.apache.zest.bootstrap.AssemblyException;
import org.apache.zest.bootstrap.ModuleAssembly;

import static org.apache.zest.api.common.Visibility.application;
import static org.apache.zest.api.common.Visibility.layer;

public final class SchoolModelAssembler
    implements Assembler
{
    @Override
    public final void assemble( ModuleAssembly module )
        throws AssemblyException
    {
        module.entities(
            StudentEntity.class,
            SchoolEntity.class,
            SubjectEntity.class
        ).visibleIn( layer );

        module.services( SchoolRepositoryService.class )
            .visibleIn( application );
    }
}