package org.example;

import java.util.ArrayList;
import java.util.List;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]
     *
     * @param count      максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        validateParams(count);

        List<Integer> digits = new ArrayList<>();
        Node root = this.root;

        find(root, count, upperBound, digits);
        return digits;
    }

    private void validateParams(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }

    private Node find(Node node, int count, int upperBound, List<Integer> result) {
        if (node != null && node.value <= upperBound && result.size() < count) {
            Node found = find(node.right,  count, upperBound, result);
            if(found == null) {
                addToList(node, count, result);
                return find(node.left,  count, upperBound, result);
            }

            return addToList(node, count, result);
        }
        return null;
    }

    private Node addToList(Node node, int count, List<Integer> result){
        if (result.size() < count) {
            result.add(node.value);
            return node;
        }
        return null;
    }

}
