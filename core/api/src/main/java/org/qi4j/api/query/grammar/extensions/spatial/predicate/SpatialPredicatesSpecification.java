package org.qi4j.api.query.grammar.extensions.spatial.predicate;

import org.qi4j.api.composite.Composite;
import org.qi4j.api.geometry.internal.TGeometry;
import org.qi4j.api.property.Property;
import org.qi4j.api.query.grammar.ExpressionSpecification;
import org.qi4j.api.query.grammar.PropertyFunction;
import org.qi4j.api.query.grammar.extensions.spatial.convert.SpatialConvertSpecification;
import org.qi4j.functional.Specification;

/**
 * Base Spatial Predicates Specification.
 *
 * ST_Equals, ST_Disjoint, ST_Intersects, ST_Touches, ST_Crosses, ST_Within, ST_Contains, ST_Overlaps and ST_Relate
 */
public abstract class SpatialPredicatesSpecification<T extends TGeometry>
    extends ExpressionSpecification
{
    protected final PropertyFunction<T> property;
    protected final TGeometry value;
    protected final Specification<SpatialConvertSpecification> operator;

    public SpatialPredicatesSpecification(PropertyFunction<T> property, TGeometry value)
    {
        this.property = property;
        this.value = value;
        this.operator = null;
    }

    public SpatialPredicatesSpecification(PropertyFunction<T> property, Specification<SpatialConvertSpecification> operator)
    {
        this.property = property;
        this.operator = operator;
        this.value    = null;
    }

    public PropertyFunction<T> property()
    {
        return property;
    }

    @Override
    public final boolean satisfiedBy( Composite item )
    {
        System.out.println("SpatialPredicatesSpecification::satisfiedBy(" + item + ")");

        try
        {
            Property<T> prop = property.map( item );

            if( prop == null )
            {
                return false;
            }

            TGeometry propValue = prop.get();
            if( propValue == null )
            {
                return false;
            }

            return compare( propValue );
        }
        catch( IllegalArgumentException e )
        {
            return false;
        }
    }

    protected abstract boolean compare( TGeometry value );

    public TGeometry value()
    {
        return value;
    }

    public Specification<SpatialConvertSpecification> operator()
    {
        return operator;
    }
}
