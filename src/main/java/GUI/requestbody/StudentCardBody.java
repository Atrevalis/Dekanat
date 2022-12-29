package GUI.requestbody;

public class StudentCardBody {
    private int id;

    private int form;

    private int finance;

    private String startDate;

    private String endDate;

    private int groupNumber;

    private String specialityNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public int getFinance() {
        return finance;
    }

    public void setFinance(int finance) {
        this.finance = finance;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getSpecialityNumber() {
        return specialityNumber;
    }

    public void setSpecialityNumber(String specialityNumber) {
        this.specialityNumber = specialityNumber;
    }
}
