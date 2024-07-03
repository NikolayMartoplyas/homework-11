package ru.netology;

public class TodosManager {
    private Task[] tasks = new Task[0]; //<- тут будут все задачи

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current Массив, в который мы хотим добавить элемент
     * @param task    Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Task[] addToArray(Task[] current, Task task) { //Этот метод возвращает новый массив задач.
        Task[] tmp = new Task[current.length + 1];        //Создается новый массив задач tmp, размер которого на одну больше, чем размер текущего массива current.
        for (int i = 0; i < current.length; i++) {   //Цикл for, который проходит по всем элементам
            tmp[i] = current[i];                     //текущего массива current и копирует их в новый массив tmp.
        }
        tmp[tmp.length - 1] = task; //Добавляем новую задачу task в конец нового массива tmp.
        return tmp;
    }

    /**
     * Метод добавления задачи в список дел
     *
     * @param task Добавляемая задача
     */
    public void add(Task task) {   // <- вот здесь в параметре может лежать объект и вида SimpleTask, и вида Epic, и вида Meeting
        tasks = addToArray(tasks, task);  //добавляет новую задачу (task) в массив задач (tasks).
    }                                   //Результат вызова метода addToArray присваивается переменной tasks.

    public Task[] findAll() {     //<---для получения всех задач в виде массива объектов Task
        return tasks;
    }

    /**
     * Метод поиска задач, которые подходят под поисковый запрос
     *
     * @param query Поисковый запрос
     * @return Массив из подошедших задач
     */

    public Task[] search(String query) {
        Task[] result = new Task[0]; // массив для ответа
        for (Task task : tasks) {    //перебираем список задач
            if (task.matches(query)) {    //если задача подходит под запрос
                result = addToArray(result, task);  // добавляем ее в массив задач
            }

        }
        return result;
    }

}
