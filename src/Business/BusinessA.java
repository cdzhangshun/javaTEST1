package Business;

public class BusinessA {
    /*
    需要用到读写数据，数据可能保存在数据库中，文本文件中.......也有可能增加到别的数据来源中
     */

    private IReadSaveDate iReadSaveDate;

    public BusinessA(IReadSaveDate iReadSaveDate) {
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

