package com.ccy.leetcode.D0405;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LFU缓存
 * leetcode: 460
 * 难度: 困难
 */
public class LFUCache {

    Map<Integer, Node> keyMap = new HashMap<>();
    Map<Integer, LinkedList<Node>> levelMap = new HashMap<>();

    class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.level = 0;
        }

        public int key;
        public int value;
        public int level;
    }

    private int capacity;
    private int size = 0;
    private int minLevel = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        int level = node.level;
        LinkedList<Node> list = levelMap.get(level);
        list.remove(node);
        if (list.isEmpty()) {
            levelMap.remove(level);
            if (minLevel == level) {
                minLevel++;
            }
        }
        node.level = ++level;
        LinkedList<Node> nodes = levelMap.get(level);
        if (nodes == null) {
            nodes = new LinkedList<>();
            nodes.addFirst(node);
            levelMap.put(level, nodes);
        } else {
            nodes.addFirst(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = keyMap.get(key);
        if (node != null) {
            node.value = value;
            get(key);
            return;
        }
        node = new Node(key, value);
        if (size == capacity) {
            LinkedList<Node> nodes = levelMap.get(minLevel);
            Node tmp = nodes.getLast();
            keyMap.remove(tmp.key);
            nodes.removeLast();
            if (nodes.isEmpty()) {
                levelMap.remove(minLevel);
                minLevel++;
            }
            size--;
        }
        if (size < capacity) {
            keyMap.put(key, node);
            LinkedList<Node> list = levelMap.get(0);
            if (list != null) {
                list.addFirst(node);
            } else {
                list = new LinkedList<>();
                list.add(node);
                levelMap.put(0, list);
                minLevel = 0;
            }
            size++;
        }
    }
}
