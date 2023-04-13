package com.me.bootingSpring.filter;

import java.util.List;

public class Pattern {
    public Integer length;  //Might vary from list.size() later when * or ? is used
    List<Comparator> comparators;

    public Pattern(List<Comparator> comparators) {
        this.length = comparators.size();
        this.comparators = comparators;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = this.comparators.size();
    }

    public List<Comparator> getComparators() {
        return comparators;
    }

    public void setComparators(List<Comparator> comparators) {
        this.comparators = comparators;
    }
}

