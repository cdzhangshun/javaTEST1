package Business;

public class BusinessC {
    private IReadSaveDate iReadSaveDate;
    public IReadSaveDate getiReadSaveDate(){
        return  iReadSaveDate;
    }

    public BusinessC(IReadSaveDate iReadSaveDate) {
        this.iReadSaveDate=iReadSaveDate;
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
