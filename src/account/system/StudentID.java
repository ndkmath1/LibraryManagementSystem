package account.system;

class StudentID {
    private int year;
    private int order;

    public StudentID(String studentIDNumber) {
        this.year = Integer.valueOf(studentIDNumber.substring(0, 4));
        this.order = Integer.valueOf(studentIDNumber.substring(4, 8));
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
