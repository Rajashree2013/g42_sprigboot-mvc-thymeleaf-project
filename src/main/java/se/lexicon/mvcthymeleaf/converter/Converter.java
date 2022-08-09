package se.lexicon.mvcthymeleaf.converter;

import java.util.Collection;

public interface Converter<E, V> {

    V toView(E entity);

    E toEntity(V view);

    Collection<V> toViews(Collection<E> entities);

    Collection<E> toEntities(Collection<V> views);
}
