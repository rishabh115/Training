public class Message {
    int ts,dataType;
    String dataSender,data;

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getDataSender() {
        return dataSender;
    }

    public void setDataSender(String dataSender) {
        this.dataSender = dataSender;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String st="{ "+ts+" , "+dataSender+" , "+dataType+" , "+data+" }";
        return st;
    }
}
