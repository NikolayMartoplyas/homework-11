package ru.netology;

import java.util.Objects;

public class Task {
    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true; //Если текущий объект и переданный объект указывают на один и тот же объект в памяти, они считаются равными.
        if (o == null || getClass() != o.getClass())
            return false; //Если переданный объект равен null или классы объектов не совпадают, объекты не равны и возвращаем false.
        Task task = (Task) o; //Преобразуем объект o к типу Task.
        return id == task.id; //Возвращаем результат сравнения идентификаторов (считаем, что если идентификаторы совпадают, объекты равны)
    }

    @Override
    public int hashCode() {   //Метод hashCode возвращает целое число, которое представляет хеш-код объекта
        return Objects.hash(id);
    }

    /**
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя
     *
     * @param query Поисковый запрос
     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
     */
    public boolean matches(String query) {
        return false;
    }
}
