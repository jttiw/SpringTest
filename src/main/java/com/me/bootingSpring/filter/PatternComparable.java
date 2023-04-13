package com.me.bootingSpring.filter;

import java.util.List;

public interface PatternComparable<C> {

    public boolean equal(C two);

    public boolean latest(List<C> list);



}
