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
package org.apache.polygene.library.shiro.ini;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ThreadContext;
import org.apache.polygene.api.common.Optional;
import org.apache.polygene.api.configuration.Configuration;
import org.apache.polygene.api.injection.scope.Service;
import org.apache.polygene.api.injection.scope.This;
import org.apache.polygene.api.mixin.Mixins;
import org.apache.polygene.api.service.ServiceActivation;
import org.apache.polygene.api.service.ServiceReference;
import org.apache.polygene.library.shiro.Shiro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mixins( IniSecurityManagerService.Mixin.class )
public interface IniSecurityManagerService
        extends ServiceActivation
{

    SecurityManager getSecurityManager();

    class Mixin
            extends IniSecurityManagerFactory
            implements IniSecurityManagerService
    {

        private static final Logger LOG = LoggerFactory.getLogger( Shiro.LOGGER_NAME );

        @This
        private Configuration<ShiroIniConfiguration> configuration;

        @Optional
        @Service
        private Iterable<ServiceReference<Realm>> realmsRefs;

        private SecurityManager securityManager;

        @Override
        public void activateService()
                throws Exception
        {
            configuration.refresh();
            ShiroIniConfiguration config = configuration.get();

            String iniResourcePath = config.iniResourcePath().get() == null
                                     ? Shiro.DEFAULT_INI_RESOURCE_PATH
                                     : config.iniResourcePath().get();

            setIni( Ini.fromResourcePath( iniResourcePath ) );
            securityManager = getInstance();

            if ( realmsRefs != null && realmsRefs.iterator().hasNext() ) {

                // Register Realms Services
                RealmSecurityManager realmSecurityManager = ( RealmSecurityManager ) securityManager;
                Collection<Realm> iniRealms = new ArrayList<>( realmSecurityManager.getRealms() );
                for ( ServiceReference<Realm> realmRef : realmsRefs ) {
                    iniRealms.add( realmRef.get() );
                    LOG.debug( "Realm Service '{}' registered!", realmRef.identity() );
                }
                realmSecurityManager.setRealms( iniRealms );

            }

            ThreadContext.bind( securityManager );
        }

        @Override
        public void passivateService()
                throws Exception
        {
            ThreadContext.unbindSubject();
            ThreadContext.unbindSecurityManager();
        }

        @Override
        public SecurityManager getSecurityManager()
        {
            return securityManager;
        }

    }

}
