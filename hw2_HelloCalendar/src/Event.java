/**
 * Created by aniquedavla on 3/11/17.
 */
public class Event {

    private String eventTitle;
    private int DD;
    private int MM;
    private int YYYY;
    private int startTimeHR;
    private int startTimeMN;
    private boolean hasEndTime;
    private int endTimeHR;
    private int endTimeMN;

    public Event(String title,int DD, int MM, int YYYY,int startTimeHR, int startTimeMN, boolean hasEndTime, int endTimeHR, int endTimeMN) {
        this.eventTitle = title;
        this.DD = DD;
        this.MM = MM;
        this.YYYY = YYYY;
        this.startTimeHR = startTimeHR;
        this.startTimeMN = startTimeMN;
        if(hasEndTime){
            this.endTimeHR = endTimeHR;
            this.endTimeMN = endTimeMN;
        }
    }

    public void setTitle(String title) {
        this.eventTitle = title;
    }

    public void setDd(int dd) {
        this.DD = dd;
    }

    public void setMm(int mm) {
        this.MM = mm;
    }

    public void setYyyy(int yyyy) {
        this.YYYY = yyyy;
    }

    public void setStartTimeHR(int startTimeHR) {
        this.startTimeHR = startTimeHR;
    }

    public void setStartTimeMN(int startTimeMN) {
        this.startTimeMN = startTimeMN;
    }

    public void setHasEndTime(boolean hasEndTime) {
        this.hasEndTime = hasEndTime;
    }

    public void setEndTimeHR(int endTimeHR) {
        this.endTimeHR = endTimeHR;
    }

    public void setEndTimeMN(int endTimeMN) {
        this.endTimeMN = endTimeMN;
    }


    public String getTitle() {
        return eventTitle;
    }

    public int getDd() {
        return DD;
    }

    public int getMm() {
        return MM;
    }

    public int getYyyy() {
        return YYYY;
    }

    public int getStartTimeHR() {
        return startTimeHR;
    }

    public int getStartTimeMN() {
        return startTimeMN;
    }

    public boolean getHasEndTime() {
        return hasEndTime;
    }

    public int getEndTimeHR() {
        return endTimeHR;
    }

    public int getEndTimeMN() {
        return endTimeMN;
    }

}
