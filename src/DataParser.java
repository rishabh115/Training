import java.util.Scanner;

public class DataParser {
    private static String UMD[]={"bg","height","weight","uid"};
    private static String UBD[]={"method","tid","count","amount","uid"};
    private static String UPD[]={"name","add","uid"};

    public static UserMedicalDetails kvMedical(String s)
    {
        UserMedicalDetails ob=new UserMedicalDetails();
     String base[]=s.split("[&]{1}");
     for (int j=0;j<4;j++)
     {
         String kva[]=base[j].split("=");
         if (kva[0].compareTo(UMD[0])==0)
             ob.setBg(kva[1]);
         else if (kva[0].compareTo(UMD[1])==0)
             ob.setHeight(Integer.parseInt(kva[1]));
         else if (kva[0].compareTo(UMD[2])==0)
             ob.setWeight(Integer.parseInt(kva[1]));
         else if (kva[0].compareTo(UMD[3])==0)
             ob.setUid(Integer.parseInt(kva[1]));
     }
     return ob;
    }
    public static UserBillingDetails kvBilling(String s)
    {
        UserBillingDetails ob=new UserBillingDetails();
        String base[]=s.split("[&]{1}");
        for (int i=0;i<5;i++)
        {
            String kva[]=base[i].split("=");
            if (kva[0].compareTo(UBD[0])==0)
                ob.setMethod(kva[1]);
            else if (kva[0].compareTo(UBD[1])==0)
                ob.setTid(kva[1]);
            else if (kva[0].compareTo(UBD[2])==0)
                ob.setCount(Integer.parseInt(kva[1]));
            else if (kva[0].compareTo(UBD[3])==0)
                ob.setAmount(Integer.parseInt(kva[1]));
            else if(kva[0].compareTo(UBD[4])==0)
                ob.setUid(Integer.parseInt(kva[1]));
        }
        return ob;
    }
    public static UserProfileData kvProfile(String s)
    {
        UserProfileData ob=new UserProfileData();
        String base[]=s.split("[&]{1}");
        for (int i=0;i<3;i++)
        {
            String kva[]=base[i].split("=");
            if (kva[0].compareTo(UPD[0])==0)
                ob.setName(kva[1]);
            else if (kva[0].compareTo(UPD[1])==0)
                ob.setAdd(kva[1]);
            else if (kva[0].compareTo(UPD[2])==0)
                ob.setUid(Integer.parseInt(kva[1]));
        }
        return ob;
    }
}
