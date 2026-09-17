package com.shikavani.resource_sharing.solution.atomic_ops.atomic_reference;

public class StackNode<T> {
    public T value;
    public StackNode<T> next;

    public StackNode(T value) {
        this.value = value;
    }
}
