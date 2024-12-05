package org.jb10pigeonskyracesecurity.utils.generators;

public interface Generator<T, R> {
    R generate (T ...payload);
}
