/*
 * Copyright (c) 2014, Jiri Jetmar. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.qi4j.api.geometry.internal.builders;

import org.qi4j.api.geometry.TFeature;
import org.qi4j.api.geometry.internal.TGeometry;
import org.qi4j.api.structure.Module;

/**
 * Created by jj on 26.11.14.
 */
public class TFeatureBuilder {

    private Module module;
    private TFeature geometry;


    public TFeatureBuilder(Module module) {
        this.module = module;
        geometry = module.newValueBuilder(TFeature.class).prototype();
    }


    public TFeatureBuilder of(TGeometry feature) {
        geometry.of(feature);
        return this;
    }


    public TFeature geometry() {
        return geometry;
    }

    public TFeature geometry(int srid) {
        return geometry();
    }
}
