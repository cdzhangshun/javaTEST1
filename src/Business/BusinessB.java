package Business;

public class BusinessB {
    private IReadSaveDate iReadSaveDate;

    public BusinessB(IReadSaveDate iReadSaveDate) {
        this.iReadSaveDate=iReadSaveDate;
    }


    public IReadSaveDate getiReadSaveDate(){
        return  iReadSaveDate;
    }

    public void setiReadSaveDate(IReadSaveDate iReadSaveDate){
        this.iReadSaveDate=iReadSaveDate;

    }
    //保存数据
    public void saveDate(String date){
        iReadSaveDate.saveDate(date);

    }
    public String readDate(){
        return iReadSaveDate.getDate();
    }
}
