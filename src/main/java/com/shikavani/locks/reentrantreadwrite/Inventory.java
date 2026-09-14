package com.shikavani.locks.reentrantreadwrite;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Inventory {
    private final TreeMap<Integer, Integer> priceCountMap;
    private final ReentrantReadWriteLock reentrantReadWriteLock;
    private final ReentrantReadWriteLock.ReadLock readLock;
    private final ReentrantReadWriteLock.WriteLock writeLock;
    private final ReentrantLock lock;

    public Inventory() {
        this.priceCountMap = new TreeMap<>();
        this.reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = this.reentrantReadWriteLock.readLock();
        this.writeLock = this.reentrantReadWriteLock.writeLock();
        this.lock = new ReentrantLock();

    }

    public int getNoOfItemsInPriceRange(int lower, int upper) {
        int tq = 0;
        try {
           // lock.lock();

            Integer fromKey = priceCountMap.ceilingKey(lower);
            Integer toKey = priceCountMap.floorKey(upper);

            if (fromKey == null || toKey == null) {
                return 0;
            }

            NavigableMap<Integer, Integer> rangeOfPrices = priceCountMap.subMap(fromKey, true, toKey, true);

            for (Integer q : rangeOfPrices.values()) {
                tq += q;
            }
        } finally {
            // lock.unlock();
        }

        return tq;
    }

    public void addItem(int price) {
        try {

           // lock.lock();
            Integer count = priceCountMap.get(price);
            if (count == null) {
                priceCountMap.put(price, 1);
            } else {
                priceCountMap.merge(price, 1, Integer::sum);
            }
        } finally {
           // lock.unlock();
        }
    }

    public void remove(int price) {
        try {
            //lock.lock();
            Integer count = priceCountMap.get(price);
            if (count == null || count == 1) {
                priceCountMap.remove(price);
            } else {
                priceCountMap.computeIfPresent(price, (k, v) -> v - 1);
            }
        } finally {
           // lock.unlock();
        }
    }

    public Map<Integer, Integer> getPriceCountMap() {
        return Map.copyOf(priceCountMap);
    }

    public ReentrantReadWriteLock getReentrantReadWriteLock() {
        return reentrantReadWriteLock;
    }

    public ReentrantReadWriteLock.ReadLock getReadLock() {
        return readLock;
    }

    public ReentrantReadWriteLock.WriteLock getWriteLock() {
        return writeLock;
    }
}
