/*
 * Copyright 2008 Alin Dreghiciu.
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
package org.qi4j.entity.index.rdf;

import org.qi4j.composite.CompositeBuilder;
import org.qi4j.entity.UnitOfWork;
import org.qi4j.entity.UnitOfWorkCompletionException;

/**
 * TODO Add JavaDoc
 *
 * @author Alin Dreghiciu
 * @since March 20, 2008
 */
class Network
{
    static void populate( UnitOfWork unitOfWork )
        throws UnitOfWorkCompletionException
    {
        CompositeBuilder<DomainComposite> domainBuilder = unitOfWork.newEntityBuilder( DomainComposite.class );
        Domain gaming = domainBuilder.newInstance();
        gaming.name().set( "Gaming" );
        gaming.description().set( "Gaming domain" );

        //domainBuilder = unitOfWork.newEntityBuilder( DomainComposite.class );
        Domain programming = domainBuilder.newInstance();
        programming.name().set( "Programming" );
        programming.description().set( "Programing domain" );

        //domainBuilder = unitOfWork.newEntityBuilder( DomainComposite.class );
        Domain cooking = domainBuilder.newInstance();
        cooking.name().set( "Cooking" );
        cooking.description().set( "Cooking domain" );

        CompositeBuilder<CityComposite> cityBuilder = unitOfWork.newEntityBuilder( CityComposite.class );
        City kualaLumpur = cityBuilder.newInstance();
        kualaLumpur.name().set( "Kuala Lumpur" );
        kualaLumpur.country().set( "Malaysia" );

        CompositeBuilder<PersonComposite> personBuilder = unitOfWork.newEntityBuilder( PersonComposite.class );

        Person annDoe = personBuilder.newInstance();
        annDoe.name().set( "Ann Doe" );
        annDoe.placeOfBirth().set( kualaLumpur );
        annDoe.interests().add( cooking );

        //personBuilder = unitOfWork.newEntityBuilder( PersonComposite.class );
        Person joeDoe = personBuilder.newInstance();
        joeDoe.name().set( "Joe Doe" );
        joeDoe.placeOfBirth().set( kualaLumpur );
        joeDoe.mother().set( annDoe );
        joeDoe.interests().add( programming );
        joeDoe.interests().add( gaming );

        unitOfWork.complete();
    }
}