package ru.netology;


public class SimpleTask extends Task {
    protected final String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
