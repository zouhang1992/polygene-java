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
package org.apache.polygene.regression.qi383;

import org.apache.polygene.api.entity.EntityComposite;
import org.apache.polygene.api.identity.StringIdentity;
import org.apache.polygene.api.unitofwork.EntityCompositeAlreadyExistsException;
import org.apache.polygene.api.unitofwork.UnitOfWork;
import org.apache.polygene.api.unitofwork.UnitOfWorkCompletionException;
import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.ModuleAssembly;
import org.apache.polygene.test.AbstractPolygeneTest;
import org.apache.polygene.test.EntityTestAssembler;
import org.junit.Test;

public class Qi383Test extends AbstractPolygeneTest
{
    @Override
    public void assemble( ModuleAssembly module )
        throws AssemblyException
    {
        module.entities( Car.class );

        new EntityTestAssembler().assemble( module );
    }

    @Test( expected = EntityCompositeAlreadyExistsException.class )
    public void givenUnitOfWorkInProgressWhenAddingSameEntityTwiceExpectException()
        throws UnitOfWorkCompletionException
    {
        try( UnitOfWork unitOfWork = unitOfWorkFactory.newUnitOfWork() )
        {
            unitOfWork.newEntity( Car.class, StringIdentity.identityOf( "Ferrari" ) );
            unitOfWork.newEntity( Car.class, StringIdentity.identityOf( "Ford" ) );
            unitOfWork.newEntity( Car.class, StringIdentity.identityOf( "Ferrari" ) );
            unitOfWork.complete();
        }
    }

    public interface Car extends EntityComposite
    {
    }
}
