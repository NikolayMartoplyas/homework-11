package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

    private TodosManager todos;
    private SimpleTask simpleTask;
    private Epic epic;
    private Meeting meeting;

    @BeforeEach
    public void setUp() {
        todos = new TodosManager();
        simpleTask = new SimpleTask(1, "магазин");
        epic = new Epic(2, new String[]{"евро", "доллар", "рубль"});
        meeting = new Meeting(3, "купить машину", "поставить дверь", "через неделю");
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddTasksCorrectly() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchTasksCorrectly() {
        Assertions.assertTrue(simpleTask.matches("магазин"));
        Assertions.assertFalse(simpleTask.matches("кино"));
        Assertions.assertTrue(epic.matches("евро"));
        Assertions.assertFalse(epic.matches("канадский доллар"));
        Assertions.assertTrue(meeting.matches("купить машину"));
        Assertions.assertTrue(meeting.matches("поставить дверь"));
        Assertions.assertFalse(meeting.matches("полететь в космос"));

    }

    @Test
    public void withEmptyTaskArray() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("магазин");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void withEmptyRequest() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void theRequestDoesNotCorrespondToTheTasks() {
        Task[] expected = {};
        Task[] actual = todos.search("грибы");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void multipleTaskSearchRequest() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("ма");

        Assertions.assertArrayEquals(expected, actual);
    }
}
