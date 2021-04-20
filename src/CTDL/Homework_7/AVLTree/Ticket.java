package CTDL.Homework_7.AVLTree;

public class Ticket implements Comparable {
    private Integer ticketID;
    private String diadiem;
    private String biensoxe;
    private String masoxe;
    private String ngaygiodoxe;
    private String hotennguoigui;
    private String sodienthoainguoigui;
    private String hotenbaove;
    private String sodienthoaibaove;
    private String diachibaove;
    private String ngaysinhbaove;
    private String url; // duong dan den hinh anh luu lai

    public Ticket() {
    }

    public Ticket(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Ticket(Integer ticketID, String diadiem, String biensoxe, String masoxe, String ngaygiodoxe, String hotennguoigui, String sodienthoainguoigui, String hotenbaove, String sodienthoaibaove, String diachibaove, String ngaysinhbaove) {
        this.ticketID = ticketID;
        this.diadiem = diadiem;
        this.biensoxe = biensoxe;
        this.masoxe = masoxe;
        this.ngaygiodoxe = ngaygiodoxe;
        this.hotennguoigui = hotennguoigui;
        this.sodienthoainguoigui = sodienthoainguoigui;
        this.hotenbaove = hotenbaove;
        this.sodienthoaibaove = sodienthoaibaove;
        this.diachibaove = diachibaove;
        this.ngaysinhbaove = ngaysinhbaove;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public String getMasoxe() {
        return masoxe;
    }

    public void setMasoxe(String masoxe) {
        this.masoxe = masoxe;
    }

    public String getNgaygiodoxe() {
        return ngaygiodoxe;
    }

    public void setNgaygiodoxe(String ngaygiodoxe) {
        this.ngaygiodoxe = ngaygiodoxe;
    }

    public String getHotennguoigui() {
        return hotennguoigui;
    }

    public void setHotennguoigui(String hotennguoigui) {
        this.hotennguoigui = hotennguoigui;
    }

    public String getSodienthoainguoigui() {
        return sodienthoainguoigui;
    }

    public void setSodienthoainguoigui(String sodienthoainguoigui) {
        this.sodienthoainguoigui = sodienthoainguoigui;
    }

    public String getHotenbaove() {
        return hotenbaove;
    }

    public void setHotenbaove(String hotenbaove) {
        this.hotenbaove = hotenbaove;
    }

    public String getSodienthoaibaove() {
        return sodienthoaibaove;
    }

    public void setSodienthoaibaove(String sodienthoaibaove) {
        this.sodienthoaibaove = sodienthoaibaove;
    }

    public String getDiachibaove() {
        return diachibaove;
    }

    public void setDiachibaove(String diachibaove) {
        this.diachibaove = diachibaove;
    }

    public String getNgaysinhbaove() {
        return ngaysinhbaove;
    }

    public void setNgaysinhbaove(String ngaysinhbaove) {
        this.ngaysinhbaove = ngaysinhbaove;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int compareTo(Object o) {
        Ticket x = (Ticket) o;
        if (x.getTicketID().equals(this.ticketID)) return 0;
        else {
            if (x.getTicketID() < this.ticketID) return 1;
            else return -1;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", diadiem=" + diadiem +
                '}';
    }
}
